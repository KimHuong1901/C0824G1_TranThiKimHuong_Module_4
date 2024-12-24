package com.example.th1.controller;

import com.example.th1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "list";
    }
}
