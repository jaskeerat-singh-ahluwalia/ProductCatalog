package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jaskeeratsingh
 *
 */
@RestController

public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/products/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return service.getProductsByCategory(category);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
        return service.updateProduct(id,product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    @GetMapping("/products/category/{category}/price/{price}")
    public List<Product> getProductsByCategoryAndPrice(
            @PathVariable String category,
            @PathVariable double price) {
        return service.getProductsByCategoryAndPrice(category, price);
    }

    @GetMapping("/products/price/{price}")
    public List<Product> getProductsByPrice(@PathVariable double price) {
        return service.getProductsByPrice(price);
    }



}
