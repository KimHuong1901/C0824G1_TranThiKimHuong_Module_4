package com.example.bai_tap.controller;
import com.example.bai_tap.model.Category;
import com.example.bai_tap.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ModelAndView viewAllCategory(Model model, @RequestParam(defaultValue = "") String title){
        model.addAttribute("title", title);
        return new ModelAndView("list", "categories", categoryService.getAll());
    }
    @GetMapping("/show-add")
    public String showAddCategoryForm() {
        return "add";
    }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category")Category category,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getAllErrors());
            return "category/list";
        }
        if(category.getId()==null || categoryService.findById(category.getId()) != null){
            categoryService.addNew(category);
        }else {
            throw new DuplicateKeyException("Category already exits");
        }
        redirectAttributes.addFlashAttribute("message", "Category added successfully");
        return "redirect:/category";
    }
    @GetMapping("/{id}/show-update")
    public String showUpdateCategoryForm(@PathVariable("id") int id, @ModelAttribute("category") Category category, Model model) {
        if(categoryService.findById(id) != null){
            model.addAttribute("category", category);
            return "category/update";
        }else {
            throw new NoSuchElementException("Not found with this id to update");
        }
    }
    @PostMapping("/{id}/update")
    public String updateCategory(@PathVariable("id") int id, @ModelAttribute("category") Category category,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getAllErrors());
            return "category/list";
        }
        category.setId(id);
        categoryService.update(id, category);
        redirectAttributes.addFlashAttribute("message", "Category updated successfully");
        return "redirect:/category";
    }
    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable( "id") int id,
                             RedirectAttributes redirectAttributes) {
        if(categoryService.findById(id) != null){
            categoryService.deleteById(id);
        }else {
            throw new NoSuchElementException("Not found with this id to delete");
        }
        redirectAttributes.addFlashAttribute("message", "Category deleted successfully");
        return "redirect:/category";
    }
}
