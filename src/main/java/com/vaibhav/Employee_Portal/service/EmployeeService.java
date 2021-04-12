package com.vaibhav.Employee_Portal.service;

import com.vaibhav.Employee_Portal.model.Employee;
import java.util.*;

import org.springframework.data.domain.Page;

public interface EmployeeService {

	public void save(Employee employee);
	
	//public List<Employee> getAllRecords();
	
	//For pagination--
	public Page<Employee> getAllRecords(int pagenumber);
	
	public void deleteEmployee(int id);
	
	public Employee get(int id);
	
}
