package com.pradip.springcloud;

public class Employee {
	
	private String empId;
	private String empName;
	private String empEmail;
	
	public Employee() {
		super();
	}

	public Employee(String empId, String empName, String empEmail) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + "]";
	}
	
}
