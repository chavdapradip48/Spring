package com.pradip.springbootfinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pradip.springbootfinal.dao.UserRepository;
import com.pradip.springbootfinal.model.User;

@Controller
public class UserController {
	@Autowired
	private User user;
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
//		Iterable<User> findAll = userRepository.findAll();
//		List<User> result = new ArrayList<>();
//	    findAll.forEach(result::add);
//	    
//		List<User> result=userRepository.getAllBetweenUsers(4, 11);
		
		List<User> result=userRepository.getUsersByNative();
	    model.addAttribute("editUser",user);
		model.addAttribute("users",result);
		System.out.println("Request for index");
		model.addAttribute("userObj", new User());
		
		return "index";
	}
	
	@PostMapping("/form")
	public String getFormPage(@Valid @ModelAttribute("userObj") User user, BindingResult result) {
		System.out.println("\nhello name is : "+user.getName());
		System.out.println("\nhello mobile is : "+user.getMobile());
		System.out.println("\n\n => "+result);
		userRepository.save(user);
//		if(result.hasErrors()) {
//			System.out.println("\n\n => There is error\n\n");
////			return "redirect:/";
//		}
//		else {
//			System.out.println("There is no error");
////			return "redirect:/";
//		}
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/DeleteUser")
	public String deleteUser(@RequestParam("id") int id) {
		userRepository.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping("/EditUser")
	public String EditUser(@RequestParam("id") int id,Model model) {
		Optional<User> fUser=userRepository.findById(id);
		
		User userf=fUser.get();
		model.addAttribute("editUser", userf);
		return "index";
	}
	@RequestMapping("/ByName")
	public String byName() {
		List<User> fUser=userRepository.findByName("Sandip Chavda");
		System.out.println("\n\n=> Find by name is : ");
		fUser.forEach(u -> System.out.println(u));
		return "redirect:/";
	}
	
}
