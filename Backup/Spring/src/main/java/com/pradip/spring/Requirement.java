package com.pradip.spring;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Requirement {
	public static void main(String args[]) { 
		/*
		 * There are two type of IOC container 
		 * 1. ApplicationContext :
		 * => ApplicationContext context= new ClassPathXmlApplicationContext("springbean.xml");
		 * 
		 * 2. BeanFactory
		 * => 
		 * 	Resource resource=new ClassPathResource("springbean.xml");  
		 * 	BeanFactory factory=new XmlBeanFactory(resource);   
		 * 
		 * */
		
		// ApplicationContext use to get access of xml file 
		ApplicationContext context= new ClassPathXmlApplicationContext("springbean.xml");
		
		Bike hondaObject=(Bike)context.getBean("honda");
		Bike hondaObject2=(Bike)context.getBean("honda");
		System.out.println("\n\n** Getter and setter example\n");
		System.out.println("=> Bike toString Method is : ");
		System.out.println(hondaObject.toString());
		System.out.println(hondaObject2.toString());
		System.out.println("=> Both objet hascode is : 1. "+hondaObject.hashCode()+" 2. "+hondaObject2.hashCode());
		
		Tyre tyre=(Tyre)context.getBean("bikeTyre");
		Tyre tyre2=(Tyre)context.getBean("bikeTyre");
		System.out.println("\n\n=> Tyre toString Method is (referenced from bike): ");
		System.out.println(tyre.toString());
		System.out.println(tyre2.toString());
		System.out.println("=> Both objet hascode is : 1. "+tyre.hashCode()+" 2. "+tyre2.hashCode());
	}
}
