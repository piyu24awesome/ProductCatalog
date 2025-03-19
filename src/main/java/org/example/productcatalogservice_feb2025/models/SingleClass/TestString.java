package org.example.productcatalogservice_feb2025.models.SingleClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class TestString {

  //  @Column(name ="ID", nullable = false,  insertable = true, updatable = false)
    @Id
    private Integer id;
    //@Column(name="NAME", nullable = false, insertable = true, updatable = true, length = 50)
    private String name;
}
