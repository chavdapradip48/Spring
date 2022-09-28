package com.user.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.userservice.model.Address;
import com.user.userservice.model.Person;
import com.user.userservice.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable("id") String id) {
		
		Person person=personService.getPerson(id);
		//http://localhost:8010/address/3
		
		@SuppressWarnings("unchecked")
		List<Address> AddressList = this.restTemplate.getForObject("http://address-service/address/"+id, List.class);
		
		person.setAddresses(AddressList);
		
		return person;
	}
	
	@GetMapping("/")
	public List<Person> getPersons() {
		return personService.getAllPersons();
	}
}

/* OUTPUT

{
    "id": "1",
    "name": "Pradip Chavda",
    "mobile": "9909714196",
    "addresses": [
        {
            "id": "1",
            "fullAddress": "Shankarapara, Botad",
            "userId": "1"
        },
        {
            "id": "2",
            "fullAddress": "Memnagar, Ahmedabad",
            "userId": "1"
        }
    ]
}
 */
