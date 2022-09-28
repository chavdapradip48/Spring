package com.address.addressservice.service;

import java.util.List;

import com.address.addressservice.model.Address;

public interface AddressService {
	public List<Address> getAllAddresses(String userId);
}
