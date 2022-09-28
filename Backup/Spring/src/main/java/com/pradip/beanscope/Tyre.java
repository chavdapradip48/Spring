package com.pradip.beanscope;

public class Tyre {
	String brandName;
	int price;
	
	public Tyre() {}
	
	public Tyre(String brandName, int price) {
		super();
		this.brandName = brandName;
		this.price = price;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Tyre [brandName=" + brandName + ", price=" + price + "]";
	}
}
