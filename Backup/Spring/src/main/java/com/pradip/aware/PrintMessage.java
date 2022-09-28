package com.pradip.aware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PrintMessage{

	public static void main(String[] args) {
		
		System.out.println("\n** ApplicationContextAware **\n");

		ApplicationContext context= new ClassPathXmlApplicationContext("general.xml");

		MyBeanNameAware mm=(MyBeanNameAware)context.getBean("beanname");
		mm.show();
	}


}
