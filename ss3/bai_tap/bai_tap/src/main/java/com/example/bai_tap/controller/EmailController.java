package com.example.bai_tap.controller;

import com.example.bai_tap.model.Email;
import com.example.bai_tap.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @GetMapping("")
    public ModelAndView viewEmail(Model model){
        return new ModelAndView("information", "emails", emailService.getAll());
    }
    @GetMapping("/update")
        public String information(Model model){
        model.addAttribute("emails", new Email());
        model.addAttribute("language", new String[] {"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("size", new String[] {"5", "10", "15", "25", "50", "100"});
        return "update";
    }
    @PostMapping("/update")
    public String updateInformation(@ModelAttribute ("emails") Email email, BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",  bindingResult.getAllErrors());
            model.addAttribute("language", new String[] {"English", "Vietnamese", "Japanese", "Chinese"});
            model.addAttribute("size", new int[] {5, 10, 15, 25, 50, 100});
            model.addAttribute("emails", email);
            return "update";
        }
        emailService.update(email);
        model.addAttribute("emails", email);
        model.addAttribute("update", true);
        model.addAttribute("language", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("size", new String[]{"5", "10", "15", "25", "50", "100"});
        return "update";
    }

}
