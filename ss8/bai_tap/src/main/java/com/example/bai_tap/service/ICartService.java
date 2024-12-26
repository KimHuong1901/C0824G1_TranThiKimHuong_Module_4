package com.example.bai_tap.service;

import com.example.bai_tap.model.Cart;
import com.example.bai_tap.model.Product;

public interface ICartService {
    boolean checkItemInCart(Product product, Cart cart);
    void addProduct(Product product, Cart cart);
    int countProductQuantity(Cart cart);
    int countItemQuantity(Cart cart);
    float countTotalPayment(Cart cart);
    void updateProductQuantity(Product product, int quantity, Cart cart);
}
