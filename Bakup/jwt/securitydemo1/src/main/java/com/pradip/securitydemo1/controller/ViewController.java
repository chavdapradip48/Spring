package com.pradip.securitydemo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pradip.securitydemo1.model.User;
import com.pradip.securitydemo1.service.ServiceInf;

@Controller
public class ViewController {
	
//	private BCryptPasswordEncoder passEncode=new BCryptPasswordEncoder();
//	
//	@Autowired
//	private ServiceInf serviceInf;
	
	
	@RequestMapping("/loginpage")
	public String getIndexPage() {
//		User u=new User();
//		u.setUsername("sandip@gmail.com");
//		u.setPassword(passEncode.encode("sandip123"));
//		u.setRole("NORMAL");
//		serviceInf.insertUser(u);
		return "index";
	}
}
