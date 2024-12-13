package com.example.bai_2.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository {
 private static final Map<String, String> dictionaryMap = new HashMap<>();
 static {
     dictionaryMap.put("apple", "táo");
     dictionaryMap.put("flower", "hoa");
     dictionaryMap.put("cat", "mèo");
     dictionaryMap.put("home", "nhà");
 }
 public String findWord(String word) {
     return dictionaryMap.get(word);
 }
}
