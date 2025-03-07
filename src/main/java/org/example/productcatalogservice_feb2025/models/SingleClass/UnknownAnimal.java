package org.example.productcatalogservice_feb2025.models.SingleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("UNKNOWN")
@Getter
@Setter
public class UnknownAnimal extends Animal {
    private String reason = "Unrecognized Animal Type";
}
