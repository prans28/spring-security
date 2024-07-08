package com.security.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.auth.entity.AuthRequest;
import com.security.auth.entity.Employee;
import com.security.auth.entity.SecurityUser;
import com.security.auth.entity.Student;
import com.security.auth.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SecurityController {

	private final JwtUtil jwtUtils;
	private final AuthenticationManager authenticationManager;

	@GetMapping("/api")
	public String m1() {
		return "hi";
	}

	@GetMapping("/get/employee")
	public ResponseEntity<Employee> getEmployee() {
		return ResponseEntity.ok(Employee.builder().name("pranav").age("22").sex("male").ids("1").phoneNo("838383883")
				.email("prans7590@gmail.com").build());

	}

	@GetMapping("/get/security-user")
	public ResponseEntity<SecurityUser> getSecurityUser() {
		return ResponseEntity.ok(SecurityUser.builder().name("pranav").age("22").sex("male").ids("1")
				.phoneNo("838383883").email("prans7590@gmail.com").build());

	}

	@GetMapping("/get/student")
	public ResponseEntity<Student> getSudent() {
		return ResponseEntity.ok(Student.builder().name("pranav").age("22").sex("male").ids("1").phoneNo("838383883")
				.email("prans7590@gmail.com").build());

	}

	@PostMapping("/authenticate")
	public String generationToken(@RequestBody AuthRequest authRequest) {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jwtUtils.generateToken(authRequest.getUserName());
	}
}
