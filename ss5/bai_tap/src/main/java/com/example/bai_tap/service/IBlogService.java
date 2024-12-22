package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;

import java.util.List;
public interface IBlogService {
    void addNewBlog(Blog blog);
    void updateBlog(int id, Blog blog);
    List<Blog> getAllBlogs();
    Blog getBlogById(int id);
    void deleteBlogById(int id);
    Blog findBlogById(int id);
}
