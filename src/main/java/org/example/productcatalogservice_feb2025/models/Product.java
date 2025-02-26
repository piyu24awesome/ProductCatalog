package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    String name;
    String description;
    String imageUrl;
    double price;
    boolean isPrime;
    @ManyToOne(cascade = CascadeType.ALL)
    Category category;
}
