package org.example.productcatalogservice_feb2025.client;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.models.BaseModel;

@Setter
@Getter
public class FakeStoreProductDTO extends BaseModel {
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
   // public Rating rating;
}
