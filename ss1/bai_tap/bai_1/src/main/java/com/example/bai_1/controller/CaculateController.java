package com.example.bai_1.controller;

import com.example.bai_1.service.CaculateService;
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
    private CaculateService caculateService;
    @GetMapping("")
    public String form(){
        return "caculate";
    }
    @PostMapping("/result")
    public String convert( @RequestParam("amount") String amountStr, Model model){
        double rate = 24000;
        boolean isNumber = caculateService.isNumber(amountStr);
        if(!isNumber){
            model.addAttribute("error", "Amount must be a number");
            return "caculate";
        }

        double amount = Double.parseDouble(amountStr);
        boolean isPositive = caculateService.isPositive(amount);
        if(!isPositive){
            model.addAttribute("error", "Amount have to greater than 0");
            return "caculate";
        }
            String result = caculateService.convert(amount, rate);
            model.addAttribute("result", result);
            model.addAttribute("rate", rate);
            model.addAttribute("amount", amount);
            return "result";

    }

}
