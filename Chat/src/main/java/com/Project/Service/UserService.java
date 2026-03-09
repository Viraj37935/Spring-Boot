package com.Project.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Project.DTO.UserDTO;
import com.Project.Entity.UserEntity;
import com.Project.Repository.UserRepository;

@Service
public class UserService {

	private UserRepository repo;
	
	public UserService (UserRepository repo) {
		this.repo=repo;
	}
	
	public UserEntity saveUser (UserDTO dto) {
		UserEntity user = new UserEntity();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		
		return repo.save(user);
		
	}
	
	public List<UserEntity> getAllUser(){
		return repo.findAll();
	}
	
	public UserEntity getUserById(Long id) {
		return repo.findById(id)
				.orElseThrow(()-> new RuntimeException("User Not Found"));
	}
	
}
