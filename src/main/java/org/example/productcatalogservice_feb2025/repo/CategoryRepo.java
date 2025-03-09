package org.example.productcatalogservice_feb2025.repo;

import org.example.productcatalogservice_feb2025.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
     Optional<Category> findByName(String name);
     void delete(Category entity);
}
