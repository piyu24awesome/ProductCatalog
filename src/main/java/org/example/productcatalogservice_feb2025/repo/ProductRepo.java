package org.example.productcatalogservice_feb2025.repo;

import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product save(Product product);

    void delete(Product entity);

    Optional<Product> findById(Long aLong);

  //  List<Product> saveAll(List<Product> productList);

    boolean existsById(Long aLong);
}
