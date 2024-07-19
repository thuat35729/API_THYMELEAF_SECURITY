package com.example.advenced_restful_api.Controller;

import com.example.advenced_restful_api.Entity.Student;
import com.example.advenced_restful_api.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;
    @GetMapping("/rest/student")
    public List<Student> getAll(Model model){
        return studentRepo.findAll();
    }
    @GetMapping("/rest/student/{email}")
    public Student getOne(@PathVariable("email") String email){
        return studentRepo.findById(email).get();
    }
    @PostMapping("/rest/student")
    public Student post(@RequestBody Student student){
        studentRepo.save(student);
        return student;
    }
    @PutMapping("/rest/student/{email}")
    public Student put(@PathVariable("email")String email, @RequestBody Student student){
        studentRepo.save(student);
        return student;
    }
    @DeleteMapping("rest/student/{email}")
    public void delete(@PathVariable("email" )String email){
        studentRepo.deleteById(email);
    }

}
