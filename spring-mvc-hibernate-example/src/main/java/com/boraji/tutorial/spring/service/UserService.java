package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.model.User;

public interface UserService {
   void save(User user);

   List<User> list();
}
