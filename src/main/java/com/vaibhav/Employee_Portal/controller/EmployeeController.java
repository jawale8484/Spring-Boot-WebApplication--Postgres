package com.vaibhav.Employee_Portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;

import com.vaibhav.Employee_Portal.model.Employee;
import com.vaibhav.Employee_Portal.repository.EmployeeRepository;
import com.vaibhav.Employee_Portal.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
		
	@RequestMapping("/index")
	public String frontpage() {
		return "index";
	}
	
	
	
	@RequestMapping("/addemployee")
	public String insert(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "addemployee";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveDetails(Employee employee,Model model) {
		employeeService.save(employee);
		
		return viewEmployees(1,model); 
	}
	
	
	//this method for show all data
	
//	@RequestMapping(value = "/show", method = RequestMethod.GET)
//	public String viewEmployees(Model model) {
//	List<Employee> emplist=	employeeService.getAllRecords();
//		model.addAttribute("employeelist",emplist);
//		return "show";
//	}
//	
	
	
	//pagination-->
	@RequestMapping(value = "/show/{page}", method = RequestMethod.GET)
	public String viewEmployees(@PathVariable("page")Integer page, Model model) {
	Page<Employee> emplist=	employeeService.getAllRecords(page);
	
	int totalitem=emplist.getNumberOfElements();
	long totalpage=emplist.getTotalPages();
	
	List<Employee> list=emplist.getContent();
	model.addAttribute("currentpage",page);
	model.addAttribute("totalpage",totalpage);
	model.addAttribute("totalitem",totalitem);
	model.addAttribute("employeelist",list);
		return "show";
	}
	
	
	
	//--------
	
	

	@RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.GET)
	public String deleteEmployeesByid(@PathVariable("id") int id ,Model model) {
		
//		Employee employee=employeeRepository.findById(id)
//				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//		employeeRepository.delete(employee);
//		
		
		this.employeeService.deleteEmployee(id);
		return viewEmployees(1,model);
	}
	
	@RequestMapping(value = "/updatebyid/{id}",method = RequestMethod.GET)
	public String updateByid(@PathVariable(value = "id")int id,Employee employee,Model model) {
		
//		employeeService.save(employee);
		
		Employee employ=employeeService.get(id);
		model.addAttribute("employ",employ);	
		
		return "updatebyid";
		
		
	}
	
	
}
