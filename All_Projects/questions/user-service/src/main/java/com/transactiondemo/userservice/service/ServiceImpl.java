package com.transactiondemo.userservice.service;

import com.transactiondemo.userservice.dao.Dao;
import com.transactiondemo.userservice.model.Address;
import com.transactiondemo.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceInf {
    
    @Autowired
    private Dao dao;
    
    @Override
    public User addUser(User user) {
        for(Address u:user.getAddress()){
            u.setUser(user);
        }
        return dao.save(user);
    }

    @Override
    public List<User> getAllUser() {
        System.out.println("\n=> Users from all\n");
        List<User> l =dao.findAll();
        if(l != null){
            System.out.println("list not null");
            return l;
        }
        else{
            System.out.println("list is null");
            return  null;
        }
    }

    @Override
    public User getUserById(int id) {
        return dao.findById(id);
    }

    @Override
    public boolean deletetUserById(int id) {
        dao.deleteById(id);
        return true;
    }
}
