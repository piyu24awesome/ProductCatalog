package org.example.productcatalogservice_feb2025.mapper;

import org.example.productcatalogservice_feb2025.DTO.ProductDTO;
import org.example.productcatalogservice_feb2025.client.FakeStoreProductDTO;
import org.example.productcatalogservice_feb2025.models.Category;
import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class MapperUtil {

    public ProductDTO mapperFromProductToProductDTO(Product product) {
        return getProductDTO(product);
    }


    public List<ProductDTO> mapperFromProductToProductDTO(List<Product> products) {

        return products.stream().map(this::getProductDTO).toList();
    }

    private ProductDTO getProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setPrice(String.valueOf(product.getPrice()));
        productDTO.setTitle(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setImage(product.getImageUrl());
        productDTO.setCategory(product.getCategory().getName());
        productDTO.setCreatedDate(product.getCreatedDate());
        productDTO.setLastUpdatedAt(product.getLastUpdatedAt());
        productDTO.setState(product.getState());
        return productDTO;
    }

    public Product mapperFromProductDTOToProductEntity(ProductDTO productDTO) {
        return getProduct(productDTO);
    }

    private Product getProduct(ProductDTO productDTO) {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getTitle());

        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImage());
        if (!ObjectUtils.isEmpty(product.getPrice())) {
            double price = Double.parseDouble(productDTO.getPrice());
            product.setPrice(price);
        }

        Category category1 = new Category();
        category1.setName(productDTO.getCategory());
        product.setCategory(category1);
        product.setCreatedDate(productDTO.getCreatedDate());
        product.setLastUpdatedAt(productDTO.getLastUpdatedAt());
        product.setState(productDTO.getState());

        return product;
    }


    public List<Product> mapperFromProductDTOToProductEntity(List<ProductDTO> productDTOS) {
        return productDTOS.stream().map(this::getProduct).toList();
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
        product.setCreatedDate(fakeStoreProductDTO.getCreatedDate());
        product.setLastUpdatedAt(fakeStoreProductDTO.getLastUpdatedAt());
        product.setState(fakeStoreProductDTO.getState());
        return product;
    }

    public List<Product>mapperFromFakeStoreDTOToProductEntity(List<FakeStoreProductDTO> fakeStoreProductDTOList){
        return fakeStoreProductDTOList.stream().map(this::mapperFromFakeStoreDTOToProductEntity).toList();
    }

    public FakeStoreProductDTO mapperFromProductEntityToFakeStoreDTO(Product product) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getName());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setImage(product.getImageUrl());
        fakeStoreProductDTO.setCreatedDate(product.getCreatedDate());
        fakeStoreProductDTO.setLastUpdatedAt(product.getLastUpdatedAt());
        fakeStoreProductDTO.setState(product.getState());

        return fakeStoreProductDTO;
    }


    public List<FakeStoreProductDTO> mapperFromProductEntityToFakeStoreDTO(List<Product> products) {
        return products.stream().map(this::mapperFromProductEntityToFakeStoreDTO).toList();
    }
}
