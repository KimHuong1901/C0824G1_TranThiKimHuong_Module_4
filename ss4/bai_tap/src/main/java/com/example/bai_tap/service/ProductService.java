package com.example.bai_tap.service;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public void addProduct(Product product) {
         productRepository.addProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        if(productRepository.deleteProduct(id)){
            return true;
        }
            return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        if(productRepository.updateProduct(product)){
            return true;
        }
        return false;
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.getProductById(id);
    }
}
