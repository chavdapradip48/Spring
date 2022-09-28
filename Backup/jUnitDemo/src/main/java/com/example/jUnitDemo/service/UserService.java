package com.example.jUnitDemo.service;

import com.example.jUnitDemo.model.User;

public interface UserService {
	
	User saveUser(User user);

	User getUserById(int userId);


}
