package com.example.final_module.service;

import com.example.final_module.model.Discount;
import com.example.final_module.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscountService implements IDiscountSevice {
    @Autowired
    private DiscountRepository discountRepository;
    @Override
    public List<Discount> getDiscounts(String title) {
        return discountRepository.findAllByTitleContainingIgnoreCase(title);
    }

    @Override
    public void addNewDiscount(Discount discount) {
        discountRepository.save(discount);
    }


    @Override
    public boolean updateDiscount(int id, Discount discount) {
        discountRepository.save(discount);
        return true;
    }

    @Override
    public boolean removeDiscount(int id) {
        discountRepository.deleteById(id);
        return true;
    }

    @Override
    public Discount getDiscountById(int id) {
        return discountRepository.findById(id).orElse(null);
    }

}
