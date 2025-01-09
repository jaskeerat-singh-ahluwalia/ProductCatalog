package com.fyndna.demo.repository;

import com.fyndna.demo.entity.Product;
import com.fyndna.infra.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jaskeeratsingh
 */
@Repository
public interface ProductRepository extends AbstractRepository<Product, Integer> {
    List<Product> findByCategory(String category);
    List<Product> findByCategoryAndPriceLessThan(String category, double price);
    List<Product> findByPriceGreaterThan(double price);
}
