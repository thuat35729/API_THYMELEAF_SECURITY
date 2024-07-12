package com.example.bai2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/home")
    public String view(Model model){
        model.addAttribute("message", "FPT <b>Poly</b>");
        return "hello";
    }
}
