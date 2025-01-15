package com.example.bai_tap.controller;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.service.IProductService;
import com.example.bai_tap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/product")
    @GetMapping("")
    public ModelAndView viewProduct(Model model){
        return new ModelAndView("list", "products", productService.getAllProducts());
    }
    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable(name = "id")  int id, @ModelAttribute("product") Product product,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        product.setId(id);
        boolean isValue= productService.updateProduct(product);
        if(!isValue){
            redirectAttributes.addFlashAttribute("error", "Product with id " + id + " does not exists");
            return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("message", "Product updated successfully");
        return "redirect:/product";
    }
    @PostMapping("/create")
    public String addProduct(@ModelAttribute("product") Product product,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "fragment";
        }
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product added successfully");
        return "redirect:/product";
    }
    @GetMapping("/{id}/confirm-delete")
    public String deleteProduct(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        boolean isValue = productService.deleteProduct(id);
        if(!isValue){
            redirectAttributes.addFlashAttribute("error", "Product with id " + id + " does not exists");
            return "redirect:/product";
        }
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully");
        return "redirect:/product";
    }
}

