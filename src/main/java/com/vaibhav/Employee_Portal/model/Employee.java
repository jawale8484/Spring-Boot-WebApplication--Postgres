package com.vaibhav.Employee_Portal.model;
import java.lang.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	private String emp_name;
	private String address;
	private String desiganation;
	private long salary;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int emp_id, String emp_name, String address, String desiganation, long salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.address = address;
		this.desiganation = desiganation;
		this.salary = salary;
	}


	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDesiganation() {
		return desiganation;
	}


	public void setDesiganation(String desiganation) {
		this.desiganation = desiganation;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", address=" + address + ", desiganation="
				+ desiganation + ", salary=" + salary + "]";
	}


	
	
	
	
}
