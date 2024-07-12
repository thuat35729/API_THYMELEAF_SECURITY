package com.example.advanced_thymeleaf.controller;

import com.example.advanced_thymeleaf.model.Student;
import com.example.advanced_thymeleaf.model.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Studentcontroller {
    @GetMapping("/student/form")
    public String form(Model model){
        Student student = new Student();
        model.addAttribute("sv", student);
        return "student/form";
    }
    @GetMapping("/student/view-form")
    public String viewForm(Model model){
        Student2 student2 = new Student2();
        model.addAttribute("sv", student2);
        return "validation/form";
    }
    @PostMapping("/student/save")
    public String save(@ModelAttribute("sv") Student form, Error error){
        return "student/success";
    }
    @PostMapping("/student/validate")
    public String validate(Model model, @Validated @ModelAttribute("sv") Student2 form, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("message", "Vui longf sửa lỗi");
            return "validation/form";
        }
        return "validation/sucess";
    }
}
