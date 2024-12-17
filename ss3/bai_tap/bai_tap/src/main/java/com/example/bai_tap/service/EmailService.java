package com.example.bai_tap.service;

import com.example.bai_tap.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmailService implements IEmailService{
    private List<Email> emails = new ArrayList<>();
    @Override
    public List<Email> getAll() {
        return emails;
    }

    @Override
    public void update(Email email) {
            emails.add(email);
    }
}
