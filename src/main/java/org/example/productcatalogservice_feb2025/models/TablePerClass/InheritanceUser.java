package org.example.productcatalogservice_feb2025.models.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class InheritanceUser {
    @Id
    Long id;
    String email;
    String name;


    public InheritanceUser() {
    }
    public InheritanceUser(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
