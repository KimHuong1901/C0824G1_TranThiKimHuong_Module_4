package com.example.final_module.controller;

import com.example.final_module.model.Discount;
import com.example.final_module.service.IDiscountSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/home")
public class DiscountController {
    @Autowired
    private IDiscountSevice discountSevice;
    @GetMapping("")
    public String showListDiscount(@RequestParam(defaultValue = "") String information,
                                   Model model){
        model.addAttribute("information", information);
        List<Discount> discounts = discountSevice.getDiscounts(information);
        model.addAttribute("discounts", discounts);
        return"discounts";
    }
    @GetMapping("/search")
    public String searchByCategory(@RequestParam(defaultValue = "")  String information, Model model){
        List<Discount> discounts = discountSevice.getDiscounts(information);
        model.addAttribute("discount", discounts);
        return "discounts";
    }
    @GetMapping("/add")
    public String addDiscount(Model model){
        model.addAttribute("discount", new Discount());
        return"addNew";
    }
    @PostMapping("/add")
    public String addNewDiscount(@Validated @ModelAttribute("discount") Discount discount,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getAllErrors());
            return"addNew";
        }
        if(discount.getId()==null || discountSevice.getDiscountById(discount.getId())==null){
            discountSevice.addNewDiscount(discount);
        }else {
            throw new DuplicateKeyException("Discount already exits");
        }
        redirectAttributes.addFlashAttribute("message", "Discount added successfully");
        return "redirect:/home";
    }
    @GetMapping("/{id}/show-update")
    public String updateDiscount(@PathVariable("id") int id, @ModelAttribute("discount") Discount discount,  Model model){
        if(discountSevice.getDiscountById(id)!=null){
            model.addAttribute("discount", discount);
            return "updateDiscount";
        }else {
        throw new NoSuchElementException("Not found with this discount to update");
        }
    }
    @PostMapping("/{id}/update")
    public String updateDiscount( @Validated @PathVariable("id") int id, @ModelAttribute("discount") Discount discount,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model){
        if(bindingResult.hasErrors()){
        model.addAttribute("error", bindingResult.getAllErrors());
        return "updateDiscount";
        }
        discount.setId(id);
        discountSevice.updateDiscount(id, discount);
        redirectAttributes.addFlashAttribute("message", "Discount updated successfully");
        return "redirect:/home";
    }
    @PostMapping("/{id}/delete")
    public String deleteDiscount(@PathVariable("id") int id,
                                 RedirectAttributes redirectAttributes){
        if(discountSevice.getDiscountById(id)!=null){
            discountSevice.removeDiscount(id);
        }else {
            throw new NoSuchElementException("Not found with this discount to delete");
        }
        redirectAttributes.addFlashAttribute("message", "Discount deleted successfully");
        return "redirect:/home";
    }

}
