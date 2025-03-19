package org.example.productcatalogservice_feb2025.Service;

import org.example.productcatalogservice_feb2025.client.ThirdPartyProductServiceClient;
import org.example.productcatalogservice_feb2025.Exception.EntityNotFoundException;
import org.example.productcatalogservice_feb2025.mapper.MapperUtil;
import org.example.productcatalogservice_feb2025.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("thirdParty")
public class FakeStoreService implements ProductService {
    @Autowired
    ThirdPartyProductServiceClient client;

    @Autowired
    MapperUtil mapperUtil;

    @Override
    public Product getProductById(long id) {
        return mapperUtil.mapperFromFakeStoreDTOToProductEntity(client.getProductById(id));

    }

    @Override
    public List<Product> getAllProducts() {
        return mapperUtil.mapperFromFakeStoreDTOToProductEntity(client.getAllProducts());
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return mapperUtil.mapperFromFakeStoreDTOToProductEntity(client.updateProduct(id, mapperUtil.mapperFromProductEntityToFakeStoreDTO(product)));
    }

    @Override
    public Product patchProduct(long id, Product product) {
        return mapperUtil.mapperFromFakeStoreDTOToProductEntity(client.updateProduct(id, mapperUtil.mapperFromProductEntityToFakeStoreDTO(product)));
    }

    @Override
    public Product addProduct(Product product) {
        return mapperUtil.mapperFromFakeStoreDTOToProductEntity(client.addProduct(mapperUtil.mapperFromProductEntityToFakeStoreDTO(product)));
    }

    @Override
    public void addProducts(List<Product> products) {
        client.addProducts(mapperUtil.mapperFromProductEntityToFakeStoreDTO(products));
    }

    @Override
    public Product deleteProduct(long id) throws EntityNotFoundException {
        return mapperUtil.mapperFromFakeStoreDTOToProductEntity(client.deleteProduct(id));
    }
}

