package com.example.bai_tap.service;

import com.example.bai_tap.model.Book;

import java.util.List;

public interface IBookService {
    void addBook(Book book);
    Book findById(int id);
    int borrowBook(int id);
    boolean returnBook(int id, int code);
    List<Book> getAll();
}
