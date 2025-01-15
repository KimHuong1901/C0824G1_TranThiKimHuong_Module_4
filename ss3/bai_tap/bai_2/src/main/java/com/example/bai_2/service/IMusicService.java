package com.example.bai_2.service;

import com.example.bai_2.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getAllMusic();
    void updateMusic(Music music);
}
