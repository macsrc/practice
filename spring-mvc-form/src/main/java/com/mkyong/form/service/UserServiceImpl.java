package com.mkyong.form.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.form.dao.UserDao;
import com.mkyong.form.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	/** Test - Get User Name List */
	@Override
	public Map<String, String> getAllUserNames(){
		return (Map<String, String>) userDao.getAllUserNames();
	}

	@Override
	public void saveOrUpdate(User user) {

		if (findById(user.getId())==null) {
			userDao.save(user);
		} else {
			userDao.update(user);
		}

	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}