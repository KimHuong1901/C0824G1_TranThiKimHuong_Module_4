package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;
import org.springframework.data.domain.Page;

import java.util.List;
public interface IBlogService extends IBaseService<Blog> {
    Page<Blog> findByTitle(String title, Integer page);
    List<Blog> findAllSortedByTime();
    List<Blog> findAllByCategory(String category);
}
