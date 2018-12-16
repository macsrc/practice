package com.mkyong.form.service;

import java.util.List;

import com.mkyong.form.model.Cacdlg;
import com.mkyong.form.model.User;

public interface UserService {

	User findById(Integer id);

	List<User> findAll();

	void saveOrUpdate(User user);

	void delete(int id);

	/** Drop-down code setup */
	List<Cacdlg> getCodeValues();

//	List<Cacdlg> getCodeValues(String groupCode);

}
