package com.pradip.springbootfinal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pradip.springbootfinal.dao.UserRepository;
import com.pradip.springbootfinal.model.User;

@Controller
public class UserController {
	@Autowired
	private User user;
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping("/")
	public String getIndexPage(Model model) {
		Iterable<User> findAll = userRepository.findAll();
		List<User> result = new ArrayList<>();
	    findAll.forEach(result::add);
	    
	    model.addAttribute("editUser",user);
		model.addAttribute("users",result);
		return "index";
	}
	
	@RequestMapping("/form")
	public String getFormPage(@ModelAttribute("user") User user,  Model model) {
		userRepository.save(user);
		
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
}
