package com.example.bai_2.controller;

import com.example.bai_2.service.CaculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculateController  {
   @Autowired
    private CaculateService caculateService;
   @GetMapping("/caculate")
    public String caculate(@RequestParam(required = false, defaultValue = "0") Double num1,
                           @RequestParam(required = false, defaultValue = "0") Double num2,
                           @RequestParam(required = false, defaultValue = "add") String opera,
                           Model model){
       double result = caculateService.caculate(num1, num2, opera);
       model.addAttribute("num1", num1);
       model.addAttribute("num2", num2);
       model.addAttribute("opera", opera);
       model.addAttribute("result", result);
       return "caculate";
   }
   @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model){
       model.addAttribute("error", "Please enter the number");
       return "caculate";
   }
   @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException ex, Model model){
       model.addAttribute("error", ex.getMessage());
       return "caculate";
   }
}