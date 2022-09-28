package com.pradip.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("modelObject")
public class AnnoModel {
	@Value("message ")
	private String message;
	@Value("message2 ")
	private String message2;
	@Value("message3 ")
	private String message3;
	@Value("10")
	private int number;
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String getMessage3() {
		return message3;
	}

	public void setMessage3(String message3) {
		this.message3 = message3;
	}

	@Override
	public String toString() {
		return "AnnoModel [message=" + message + ", message2=" + message2 + ", message3=" + message3 + ", number="
				+ number + "]";
	}
		
}
