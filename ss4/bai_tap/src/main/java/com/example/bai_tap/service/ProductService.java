package com.example.bai_tap.service;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.repository.ProductRepository;
import org.hibernate.SessionFactory;
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
        checkValue(product);
        productRepository.addProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        if(getProduct(id)==null){
            return false;
        }
        return productRepository.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        checkValue(product);
        if(getProduct(product.getId()) == null) {
            return false;
        }
        return productRepository.updateProduct(product);
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.getProductById(id);
    }

    public void checkValue(Product product) {
        if (product.getPrice() == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (product.getPrice().doubleValue() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}
