package com.example.bai_tap.repository;

import com.example.bai_tap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
            Page<Blog> findAllByCategory_NameContainingIgnoreCase(String title, Pageable pageable);
            Page<Blog> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);
}
