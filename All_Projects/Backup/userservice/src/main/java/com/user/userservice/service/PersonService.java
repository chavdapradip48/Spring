package com.user.userservice.service;

import java.util.List;

import com.user.userservice.model.Person;

public interface PersonService {
	public Person getPerson(String id);

	public List<Person> getAllPersons();
}
