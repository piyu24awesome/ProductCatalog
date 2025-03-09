package org.example.productcatalogservice_feb2025.Service;

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

@Service("dbStore")
public class DBStoreService implements IProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    @Transactional(readOnly = true) //prevents unnecessary DB writes
    public Product getProductById(long id) {


        Optional<Product> retrieveProduct = productRepo.findById(id);
        if (retrieveProduct.isPresent()) {
            System.out.println(retrieveProduct.get().getName());
            System.out.println(retrieveProduct.get().getPrice());
            System.out.println(retrieveProduct.get().getDescription());
            System.out.println(retrieveProduct.get().getImageUrl());

            return retrieveProduct.get();
        } else {
            throw new RuntimeException("Product Not Found with ID : " + id);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product updateProduct(long id, Product product) {
        if (productRepo.existsById(id)) {
            return productRepo.save(product);
        } else {
            throw new RuntimeException("Product not found with Id" + id);
        }
    }

    @Override
    public Product patchProduct(long id, Product productFromDTO) {

        //direct repo call with specific query update
        Optional<Product> retrievedProduct = productRepo.findById(id);
        if (retrievedProduct.isPresent()) {
            Product prod = retrievedProduct.get();
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
        } else {
            throw new RuntimeException("Product not found with Id" + id);
        }

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
            throw new RuntimeException("Product list is empty");
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
    public boolean deleteProduct(long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
