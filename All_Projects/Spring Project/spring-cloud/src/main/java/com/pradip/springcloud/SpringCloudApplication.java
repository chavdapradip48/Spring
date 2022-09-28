package com.pradip.springcloud;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudApplication {

	public static void main(String[] args) {SpringApplication.run(SpringCloudApplication.class, args);}

//	Function interface have a two parameter target and return type
	
	/*
	 *  curl -H "Content-Type: text/plain" localhost:8080/toUpperCase -d "this is to upper case method "
	 *  
	 *  THIS IS TO UPPER CASE METHOD 	
	 * */
	@Bean
	public Function<String,String> toUpperCase(){
		return (value) -> new StringBuffer(value).toString().toUpperCase();
	}
	
	
	/*
	 *  curl -H "Content-Type: text/plain" localhost:8080/getMessage
	 *  
	 *  This is supplier function
	 * */
	
	@Bean
	public Supplier<String> getMessage(){
		return ()-> "This is supplier function";
	}
	
	
	
	/*
	 * curl -H "Content-Type: text/plain" localhost:8080/writeMessage -d "this is consumer function. and it print result in console"
	 * 
	 * this is consumer function. and it print result in console
	 * */
	@Bean
	public Consumer<String> writeMessage(){
		return (value)-> System.out.println(value);
	}
}