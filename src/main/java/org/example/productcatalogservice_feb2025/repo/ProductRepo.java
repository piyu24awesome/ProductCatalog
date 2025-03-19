package org.example.productcatalogservice_feb2025.repo;

import org.example.productcatalogservice_feb2025.models.Category;
import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product save(Product product);

    void delete(Product entity);

     Optional<Product> findById(Long aLong);
//    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.category WHERE p.Id = :id")
//    Optional<Product> findById(@Param("id") Long id);

    boolean existsById(Long aLong);

    List<Product> findByCategory_Id(Long categoryId);

    //@Query(value = "SELECT pname, pdesc FROM product WHERE id = :id", nativeQuery = true)
    //Object[] findRawProductById(@Param("id") Long id);


}
