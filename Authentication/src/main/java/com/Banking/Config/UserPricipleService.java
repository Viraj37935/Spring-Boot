package com.Banking.Config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Banking.Entity.UserEntity;


public class UserPricipleService implements UserDetails {
	
		private UserEntity user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<SimpleGrantedAuthority> list = user.getRoles().stream()
				 .map((roles)->(new SimpleGrantedAuthority(roles))).collect(Collectors.toList());
		 return list;
	}

	@Override
	public @Nullable String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	public UserPricipleService(UserEntity user) {
		super();
		this.user = user;
	}
	
	

}
