package com.example.bai_tap.controller;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.service.BlogService;
import com.example.bai_tap.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ModelAndView viewAllBlog(Model model, @RequestParam(defaultValue = "") String title){
            model.addAttribute("title", title);
            return new ModelAndView("list", "blogs", blogService.getAllBlogs());
    }
    @GetMapping("/show-add")
    public String showAddBlogForm() {
        return "add";
    }
    @PostMapping("/add")
    public String addBlog(@ModelAttribute("blog") Blog blog,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                          Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getAllErrors());
            return "list";
        }
        blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Blog added successfully");
            return "redirect:/blog";
    }
    @GetMapping("/{id}/show-update")
    public String showUpdateBlogForm(@PathVariable("id") int id, @ModelAttribute("blog") Blog blog, Model model) {
        blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "update";
    }

    @PostMapping("/{id}/update")
    public String updateBlog(@PathVariable("id") int id, @ModelAttribute("blog") Blog blog,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getAllErrors());
            return "list";
        }
        blog.setId(id);
        blogService.updateBlog(id, blog);
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable( "id") int id,
                             RedirectAttributes redirectAttributes) {
        blogService.deleteBlogById(id);
        redirectAttributes.addFlashAttribute("message", "Blog deleted successfully");
        return "redirect:/blog";
    }
    @GetMapping("/{id}")
    public String viewDetail(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

}
