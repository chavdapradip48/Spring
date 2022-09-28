package com.user.userservice.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String id;
	private String name;
	private String mobile;
	private List<Address> addresses=new ArrayList<>();
	
	public Person() {
		super();
	}
	public Person(String id, String name, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
	}
	public Person(String id, String name, String mobile, List<Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.addresses = addresses;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobile=" + mobile + ", addresses=" + addresses + "]";
	}
}
