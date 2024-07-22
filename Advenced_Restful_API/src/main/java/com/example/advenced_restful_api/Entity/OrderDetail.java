package com.example.advenced_restful_api.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "OrderDetails")
public class OrderDetail implements Serializable {
    @Id
    Integer id;
    Integer orderId;
    Integer productId;
    Double price;
    Integer quantity;
    @ManyToOne
    @JoinColumn(name="order")
    Order order;
    @ManyToOne
    @JoinColumn(name="product")
    Product product;
}
