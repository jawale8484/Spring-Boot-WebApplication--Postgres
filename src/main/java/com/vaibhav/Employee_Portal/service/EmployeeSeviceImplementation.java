package com.vaibhav.Employee_Portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vaibhav.Employee_Portal.model.Employee;
import com.vaibhav.Employee_Portal.repository.EmployeeRepository;

@Service
public class EmployeeSeviceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	// regular method
//	@Override
//	public List<Employee> getAllRecords() {
//		return employeeRepository.findAll();
//	}

	@Override
	public void deleteEmployee(int id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Employee get(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp.get();

//		 Optional < Employee > optional = employeeRepository.findById(id);
//	        Employee employee = null;
//	        if (optional.isPresent()) {
//	            employee = optional.get();
//	        } else {
//	            throw new RuntimeException(" Employee not found for id :: " + id);
//	        }
//	        return employee;
	}

	@Override
	public Page<Employee> getAllRecords(int pagenumber) {
		Pageable pageale=PageRequest.of(pagenumber-1, 5);
		return employeeRepository.findAll(pageale);
	}

}
