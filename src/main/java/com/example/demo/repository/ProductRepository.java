package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jaskeeratsingh
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(String category);
    List<Product> findByCategoryAndPriceLessThan(String category, double price);
    List<Product> findByPriceGreaterThan(double price);
}
