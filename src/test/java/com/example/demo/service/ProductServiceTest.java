package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProduct() {
        Product product = new Product(1, "Product1", 100.0, "Category1", 10);
        when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.saveProduct(product);

        assertNotNull(savedProduct);
        assertEquals(1, savedProduct.getId());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testGetProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product1", 100.0, "Category1", 10),
                new Product(2, "Product2", 200.0, "Category2", 5)
        );
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getProducts();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductById() {
        Product product = new Product(1, "Product1", 100.0, "Category1", 10);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1);

        assertNotNull(result);
        assertEquals("Product1", result.getProductName());
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void testUpdateProduct() {
        Product existingProduct = new Product(1, "OldName", 100.0, "Category1", 10);
        Product updatedProduct = new Product(1, "UpdatedName", 150.0, "Category1", 20);

        when(productRepository.findById(1)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

        Product result = productService.updateProduct(1, updatedProduct);

        assertNotNull(result);
        assertEquals("UpdatedName", result.getProductName());
        assertEquals(150.0, result.getPrice());
        verify(productRepository, times(1)).findById(1);
        verify(productRepository, times(1)).save(existingProduct);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1);

        String result = productService.deleteProduct(1);

        assertEquals("Product removed !! 1", result);
        verify(productRepository, times(1)).deleteById(1);
    }
}
