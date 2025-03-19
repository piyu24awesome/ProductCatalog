package org.example.productcatalogservice_feb2025.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.productcatalogservice_feb2025.Exception.EntityNotFoundException;
import org.example.productcatalogservice_feb2025.Exception.ProductListEmptyException;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import org.example.productcatalogservice_feb2025.models.Category;
import org.example.productcatalogservice_feb2025.models.Product;
import org.example.productcatalogservice_feb2025.repo.CategoryRepo;
import org.example.productcatalogservice_feb2025.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Primary
@Service("dbStore")
public class DBStoreService implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    @Transactional(readOnly = true) //prevents unnecessary DB writes
    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow(() -> {
            log.error("Product with ID {} not found", id);
            return new EntityNotFoundException("Product Not Found with ID: " + id);
        });
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        if (products.isEmpty()) {
            log.info("No products found in DB");
            throw new ProductListEmptyException("No products found in DB");
        }
        return products;
    }

    @Override
    public Product updateProduct(long id, Product product) {

        Product existingProduct = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with Id" + id));
        // Ensure the product retains the same ID
        existingProduct.setId(id);
        return productRepo.save(existingProduct);
    }

    @Override
    public Product patchProduct(long id, Product productFromDTO) {

        //direct repo call with specific query update
        Product prod = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with Id" + id));

        if (productFromDTO.getDescription() != null) {
            prod.setDescription(productFromDTO.getDescription());
        }
        if (productFromDTO.getCategory() != null) {
            prod.setCategory(productFromDTO.getCategory());
        }
        if (!ObjectUtils.isEmpty(productFromDTO) && !ObjectUtils.isEmpty(productFromDTO.getPrice())) {
            prod.setPrice(productFromDTO.getPrice());
        }
        return productRepo.save(prod);
    }


    @Override
    public Product addProduct(Product product) {
        checkIfCategoryExistsAndUpdateProductCategory(product);
        return productRepo.save(product);
    }

    private void checkIfCategoryExistsAndUpdateProductCategory(Product product) {
        Category category = product.getCategory();
        if (category != null) {
            Optional<Category> categoryFromDB = categoryRepo.findByName(category.getName());
            if (categoryFromDB.isEmpty()) {
                //then we need to save the new category in categoryRepo and Product.
                categoryRepo.save(category);
            }
            categoryFromDB.ifPresent(product::setCategory);
        }
    }

    @Transactional
    @Override
    public void addProducts(List<Product> products) {
        if (ObjectUtils.isEmpty(products)) {
            throw new ProductListEmptyException("Product list is empty");
        }
        Map<String, Category> categoryCache = new HashMap<>();

        for (Product product : products) {
            Category category = product.getCategory();

            if (category != null) {
                // 🔍 Check if Category exists in cache or database
                category = categoryCache.computeIfAbsent(
                        category.getName(),
                        name -> categoryRepo.findByName(name).orElseGet(() -> categoryRepo.save(new Category(name)))
                );
                product.setCategory(category);
            }
        }
        productRepo.saveAll(products);
    }

    @Override
    public Product deleteProduct(long id) {
        // Fetch the product first
        Product product = productRepo.findById(id).orElseThrow(() -> {
            log.error("Delete failed: Product with ID {} not found", id);
            return new EntityNotFoundException("Product Not Found with ID: " + id);

        });
        // Delete the product
        productRepo.delete(product);
        // Return the deleted product
        return product;
    }
}
