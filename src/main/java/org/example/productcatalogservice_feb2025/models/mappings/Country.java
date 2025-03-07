package org.example.productcatalogservice_feb2025.models.mappings;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.models.BaseModel;

@Getter
@Setter
@Entity
public class Country extends BaseModel {
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    Capital capital;
}
