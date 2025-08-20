package com.example.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.DTO.ProductRequest;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.repository.ProductRepository;
import com.example.product.service.model.Product;
import java.util.List;

@Service
public class ProductService {

    // Service Takes Repository 
    @Autowired
    private ProductRepository productRepository;

    // Create product and return id (Think)
    // update product
    // public Product saveProduct (Product product) {
    //     return productRepository.save(product);
    // }

    public Product saveProduct (ProductRequest product) {
        Product prod = new Product();
        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        
        return productRepository.save(prod);
    }

    // Get Product by id
    public Product getProductById (Long Id) {
        return productRepository.findById(Id).orElse(null);
    }
    
    // Get all product
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    // Update product by id
    public Product updateProduct(Long id, ProductRequest product){
        Product existing = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return productRepository.save(existing);
    }

    // delete Product by id 

    public void deleteProductById(Long Id) {
        if(!productRepository.existsById(Id)){
            throw new ProductNotFoundException(Id);
        }
        
        productRepository.deleteById(Id);
    }

    //  Using Custom JPA repository Service

    public List<Product> findPriceBetween(int price1, int price2){
        return productRepository.findByPriceBetween(price1, price2);
    }



}
