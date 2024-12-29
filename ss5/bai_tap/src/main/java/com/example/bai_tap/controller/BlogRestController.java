package com.example.bai_tap.controller;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.model.Category;
import com.example.bai_tap.service.IBlogService;
import com.example.bai_tap.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<Page<Blog>> getAllBlogs(@RequestParam(defaultValue = "") String title) {
        return new ResponseEntity<>(blogService.findByTitle(title, 0), HttpStatus.OK);
    }
    @GetMapping("/search_category")
    public ResponseEntity<Page<Blog>> searchByCategory(@RequestParam(defaultValue = "") String categoryName){
        return new ResponseEntity<>(blogService.findAllByCategory(categoryName, 0), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> detailBlog(@PathVariable ("id") int id) {
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "") String categoryName) {
        return new ResponseEntity<>(categoryService.findByName(categoryName, 0), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        blogService.addNew(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
