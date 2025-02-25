package org.example.productcatalogservice_feb2025.Service;

import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBStoreService implements IProductService{
    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }
}
