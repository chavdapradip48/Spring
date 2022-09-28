package com.pradip.springcloud;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GetEmployees implements Supplier<EmployeeData> {

	@Override
	public EmployeeData get() {
		EmployeeData empData=new EmployeeData();
		empData.setEmployees(this.employees());
		return empData;
	}
	
	
	private List<Employee> employees(){
		return new ArrayList<Employee>() {{
			add(new Employee("1","Pradip","pradip@gmail.com"));
			add(new Employee("2","Sandip","sandip@gmail.com"));
			add(new Employee("3","Ajay","ajay@gmail.com"));
			add(new Employee("4","Rakesh","rakesh@gmail.com"));
		}};
	}
}
/*
 * root320@pradip-inexture:~$ curl -H "Content-Type: application/json" localhost:8080/getEmployees
 * {"employees":[{"empId":"1","empName":"Pradip","empEmail":"pradip@gmail.com"},
 * 				{"empId":"2","empName":"Sandip","empEmail":"sandip@gmail.com"},
 * 				{"empId":"3","empName":"Ajay","empEmail":"ajay@gmail.com"},
 * 				{"empId":"4","empName":"Rakesh","empEmail":"rakesh@gmail.com"}]}
 * 
 * */
 