package com.project.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Entity.User;
import com.project.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/add-user")
	public User addUser(@RequestBody User user ) {
		return service.addUser(user);
	}
	
}
