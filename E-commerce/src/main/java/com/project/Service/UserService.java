package com.project.Service;

import org.springframework.stereotype.Service;

import com.project.Entity.User;
import com.project.Repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	
	
	
	
}
