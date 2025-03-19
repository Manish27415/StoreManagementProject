package com.example.demo.StoreManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Entity
@Table(name = "products")
public class StoreEntity
{
    @Id
    @Column(name = "productId")
    private String productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private double productPrice;

    @Column(name = "productQuantity")
    private int productQuantity;

}
