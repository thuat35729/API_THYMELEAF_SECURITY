package com.example.advenced_restful_api.Repository;

import com.example.advenced_restful_api.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
