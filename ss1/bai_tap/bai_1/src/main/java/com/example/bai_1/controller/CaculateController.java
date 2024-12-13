package com.example.bai_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;

@Controller
@RequestMapping("/caculate")
public class CaculateController {
    @Autowired
    private CaculateController caculateController;
    @GetMapping("")
    public String form(){
        return "caculate";
    }
    @PostMapping("/result")
    public String convertCurrency ( @RequestParam("amount") double amount, Model model){
        double rate = 24000;
        double result = rate * amount;
        DecimalFormat df = new DecimalFormat("#,###.##");
        String formattedResult = df.format(result);

        model.addAttribute("result", formattedResult);
        model.addAttribute("rate", rate);
        model.addAttribute("amount", amount);
        return "result";
    }

}
