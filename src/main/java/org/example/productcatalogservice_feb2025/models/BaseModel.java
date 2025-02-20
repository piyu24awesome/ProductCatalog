package org.example.productcatalogservice_feb2025.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseModel {

    Long Id;
    Date createdDate;
    Date lastUpdatedAt;
    State state;
}
