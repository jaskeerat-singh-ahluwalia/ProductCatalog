package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testFindByCategory() {
        Product product1 = new Product(0, "Product1", 100.0, "Electronics", 10);
        Product product2 = new Product(0, "Product2", 200.0, "Electronics", 5);
        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> result = productRepository.findByCategory("Electronics");

        assertEquals(2, result.size());
    }

    @Test
    void testFindByCategoryAndPriceLessThan() {
        Product product = new Product(0, "Product1", 100.0, "Electronics", 10);
        productRepository.save(product);

        List<Product> result = productRepository.findByCategoryAndPriceLessThan("Electronics", 150.0);

        assertEquals(1, result.size());
    }

    @Test
    void testFindByPriceGreaterThan() {
        Product product = new Product(0, "Product1", 200.0, "Electronics", 10);
        productRepository.save(product);

        List<Product> result = productRepository.findByPriceGreaterThan(150.0);

        assertEquals(1, result.size());
    }
}
