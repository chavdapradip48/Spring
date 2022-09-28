package com.transactiondemo.userservice.controller;

import com.transactiondemo.userservice.model.User;
import com.transactiondemo.userservice.service.ServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestApi {
    @Autowired
    private ServiceInf service;

    @Autowired
    private User user;

    @GetMapping("/")
    public List<User> getAllUsersApi(){
        System.out.println("hello rest /");
//        Address addres=new Address();
//        addres.setGeneral("This is general address");
//        addres.setUser(user);
//        user.setName("Pradip Chavda");
//        user.setMobile("9909714196");
//        List<Address> list=new ArrayList<Address>();
//        list.add(addres);
//        list.add(addres);
//        user.setAddress(list);
//        service.addUser(user);

        return service.getAllUser();
    }

    @PostMapping("/add")
    public User insertUpdateUserApi(@RequestBody User userAdd){
        System.out.println(userAdd);
        return service.addUser(userAdd);
    }

    @GetMapping("/get/{id}")
    public User getUserByIdsApi(@PathVariable("id") int id){
        return service.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserByIdsApi(@PathVariable("id") int id){
        if(service.deletetUserById(id)){
            return "User deleted";
        }
        else {
            return "User not deleted";
        }
    }

}
