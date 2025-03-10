package org.example.productcatalogservice_feb2025.Service;

import org.example.productcatalogservice_feb2025.DTO.FakeStoreProductDTO;
import org.example.productcatalogservice_feb2025.mapper.MapperUtil;
import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("thirdParty")
public class FakeStoreService implements IProductService {
    @Autowired
    RestTemplateBuilder restTemplate;

    @Autowired
    MapperUtil mapperUtil;
    String baseUrl = "https://fakestoreapi.com/products";

    @Override
    public Product getProductById(long id) {
        String url = baseUrl + "/{id}";
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTO = restTemplate.build().getForEntity(url, FakeStoreProductDTO.class, id);
        if (fakeStoreProductDTO.getBody() != null && fakeStoreProductDTO.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            return mapperUtil.mapperFromFakeStoreDTOToProductEntity(fakeStoreProductDTO.getBody());
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String url = baseUrl;
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

        String url = baseUrl + "/{id}";
        FakeStoreProductDTO fakeStoreProductDTO = mapperUtil.mapperFromProductEntityToFakeStoreDTO(product);
        HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(fakeStoreProductDTO);
        ResponseEntity<FakeStoreProductDTO> updatedProduct = restTemplate.build().exchange(url, HttpMethod.PUT, requestEntity, FakeStoreProductDTO.class, id);
        if (updatedProduct.getBody() != null && updatedProduct.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            return mapperUtil.mapperFromFakeStoreDTOToProductEntity(updatedProduct.getBody());
        }
        return null;
    }

    @Override
    public Product patchProduct(long id, Product product) {
        return updateProduct(id, product);
    }

    @Override
    public Product addProduct(Product product) {
        String url = baseUrl;
        FakeStoreProductDTO fakeStoreProductDTO = mapperUtil.mapperFromProductEntityToFakeStoreDTO(product);
        HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(fakeStoreProductDTO);
        ResponseEntity<FakeStoreProductDTO> responseProduct = restTemplate.build().postForEntity(url, requestEntity, FakeStoreProductDTO.class);
        if (responseProduct.getBody() != null && responseProduct.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            return mapperUtil.mapperFromFakeStoreDTOToProductEntity(responseProduct.getBody());
        }
        return null;
    }

    @Override
    public void addProducts(List<Product> product) {
    }


    @Override
    public boolean deleteProduct(long id) {
        String url = baseUrl + "/{id}";
        restTemplate.build().delete(url, id);
        return true;
    }


}

