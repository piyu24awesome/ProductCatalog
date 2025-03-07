package org.example.productcatalogservice_feb2025.repo.inheritance;

import org.example.productcatalogservice_feb2025.models.TablePerClass.InheritanceUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InheritanceUserRepo extends CrudRepository<InheritanceUser, Long> {

    List<InheritanceUser> findAll();
}
