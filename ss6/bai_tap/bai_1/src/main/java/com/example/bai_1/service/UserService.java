package com.example.bai_1.service;

import com.example.bai_1.model.User;
import com.example.bai_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean addUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
