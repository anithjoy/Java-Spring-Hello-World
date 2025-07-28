package com.example.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{

    // Custome Method
    // This custome method will query based on the method name .. there are multiple keywords in JPA spring query repository. Here findBy Between are keywords

    List<Product> findByName (String name);
    
    List<Product> findByPriceBetween(int price1, int price2);

}
