package org.example.productcatalogservice_feb2025.Service;

import org.example.productcatalogservice_feb2025.models.Product;

import java.util.List;

public interface IProductService {

    public Product getProductById(long id);

    public List<Product> getAllProducts();

    public Product updateProduct(long id, Product product);

}
