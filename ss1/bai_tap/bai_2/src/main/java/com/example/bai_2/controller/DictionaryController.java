package com.example.bai_2.controller;

import com.example.bai_2.service.DictionaryService;
import com.example.bai_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("/")
    public String dictionary() {
        return "dictionary";
    }
    @GetMapping("/dictionary")
    public String find(@RequestParam(value = "word", required = false) String word, Model model) {
        if(word != null) {
            String meaning = dictionaryService.getWord(word);
            model.addAttribute("word", word);
            model.addAttribute("meaning", meaning);
        }
        return "dictionary";
    }
}
