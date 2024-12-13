package com.example.thuc_hanh_2.service;

import com.example.thuc_hanh_2.model.Customer;
import com.example.thuc_hanh_2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(int id, Customer customer) {

    }
}
