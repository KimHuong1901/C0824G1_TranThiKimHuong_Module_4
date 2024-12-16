package com.example.bai_1.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CaculateService implements ICaculateService {
    public String convert(double amount, double rate) {
        double result = rate * amount;
        DecimalFormat df = new DecimalFormat("#,###.##");
        return df.format(result);
    }

    @Override
    public boolean isNumber(String amount) {
        try {
            Double.parseDouble(amount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isPositive(double amount) {
        if(amount > 0){
            return true;
        }
        return false;
    }

}
