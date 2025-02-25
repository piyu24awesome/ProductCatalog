package org.example.productcatalogservice_feb2025.controllers;

import org.example.productcatalogservice_feb2025.DTO.ProductDTO;
import org.example.productcatalogservice_feb2025.Service.FakeStoreService;
import org.example.productcatalogservice_feb2025.Service.IProductService;
import org.example.productcatalogservice_feb2025.mapper.MapperUtil;
import org.example.productcatalogservice_feb2025.models.Category;
import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Qualifier("fakeStoreService")
    @Autowired
    IProductService productService;

    @Autowired
    MapperUtil mapperUtil;

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        if (ObjectUtils.isEmpty(products)) {
            return null;
        }
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(mapperUtil.mapperFromProductToProductDTO(product));
        }
        return productDTOS;
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductDetailsById(@PathVariable long id) {

        if (productService instanceof FakeStoreService) {
            if ( id < 1 || id > 20) {
                throw new IllegalArgumentException("Invalid product id is input from user");
            }
        }

        Product product = productService.getProductById(id);

        if (ObjectUtils.isEmpty(product)) {
            return null;
        }
        return mapperUtil.mapperFromProductToProductDTO(product);

    }


    @PostMapping("/products")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return null;
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        if (productService instanceof FakeStoreService) {
            if ( id < 1 || id > 20) {
                throw new IllegalArgumentException("Invalid product id is input from user");
            }
        }
        Product product = mapperUtil.mapperFromProductDTOToProductEntity(productDTO);
        Product returnedProduct = productService.updateProduct(id, product);

        if (!ObjectUtils.isEmpty(returnedProduct)) {
            return mapperUtil.mapperFromProductToProductDTO(returnedProduct);
        }
        return null;
    }


    @PatchMapping("/products/{id}")
    public ProductDTO updateProductById(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        return null;
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable long id) {
        return false;
    }
}
