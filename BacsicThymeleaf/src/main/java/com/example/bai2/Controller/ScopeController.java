package com.example.bai2.Controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    ServletContext servletContext;
    @Autowired
    HttpSession session;

    @RequestMapping("/scope")
    public String index(Model model) {
        model.addAttribute("A", "Model day");
        request.setAttribute("B", "Request day");
        session.setAttribute("C", "Session day");
        servletContext.setAttribute("D", "Application day");
        return "scope/index";
    }
}
