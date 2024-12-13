package com.example.thuc_hanh_2.controller;

import com.example.thuc_hanh_2.model.Customer;
import com.example.thuc_hanh_2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("")
    public ModelAndView viewAllCustomer(Model model) {
        List< Customer> customerList = customerService.getCustomers();
            model.addAttribute("customerList", customerList);
        return new ModelAndView("customer");
    }
}
