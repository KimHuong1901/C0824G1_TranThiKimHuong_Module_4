package com.example.bai_2.service;

import com.example.bai_2.model.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicService implements IMusicService {
    private List<Music> musics = new ArrayList<>();
    @Override
    public List<Music> getAllMusic() {
        return musics;
    }

    @Override
    public void updateMusic(Music music) {
        musics.add(music);
    }
}
