package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor  // ✅ Generates a constructor for fields with @NonNull
@Entity
public class Category extends BaseModel {

    @NonNull
    private String name;
    private String description;
    //
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
}
