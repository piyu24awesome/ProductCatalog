package org.example.productcatalogservice_feb2025.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ProductListEmptyException extends RuntimeException {

    public ProductListEmptyException(String message) {
        super(message);
    }

}
