package com.example.bai_tap.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(DuplicateKeyException.class)
        public String handleDuplicateKeyException(DuplicateKeyException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "list";
            }
            @ExceptionHandler(NoSuchElementException.class)
                public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException e) {
                    Map<String, String> map = new HashMap<>();
                    map.put("error", e.getMessage());
                    return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
                }
            }

}
