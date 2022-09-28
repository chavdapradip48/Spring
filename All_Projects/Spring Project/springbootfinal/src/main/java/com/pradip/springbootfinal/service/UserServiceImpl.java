package com.pradip.springbootfinal.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pradip.springbootfinal.dao.UserRepository;
import com.pradip.springbootfinal.model.User;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
