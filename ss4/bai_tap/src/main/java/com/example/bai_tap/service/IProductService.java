package com.example.bai_tap.service;

import com.example.bai_tap.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    boolean deleteProduct(int id);
    boolean updateProduct(Product product);
    Product getProduct(int id);
}
