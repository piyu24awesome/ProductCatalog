package org.example.productcatalogservice_feb2025.repo;

import org.example.productcatalogservice_feb2025.models.TestString;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TestStringRepo extends CrudRepository<TestString, Integer> {
    Optional<TestString> findById(Integer integer);

    @Query(value = "SELECT * FROM test_string WHERE id = :id", nativeQuery = true)
    List<Object[]> findTestById(@Param("id") int id);
}
