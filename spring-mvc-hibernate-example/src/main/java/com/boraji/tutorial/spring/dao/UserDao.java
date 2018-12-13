package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.User;

public interface UserDao {
   void save(User user);
   List<User> list();
}
