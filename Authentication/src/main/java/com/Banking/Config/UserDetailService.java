package com.Banking.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Banking.Entity.UserEntity;
import com.Banking.Repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = repo.getUser(username);
		
		return new UserPricipleService(user);
	}

}
