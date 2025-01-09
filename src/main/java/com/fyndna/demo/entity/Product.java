package com.fyndna.demo.entity;

import com.fyndna.infra.entity.AbstractDomainEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author jaskeeratsingh
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")
public class Product extends AbstractDomainEntity<Integer> {
    @Id
    @GeneratedValue
     private Integer id;
     private String ProductName ;
     private double price;
     private String category;
     private int quantity;
}
