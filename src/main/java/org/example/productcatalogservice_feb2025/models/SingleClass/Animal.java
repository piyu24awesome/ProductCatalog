package org.example.productcatalogservice_feb2025.models.SingleClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.converter.AnimalTypeConverter;
import org.example.productcatalogservice_feb2025.repo.inheritance.AnimalRepo;
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType= DiscriminatorType.STRING)
public abstract class Animal {
    @Id
    Long id;
    String name;

    @Convert(converter = AnimalTypeConverter.class)
    @Column(name = "type", insertable = false, updatable = false)
    private String animalType;

    public Animal() {
    }

    public Animal(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
