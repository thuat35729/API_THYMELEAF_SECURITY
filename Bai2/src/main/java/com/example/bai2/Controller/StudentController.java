package com.example.bai2.Controller;

import com.example.bai2.Bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @RequestMapping("/student")
    public String index(Model model, @RequestParam("index") Optional<Integer> index) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File path = new ClassPathResource("\\static\\Student.json").getFile();
        TypeReference<List<Student>> typeref = new TypeReference<List<Student>>() {};
        List<Student> students = mapper.readValue(path, typeref);
        //Integer i = index.orElse(0);
        model.addAttribute("sv", students.get(index.orElse(0)));
        model.addAttribute("dssv", students);
        return "student/list";
    }
}
