package com.security.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.auth.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUserName(String username);


}
