package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String productName ;
    private double price;
    private String category;
    private int quantity;

    public Product (){

    }
    public Product(int id, String productName, double price, String category, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId(){
        return this.id;
    }
    public String getProductName(){
        return this.productName;
    }
    public double getPrice(){
        return this.price;
    }
    public String getCategory(){
        return this.category;
    }
    public int getQuantity(){
        return this.quantity;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setProductName(String ProductName){
        this.productName = ProductName;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void getQuantity(int quantity){
        this.quantity = quantity;
    }
}
