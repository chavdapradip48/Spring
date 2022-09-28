package com.pradip.springbootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pradip.springbootmvc.dao.UserDao;
import com.pradip.springbootmvc.dao.UserDaoImpl;
import com.pradip.springbootmvc.service.UserService;
import com.pradip.springbootmvc.service.UserServiceImpl;

@SpringBootApplication
public class SpringbootmvcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootmvcApplication.class, args);
	}

}
