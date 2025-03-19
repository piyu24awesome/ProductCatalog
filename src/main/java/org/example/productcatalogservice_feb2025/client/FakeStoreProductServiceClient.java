package org.example.productcatalogservice_feb2025.client;

import org.example.productcatalogservice_feb2025.Exception.ExternalAPIException;
import org.example.productcatalogservice_feb2025.Exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductServiceClient implements ThirdPartyProductServiceClient {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    String baseUrl;

    public String getProductByIdUrl(long id) {
        return baseUrl + "/{id}";
    }

    @Override
    public FakeStoreProductDTO getProductById(long id) {
        String url = getProductByIdUrl(id);
        try {
            ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTO = restTemplateBuilder.build().getForEntity(url, FakeStoreProductDTO.class, id);
            if (fakeStoreProductDTO.getStatusCode().is2xxSuccessful() && fakeStoreProductDTO.getBody() != null) {
                return fakeStoreProductDTO.getBody();
            } else {
                throw new ExternalAPIException("Unexpected Response from external API" + url, new RuntimeException("Invalid API response"));
            }
        } catch (RestClientException e) {
            throw new ExternalAPIException("Failed to call external API " + url, new RuntimeException());
        }
    }

    @Override
    public List<FakeStoreProductDTO> getAllProducts() {

        try {
            ResponseEntity<FakeStoreProductDTO[]> listFakeStoreProductDTO = restTemplateBuilder.build().getForEntity(baseUrl, FakeStoreProductDTO[].class);
            if (listFakeStoreProductDTO.getBody() != null && listFakeStoreProductDTO.getStatusCode().is2xxSuccessful()) {
                return new ArrayList<>(Arrays.asList(listFakeStoreProductDTO.getBody()));

            } else {
                throw new ExternalAPIException("Unexpected Response from external API" + baseUrl, new RuntimeException("Invalid API response"));
            }
        } catch (RestClientException e) {
            throw new ExternalAPIException("Failed to call external API " + baseUrl, new RuntimeException());
        }
    }

    @Override
    public FakeStoreProductDTO updateProduct(long id, FakeStoreProductDTO fakeStoreProductDTO) {
        String url = getProductByIdUrl(id);
        try {
            HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(fakeStoreProductDTO);
            ResponseEntity<FakeStoreProductDTO> updatedProduct = restTemplateBuilder.build().exchange(url, HttpMethod.PUT, requestEntity, FakeStoreProductDTO.class, id);
            if (updatedProduct.getBody() != null && updatedProduct.getStatusCode().is2xxSuccessful()) {
                return updatedProduct.getBody();
            } else {
                throw new ExternalAPIException("Unexpected Response from external API" + baseUrl, new RuntimeException("Invalid API response"));
            }
        } catch (RestClientException e) {
            throw new ExternalAPIException("Failed to call external API " + baseUrl, new RuntimeException());
        }
    }

    @Override
    public FakeStoreProductDTO patchProduct(long id, FakeStoreProductDTO product) {
        return updateProduct(id, product);
    }

    @Override
    public FakeStoreProductDTO addProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        try {
            HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(fakeStoreProductDTO);
            ResponseEntity<FakeStoreProductDTO> responseProduct = restTemplateBuilder.build().postForEntity(baseUrl, requestEntity, FakeStoreProductDTO.class);
            if (responseProduct.getBody() != null && responseProduct.getStatusCode().is2xxSuccessful()) {
                return responseProduct.getBody();
            } else {
                throw new ExternalAPIException("Unexpected Response from external API" + baseUrl, new RuntimeException("Invalid API response"));
            }
        } catch (RestClientException e) {
            throw new ExternalAPIException("Failed to call external API " + baseUrl, new RuntimeException());
        }
    }

    @Override
    public void addProducts(List<FakeStoreProductDTO> product) {

    }

    @Override
    public FakeStoreProductDTO deleteProduct(long id) throws EntityNotFoundException {
        String url = getProductByIdUrl(id);
        try {
            ResponseEntity<FakeStoreProductDTO> responseProduct = restTemplateBuilder.build().exchange(url, HttpMethod.DELETE, null, FakeStoreProductDTO.class, id);
            if (responseProduct.getBody() != null && responseProduct.getStatusCode().is2xxSuccessful()) {
                return responseProduct.getBody();
            } else {
                throw new ExternalAPIException("Unexpected Response from external API" + baseUrl, new RuntimeException("Invalid API response"));
            }
        } catch (RestClientException e) {
            throw new ExternalAPIException("Failed to call external API " + baseUrl, new RuntimeException());
        }
    }
}
