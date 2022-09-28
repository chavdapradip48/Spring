package com.apigateway.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/PersonServiceDown")
	public String personServiceFallback() {
		return "Person Service is down So Please after some time.";
	}
	
	@GetMapping("/AddressServiceDown")
	public String addressServiceFallback() {
		return "Address Service is down So Please after some time.";
	}
}
