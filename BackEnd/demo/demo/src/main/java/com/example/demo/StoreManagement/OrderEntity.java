package com.example.demo.StoreManagement;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Column(name = "orderId")
    private String orderId;

    @Column(name = "productId")
    private String productId;

    @Column(name = "orderQuantity")
    private int orderQuantity;
}
