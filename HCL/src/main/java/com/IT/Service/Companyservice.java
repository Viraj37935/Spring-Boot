package com.IT.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IT.Entity.Company;
import com.IT.Exceptions.InvalidCompanyIdException;
import com.IT.Repository.CompanyRepo;

@Service
public class Companyservice {
	
	@Autowired
	private CompanyRepo repo;
	
	
	public Company saveCompany(Company comp) throws Exception
	{
		if( !comp.getCompanyemail().endsWith("@gmail.com"))
		{
			throw new Exception("Chukla re tu !");
		}
		
	  else if(comp.getCompanyname().isBlank())
			
		{
			throw new Exception("name rikama asu shakat nhi !");
		}
		return repo.save(comp);
				
}
	
	
	
	public Company getre(int id) throws Exception
	{
		if(Integer.valueOf(id)==null || id<0 )
			
		{
			throw new InvalidCompanyIdException();
		}
		
		return 
		  
		repo.findById(id).get();
	}
	
	public List<Company>  getall()
	{
	 return	repo.findAll();
	}

}