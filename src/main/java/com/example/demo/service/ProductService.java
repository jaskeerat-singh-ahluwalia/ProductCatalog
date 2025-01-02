package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;


/**
 * @author jaskeeratsingh
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id ){
        return repository.findById(id).orElse(null);
    }

    public String deleteProduct (int id ){
        repository.deleteById(id);
        return "product deleted" + id ;
    }

    public Product updateProduct(int id,Product product){
        Product oldProduct= repository.findById(id).orElse(null);
        System.out.println(oldProduct.getProductName());
        oldProduct.setProductName(product.getProductName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setCategory(product.getCategory());
        oldProduct.setPrice(product.getPrice());
        return repository.save(oldProduct);

    }

    public List<Product> getProductsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Product> getProductsByCategoryAndPrice(String category, double price) {
        return repository.findByCategoryAndPriceLessThan(category, price);
    }
    public List<Product> getProductsByPrice(double price) {
        return repository.findByPriceGreaterThan(price);
    }


}
