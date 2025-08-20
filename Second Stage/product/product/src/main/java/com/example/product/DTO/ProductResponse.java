package com.example.product.DTO;



public class ProductResponse {


    private Long id;
    private String name;
    private int price;


    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

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
