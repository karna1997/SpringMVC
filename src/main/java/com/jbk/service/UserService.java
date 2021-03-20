package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDao;
import com.jbk.pojo.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	public boolean checkLoginCredentials(User user) {
		boolean result = dao.checkLoginCredentials(user);
		return result;
	}

	public List<User> getUserlist() {

		List<User> userlist = dao.getUserlist();
		return userlist;
	}

	public boolean deleteUser(int id) {
		boolean result = dao.deleteUser(id);
		return result;
	}

	public User getDatabyId(int id) {
		User user = dao.getDatabyId(id);
		return user;
	}

	public boolean updateUser(User user) {
		
		boolean result = dao.updateUser(user);
		return result;
	}

	public boolean addUser(User user) {
		boolean result=dao.addUser(user);//
		return result;
	}

}
