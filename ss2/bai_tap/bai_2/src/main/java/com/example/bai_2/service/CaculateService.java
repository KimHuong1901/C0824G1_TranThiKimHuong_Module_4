package com.example.bai_2.service;

import org.springframework.stereotype.Service;

@Service
public class CaculateService implements ICaculateService {
    @Override
    public double add(double number1, double number2) {
        return number1 + number2;
    }

    @Override
    public double sub(double number1, double number2) {
        return number1 - number2;
    }

    @Override
    public double multi(double number1, double number2) {
        return number1 * number2;
    }

    @Override
    public double div(double number1, double number2) {
        return number1 / number2;
    }
}
