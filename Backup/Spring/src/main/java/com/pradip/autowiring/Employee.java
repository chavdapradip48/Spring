package com.pradip.autowiring;

public class Employee {
	private String mainAddress;

	private Address address;
	private Address2 address2;

	// Generate default constructor
	public Employee() {}
	
	// Also generate parameeterized constructor
	public Employee(String mainAddress, Address address, Address2 address2) {
		super();
		this.mainAddress = mainAddress;
		this.address = address;
		this.address2 = address2;
	}

	// Generate needable getter setter
	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public Address2 getAddress2() {
		return address2;
	}

	public void setAddress2(Address2 address2) {
		this.address2 = address2;
	}
	
	// for printing values of Employee class
	@Override
	public String toString() {
		return "Employee [mainAddress=" + mainAddress + ", \n\t\t\t\t\taddress=" + address + ", \n\t\t\t\t\taddress2=" + address2 + "]";
	}
	
	
}
