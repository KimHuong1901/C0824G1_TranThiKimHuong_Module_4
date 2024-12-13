package com.example.thuc_hanh_2.repository;

import com.example.thuc_hanh_2.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<Customer>();
    static {
        customers.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
        customers.add(new Customer(2, "Dang Duy Hoa", "hoa.dang@codegym.vn", "Đà Nẵng"));
        customers.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.vn", "Hà Nội"));
        customers.add(new Customer(4, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sài Gòn"));
        customers.add(new Customer(5, "Code Gym", "codegym@codegym.vn", "Việt Nam"));
    }
    public List<Customer> findAll() {
        return customers;
    }
}
