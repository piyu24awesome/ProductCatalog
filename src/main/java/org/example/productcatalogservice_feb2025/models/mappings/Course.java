package org.example.productcatalogservice_feb2025.models.mappings;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.models.BaseModel;

import java.util.List;

@Getter
@Setter
@Entity
public class Course extends BaseModel {
    String name;
    @ManyToMany
    @JoinTable(name ="student_course",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name ="student_id"))
    List<Student> students;
}
