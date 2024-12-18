package com.example.bai_tap.repository;

import com.example.bai_tap.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Iphone 15", 20000000, "Vip", "Aplle"));
        products.add(new Product(2, "Huawei Nova", 8000000, "Normal", "Huawei"));
        products.add(new Product(3, "Samsung Galaxy", 12000000, "Vip", "Samsung"));
        products.add(new Product(4, "Xiaomi Redmi", 10000000, "Vip", "Xiaomi"));
        products.add(new Product(5, "Oppo Reno 3", 9000000, "Normal", "Oppo"));
    }
    public List<Product> getAllProducts() {
        return products;
    }
    public void addProduct(Product product) {
        product.setId(products.get(products.size()-1).getId()+1);
        products.add(product);
    }
    public boolean deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
