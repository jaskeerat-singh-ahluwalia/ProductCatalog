package com.fyndna.demo.controller;

import com.fyndna.demo.entity.Product;
import com.fyndna.demo.service.ProductService;
import com.fyndna.common.controller.AbstractController;
import com.fyndna.common.domain.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author jaskeeratsingh
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController extends AbstractController {

    @Autowired
    private ProductService service;

    @PostMapping
    public BaseResponse<Product> addProduct(@RequestBody Product product){
        return new BaseResponse<>(service.saveProduct(product), HttpStatus.OK);
    }

//    @GetMapping
//    public List<Product> findAllProducts(){
//        return service.getProducts();
//    }
//
//    @GetMapping("/{id}")
//    public Product findProductById(@PathVariable int id){
//        return service.getProductById(id);
//    }
//
//    @GetMapping("/category/{category}")
//    public List<Product> getProductsByCategory(@PathVariable String category) {
//        return service.getProductsByCategory(category);
//    }
//
//    @PutMapping("/{id}")
//    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
//        return service.updateProduct(id,product);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteProduct(@PathVariable int id){
//        return service.deleteProduct(id);
//    }
//
//    @GetMapping("/category/{category}/price/{price}")
//    public List<Product> getProductsByCategoryAndPrice(
//            @PathVariable String category,
//            @PathVariable double price) {
//        return service.getProductsByCategoryAndPrice(category, price);
//    }
//
//    @GetMapping("/price/{price}")
//    public List<Product> getProductsByPrice(@PathVariable double price) {
//        return service.getProductsByPrice(price);
//    }



}
