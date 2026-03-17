package com.IT.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.IT.Entity.Company;
import com.IT.Entity.Employee;

public class Compnay_Dto {
	
	String companyname;
	String companyemail;
	List<EmployeeDto> list;


	
	public String getCompanyname() {
		return companyname;
	}

	

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}


	public String getCompanyemail() {
		return companyemail;
	}

	

	public void setCompanyemail(String companyemail) {
		this.companyemail = companyemail;
	}


	public List<EmployeeDto> getList() {
		return list;
	}


	public void setList(List<EmployeeDto> list) {
		this.list = list;
	}
	
	

}

class EmployeeDto
{
	String ename;
	String eemail;
	
}

class Converter_I
{
	
	public static Compnay_Dto convert(Company company)
	{
		     
		Compnay_Dto dto=new Compnay_Dto();
		
		 dto.setCompanyemail(company.getCompanyemail());
		 dto.setCompanyname(company.getCompanyname());
		  List<EmployeeDto>  empd=company.getEmployees().stream()
		       .map((e)->{
		    	   EmployeeDto dt=new EmployeeDto();
		    	   dt.eemail=e.getEemail();
		    	   dt.ename=e.getEname();
		    	   return dt;
		       }).collect(Collectors.toList());
		  
		  return dto;
	}
}

