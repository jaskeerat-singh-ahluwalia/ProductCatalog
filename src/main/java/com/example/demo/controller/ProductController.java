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
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @GetMapping
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return service.getProductsByCategory(category);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
        return service.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    @GetMapping("/category/{category}/price/{price}")
    public List<Product> getProductsByCategoryAndPrice(
            @PathVariable String category,
            @PathVariable double price) {
        return service.getProductsByCategoryAndPrice(category, price);
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductsByPrice(@PathVariable double price) {
        return service.getProductsByPrice(price);
    }



}
