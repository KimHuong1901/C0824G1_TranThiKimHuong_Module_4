package com.example.bai_tap.service;

import com.example.bai_tap.model.Book;
import com.example.bai_tap.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
@Service
@Transactional
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public int borrowBook(int id) {
        Book book = findById(id);
        if (book == null || book.getQuantity() <= 0) {
            throw new IllegalArgumentException("Book not available or out of stock.");
        }
        book.setQuantity(book.getQuantity() - 1);
        int borrowCode = generateBorrowCode();
        book.setCode(borrowCode);
        bookRepository.save(book);
        return borrowCode;
    }

    @Override
    @Transactional
    public boolean returnBook(int id, int code) {
        Book book = findById(id);
        if (book == null) {
            throw new IllegalArgumentException("Book not found for ID: " + id);
        }
        if (book.getCode() != code) {
            throw new IllegalArgumentException("Invalid borrow code.");
        }
        book.setQuantity(book.getQuantity() + 1);
        book.setCode(0);
        bookRepository.save(book);

        System.out.println("Book returned: " + book.getName() + ", New Quantity: " + book.getQuantity());

        return true;
    }

    private int generateBorrowCode() {
        Random random = new Random();
        return random.nextInt(89999) + 10000;
    }
}


