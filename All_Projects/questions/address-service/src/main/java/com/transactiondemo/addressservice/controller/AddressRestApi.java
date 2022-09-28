package com.transactiondemo.addressservice.controller;

import com.transactiondemo.addressservice.model.Address;
import com.transactiondemo.addressservice.model.User;
import com.transactiondemo.addressservice.service.ServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressRestApi {
    @Autowired
    private ServiceInf service;

    @Autowired
    private User user;

    @GetMapping("/")
    public List<Address> getAllAdddressrsApi(){
        return service.getAllAddress();
    }

    @PostMapping("/add")
    public Address insertUpdateAddressApi(@RequestBody Address addAdd){
        return service.addAddress(addAdd);
    }

    @GetMapping("/get/{id}")
    public Address getUserByIdsApi(@PathVariable("id") int id){
        return service.getAddressById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserByIdsApi(@PathVariable("id") int id){
        if(service.deletetAddressById(id)){
            return id+"th address deleted";
        }
        else {
            return id+"th address not deleted";
        }
    }
    @GetMapping("/gets/{id}")
    public List<Address> getUserByUserIdsApi(@PathVariable("id") int id){
        return service.getAddressByUserId(id);
    }

    @DeleteMapping("/deletes/{id}")
    public String deleteUserByUserIdsApi(@PathVariable("id") int id){
        if(service.deletetAddressByUserId(id)){
            return  id+"th user's Addresses deleted ";
        }
        else {
            return id+"th user's Addresses not deleted ";
        }
    }
}
