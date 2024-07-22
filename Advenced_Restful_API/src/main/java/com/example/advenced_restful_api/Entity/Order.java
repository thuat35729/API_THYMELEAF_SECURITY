package com.example.advenced_restful_api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="Orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String address;
    @Temporal(TemporalType.DATE)
    @Column(name="Createdate")
    Date createDate = new Date();
    @ManyToOne
    @JoinColumn(name="Username")
    Account account;
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
}
