package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    Long Id;
    Date createdDate;
    Date lastUpdatedAt;
    State state;
}
