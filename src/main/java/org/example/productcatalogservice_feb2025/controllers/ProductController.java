package org.example.productcatalogservice_feb2025.controllers;

import org.example.productcatalogservice_feb2025.DTO.ProductDTO;
import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        return null;
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductDetails(@PathVariable long id){
        return null;

    }

    @PostMapping("/products")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO){
        return null;
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO){
        return null;
    }

    @PatchMapping("/products/{id}")
    public ProductDTO updateProductById(@PathVariable long id, @RequestBody ProductDTO productDTO){
        return null;
    }
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable long id){
        return false;
    }
}
