package com.example.demo_mybatis.daoTest;

import com.example.demo_mybatis.dao.UserDao;

import com.example.demo_mybatis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserTest {
    @Resource
    UserDao userDao;


    @Test
    public void test1(){
    System.out.println(userDao.getUsers());
    }

    @Test
    public void test2(){
        User user=new User();
       user.setuName("fbz");
       user.setuPass("123456");

        System.out.println(userDao.login(user));
    }

    @Test
    public void  test3(){
        for(User u:userDao.getUsers()){
            System.out.println(u);
            
        }
    }

    @Test
    public void test4(){
        List<User> users=new ArrayList<>();
        User u1=new User();
        u1.setuName("ffff");
        u1.setuPass("fbbb");
        u1.setuAge(20);
        User u2=new User();
        u2.setuName("dddd");
        u2.setuAge(30);
        u2.setuPass("ddd");
        users.add(u1);
        users.add(u2);
        userDao.insertList(users);
    }

}
