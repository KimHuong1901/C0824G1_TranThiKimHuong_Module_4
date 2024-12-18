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
    @GetMapping("/list")
    public ModelAndView viewProduct(Model model){
        return new ModelAndView("list", "products", productService.getAllProducts());
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute("product") Product product,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        product.setId(id);
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully");
        return "redirect:/list";
    }
    @PostMapping("/create")
    public String addProduct(@ModelAttribute("product") Product product,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "add";
        }
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product added successfully");
        return "redirect:/list";
    }
    @GetMapping("/confirm-delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully");
        return "redirect:/list";
    }
    @GetMapping("detail/{id}")
    public String detailProduct(@PathVariable int id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "detail";
    }

}

