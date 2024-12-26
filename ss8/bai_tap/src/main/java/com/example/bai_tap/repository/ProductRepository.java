package com.example.bai_tap.repository;

import com.example.bai_tap.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
