package com.pradip.initializingbeandesposableBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PrintMessage{

	public static void main(String[] args) {
		
		System.out.println("\n** InitializingBean and DisposableBean **\n");
		System.out.println("\n=>  First way  : using interface and override methods");
		System.out.println("-> class MessageModel implements InitializingBean, DisposableBean   and impliments methods");
		System.out.println("\n=>  Second way  : use bean init-method and destroy-method attributes ");
		System.out.println("-> <bean id=\"messagemodel\" class=\"com.pradip.initializingbeandesposableBean.MessageModel\" init-method=\"init\" destroy-method=\"destroy\">");
		System.out.println("\n=>  Third way  : use beans default-init-method and default-destroy-method ");
		System.out.println("<beans default-init-method=\"init\" default-destroy-method=\"destroy\"></beans>");
		System.out.println("\n=>  Fourth way  : use annotation like @Postconstruct and @PreDestroy");
		System.out.println("-> Active annotation in spring project by <context:annotation-config/>");
		System.out.println("-> Write @PostConstruct on intialize method");
		System.out.println("-> Write @PreDestroy on destroy method");
		ApplicationContext context= new ClassPathXmlApplicationContext("file:/home/pradip/Documents/Spring Practice/general.xml");

		MessageModel mm=(MessageModel)context.getBean("messagemodel");
		
		System.out.println(mm.getMessage());
		((ConfigurableApplicationContext)context).close();
		System.out.print("\n=>  NOTE : there is disadvantage like we have multiple model than. \n");
	}


}
