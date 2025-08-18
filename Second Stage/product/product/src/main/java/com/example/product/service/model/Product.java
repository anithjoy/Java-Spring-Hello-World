package com.example.product.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//      This annotation applies specifically to String fields. It enforces two conditions:
// The string must not be null.
// The string must contain at least one non-whitespace character after trimming any leading or trailing whitespace. This means empty strings ("") and strings containing only whitespace (" ") are considered invalid.
    @NotBlank(message = "Product name can not be empty")
    @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Product Price can not be null")
    @Min(value = 1, message = "Price  must be greater than 0")
    private int price;


    // Constructor
    public Product (){}

    public Product (long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Implement Getters and setters
    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }


}
