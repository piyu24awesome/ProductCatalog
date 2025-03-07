package org.example.productcatalogservice_feb2025.models.mappings;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.models.BaseModel;

@Entity
@Getter
@Setter
public class Capital extends BaseModel {
    String name;
    @OneToOne(mappedBy = "capital")
    Country country;
}
