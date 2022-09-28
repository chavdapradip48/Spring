package com.address.addressservice.model;

public class Address {
	
	private String id;
	private String fullAddress;
	private String userId;
	
	
	public Address(String id, String fullAddress,String userId) {
		super();
		this.id = id;
		this.fullAddress = fullAddress;
		this.setUserId(userId);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public Address(String userId) {
		super();
		this.setUserId(userId);
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", fullAddress=" + fullAddress + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
}
