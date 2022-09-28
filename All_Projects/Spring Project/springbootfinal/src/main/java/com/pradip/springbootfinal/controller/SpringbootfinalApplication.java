package com.pradip.springbootfinal.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
	
@SpringBootApplication
@ComponentScan(basePackages={"com.pradip.springbootfinal"}) 
@EntityScan(basePackages={"com.pradip.springbootfinal.model"}) 
@EnableJpaRepositories(basePackages={"com.pradip.springbootfinal.dao"}) 
public class SpringbootfinalApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootfinalApplication.class, args);
		
	}
}
