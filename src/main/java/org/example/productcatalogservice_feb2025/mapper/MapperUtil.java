package org.example.productcatalogservice_feb2025.mapper;

import org.example.productcatalogservice_feb2025.DTO.FakeStoreProductDTO;
import org.example.productcatalogservice_feb2025.DTO.ProductDTO;
import org.example.productcatalogservice_feb2025.models.Category;
import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class MapperUtil {

    public ProductDTO mapperFromProductToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setPrice(String.valueOf(product.getPrice()));
        productDTO.setTitle(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setImage(product.getImageUrl());
        productDTO.setCategory(product.getCategory().getName());
        return productDTO;
    }

    public Product mapperFromProductDTOToProductEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getTitle());

        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImage());
        if(!ObjectUtils.isEmpty(product.getPrice())){
            double price = Double.parseDouble(productDTO.getPrice());
            product.setPrice(price);
        }

        Category category1 = new Category();
        category1.setName(productDTO.getCategory());
        product.setCategory(category1);
        return product;
    }


    public Product mapperFromFakeStoreDTOToProductEntity(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setName(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImageUrl(fakeStoreProductDTO.getImage());
        product.setPrice(fakeStoreProductDTO.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }

    public FakeStoreProductDTO mapperFromProductEntityToFakeStoreDTO(Product product) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getName());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setImage(product.getImageUrl());

        return fakeStoreProductDTO;
    }
}
