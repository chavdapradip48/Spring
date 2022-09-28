package com.amberflo.metering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.amberflo.metering"})
@Configuration
public class EmberfloExampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EmberfloExampleApplication.class, args);
	}
}