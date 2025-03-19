package org.example.productcatalogservice_feb2025.controllers;

import org.example.productcatalogservice_feb2025.Exception.ExternalAPIException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, RuntimeException.class})
    public ResponseEntity<Map<String, Object>> handleExceptions(Exception exception, WebRequest request) {

        return buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Map<String, Object>> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex, WebRequest request) {
        return buildErrorResponse("Index out of bounds: " + ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }
    //ProductNotFoundException handled using @ResponseStatus in that class

    @ExceptionHandler(ExternalAPIException.class)
    public ResponseEntity<Map<String, Object>> handleExternalAPIException(ExternalAPIException ex, WebRequest request) {
    return buildErrorResponse(ex.getMessage(),HttpStatus.SERVICE_UNAVAILABLE, request);
    }



    //handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex, WebRequest request) {
        return buildErrorResponse("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    // 🔹 Helper Method to Format Error Responses
    private ResponseEntity<Map<String, Object>> buildErrorResponse(String message, HttpStatus status, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", status.value());
        errorDetails.put("error", status.getReasonPhrase());
        errorDetails.put("message", message);
        errorDetails.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(errorDetails, status);
    }
}


