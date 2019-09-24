package com.example.demo_mybatis.daoTest;

import com.example.demo_mybatis.dao.MangaDao;
import com.example.demo_mybatis.entity.Manga;
import com.example.demo_mybatis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class MangaTest {
    @Resource
    MangaDao mangaDao;

    @Test
    public void test1(){
        List<Manga>  mangaList=mangaDao.getMangas();
        for(Manga manga:mangaList){
            System.out.println(manga);
        }
    }

    @Test
    public void test2(){
        System.out.println(mangaDao.getCount());
    }

    @Test
    public void test3(){
        Manga manga=new Manga();
        User user=new User();
        user.setuId(2);
        manga.setmDir("D://");
        manga.setmName("naruto");
        manga.setmDesc("liihihi");
 
        manga.setmTime(new Date());
        manga.setUploader(user);
        mangaDao.addManga(manga);

    }

    @Test
    public void test22(){
        System.out.println(mangaDao.getMangas());
    }

    @Test
    public void tets2(){
       Manga manga=mangaDao.getMangaById(13);
        System.out.println(manga);
    }

    @Test
    public void tets(){
        User user=new User();
        user.setuId(1);
        List<Manga> mangaList=mangaDao.getMine(user);
        System.out.println(mangaList);
    }
}
