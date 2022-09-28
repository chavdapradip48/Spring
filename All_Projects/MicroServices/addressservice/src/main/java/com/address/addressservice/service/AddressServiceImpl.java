package com.address.addressservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.address.addressservice.model.Address;

@Service
public class AddressServiceImpl implements AddressService{

	//Fake adress list
	List<Address> addList=List.of(
			new Address("1","Shankarapara, Botad","1"),
			new Address("2","Memnagar, Ahmedabad","1"),
			new Address("3","Divya Society, Bavla","2"),
			new Address("4","Shankarapara, Botad","3"),
			new Address("5","Medhaninagar, Barwala","3")
			);
	
	
	@Override
	public List<Address> getAllAddresses(String userId) {
		return addList.stream().filter(address -> address.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
