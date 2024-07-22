package com.example.advenced_restful_api.Controller;

import com.example.advenced_restful_api.Entity.Category;
import com.example.advenced_restful_api.Repository.CatogoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CategoryController {
    @Autowired
    CatogoryRepo catogoryRepo;

    @GetMapping("/rest/categories")
    public ResponseEntity<List<Category>> findAll(Model model) {
        return ResponseEntity.ok(catogoryRepo.findAll());
    }

    @GetMapping("/rest/categories/{id}")
    public ResponseEntity<Category> getOne(@PathVariable("id") Integer id) {
        if (!catogoryRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(catogoryRepo.findById(id).get());
    }

    @PostMapping("/rest/categories")
    public ResponseEntity<Category> post(@RequestBody Category category) {
        // Kiểm tra nếu Id không null và đã tồn tại
        if (category.getId() != null && catogoryRepo.existsById(category.getId())) {
            return ResponseEntity.badRequest().build();
        }
        // Lưu đối tượng category
        catogoryRepo.save(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/rest/categories/{id}")
    public ResponseEntity<Category> put(@PathVariable("id") Integer id, @RequestBody Category category) {
        if (!catogoryRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        category.setId(id); // Ensure the ID is set correctly
        catogoryRepo.save(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/rest/categories/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        if (!catogoryRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        catogoryRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
