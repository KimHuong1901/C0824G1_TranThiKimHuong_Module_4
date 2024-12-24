package com.example.bai_1.controller;

import com.example.bai_1.model.User;
import com.example.bai_1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
    public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
        public String viewHomePage(){
            return "home";
    }
    @GetMapping("/show-regis")
        public String showRegisForm(Model model){
        model.addAttribute("user", new User());
            return "regis";
    }
    @PostMapping("/registration")
        public String regisUser(@Validated @ModelAttribute("user") User user,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("error", bindingResult.getAllErrors());
            return "regis";
        }
        redirectAttributes.addFlashAttribute("mess", "Registration Successful");
        return "redirect:/home";
    }
}
