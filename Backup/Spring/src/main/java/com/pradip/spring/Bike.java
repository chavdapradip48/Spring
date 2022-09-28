package com.pradip.spring;
public class Bike {
	String bikeName;
	String bikeModel;
	int bikeSpeed;
	Tyre bikeTyre;

	public Bike() {}

	public Bike(String bikeName, String bikeModel, int bikeSpeed, Tyre bikeTyre) {
		super();
		this.bikeName = bikeName;
		this.bikeModel = bikeModel;
		this.bikeSpeed = bikeSpeed;
		this.bikeTyre = bikeTyre;
	}
	
	@Override
	public String toString() {
		return "Bike [bikeName=" + bikeName + ", bikeModel=" + bikeModel + ", bikeSpeed=" + bikeSpeed + ", bikeTyre="
				+ bikeTyre + "]";
	}

	public Bike(String bikeName) {
		this.bikeName = bikeName;
	}
	
	public Tyre getBikeTyre() {
		return bikeTyre;
	}

	public void setBikeTyre(Tyre bikeTyre) {
		this.bikeTyre = bikeTyre;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getBikeModel() {
		return bikeModel;
	}
	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}
	public int getBikeSpeed() {
		return bikeSpeed;
	}
	public void setBikeSpeed(int bikeSpeed) {
		this.bikeSpeed = bikeSpeed;
	}
}
