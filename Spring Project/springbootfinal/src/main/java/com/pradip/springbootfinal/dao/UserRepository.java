package com.pradip.springbootfinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pradip.springbootfinal.model.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	//spring boot implement automatically all method 	
	public List<User> findByName(String name);
	
	@Query("select u from User u where u.id > :s and u.id < :e")
	public List<User> getAllBetweenUsers(@Param("s") int start,@Param("e") int end);
	
	@Query(value = "select * from test_user",nativeQuery = true)
	public List<User> getUsersByNative();
}
