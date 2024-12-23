package com.example.bai_tap.repository;

import com.example.bai_tap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
            List<Blog> findAllByTitleContainingIgnoreCase(String title);
            List<Blog> findAllByCategoryContainingIgnoreCase(String category);
            Page<Blog> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);
}
