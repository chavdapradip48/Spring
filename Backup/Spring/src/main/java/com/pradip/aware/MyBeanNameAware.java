package com.pradip.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBeanNameAware implements ApplicationContextAware{
	private ApplicationContext applicationContext;
	
	public void show() {
		System.out.print("Bean name is : "+applicationContext);
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext=applicationContext;
		
	}

}
