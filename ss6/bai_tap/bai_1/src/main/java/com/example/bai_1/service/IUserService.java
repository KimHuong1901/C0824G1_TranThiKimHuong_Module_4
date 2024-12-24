package com.example.bai_1.service;

import com.example.bai_1.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    boolean addUser(User user);
    User findById(int id);
}
