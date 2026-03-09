package com.Banking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Banking.Entity.BankEntity;
import com.Banking.Repository.BankRepository;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired 
	private BankRepository repo;
	
	@PostMapping("/add-bank")
	public BankEntity addBank(@RequestBody BankEntity bank)
	{
		return repo.save(bank);
	}
	
	 @GetMapping("/get")
	 public List<BankEntity>getBanks()
	 {
		
		 return repo.findAll();
	 }
}
