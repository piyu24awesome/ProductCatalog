package org.example.productcatalogservice_feb2025.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "product")
public class Product extends BaseModel {

    @Column(columnDefinition = "VARCHAR(255)",nullable = false)
    String name;
    @Column(length=10000)
    String description;
    @Column(columnDefinition = "VARCHAR(255)")
    String imageUrl;
    @Column(nullable = false)
    double price;
    Boolean isPrime;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    Category category;
    public Product() {}
}
