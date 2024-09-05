package com.example.basicspringsecutiry.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/home/login")
    public String login() {
        return "home/fancy-login";
    }
    @GetMapping("/access")
    public String access(Model model){
        return "home/access";
    }

}
