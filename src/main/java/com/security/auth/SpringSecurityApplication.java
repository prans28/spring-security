package com.security.auth;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.security.auth.entity.Users;
import com.security.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@SpringBootApplication
public class SpringSecurityApplication {
      
	
	private final UserRepository repository; 

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
    @PostConstruct
	public void initUser() {
		List<Users> users =
		Stream.of(new Users(1, "pranav", "kumar", "prans7590"), new Users(2, "kumar", "singh", "kumar1234")).collect(Collectors.toList());
	    
		repository.saveAll(users);
	
	}

}
