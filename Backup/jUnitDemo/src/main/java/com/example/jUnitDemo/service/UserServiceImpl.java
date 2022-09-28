package com.example.jUnitDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jUnitDemo.dao.UserDao;
import com.example.jUnitDemo.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User saveUser(User user) {
		try {
			return userDao.save(user);
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public User getUserById(int userId) {
		try {
			return userDao.getById(userId);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
