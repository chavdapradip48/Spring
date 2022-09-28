package com.pradip.securitydemo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.securitydemo1.model.JwtRequest;
import com.pradip.securitydemo1.model.JwtResponse;
import com.pradip.securitydemo1.model.User;
import com.pradip.securitydemo1.service.CustomUserDetailService;
import com.pradip.securitydemo1.service.ServiceInf;
import com.pradip.securitydemo1.util.JWTHelper;

@RestController
@RequestMapping("/user")
public class UserController {
	

	//private BCryptPasswordEncoder passEncode=new BCryptPasswordEncoder();
	@Autowired
	private ServiceInf serviceInf;
	
	@GetMapping("/")
	public String getHome(){
		return "THis is Public page";
	}
	
	@GetMapping("/users")
//	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers(){

		return this.serviceInf.getAllUsers();
	}
	
	@GetMapping("/getuser/{id}")
//	@PreAuthorize("hasRole('ADMIN')") // this url access only admin role user
	public User getUserById(@PathVariable("id") int id) {
		return this.serviceInf.getUserById(id);
	}
	
	@PostMapping("/adduser")
	public User insertUser(@RequestBody User user) {
//		user.setPassword(passEncode.encode(user.getPassword()));
		return this.serviceInf.insertUser(user);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public List<User> deleteUserById(@PathVariable("id") int id) {
		this.serviceInf.deleteUserById(id);
		return this.serviceInf.getAllUsers();
	}
	

	
}
