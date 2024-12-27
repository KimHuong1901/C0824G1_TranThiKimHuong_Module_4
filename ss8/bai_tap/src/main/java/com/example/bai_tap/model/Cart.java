package com.example.bai_tap.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
    public int countItemQuantity() {
        return 0;
    }
    public int countProductQuantity() {
        return 0;
    }
    public BigDecimal countTotalPayment() {
        BigDecimal totalPayment = BigDecimal.valueOf(1000);
        return totalPayment;
    }
}
