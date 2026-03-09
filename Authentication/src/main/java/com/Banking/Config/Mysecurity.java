package com.Banking.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class Mysecurity {
	
	@Autowired
	private UserDetailService userd;
	
	@Bean
	public SecurityFilterChain mySecure(HttpSecurity http) { 
		return  http.csrf((i)->{i.disable();})
				.authorizeHttpRequests((req)->{
					req.requestMatchers(HttpMethod.POST).permitAll()
					.requestMatchers(HttpMethod.GET).hasAnyAuthority("ADMIN","USER")
					.anyRequest().authenticated();
				}).httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	public DaoAuthenticationProvider myAuth() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userd);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(11));
		return provider;
	}
}
