package com.pradip.springbootmvc.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pradip.springbootmvc.dao.AddressDao;
import com.pradip.springbootmvc.dao.UserDao;
import com.pradip.springbootmvc.model.Address;
import com.pradip.springbootmvc.model.Role;
import com.pradip.springbootmvc.model.User;



@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserDao userDao;
	
	@Mock
	private AddressDao addressDao;
	
	User u;
	
	@BeforeAll
	void init() {
		userService = new UserServiceImpl();
		u=new User();
		u.setId(12);
		u.setName("Sandip");
		u.setEmail("sandip@gmail.com");
		u.setMobile("9966225511");
		u.setBirthdate("2000-04-21");
		u.setGender("male");
		u.setHobby("Cricket");
	
		Address ad=new Address();
		ad.setId(1);
		ad.setGeneral("general");
		ad.setCity("city");		
		ad.setState("fvd");
		ad.setPincode("sdfsdf");
		ad.setUser(u);
		
		Address ad1=new Address();
		ad1.setId(2);
		ad1.setGeneral("general");
		ad.setCity("city");	
		ad1.setState("fvd");
		ad1.setPincode("sdfsdf");
		ad1.setUser(u);

		Address ad3=new Address();
		ad1.setId(0);
		ad1.setGeneral("");
		ad.setCity("");	
		ad1.setState("");
		ad1.setPincode("");
		ad1.setUser(u);
		
		List<Address> addl=new ArrayList<>();
		addl.add(ad);
		addl.add(ad1);
		addl.add(ad3);
		
		u.setAddress(addl);
		
		Role r=new Role();
		r.setId(1);
		r.setRoleType(1);
		r.setUser(u);
		
		u.setRole(r);
	}
	
	@Test
	@DisplayName("This test case for login request and is true")
	void userLoginServiceIfTest() throws Exception {
		
		String email="sandip@gmail.com";
		String password="APi0O8IrWRqwcMI8Iojp7w==";
		System.out.println("this is setted user : "+u);
		when(userDao.existsByEmailAndPassword(any(),any())).thenReturn(true);	
		boolean actual=userService.userLoginService(email,password);		

		System.out.println(actual);
		assertThat(actual).isTrue();
	}
	
	@Test
	@DisplayName("This test case for login request and is false")
	void userLoginServiceElseTest() throws Exception {
		
		String email="sandip@gmail.com";
		String password="APi0O8IrWRqwcMI8Iojp7w==";
		
		when(userDao.existsByEmailAndPassword(any(),any())).thenReturn(false);	
		boolean actual=userService.userLoginService(email,password);		
		System.out.println(actual);
		assertThat(actual).isFalse();
	}
	
	@Test
	@DisplayName("This test case for getAllUsers that return user list")
	void getAllUsersTest() throws Exception {
		List<User> userList=new ArrayList<>();
		userList.add(u);
		userList.add(u);
		userList.add(u);
		when(userDao.findAll()).thenReturn(userList);	
		List<User> actual = userService.getAllUsers();
		System.out.println(actual);
		assertThat(actual).isNotNull();
	}
	
