package com.example.bai_tap.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleInvalidPriceException(IllegalArgumentException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "list";
    }
}
