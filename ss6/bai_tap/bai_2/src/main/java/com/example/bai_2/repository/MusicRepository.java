package com.example.bai_2.repository;

import com.example.bai_2.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Integer> {

}
