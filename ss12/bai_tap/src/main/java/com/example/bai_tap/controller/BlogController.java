package com.example.bai_tap.controller;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.model.Category;
import com.example.bai_tap.service.IBlogService;
import com.example.bai_tap.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ModelAndView viewAllBlog(Model model, @RequestParam(defaultValue = "") String title, @RequestParam(name="page", defaultValue = "0") Integer page){
        model.addAttribute("title", title);
        model.addAttribute("blogsSorted", blogService.findAllSortedByTime());
        model.addAttribute("blogs", blogService.findByTitle(title, page));
        return new ModelAndView("blog/list");
    }
    @GetMapping("/search")
    public String searchByCategory(@RequestParam("categoryName") String categoryName, Model model){
        Page<Blog> blogs = blogService.findAllByCategory(categoryName, 0);
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }
    @GetMapping("/show-add")
    public String showAddBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.getAll());
        return "blog/add";
    }
    @PostMapping("/add")
    public String addBlog(@ModelAttribute("blog") Blog blog,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                          Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getAllErrors());
            model.addAttribute("categories",categoryService.getAll());
            return "blog/list";
        }
        if(blog.getId()==null || blogService.findById(blog.getId()) != null){
            blogService.addNew(blog);
        }else {
            throw new DuplicateKeyException("Blog already exits");
        }
        redirectAttributes.addFlashAttribute("message", "Blog added successfully");
            return "redirect:/blog";
    }
    @GetMapping("/{id}/show-update")
    public String showUpdateBlogForm(@PathVariable("id") int id, @ModelAttribute("blog") Blog blog, Model model) {
        if(blogService.findById(id) != null){
            model.addAttribute("blog", blog);
            model.addAttribute("categories", categoryService.getAll());
            return "blog/update";
        }else {
            throw new NoSuchElementException("Not found with this id to update");
        }
    }
    @PostMapping("/{id}/update")
    public String updateBlog(@PathVariable("id") int id, @ModelAttribute("blog") Blog blog,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getAllErrors());
            model.addAttribute("categories",  categoryService.getAll().stream().map(Category::getId).toList());
            return "blog/list";
        }
        blog.setId(id);
        blogService.update(id, blog);
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable( "id") int id,
                             RedirectAttributes redirectAttributes) {
        if(blogService.findById(id) != null){
            blogService.deleteById(id);
        }else {
            throw new NoSuchElementException("Not found with this id to delete");
        }
        redirectAttributes.addFlashAttribute("message", "Blog deleted successfully");
        return "redirect:/blog";
    }
    @GetMapping("/{id}")
    public String viewDetail(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.getById(id);
        Category category = categoryService.getById(blog.getCategory().getId());
        model.addAttribute("blog", blog);
        model.addAttribute("category", category);
        return "blog/detail";
    }

}
