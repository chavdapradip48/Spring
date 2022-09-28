package com.pradip.springcloud;

import java.util.List;

public class EmployeeData {
	
	private List<Employee> employees;

	public EmployeeData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeData(List<Employee> employees) {
		super();
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "EmployeeData [employees=" + employees + "]";
	}

	
	
}
