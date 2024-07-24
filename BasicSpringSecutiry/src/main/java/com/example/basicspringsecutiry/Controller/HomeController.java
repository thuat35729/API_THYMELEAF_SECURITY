package com.example.basicspringsecutiry.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "This is home page");
        return "home/home";
    }

//    @RequestMapping("/home/about")
//    public String about(Model model) {
//        model.addAttribute("message", "This is introduction page");
//        return "home/home"; // Ensure the template name matches
//    }
//

    @PostMapping("/login")
    public String lo() {
        // This endpoint is not necessary if you're using default Spring Security configuration.
        return "/home/home";
    }
}
