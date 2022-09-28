package com.gateway.apigateway2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {


    @GetMapping("/PersonServiceFallback")
    public String userServiceFallback() {
        return "User service is down at this time !!";
    }

    @GetMapping("/AddressServiceFallback")
    public String contactServiceFallback() {
        return "Contact service is down at this time";
    }

}
