package com.user.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.userservice.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	//Make fake user list
	List<Person> list=List.of(
			new Person("1","Pradip Chavda","9909714196"),
			new Person("2","Sandip Chavda", "9664921495"),
			new Person("3","Ajay Kanjariya","9955668855")
			);
	
	@Override
	public Person getPerson(String id) {
		return this.list.stream().filter(user-> user.getId().equals(id)).findAny().orElse(null);
	}

	@Override
	public List<Person> getAllPersons() {
		return list;
	}

	
}
