package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jaskeeratsingh
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue
     private int id;
     private String ProductName ;
     private double price;
     private String category;
     private int quantity;

     public int getId(){
         return this.id;
     }
    public String getProductName(){
        return this.ProductName;
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
         this.ProductName = ProductName;
    }
    public void setPrice(double price){
         this.price = price;
    }
    public void setCategory(String category){
         this.category = category;
    }
    public void getQuantity(int quantity){
        this.quantity = quantity;
    }
}
