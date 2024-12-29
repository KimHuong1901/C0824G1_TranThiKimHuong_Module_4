package com.example.bai_tap.service;

import com.example.bai_tap.model.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService extends IBaseService<Category> {
    Page<Category> findByName(String name, Integer page);
}
