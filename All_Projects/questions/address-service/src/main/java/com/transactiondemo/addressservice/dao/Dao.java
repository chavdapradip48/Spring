package com.transactiondemo.addressservice.dao;


import com.transactiondemo.addressservice.model.Address;
import com.transactiondemo.addressservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface Dao extends JpaRepository<Address,Integer> {
    public Address findById(int id);
    public List<Address> findByUser(User user);
    public void deleteByUser(User user);
}
