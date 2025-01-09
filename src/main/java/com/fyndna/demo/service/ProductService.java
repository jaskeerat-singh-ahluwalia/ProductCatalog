package com.fyndna.demo.service;

import com.fyndna.demo.policy.ProductBusinessPolicy;
import com.fyndna.demo.repository.ProductRepository;
import com.fyndna.infra.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fyndna.demo.entity.Product;

import java.util.List;


/**
 * @author jaskeeratsingh
 */
@Service
public class ProductService extends AbstractService<ProductRepository, Product, Integer> {

    @Autowired
    private ProductRepository repository;

    public ProductService(ProductRepository repository, ProductBusinessPolicy policy) {
        super(repository,policy);
        this.repository = repository;
    }

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
