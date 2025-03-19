package org.example.productcatalogservice_feb2025.repo.inheritance;

import org.example.productcatalogservice_feb2025.models.SingleClass.TestString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TestStringRepo extends JpaRepository<TestString, Integer> {
    Optional<TestString> findById(Integer integer);
    
    List<TestString> findTestStringById(Integer id);

    @Query(value = "SELECT id, name FROM test_string WHERE id = :id", nativeQuery = true)
    Object[] findTestById(@Param("id") int id);
}
