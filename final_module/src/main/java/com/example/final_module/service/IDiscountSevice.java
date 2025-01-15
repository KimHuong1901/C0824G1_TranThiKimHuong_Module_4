package com.example.final_module.service;

import com.example.final_module.model.Discount;

import java.util.List;

public interface IDiscountSevice {
    List<Discount> getDiscounts(String title);
    void addNewDiscount(Discount discount);
    boolean updateDiscount(int id, Discount discount);
    boolean removeDiscount(int id);
    Discount getDiscountById(int id);

}
