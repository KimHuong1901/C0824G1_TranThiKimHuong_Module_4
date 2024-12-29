package com.example.bai_tap.repository;

import com.example.bai_tap.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Page<Category> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
