package com.example.bai_tap.service.imple;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.repository.ProductRepository;
import com.example.bai_tap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void addNewProduct(Product product) {
         productRepository.save(product);
    }
}
