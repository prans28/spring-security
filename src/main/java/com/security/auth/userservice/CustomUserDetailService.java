package com.security.auth.userservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.auth.entity.Users;
import com.security.auth.repository.UserRepository;
@Component
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private  UserRepository repository; 
   
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = repository.findByUserName(username);
		return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}
   
}
