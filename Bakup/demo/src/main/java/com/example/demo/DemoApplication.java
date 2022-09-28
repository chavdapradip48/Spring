package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {



		SpringApplication.run(DemoApplication.class, args);

		TestInteraface te=new Test1();
		te.thisMethod();
		te.thisMethod2();
		te.thisMethod3();


	}

}
