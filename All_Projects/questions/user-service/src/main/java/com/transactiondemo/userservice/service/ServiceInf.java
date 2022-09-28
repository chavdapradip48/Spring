package com.transactiondemo.userservice.service;

import com.transactiondemo.userservice.model.User;

import java.util.List;

public interface ServiceInf {

    // User save or update
    public User addUser(User user);
    // get all users
    public List<User> getAllUser();
    // get perticular by user id
    public User getUserById(int id);

    public boolean deletetUserById(int id);

}
