package com.pradip.properties;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintData {
	public static void main(String a[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("general.xml");
		SetProp db = (SetProp) context.getBean("setprop");
	      
	    System.out.println("** Spring properties file demo **\n\n"+db.toString());
	    
	    ((ConfigurableApplicationContext)context).close();
		
	}
}
