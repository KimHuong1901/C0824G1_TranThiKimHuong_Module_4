package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;

import java.util.List;

public interface IBaseService<T> {
    void addNew(T t );
    boolean update(int id, T t);
    List<T> getAll();
    T getById(int id);
    boolean deleteById(int id);
    T findById(int id);
}
