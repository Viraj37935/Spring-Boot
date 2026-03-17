package com.IT.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Entity.Company;
import com.IT.Entity.Employee;
import com.IT.Service.Companyservice;
import com.IT.*;
import com.IT.DTO.Compnay_Dto;


@RestController
public class CompanyController {
	

	@Autowired
	private Companyservice service;

	
	
	
	@PostMapping("/add-comp")
	public Company addcom(@RequestBody Company co) throws Exception
	{
		
		return service.saveCompany(co);
	}
	
	
	@GetMapping("/getbyid/{id}")
	public Company getre2(@PathVariable(name="id") int id) throws Exception
	{
		return service.getre(id);
	}
	
	@GetMapping("/get-all")
	public List<Company> getal()
	{
 return service.getall();
		
	}
	
	
}
