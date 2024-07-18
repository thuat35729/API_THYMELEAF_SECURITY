package com.example.basicrestfulapi.Controller;

import com.example.basicrestfulapi.Entity.User;
import com.example.basicrestfulapi.Map.UserMap;
import com.example.basicrestfulapi.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;


    @RequestMapping("/user/index")
    public String index(Model model) {
        User user = new User("", "", 0.0, true, "VN");
        model.addAttribute("form", user);
        UserMap userMap = userRepo.findAll();
        model.addAttribute("items", userMap);
        return "index/User";
    }

    @RequestMapping("/student/edit/{key}")
    public String edit(Model model, @PathVariable("key") String key) {
        model.addAttribute("key", key);
        User user = userRepo.findByKey(key);
        model.addAttribute("form", user);
        UserMap userMap = userRepo.findAll();
        model.addAttribute("items", userMap);
        return "index/User";
    }

    @RequestMapping("/student/create")
    public String create(User user) {
        userRepo.create(user);
        return "redirect:/user/index";
    }

    @RequestMapping("/student/update/{key}")
    public String update(@PathVariable("key") String key, User user) {
        userRepo.update(key, user);
        return "redirect:/student/edit/" + key;
    }

    @RequestMapping("/student/delete/{key}")
    public String delete(@PathVariable("key") String key) {
        userRepo.delete(key);
        return "redirect:/user/index";
    }
}
