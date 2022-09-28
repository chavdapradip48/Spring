package com.user.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@Lazy
	private RestTemplate restTemplate;

//	@Value("${address.provider.url}")
	private String addresUrl="localhost:8010/address/add";

	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable("id") String id) {
		

		
		Person person=personService.getPerson(id);
		//http://localhost:8010/address/3
		//"http://address-service/address/"
		
		Address address1=new Address();
		address1.setId("1");
		address1.setUserId("1");
		address1.setFullAddress("pradip");
		
		ResponseEntity<Address> address=this.restTemplate.postForEntity(addresUrl, address1, Address.class);
//		@SuppressWarnings("unchecked")
//		List<Address> AddressList = this.restTemplate.getForObject(addresUrl+id, List.class);
		System.out.println("Resttemplate : "+address);
		
		return person;
	}
	
	@PostMapping("/test")
	public String getPersons1(@RequestBody Person person) {
		System.out.println("This is link of address list : "+person);
		
		Address address1=new Address();
		address1.setId("1");
		address1.setUserId("1");
		address1.setFullAddress("pradip");
		
		this.restTemplate.postForEntity(addresUrl, address1, Address.class);
		
//		System.out.println("\n\nhello from rest "+address);
		
		return "Hello";
	}
	
	@GetMapping("/")
	public List<Person> getPersons() {
		System.out.println("This is link of address list : "+addresUrl);
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
