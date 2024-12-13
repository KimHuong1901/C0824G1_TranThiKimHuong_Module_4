package com.example.thuc_hanh1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class THController {
    @GetMapping("/th")
        public String th(){
            return "index";
        }
    }

