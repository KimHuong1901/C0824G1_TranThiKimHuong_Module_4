package com.example.bai_tap.service;

import com.example.bai_tap.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(int id);
    void addNewProduct(Product product);
}
