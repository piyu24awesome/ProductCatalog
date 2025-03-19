package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor  // ✅ Generates a constructor for fields with @NonNull
@Entity
@Table(name = "category", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category extends BaseModel {


    @NonNull
    @Column( nullable = false, unique = true)
    private String name;
    private String description;
    //
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
}
