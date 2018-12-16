package com.mkyong.form.service;

import java.util.List;
import java.util.Map;

import com.mkyong.form.model.User;

public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();

	void saveOrUpdate(User user);
	
	void delete(int id);
	
	// test add
	Map<String, String> getAllUserNames();
	
}