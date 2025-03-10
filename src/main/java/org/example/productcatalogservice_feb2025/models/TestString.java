package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class TestString {

    @Column(name ="ID", nullable = false,  insertable = true, updatable = false)
    @Id
    private int id;
    @Column(name="NAME", nullable = false, insertable = true, updatable = true, length = 50)
    private String name;
}
