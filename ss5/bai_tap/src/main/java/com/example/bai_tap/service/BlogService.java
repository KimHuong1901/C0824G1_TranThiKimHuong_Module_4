package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public void addNewBlog(Blog blog) {
        if(blog.getId()==null || findBlogById(blog.getId())!=null){
            blogRepository.save(blog);
        } else {
            throw new DuplicateKeyException("Blog already exists");
        }

    }

    @Override
    public void updateBlog(int id, Blog blog) {
        if(findBlogById(id)!=null){
            blogRepository.save(blog);
        }else {
            throw new NoSuchElementException("Not found with this id to update");
        }
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        if(findBlogById(id)!=null){
            return blogRepository.findById(id).get();
        }
        throw new NoSuchElementException("Not found with this id");
    }

    @Override
    public void deleteBlogById(int id) {
        if(findBlogById(id)!=null){
            blogRepository.deleteById(id);
        }
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }
}
