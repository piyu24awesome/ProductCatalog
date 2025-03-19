package org.example.productcatalogservice_feb2025.Service;

import org.example.productcatalogservice_feb2025.Exception.EntityNotFoundException;
import org.example.productcatalogservice_feb2025.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(long id);

    public List<Product> getAllProducts();

    public Product updateProduct(long id, Product product);

    public Product patchProduct(long id, Product product);

    public Product addProduct(Product product);

    public void addProducts(List<Product> product);

    public Product deleteProduct(long id) throws EntityNotFoundException;
}
