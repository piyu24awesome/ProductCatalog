package org.example.productcatalogservice_feb2025.controllers;

import org.example.productcatalogservice_feb2025.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable long id) {
      return   categoryService.deleteCategory(id);

    }
 }
