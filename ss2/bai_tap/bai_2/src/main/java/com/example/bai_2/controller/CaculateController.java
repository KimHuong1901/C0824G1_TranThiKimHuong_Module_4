package com.example.bai_2.controller;

import com.example.bai_2.service.CaculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
       if (  num2 == 0 && opera.equals("div")) {
           model.addAttribute("error", "Cannot divide by zero. Please enter other number");
           return "caculate";
       }
       double result = 0;
       switch(opera){
           case "add":
               result = caculateService.add(num1, num2);
               break;
           case "sub":
               result = caculateService.sub(num1, num2);
               break;
           case "multi":
               result = caculateService.multi(num1, num2);
               break;
           case "div":
               result = caculateService.div(num1, num2);
               break;
       }
       model.addAttribute("result", result);
       return "caculate";
   }
}