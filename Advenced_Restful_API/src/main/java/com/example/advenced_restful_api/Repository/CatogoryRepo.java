package com.example.advenced_restful_api.Repository;

import com.example.advenced_restful_api.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatogoryRepo extends JpaRepository<Category, Integer> {
}
