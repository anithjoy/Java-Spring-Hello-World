package com.example.product.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @NotBlank(message = "(From DTO file)Product name is required")
    @Size(min = 2, max = 50, message = "(From DTO file)Product name must be between 2 and 50 characters")
    private String name;

    @DecimalMin(value = "0.01", message = "(From DTO file)Price must be greater than 0")
    private int price;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
