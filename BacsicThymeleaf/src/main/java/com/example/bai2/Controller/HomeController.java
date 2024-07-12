package com.example.bai2.Controller;

import com.example.bai2.Bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {
    @RequestMapping("/home/index")
    public String view(Model model) throws Exception {
        model.addAttribute("massage", "Test tutol");
        ObjectMapper mapper = new ObjectMapper();
        String path = "D:\\Java6\\Bai2\\src\\main\\resources\\static\\Student.json";
        Student student = mapper.readValue(new File(path), Student.class);
        model.addAttribute("sv", student);
        return "home/index";
    }

}
