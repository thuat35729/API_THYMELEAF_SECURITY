package com.example.advenced_restful_api.Repository;

import com.example.advenced_restful_api.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {
}
