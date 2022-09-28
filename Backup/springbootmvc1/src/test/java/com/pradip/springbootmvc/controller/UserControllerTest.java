package com.pradip.springbootmvc.controller;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pradip.springbootmvc.model.Address;
import com.pradip.springbootmvc.model.Role;
import com.pradip.springbootmvc.model.User;
import com.pradip.springbootmvc.service.UserService;

//@WebMvcTest(UserController.class)
//@SpringBootTest
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private User user;
	
	@MockBean
	private UserService userService;
	
//	@Mock
//	@Spy
//	private GeneralFilter generalFilter;
	
	void init() {
//		userService = new UserServiceImpl();
		user=new User();
		user.setId(12);
		user.setName("Sandip");
		user.setEmail("sandip@gmail.com");
		user.setMobile("9966225511");
		user.setBirthdate("2000-04-21");
		user.setGender("male");
		user.setHobby("Cricket");
		user.setImageBase64("");
		user.setPassword("this is password");
	
		Address ad=new Address();
		ad.setId(1);
		ad.setGeneral("general");
		ad.setCity("city");		
		ad.setState("fvd");
		ad.setPincode("sdfsdf");
		ad.setUser(user);
		
		Address ad1=new Address();
		ad1.setId(2);
		ad1.setGeneral("general");
		ad.setCity("city");	
		ad1.setState("fvd");
		ad1.setPincode("sdfsdf");
		ad1.setUser(user);

		List<Address> addl=new ArrayList<>();
		addl.add(ad);
		addl.add(ad1);
		
		user.setAddress(addl);
		
		Role r=new Role();
		r.setId(1);
		r.setRoleType(1);
		r.setUser(user);
		
		user.setRole(r);
	}
	
	@Test
	public void indexPageTest() throws Exception {
//	    HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
//	    HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
//	    FilterChain filterChain = mock(FilterChain.class);
//		doReturn("index").when(generalFilter).doFilter(httpServletRequest, httpServletResponse, filterChain);
//	    when(httpServletRequest.getServletPath()).thenReturn("/index");
//	    doNothing().when(generalFilter).doFilter(httpServletRequest, httpServletResponse, filterChain);
		
//	    this.mockmvc.perform(get("/index")).andExpect(status().is(302));
		init();
		ResultActions perform = mockmvc.perform(MockMvcRequestBuilders.get("/").sessionAttr("sessionUser", user));
		perform.andExpect(status().isOk());
		System.out.println("\n=> When / fired then the "+perform.andReturn().getModelAndView().getViewName()+" view comes.");
	}
	
	@Test
	public void registerPageTest() throws Exception {
		init();
		ResultActions perform = mockmvc.perform(MockMvcRequestBuilders.get("/register").sessionAttr("sessionUser", user));
		perform.andExpect(status().isOk());
		System.out.println("\n=> When /register fired then the "+perform.andReturn().getModelAndView().getViewName()+" view comes.");
	}
	
	@Test
	public void forgotPageTest() throws Exception {
		init();
		ResultActions perform = mockmvc.perform(MockMvcRequestBuilders.get("/forgot").sessionAttr("sessionUser", user));
		perform.andExpect(status().isOk());
		System.out.println("\n=> When /forgot fired then the "+perform.andReturn().getModelAndView().getViewName()+" view comes.");
	}
	
	@Test
	public void errorPageTest() throws Exception {
		init();
		ResultActions perform = mockmvc.perform(MockMvcRequestBuilders.get("/error").sessionAttr("sessionUser", user));
		perform.andExpect(status().isOk());
		System.out.println("\n=> When /error fired then the "+perform.andReturn().getModelAndView().getViewName()+" view comes.");
	}
	
	@Test
	public void viewusersPageTest() throws Exception {
		
		init();
		System.out.println("");
		List<User> userList=new ArrayList<>();
		userList.add(user);
		userList.add(user);
		when(userService.getAllUsers()).thenReturn(userList);
//		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
//		
//		when(httpServletRequest.getServletPath()).thenReturn("viewusers");
		
		ResultActions perform = mockmvc.perform(MockMvcRequestBuilders.get("/viewusers").sessionAttr("sessionUser", user));
		perform.andExpect(status().isOk());
		System.out.println("\n=> When /viewusers fired then the "+perform.andReturn().getModelAndView().getViewName()+" view comes.");
	}
	
	@Test
	public void profilePageTest() throws Exception {
		init();
		
		when(userService.getUserByEmail("sandip@gmail.com")).thenReturn(user);
//		when(userService.getUserByEmail("sandip@gmail.com"));
		ResultActions perform = mockmvc.perform(MockMvcRequestBuilders.get("/profile?profileEmail=sandip@gmail.com").sessionAttr("sessionUser", user));
		perform.andExpect(status().isOk());
		System.out.println("\n=> When /profile fired then the "+perform.andReturn().getModelAndView().getViewName()+" view comes.");
	}
	
	@Test
	public void deleteUserTest() throws Exception {
		init();
		userService.deleteById(12);
		ResultActions perform = mockmvc.perform(MockMvcRequestBuilders.get("/DeleteUser?id=12").sessionAttr("sessionUser", user));
	}
	
	
	@Test
	public void emailCheckIfTest() throws Exception {
		init();
		
		when(userService.existsByEmail("sandip@gmail.com")).thenReturn(true);
		mockmvc.perform(MockMvcRequestBuilders.get("/EmailCheck?cuEmail=sandip@gmail.com").sessionAttr("sessionUser", user));
//		perform.andExpect(status().isOk());
//		System.out.println("\n=> When /profile fired then the "+perform.andReturn().getModelAndView().getViewName()+" view comes.");
	}
	@Test
	public void emailCheckElseTest() throws Exception {
		init();
		when(userService.existsByEmail("sandip@gmail.com")).thenReturn(false);
		mockmvc.perform(MockMvcRequestBuilders.get("/EmailCheck?cuEmail=sandip@gmail.com").sessionAttr("sessionUser", user));
	}
	
	@Test
	public void processForgotTest() throws Exception {
		init();
		
		when(userService.updatePassword("sandip@gmail.com",user.getPassword())).thenReturn(true);

		mockmvc.perform(MockMvcRequestBuilders.get("/ProcessForgot")
				.param("email", user.getEmail())
				.param("password", user.getPassword())
				.sessionAttr("sessionUser", user)).andExpect(status().is(200));
	}
	
	@Test
	public void processForgotFalseTest() throws Exception {
		init();
		
		when(userService.updatePassword("sandip@gmail.com",user.getPassword())).thenReturn(false);

		mockmvc.perform(MockMvcRequestBuilders.get("/ProcessForgot")
				.param("email", user.getEmail())
				.param("password", user.getPassword())
				.sessionAttr("sessionUser", user)).andExpect(status().is(200));
	}
	
	@Test
	public void generateCSVTest() throws Exception {
		init();
		mockmvc.perform(MockMvcRequestBuilders.get("/GenerateCSV")
				.sessionAttr("sessionUser", user)).andExpect(redirectedUrl("/viewusers"));
	}
	
	@Test
	public void logoutTest() throws Exception {
		init();
		mockmvc.perform(MockMvcRequestBuilders.get("/Logout")
				.sessionAttr("sessionUser", user)).andExpect(redirectedUrl("/"));
	}
	
	@Test
	public void processLoginAdminTest() throws Exception {
		init();
		when(userService.userLoginService(user.getEmail(), user.getPassword())).thenReturn(true);
		when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
		
		mockmvc.perform(MockMvcRequestBuilders.get("/ProcessLogin")
				.param("email", user.getEmail())
				.param("password", user.getPassword())
				.sessionAttr("sessionUser", user)).andExpect(redirectedUrl("/viewusers"));
	}
	
	@Test
	public void processLoginUserTest() throws Exception {
		init();
		user.getRole().setRoleType(0);
		when(userService.userLoginService(user.getEmail(), user.getPassword())).thenReturn(true);
		when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
		
		mockmvc.perform(MockMvcRequestBuilders.get("/ProcessLogin")
				.param("email", user.getEmail())
				.param("password", user.getPassword())
				.sessionAttr("sessionUser", user)).andExpect(redirectedUrl("/profile?profileEmail=sandip@gmail.com"));
	}
	
	@Test
	public void processLoginFalseTest() throws Exception {
		init();
		when(userService.userLoginService(user.getEmail(), user.getPassword())).thenReturn(false);
		
		mockmvc.perform(MockMvcRequestBuilders.get("/ProcessLogin")
				.param("email", user.getEmail())
				.param("password", user.getPassword())
				.sessionAttr("sessionUser", user)).andExpect(status().isOk());
	}
	
	@Test
	public void editProfileTest() throws Exception {
		init();
		when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
		mockmvc.perform(MockMvcRequestBuilders.get("/EditProfile").param("email", user.getEmail()).sessionAttr("sessionUser", user)).andExpect(status().isOk());
	}
	
	@Test
	public void adduserHasErrorTest() throws Exception {
		init();
		mockmvc.perform(MockMvcRequestBuilders.post("/AddUser")
				.sessionAttr("sessionUser", user)).andExpect(status().is(200));
	}
	
	@Test
	public void adduserTest() throws Exception {
		init();
		user.setId(13);
		mockmvc.perform(MockMvcRequestBuilders.post("/AddUser")
				.flashAttr("userObj", user)
				.sessionAttr("sessionUser", user)).andExpect(status().is(302));
//		Gson gson = new Gson();
//        String json = gson.toJson(user);
//		String stringUser = user.toString();
//		mockmvc.perform(post("/usermgmt/createCloudCredential").contentType(
//		            MediaType.APPLICATION_JSON).content(json)).andExpect(
//		        status().isOk());

//		mockmvc.perform(MockMvcRequestBuilders.post("/AddUser").param("UserObj", stringUser)).andExpect(status().isOk());
////		User uu=User.b
////		when(userService.userSave(user)).thenReturn(true);
////		
//		ObjectMapper mapper=new ObjectMapper();
//		ObjectWriter writer=mapper.writer();
//		String passObject=writer.writeValueAsString(user);
//		
//		MockHttpServletRequestBuilder req=MockMvcRequestBuilders.post("/AddUser").content(passObject);
		
		
//		mockmvc.perform(req);
//		verify(userService,atLeast(1)).userSave(user);
	}
	
}
