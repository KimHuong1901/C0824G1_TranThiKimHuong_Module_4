package com.example.bai_tap.service.imple;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.repository.BlogRepository;
import com.example.bai_tap.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public void addNew(Blog blog) {
            blogRepository.save(blog);
    }
    @Override
    public boolean update(int id, Blog blog) {
            blogRepository.save(blog);
        return true;
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getById(int id) {
            return blogRepository.findById(id).get();
    }

    @Override
    public boolean deleteById(int id) {
            blogRepository.deleteById(id);
            return true;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findByTitle(String title, Integer page) {
        return blogRepository.findAllByTitleContainingIgnoreCase(title, PageRequest.of(page, 10));
    }

    @Override
    public List<Blog> findAllSortedByTime() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "time"));
    }

    @Override
    public Page<Blog> findAllByCategory(String category, Integer page) {
        return blogRepository.findByCategory_NameContainingIgnoreCase(category, PageRequest.of(page, 10));
    }
}
