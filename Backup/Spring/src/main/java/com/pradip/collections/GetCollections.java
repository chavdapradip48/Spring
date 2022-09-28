package com.pradip.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetCollections {
	public static void main(String args[]) { 
		// ApplicationContext use to get access of xml file 
		ApplicationContext context= new ClassPathXmlApplicationContext("collections.xml");
		
		JavaCollections listObject=(JavaCollections)context.getBean("collections");
		// Take list from collections class and print that and it contain duplicate values
		System.out.println("\n\n** List Values is : \n");
		System.out.println(listObject.getList());
		// Take set from collection class and print and it can not contains duplicate values
		// if set contain multiple values then it print first value then skip all other same values 
		System.out.println("\n\n** Set Values is : \n");
		System.out.println(listObject.getSet());
		System.out.println("=> NOTE : Here we see second pradip not print \n\tbecause list contains duplicate values but set can not contains duplicate values.");
		
		
		System.out.println("\n\n** Map Values is : \n");
		System.out.println("-> Keys is : "+listObject.getMap().keySet());
		System.out.println("-> Values is : "+listObject.getMap().values());
		System.out.println("=> NOTE : Map contains duplicate values but keys can not duplicate. \n\tIf Map have multiple same keys then it take last key");
		System.out.println("\tIn above we have three same key it print last and it print two time Tea");
		
		System.out.println("\n\n** Properties Values is : \n");
		System.out.println("-> First Name is : "+listObject.getProperties().getProperty("fName"));
		System.out.println("-> Last Name is : "+listObject.getProperties().getProperty("lName"));
		System.out.println("-> Mobile is : "+listObject.getProperties().getProperty("mobile"));
		System.out.println("-> Address is : "+listObject.getProperties().getProperty("address"));
		
		System.out.println("\n=> NOTE : Properties contains duplicate values but keys can not duplicate. \n\tIf Map have multiple same keys then it take last key");
		System.out.println("\tIn above we have three same key it print last and it print two time Tea");
		
	}
}
