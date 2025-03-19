package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseModel {

    @Column(name = "pname", nullable = false)
    private String name;
    @Column(name = "pdesc", length = 10000)
    private String description;
    @Column(name = "pimage_url")
    private String imageUrl;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "is_prime")
    private Boolean isPrime;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
