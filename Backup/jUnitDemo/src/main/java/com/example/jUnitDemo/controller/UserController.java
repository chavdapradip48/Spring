package com.example.jUnitDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jUnitDemo.model.User;
import com.example.jUnitDemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/save-user", method=RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@RequestMapping(value="/get-user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
    }
}
