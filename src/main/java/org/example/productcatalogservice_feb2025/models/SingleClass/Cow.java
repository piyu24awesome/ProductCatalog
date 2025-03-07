package org.example.productcatalogservice_feb2025.models.SingleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cow")
public class Cow extends Animal {
    boolean doesMoo;


    public Cow() {
    }

    public Cow(String name, long id, boolean doesMoo) {
        this.name = name;
        this.id = id;
        this.doesMoo = doesMoo;
    }
}
