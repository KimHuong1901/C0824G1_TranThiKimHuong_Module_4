package com.example.bai_2.service;

import com.example.bai_2.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Override
    public String getWord(String word) {
        if(word == null || word.isEmpty()){
            return "You have to enter a word";
        }
        String meaning = dictionaryRepository.findWord(word);
        if(meaning != null){
            return meaning;
        } else {
            return "Not found with this word";
        }
    }
}
