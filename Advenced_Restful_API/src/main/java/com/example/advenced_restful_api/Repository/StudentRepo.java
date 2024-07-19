package com.example.advenced_restful_api.Repository;

import com.example.advenced_restful_api.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
}
