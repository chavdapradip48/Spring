package com.pradip.springbootfinal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pradip.springbootfinal.model.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	//spring boot implement automatically all method 	
}
