package org.example.productcatalogservice_feb2025.models.mappings;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.models.BaseModel;

import java.util.List;

@Getter
@Setter
@Entity
public class Course_new extends BaseModel {
    String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Student_Course_Entity> studentCourseEntity;
}
