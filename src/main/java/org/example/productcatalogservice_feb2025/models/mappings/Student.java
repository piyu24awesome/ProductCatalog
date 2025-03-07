package org.example.productcatalogservice_feb2025.models.mappings;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.models.BaseModel;

import java.util.List;

@Getter
@Setter
@Entity
public class Student extends BaseModel {
    String name;
    @ManyToMany(mappedBy ="students")
    List<Course> courses;
}
