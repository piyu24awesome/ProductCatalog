package org.example.productcatalogservice_feb2025.repo;

import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product save(Product product);

    void delete(Product entity);

    Optional<Product> findById(Long aLong);
}
