package com.pradip.springbootfinal.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "test_user")
@Component
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "name empty")
	@Size(min = 5, max = 10,message = "This is name size error ")
//	@NotEmpty(message = "Please enter name field.")
	private String name;
	
	@Column(unique = true)
//	@NotEmpty(message = "Please enter mobile field.")
//	@Size(min = 10,message = "Please enter 10 digit mobile number.")
	private String mobile;
	public User() {
		super();
	}
	public User(int id, String name, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
