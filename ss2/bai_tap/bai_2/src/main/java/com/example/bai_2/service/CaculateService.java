package com.example.bai_2.service;

import org.springframework.stereotype.Service;

@Service
public class CaculateService implements ICaculateService {


    @Override
    public double caculate(double number1, double number2, String opera) {
        switch(opera){
            case "add":
                return number1 + number2;
            case "sub":
                return number1 - number2;
            case "multi":
                return number1 * number2;
            case "div":
                if(number2 == 0){
                    throw new ArithmeticException("Not divided by zero");
                }
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Invalid value");
        }
    }
}
