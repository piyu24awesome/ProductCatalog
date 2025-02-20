package org.example.productcatalogservice_feb2025.DTO;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_feb2025.models.BaseModel;
import org.example.productcatalogservice_feb2025.models.Category;

@Setter
@Getter
public class ProductDTO extends BaseModel {
    String title;
    String description;
    String image;
    String price;
    String category;
}
