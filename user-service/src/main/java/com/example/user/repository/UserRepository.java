package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	
	// If you want to implement any custom query

}
