package org.example.productcatalogservice_feb2025.models.TablePerClass;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@Entity
public class Instructor extends InheritanceUser {

    private String company;

    public Instructor() {

    }

    public Instructor( long id, String name , String email, String company ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;

    }
}
