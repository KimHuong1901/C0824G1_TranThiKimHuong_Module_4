package com.example.bai_2.service;

import com.example.bai_2.model.Music;
import com.example.bai_2.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicService implements IMusicService {
    @Autowired
        private MusicRepository musicRepository;

    @Override
    public boolean addNewMusic(Music music) {
        musicRepository.save(music);
        return true;
    }

    @Override
    public boolean updateMusic(int id, Music music) {
        musicRepository.save(music);
        return true;
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public List<Music> getAll() {
        return musicRepository.findAll();
    }

}
