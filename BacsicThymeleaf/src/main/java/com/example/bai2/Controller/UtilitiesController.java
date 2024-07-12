package com.example.bai2.Controller;

import com.example.bai2.Bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
public class UtilitiesController {
    @RequestMapping("/util/home")
    public String util(Model model) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new ClassPathResource("\\static\\Student.json").getFile();
        TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {};
        List<Student> list = mapper.readValue(file, typeReference);
        model.addAttribute("listSV", list);
        model.addAttribute("date", new Date());
        return "student/utilities";
    }
}