//	@DisplayName("This test case for ")
//	void existsByEmailAndPasswordTest() throws Exception {
//		when(userDao.existsByEmailAndPassword(any(), any())).thenReturn(true);	
//		boolean actual = userService.existsByEmailAndPassword(u.getEmail(), u.getPassword());
//		System.out.println(actual);
//		assertThat(actual).isTrue();
//	}
//	
	@Test
	@DisplayName("This test case for ")
	void existsByEmailTest() throws Exception {
		when(userDao.existsByEmail(any())).thenReturn(true);	
		boolean actual = userService.existsByEmail(u.getEmail());
		System.out.println(actual);
		assertThat(actual).isTrue();
	}
	
	@Test
	@DisplayName("This test case for ")
	void updatePasswordIfTest() throws Exception {
		when(userDao.updatePassword(any(), any())).thenReturn(1);	
		boolean actual = userService.updatePassword(u.getEmail(), u.getPassword());
		System.out.println(actual);
		assertThat(actual).isTrue();
	}
	
	@Test
	@DisplayName("This test case for ")
	void updatePasswordElseTest() throws Exception {
		when(userDao.updatePassword(any(), any())).thenReturn(0);	
		boolean actual = userService.updatePassword(u.getEmail(), u.getPassword());
		System.out.println(actual);
		assertThat(actual).isFalse();
	}
	
	@Test
	@DisplayName("This test case for ")
	void getUserByEmailIfTest() throws Exception {
		List<User> userList=new ArrayList<>();
		userList.add(u);
		when(userDao.findByEmail(u.getEmail())).thenReturn(userList);
		
		User actual = userService.getUserByEmail(u.getEmail());
		
		System.out.println(actual);
		
		assertThat(actual).isNotNull();
	}
	
	@Test
	@DisplayName("This test case for ")
	void getUserByEmailElseTest() throws Exception {
		List<User> userList=new ArrayList<>();
		
		when(userDao.findByEmail(u.getEmail())).thenReturn(userList);
		
		User actual = userService.getUserByEmail(u.getEmail());
		
		System.out.println(actual);
		
		assertThat(actual).isNull();
		
		
	}
	
	@Test
	@DisplayName("This test case for insert user")
	void addUserInsertTest() throws Exception {
		
		u.setId(0);
		u.getAddress().get(0).setId(0);
		u.getAddress().get(1).setId(0);
		u.getRole().setId(0);
		System.out.println("User from insert test case : "+u);
//		List<Integer> idList=new ArrayList<>();
//		idList.add(12);
//		idList.add(13);
//		idList.add(14);
//		when(addressDao.deleteByIdIn(idList, u)).thenReturn(1);
		when(userDao.save(u)).thenReturn(u);	
	
		boolean actual = userService.userSave(u);
		
		System.out.println(actual);	
		assertThat(actual).isTrue();
		
	}
	
	@Test
	@DisplayName("This test case for update user")
	void addUserUpdateTest() throws Exception {
		
//		u.setId(0);
		u.getAddress().get(0).setId(0);
//		u.getAddress().get(1).setId(0);
//		u.getRole().setId(0);
		System.out.println("User from update test case : "+u);
//		List<Integer> idList=new ArrayList<>();
//		idList.add(12);
//		idList.add(13);
//		idList.add(14);
//		when(addressDao.deleteByIdIn(idList, u)).thenReturn(1);
		when(userDao.save(u)).thenReturn(null);	
	
		boolean actual = userService.userSave(u);
		
		System.out.println(actual);	
		assertThat(actual).isFalse();
		
	}
//	@Test
//	@DisplayName("This test case for ")
//	void addUserOneTest() throws Exception {
//		when(userDao.save(u)).thenReturn(u);	
//		boolean actual = userService.userSave(u);
//		System.out.println(actual);	
//		assertThat(actual).isTrue();
//	}
	
	@Test
	@DisplayName("This test case for ")
	void deleteByIdTest() throws Exception {
		userService.deleteById(12);
		verify(userDao,atLeast(1)).deleteById(12);
	}

	
//	@Test
//	@DisplayName("This test case for ")
//	void existsByEmailAndPasswordTest() throws Exception {
//		when(userDao.).thenReturn();	
//		 actual = userService;
//		System.out.println(actual);
//		assertThat(actual).isNotNull();
//	}
	
//	@TestexistsByEmail
//	@DisplayName("This test case for ")
//	void Test() throws Exception {
//		when(userDao.).thenReturn();	
//		 actual = userService;
//		System.out.println(actual);
//		assertThat(actual).isNotNull();
//	}
	
	
	
//	existsByEmailAndPassword
//	@Test
//	@DisplayName("This test case for getUserByEmail is return user list")
//	void getUserByEmailIfTest() throws Exception {
//		
//		String email="sandip@gmail.cm";
//		List<User> user=null;
//		when(userDao.findByEmail(any())).thenReturn(user);	
//		User actual = userService.getUserByEmail(email);
//		System.out.println(actual);
//		assertThat(actual).isNull();
//	}
//	
//	@Test
//	@DisplayName("This test case for getUserByEmail is return user list")
//	void getUserByEmailElseTest() throws Exception {
//		
//		String email="sandip@gmail.com";
//		
//		when(userDao.findByEmail(any())).thenReturn(null);	
//		User actual = userService.getUserByEmail(email);
//		System.out.println(actual);
//		assertThat(actual).isNull();
//	}
}
