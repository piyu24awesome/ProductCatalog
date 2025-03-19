package org.example.productcatalogservice_feb2025.Exception;

public class ExternalAPIException extends RuntimeException {

    public ExternalAPIException(String message, Throwable cause) {
        super(message, cause);
    }
}
