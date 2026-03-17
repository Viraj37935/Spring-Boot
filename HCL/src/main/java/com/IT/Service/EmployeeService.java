package com.IT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IT.Entity.Employee;
import com.IT.Repository.EmpRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmpRepo repo;
	
	public Employee saveemp(Employee emp)
	{
		System.out.println();
		return repo.save(emp);
	}
	
	
	public List<Employee> getall()
	{
		
		return repo.findAll();
	}

}
