package com.example.bai_tap.repository;

import com.example.bai_tap.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
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
        List<Product> products = BaseRepository.entityManager.createQuery("from product", Product.class).getResultList();
        return products;
    }
    public void addProduct(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }
    public boolean deleteProduct(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class, id));
        transaction.commit();
        return true;
    }
    public boolean updateProduct(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
        return true;
    }
    public Product getProductById(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class, id);
        transaction.commit();
        return product;
    }
}
