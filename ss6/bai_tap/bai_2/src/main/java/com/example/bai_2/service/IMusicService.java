package com.example.bai_2.service;

import com.example.bai_2.model.Music;

import java.util.List;

public interface IMusicService {
    boolean addNewMusic(Music music);
    boolean updateMusic(int id, Music music);
    Music findById(int id);
    List<Music> getAll();
}
