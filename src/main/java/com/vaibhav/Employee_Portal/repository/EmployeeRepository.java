package com.vaibhav.Employee_Portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.Employee_Portal.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//for pagination
	
	
}
