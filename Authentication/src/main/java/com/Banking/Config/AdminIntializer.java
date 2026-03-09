package com.Banking.Config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Banking.Entity.UserEntity;
import com.Banking.Repository.UserRepository;

public class AdminIntializer implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;
	
	
	@Override
	public void run(String... args) throws Exception {
		List<UserEntity> users=repo.findAll();
		
		if(users.size()==0)
		{
			System.out.println("NO ADMIN FOUND...! ADDING THE DEFAULT ONE...!");
			UserEntity user=new UserEntity();
			user.setPassword(new BCryptPasswordEncoder(11).encode("ADMIN@123"));
			user.setName("ADMIN USER");
			user.setRoles(Arrays.asList("ADMIN","USER","SUPER_ADMIN"));
			System.out.println("ADMIN ADDED WITH NAME: "+ user.getName());
			
			repo.save(user);
		}
		else {
			
			List<List<String>> list = users.stream().map((i)->(i.getRoles())).collect(Collectors.toList());
			
			List<String> list2=list.stream().flatMap((i)->(i.stream())).collect(Collectors.toList());
			
			if(list2.contains("ADMIN"))
			{
				System.out.println("ADMIN already there....! no need to add !");
			}
			else 
			{
				System.out.println("NO ADMIN FOUND...! ADDING THE DEFAULT ONE...!");
				UserEntity user = new UserEntity();
				user.setPassword(new BCryptPasswordEncoder(11).encode("ADMIN@123"));
				user.setName("ADMIN USER");
				user.setRoles(Arrays.asList("ADMIN","USER","SUPER_ADMIN"));
				System.out.println("ADMIN ADDED WITH NAME: "+user.getName());
				
				repo.save(user);
			}
		}
	}

}
