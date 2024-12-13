package com.example.thuc_hanh_2.service;

import com.example.thuc_hanh_2.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    void updateCustomer(int id, Customer customer);
}
