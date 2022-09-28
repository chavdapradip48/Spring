package com.pradip.autowiring;

public class Address2 {
	private int pincode;

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address2 [pincode=" + pincode + "]";
	}
	
}
