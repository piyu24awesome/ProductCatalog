package org.example.productcatalogservice_feb2025.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="product")
public class Product extends BaseModel {

    @Column( name = "pname",  nullable = false)
    private String name;
    @Column(name="pdesc", length = 10000)
    private String description;
    @Column(name ="pimage_url")
    private String imageUrl;
    @Column(name ="price", nullable = false)
    private double price;
    @Column(name= "is_prime")
    private Boolean isPrime;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
