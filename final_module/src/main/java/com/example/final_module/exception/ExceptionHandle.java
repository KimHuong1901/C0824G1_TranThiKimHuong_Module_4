package com.example.final_module.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(DuplicateKeyException.class)
        public String handleDuplicateKeyException(DuplicateKeyException e, Model model){
            model.addAttribute("error", e.getMessage());
                return "discount";
        }
        @ExceptionHandler(NoSuchElementException.class)
            public String handleNoSuchElementException(NoSuchElementException e, Model model){
                model.addAttribute("error", e.getMessage());
                return "discount";
        }
}
