package com.transactiondemo.addressservice.service;


import com.transactiondemo.addressservice.dao.Dao;
import com.transactiondemo.addressservice.model.Address;
import com.transactiondemo.addressservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceInf {
    
    @Autowired
    private Dao dao;

    @Autowired
    private  User user;

    @Override
    public Address addAddress(Address address) {
        return dao.save(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return dao.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return dao.findById(id);
    }

    @Override
    public boolean deletetAddressById(int id) {
        dao.deleteById(id);
        return false;
    }

    @Override
    public List<Address> getAddressByUserId(int id) {
        user.setId(id);
        return dao.findByUser(user);
    }

    @Override
    public boolean deletetAddressByUserId(int id) {
        user.setId(id);
        dao.deleteByUser(user);
        System.out.println("\n=> address deletes : "+user);
        return true;
    }

}
