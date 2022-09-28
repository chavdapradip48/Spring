package com.pradip.annotation.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String args[]) {
		ApplicationContext con= new AnnotationConfigApplicationContext(AppConfig.class);
		Mobile m=con.getBean(Mobile.class);
		m.printData();
	}
}
