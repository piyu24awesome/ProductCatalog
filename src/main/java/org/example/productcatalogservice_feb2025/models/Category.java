package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

   String name;
   String description;

   @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
   List<Product> products;

   public Category(){
      super();
   }
   public Category(String name){
      super();
      this.name = name;
   }
}
