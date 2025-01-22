package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testAddProduct() throws Exception {
        Product product = new Product(1, "Product1", 100.0, "Category1", 10);

        when(productService.saveProduct(any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"productName\":\"Product1\",\"price\":100.0,\"category\":\"Category1\",\"quantity\":10}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.productName").value("Product1"))
                .andExpect(jsonPath("$.price").value(100.0))
                .andExpect(jsonPath("$.category").value("Category1"))
                .andExpect(jsonPath("$.quantity").value(10));

        verify(productService, times(1)).saveProduct(any(Product.class));
    }

    @Test
    void testFindAllProducts() throws Exception {
        List<Product> products = Arrays.asList(
                new Product(1, "Product1", 100.0, "Category1", 10),
                new Product(2, "Product2", 200.0, "Category2", 5)
        );

        when(productService.getProducts()).thenReturn(products);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].productName").value("Product1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].productName").value("Product2"));

        verify(productService, times(1)).getProducts();
    }

    @Test
    void testFindProductById() throws Exception {
        Product product = new Product(1, "Product1", 100.0, "Category1", 10);

        when(productService.getProductById(1)).thenReturn(product);

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.productName").value("Product1"));

        verify(productService, times(1)).getProductById(1);
    }

    @Test
    void testDeleteProduct() throws Exception {
        when(productService.deleteProduct(1)).thenReturn("Product deleted successfully");

        mockMvc.perform(delete("/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Product deleted successfully"));

        verify(productService, times(1)).deleteProduct(1);
    }
}
