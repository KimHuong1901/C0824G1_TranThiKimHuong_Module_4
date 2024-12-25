package com.example.bai_tap.repository;

import com.example.bai_tap.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByNameContainingIgnoreCase(String name);
}
