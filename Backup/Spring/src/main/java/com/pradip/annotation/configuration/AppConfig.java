package com.pradip.annotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Mobile getPhone() {
		return new Mobile();
	}
}
