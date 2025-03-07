package org.example.productcatalogservice_feb2025.models.mappings;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.models.BaseModel;

@Getter
@Setter
@Entity
public class Student_Course_Entity extends BaseModel {
    String comments;
    double grades;
    @ManyToOne
    @JoinColumn(name="student_idd")
    Student_new student;
    @ManyToOne
    @JoinColumn(name="course_idd")
    Course_new course;
}
