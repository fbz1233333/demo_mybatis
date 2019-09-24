package com.example.demo_mybatis.dao;
import com.example.demo_mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {

  List<User> getUsers();

  List<User> getUser(User user);

  User login(User user);

  User getUserById(int id);

  void insertList(@Param("userList") List<User> userList);
}
