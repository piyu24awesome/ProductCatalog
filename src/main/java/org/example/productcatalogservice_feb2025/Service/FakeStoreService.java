package org.example.productcatalogservice_feb2025.Service;

import lombok.Setter;
import org.example.productcatalogservice_feb2025.DTO.FakeStoreProductDTO;
import org.example.productcatalogservice_feb2025.DTO.ProductDTO;
import org.example.productcatalogservice_feb2025.mapper.MapperUtil;
import org.example.productcatalogservice_feb2025.models.Category;
import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreService implements IProductService {
    @Autowired
    RestTemplateBuilder restTemplate;

    @Autowired
    MapperUtil mapperUtil;

    @Override
    public Product getProductById(long id) {
        String url = "https://fakestoreapi.com/products/{id}";
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTO = restTemplate.build().getForEntity(url, FakeStoreProductDTO.class, id);
        if (fakeStoreProductDTO.getBody() != null && fakeStoreProductDTO.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            return mapperUtil.mapperFromFakeStoreDTOToProductEntity(fakeStoreProductDTO.getBody());
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<FakeStoreProductDTO[]> listFakeStoreProductDTO = restTemplate.build().getForEntity(url, FakeStoreProductDTO[].class);
        if (listFakeStoreProductDTO.getBody() != null && listFakeStoreProductDTO.getStatusCode().equals(HttpStatusCode.valueOf(200))) {

            for (FakeStoreProductDTO dto : listFakeStoreProductDTO.getBody()) {
                products.add(mapperUtil.mapperFromFakeStoreDTOToProductEntity(dto));
            }
        }
        return products;
    }

    @Override
    public Product updateProduct(long id, Product product) {

        String url = "https://fakestoreapi.com/products/{id}";
        FakeStoreProductDTO fakeStoreProductDTO = mapperUtil.mapperFromProductEntityToFakeStoreDTO(product);
        HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(fakeStoreProductDTO);
        ResponseEntity<FakeStoreProductDTO> updatedProduct = restTemplate.build().exchange(url, HttpMethod.PUT, requestEntity, FakeStoreProductDTO.class, id);
        if (updatedProduct.getBody() != null && updatedProduct.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            return mapperUtil.mapperFromFakeStoreDTOToProductEntity(updatedProduct.getBody());
        }
        return null;
    }


}

