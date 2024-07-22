package com.example.advenced_restful_api.Repository;

import com.example.advenced_restful_api.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
