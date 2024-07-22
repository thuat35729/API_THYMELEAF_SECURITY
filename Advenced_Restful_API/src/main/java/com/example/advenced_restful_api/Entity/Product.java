package com.example.advenced_restful_api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String image;
    Double price;
    @Temporal(TemporalType.DATE)
    @Column(name="Createdate")
    Date createDate = new Date();
    Boolean availeble;
    @ManyToOne
    @JoinColumn(name="Categoryid")//tên giống map bên Category
    Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}

