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
@RequestMapping("/products")
public class ProductController {

    @Qualifier("dbStore")
    @Autowired
    IProductService productService;

    @Autowired
    MapperUtil mapperUtil;

    @GetMapping()
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

    @GetMapping("/{id}")
    public ProductDTO getProductDetailsById(@PathVariable long id) {
        if (productService instanceof FakeStoreService) {
            if (id < 1 || id > 20) {
                throw new IllegalArgumentException("Invalid product id is input from user");
            }
        }
        Product product = productService.getProductById(id);
        if (ObjectUtils.isEmpty(product)) {
            return null;
        }
        return mapperUtil.mapperFromProductToProductDTO(product);
    }


    @PostMapping()
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        if (productDTO.getTitle() == null) {
            throw new IllegalArgumentException("Invalid product id is input from user");
        }

        if (productDTO.getCategory() == null) {
            throw new IllegalArgumentException("Invalid category id is input from user");
        }
        Product product = mapperUtil.mapperFromProductDTOToProductEntity(productDTO);
        Product addedProduct = productService.addProduct(product);

      //  return ResponseEntity.ok("Product added successfully");
        return ResponseEntity.ok(mapperUtil.mapperFromProductToProductDTO(addedProduct));
    }

    @PostMapping("/bulk")
    public ResponseEntity<String> addProductsInBulk(@RequestBody List<ProductDTO> productDTOS) {

        if(ObjectUtils.isEmpty(productDTOS)) {
            throw new IllegalArgumentException("Invalid product list is input from user");
        }
        List<Product> productList = mapperUtil.mapperFromProductDTOToProductEntity(productDTOS);
        productService.addProducts(productList);

        return ResponseEntity.ok("bulk products added successfully");
    }


    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        //if path variable- id is null, spring boot generates exception message
        if (productService instanceof FakeStoreService) {
            if (id < 1 || id > 20) {
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


    @PatchMapping("/{id}")
    public ProductDTO patchProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        //if path variable- id is null, spring boot generates exception message
        if (productService instanceof FakeStoreService) {
            if (id < 1 || id > 20) {
                throw new IllegalArgumentException("Invalid product id is input from user");
            }
        }
        Product product = mapperUtil.mapperFromProductDTOToProductEntity(productDTO);
        Product returnedProduct = productService.patchProduct(id, product);

        if (!ObjectUtils.isEmpty(returnedProduct)) {
            return mapperUtil.mapperFromProductToProductDTO(returnedProduct);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
