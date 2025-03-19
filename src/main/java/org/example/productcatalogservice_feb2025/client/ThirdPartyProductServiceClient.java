package org.example.productcatalogservice_feb2025.client;

import org.example.productcatalogservice_feb2025.Exception.EntityNotFoundException;

import java.util.List;


public interface ThirdPartyProductServiceClient {

    public FakeStoreProductDTO getProductById(long id);

    public List<FakeStoreProductDTO> getAllProducts();

    public FakeStoreProductDTO updateProduct(long id, FakeStoreProductDTO product);

    public FakeStoreProductDTO patchProduct(long id, FakeStoreProductDTO product);

    public FakeStoreProductDTO addProduct(FakeStoreProductDTO product);

    public void addProducts(List<FakeStoreProductDTO> product);

    public FakeStoreProductDTO deleteProduct(long id) throws EntityNotFoundException;
}
