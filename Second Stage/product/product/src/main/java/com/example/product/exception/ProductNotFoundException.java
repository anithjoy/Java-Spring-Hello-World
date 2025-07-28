package com.example.product.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long Id) {
        super("Product not found with id: " + Id);
    }
}
