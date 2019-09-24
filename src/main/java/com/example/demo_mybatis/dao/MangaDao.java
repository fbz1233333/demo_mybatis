package com.example.demo_mybatis.dao;

import com.example.demo_mybatis.entity.Manga;
import com.example.demo_mybatis.entity.User;

import java.util.List;

public interface MangaDao {
   int getCount();

    List<Manga> getMangas();

    void addManga(Manga manga);

    Manga getMangaById(int id);

    List<Manga> getMine(User me);
}
