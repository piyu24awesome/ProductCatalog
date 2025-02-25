package org.example.productcatalogservice_feb2025.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping("/category")
    public void getAllCategories(){
        throw new IllegalArgumentException("Testing Category Exceptions");
    }
}
