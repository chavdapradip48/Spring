package com.pradip.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("general.xml");
		/*IF we have a class name like StudentDetailClass
		 * In this case @component follows camel case for make bean object
		 * So in this case bean name is : annoModel */
		AnnoModel model=context.getBean("modelObject",AnnoModel.class);
		System.out.print(model.toString());
	}	

}
