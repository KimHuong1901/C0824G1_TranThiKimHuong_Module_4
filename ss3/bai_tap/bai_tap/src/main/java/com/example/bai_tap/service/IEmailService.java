package com.example.bai_tap.service;

import com.example.bai_tap.model.Email;

import java.util.List;

public interface IEmailService {
        List<Email> getAll();
        void update(Email email);
}
