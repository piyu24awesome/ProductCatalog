package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "test_string")
@NoArgsConstructor
@AllArgsConstructor
public class TestString {

    @Column(name ="id", nullable = false,  insertable = true, updatable = false)
    @Id
    private Integer id;
    @Column(name="name", nullable = false, insertable = true, updatable = true, length = 50)
    private String name;

    @Override
    public String toString() {
        return "[id: %s, name: %s]".formatted(id, name);
    }
}
