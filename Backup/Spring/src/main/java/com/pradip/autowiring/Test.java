package com.pradip.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String a[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("general.xml");
		Employee emp=context.getBean("employee",Employee.class);
		Address address=context.getBean("address",Address.class);
		Address2 address2=context.getBean("address2",Address2.class);

		System.out.println("\n** Autowire Example **\n");

		System.out.println("\n** Address 1 **\n");
		
		System.out.println("=> Address toString method is : "+address.toString());
		System.out.println("=> Address2 toString method is : "+address2.toString());
		System.out.println("\n=> Employee toString method is : "+emp.toString());
		System.out.println("\n=> Whle address is : "+emp.getMainAddress()+"  "+address.getStreet()+"  "+address.getCity()+"  "+address2.getPincode());
		
		Employee emp2=context.getBean("employee2",Employee.class);
		System.out.println("\n** Address 2 **\n");
		System.out.println("=> Address toString method is : "+address.toString());
		System.out.println("=> Address2 toString method is : "+address2.toString());
		System.out.println("\n=> Employee toString method is : "+emp2.toString());
		System.out.println("\n=> Whle address is : "+emp2.getMainAddress()+"  "+address.getStreet()+"  "+address.getCity()+"  "+address2.getPincode());

		Employee emp3=context.getBean("employee3",Employee.class);
		System.out.println("\n** Address 3 **\n");
		System.out.println("=> Address toString method is : "+address.toString());
		System.out.println("=> Address2 toString method is : "+address2.toString());
		System.out.println("\n=> Employee toString method is : "+emp3.toString());
		System.out.println("\n=> Whle address is : "+emp3.getMainAddress()+"  "+address.getStreet()+"  "+address.getCity()+"  "+address2.getPincode());

	
	}
}
