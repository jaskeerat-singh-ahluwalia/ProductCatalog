package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void testProductGettersAndSetters() {
        Product product = new Product();
        product.setId(1);
        product.setProductName("Product1");
        product.setPrice(100.0);
        product.setCategory("Electronics");
        product.setQuantity(10);

        assertEquals(1, product.getId());
        assertEquals("Product1", product.getProductName());
        assertEquals(100.0, product.getPrice());
        assertEquals("Electronics", product.getCategory());
        assertEquals(10, product.getQuantity());
    }

    @Test
    void testProductConstructor() {
        Product product = new Product(1, "Product1", 100.0, "Electronics", 10);

        assertEquals(1, product.getId());
        assertEquals("Product1", product.getProductName());
        assertEquals(100.0, product.getPrice());
        assertEquals("Electronics", product.getCategory());
        assertEquals(10, product.getQuantity());
    }
}
