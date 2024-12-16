package com.example.bai_1.service;

public interface ICaculateService {
   String convert(double amount, double rate);
   boolean isNumber(String amount);
   boolean isPositive(double amount);
}
