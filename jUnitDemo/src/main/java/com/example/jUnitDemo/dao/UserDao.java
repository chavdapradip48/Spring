package com.example.jUnitDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jUnitDemo.model.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{

}
