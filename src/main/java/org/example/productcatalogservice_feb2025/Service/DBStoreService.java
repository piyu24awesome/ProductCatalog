package org.example.productcatalogservice_feb2025.Service;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_feb2025.models.Product;
import org.example.productcatalogservice_feb2025.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service("dbStore")
public class DBStoreService implements IProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public Product getProductById(long id) {

        Optional<Product> retrieveProduct = productRepo.findById(id);
        if (retrieveProduct.isPresent()) {
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
        return productRepo.save(product);
    }

    @Transactional
    @Override
    public void addProducts(List<Product> products) {
        if(ObjectUtils.isEmpty(products)){
            throw new RuntimeException("Product list is empty");
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
