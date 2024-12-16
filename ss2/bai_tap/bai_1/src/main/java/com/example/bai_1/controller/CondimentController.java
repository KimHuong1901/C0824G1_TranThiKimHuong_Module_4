package com.example.bai_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {
@GetMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment,
                       @RequestParam(value = "action", required = false) String action,
                       Model model) {
    if ("save".equals(action) && (condiment == null)) {
        model.addAttribute("error", "No Condiment selected");
    } else if (condiment != null) {
        model.addAttribute("condiment", condiment);
    }
    return "save";
}
}