package com.example.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.DTO.ProductRequest;
import com.example.product.DTO.ProductResponse;
import com.example.product.service.ProductService;
import com.example.product.service.model.Product;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/products")
public class ProductController {

    // Controller Takes Service
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    // @PostMapping
    // public Product saveProduct(@Valid @RequestBody Product product) {
    //     return productService.saveProduct(product);
    // }

    @PostMapping
    public ProductResponse saveProduct(@Valid @RequestBody ProductRequest product) {
        
        Product saved =  productService.saveProduct(product);

        ProductResponse pRes = new ProductResponse();
        pRes.setId(saved.getId());
        pRes.setName(saved.getName());
        pRes.setPrice(saved.getPrice());
        return pRes;
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // @PutMapping("/{id}")
    // public Product updateProduct(@PathVariable Long id,@Valid @RequestBody Product updatedProduct){
    //     Product product = productService.getProductById(id);
    //     product.setName(updatedProduct.getName());
    //     product.setPrice(updatedProduct.getPrice());
    //     return productService.saveProduct(product);       
    // }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id,@Valid @RequestBody ProductRequest updatedProduct){
        Product product = productService.updateProduct(id, updatedProduct);
        
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(updatedProduct.getName());
        response.setPrice(updatedProduct.getPrice()); 
        return response;      
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/filter")
    public List<Product> findPriceBetween(@RequestParam int min,@RequestParam int max) {
        return productService.findPriceBetween(min, max);
    }

}   
