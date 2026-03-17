package com.IT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Entity.Employee;
import com.IT.Service.EmployeeService;
import com.IT.DTO.*;

@RestController
public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeService  service;
	
	
	
	@PostMapping("/add-emp")
	public Employee addemp(@RequestBody Employee emp)
	{
		return service.saveemp(emp);
	}
	
	
	@GetMapping("/get-all-emps")
	public List<Employee> get()
	{
		return service.getall();
	}

}
