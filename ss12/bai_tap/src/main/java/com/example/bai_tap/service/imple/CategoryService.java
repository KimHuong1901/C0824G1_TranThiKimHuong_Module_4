package com.example.bai_tap.service.imple;


import com.example.bai_tap.model.Category;
import com.example.bai_tap.repository.CategoryRepository;
import com.example.bai_tap.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addNew(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean update(int id, Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public boolean deleteById(int id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Category> findByName(String name, Integer page) {
        return categoryRepository.findAllByNameContainingIgnoreCase(name, PageRequest.of(page, 10));
    }
}
