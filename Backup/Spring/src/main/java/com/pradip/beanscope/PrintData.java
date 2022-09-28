package com.pradip.beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintData {
	public static void main(String a[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("general.xml");
		
		System.out.println("\n\n ** Bean Scope Example ** ");
		System.out.println("\n\n ** Singleton scope Example ** \n\n");	
		Tyre singletonScope=(Tyre) context.getBean("singletonscope");
		Tyre singletonScope1=(Tyre) context.getBean("singletonscope");
		System.out.println(singletonScope.toString());
		System.out.println(singletonScope1.toString());
		System.out.println("NOTE : Every bean have by default singleton scope.");
		System.out.println("NOTE : when we make object first time then container store that object .");
		System.out.println("NOTE : Now we make second time same class object then it not generate new object it return stored oject.");
		System.out.println("NOTE : If we check all objects hascode then all objects have a same hascode.");
		System.out.println("\nFirst object hascode  : "+singletonScope.hashCode());
		System.out.println("Second object hascode : "+singletonScope1.hashCode());
		
		System.out.println("\n\n ** Prototype scope Example ** \n\n");	
		Tyre protypeScope=(Tyre) context.getBean("prototypescope");
		Tyre protypeScope1=(Tyre) context.getBean("prototypescope");
		System.out.println(protypeScope.toString());
		System.out.println(protypeScope1.toString());
		System.out.println("NOTE : Prototype scope is create new object everytime.");
		System.out.println("NOTE : If we check all objects hascode then all objects have a different hascode.");
		System.out.println("\nFirst object hascode  : "+protypeScope.hashCode());
		System.out.println("Second object hascode : "+protypeScope1.hashCode());
		
	}
}
