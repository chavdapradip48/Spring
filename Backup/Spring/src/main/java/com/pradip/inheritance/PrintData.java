package com.pradip.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintData {
	public static void main(String a[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("general.xml");
		
		Inheritance parentObject=(Inheritance) context.getBean("parentObject");
		System.out.println("\n\n ** Inheritance Example ** \n\n");
		System.out.println("This is parent object : "+parentObject.toString());
		Inheritance childObject=(Inheritance) context.getBean("childObject");
		System.out.println("\n\nThis is chilld object : "+childObject.toString());
		System.out.println("\n\nNOTE : In parent we only set name thats why other values is null.");
		System.out.println("NOTE : In child, It have parent properties also thats why it print all values.");
		
	}
}
