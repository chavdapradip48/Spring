package com.transactiondemo.userservice.dao;

import com.transactiondemo.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dao extends JpaRepository<User,Integer> {
    public User findById(int id);
}
