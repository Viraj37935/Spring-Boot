package com.Banking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Banking.Entity.UserEntity;
import com.Banking.Repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@PostMapping("/add-user")
	public UserEntity addUser(@RequestBody UserEntity user) {
		user.getRoles().forEach(System.out::println);
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(11);
		
		UserEntity us= new UserEntity();
		us.setName(user.getName());
		us.setRoles(user.getRoles());
		us.setPassword(bcrypt.encode(user.getPassword()));
		
		System.out.println(us.getPassword());
		return repo.save(us);
		
	}
	
	@GetMapping("/get-user")
	 public List<UserEntity>getUser()
	 {
		
		 return repo.findAll();
	 }
}
