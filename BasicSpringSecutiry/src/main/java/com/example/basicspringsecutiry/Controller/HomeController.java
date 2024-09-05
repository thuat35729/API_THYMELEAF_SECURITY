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

    @GetMapping("/leaders")
    public String leader(Model model) {
        model.addAttribute("message", "This is introduction page");
        return "home/leader"; // Ensure the template name matches
    }
    @GetMapping("/systems")
    public String systems(Model model) {
        model.addAttribute("message", "This is introduction page");
        return "home/systems"; // Ensure the template name matches
    }

}
