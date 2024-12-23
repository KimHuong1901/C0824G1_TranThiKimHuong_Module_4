package com.example.bai_tap.repository;

import com.example.bai_tap.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAllByNameContainingIgnoreCase(String name);
}
