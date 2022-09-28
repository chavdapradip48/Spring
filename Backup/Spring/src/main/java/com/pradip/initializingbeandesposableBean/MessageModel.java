package com.pradip.initializingbeandesposableBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MessageModel{
	private String message;
	public MessageModel() {
		System.out.println("Object created of MessageModel class.");
	}
	public String getMessage() {

		System.out.println("Message getted.");
		return message;
	}

	public void setMessage(String message) {

		System.out.println("Message setted.");
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageModel [message=" + message + "]";
	}
	@PostConstruct
	public void init() throws Exception {
		/*This method call when instanciate bean and then value set using setter method then call this method*/ 
		System.out.println("I am initiazing method.");
	}
	@PreDestroy
	public void destroy() throws Exception {
		/*This method call when bean destroy before */
		System.out.println("I am destroy .");	
	}
}
