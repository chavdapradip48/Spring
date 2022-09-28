package com.pradip.spring;

public class Car {
	String carName;
	String carmodel;
	int carSpeed;
	
	public Car(String carName, String carmodel, int carSpeed) {
		super();
		this.carName = carName;
		this.carmodel = carmodel;
		this.carSpeed = carSpeed;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public int getCarSpeed() {
		return carSpeed;
	}

	public void setCarSpeed(int carSpeed) {
		this.carSpeed = carSpeed;
	}

	
}
