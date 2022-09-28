package com.example.jUnitDemo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.jUnitDemo.dao.UserDao;
import com.example.jUnitDemo.model.User;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserDao userDao;
	
	@BeforeAll
	void init() {
		userService = new UserServiceImpl();
	}
	
	@Test
	void saveUserTest() throws Exception {
		User user = new User();
		user.setName("swati");
		User expected = new User();
		expected.setId(1);
		expected.setName("swati");
		
		when(userDao.save(user)).thenReturn(expected);	
				
		User actual = userService.saveUser(user);
		assertNotNull(actual.toString());
		
		verify(userDao, atLeast(1)).save(any());
	}
	
	@Test
	void saveUserExceptionTest() throws Exception {
		User user = new User();
		
		when(userDao.save(user)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, ()-> userService.saveUser(user));
		verify(userDao, atLeast(1)).save(any());
	}

	@Test
	void getUserTest() throws Exception {
		User expected = new User();
		expected.setId(1);
		expected.setName("swati");
		
		when(userDao.getById(1)).thenReturn(expected);	
				
		User actual = userService.getUserById(1);
		assertNotNull(actual.toString());
		
		verify(userDao, atLeast(1)).getById(anyInt());
	}
	
	@Test
	void getUserExceptionTest() throws Exception {
		
		when(userDao.getById(1)).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, ()-> userService.getUserById(1));
		verify(userDao, atLeast(1)).getById(anyInt());
	}
}
