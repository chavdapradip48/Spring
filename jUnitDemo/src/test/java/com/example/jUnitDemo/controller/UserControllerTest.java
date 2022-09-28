package com.example.jUnitDemo.controller;

import static org.mockito.Mockito.atLeast;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.jUnitDemo.model.User;
import com.example.jUnitDemo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void addUserTest() throws Exception{
		User user = new User();
		user.setId(1);
		user.setName("swati");
		
		ObjectMapper Obj = new ObjectMapper();
		Obj.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String json = Obj.writeValueAsString(user);
		
		when(userService.saveUser(user)).thenReturn(user);
		
		this.mockMvc
		.perform(post("/user/save-user")
				.contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(status().isOk());

		verify(userService, atLeast(1)).saveUser(any());
		
	}
	
	@Test
	public void addUserTestException() throws Exception{
		User user = new User();
		user.setId(1);
		user.setName("swati");
		
		ObjectMapper Obj = new ObjectMapper();
		Obj.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String json = Obj.writeValueAsString(user);
		
		when(userService.saveUser(user)).thenThrow(new RuntimeException());
		
		this.mockMvc
		.perform(post("/user/save-user")
				.contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(status().isInternalServerError());

		verify(userService, atLeast(1)).saveUser(any());
	}
	
	@Test
	public void getUserTest() throws Exception{
		User user = new User();
		user.setId(1);
		user.setName("swati");
		when(userService.getUserById(1)).thenReturn(user);
		
		this.mockMvc
		.perform(get("/user/get-user/1"))
		.andExpect(status().isOk());

		verify(userService, atLeast(1)).getUserById(anyInt());
	}
	
	@Test
	public void getUserTestException() throws Exception{
		User user = new User();
		user.setId(1);
		user.setName("swati");
		when(userService.getUserById(1)).thenThrow(new RuntimeException());
		
		this.mockMvc
		.perform(get("/user/get-user/1"))
		.andExpect(status().isInternalServerError());

		verify(userService, atLeast(1)).getUserById(anyInt());
	}
	
	
	


}
