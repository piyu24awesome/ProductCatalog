package org.example.productcatalogservice_feb2025.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel {
    String name;
    String description;
    String imageUrl;
    double price;
    boolean isPrime;
    Category category;
}
