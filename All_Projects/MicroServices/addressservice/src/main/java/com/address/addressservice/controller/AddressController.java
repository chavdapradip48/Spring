package com.address.addressservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.addressservice.model.Address;
import com.address.addressservice.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{id}")
	public List<Address> getAddressesById(@PathVariable("id") String id){
		return addressService.getAllAddresses(id);
	}
	@PostMapping("/add")
	public Address addAddress(@RequestBody Address address){
		System.out.println("hello address");
		return address;
	}
}
