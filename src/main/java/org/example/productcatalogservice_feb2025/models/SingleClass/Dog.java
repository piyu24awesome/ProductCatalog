package org.example.productcatalogservice_feb2025.models.SingleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("dog")
public class Dog extends Animal{
    String breed;

    public Dog(){}

    public Dog(String name, long id, String breed){
        this.name = name;
        this.id = id;
        this.breed = breed;
    }
}
