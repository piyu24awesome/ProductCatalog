package org.example.productcatalogservice_feb2025.repo.inheritance;

import org.example.productcatalogservice_feb2025.models.SingleClass.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepo extends JpaRepository<Animal, Long> {

    List<Animal> findAll();
}
