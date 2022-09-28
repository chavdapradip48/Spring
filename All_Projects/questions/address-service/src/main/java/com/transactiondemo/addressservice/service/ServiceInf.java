package com.transactiondemo.addressservice.service;


import com.transactiondemo.addressservice.model.Address;
import com.transactiondemo.addressservice.model.User;

import java.util.List;

public interface ServiceInf {

    // User save or update
    public Address addAddress(Address address);
    // get all users
    public List<Address> getAllAddress();
    // get perticular by user id
    public Address getAddressById(int id);

    public boolean deletetAddressById(int id);

    public List<Address> getAddressByUserId(int id);

    public boolean deletetAddressByUserId(int id);

}
