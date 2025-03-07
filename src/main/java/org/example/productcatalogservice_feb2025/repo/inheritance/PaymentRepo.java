package org.example.productcatalogservice_feb2025.repo.inheritance;

import org.example.productcatalogservice_feb2025.models.joinedClass.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    List<Payment> findAll();
}
