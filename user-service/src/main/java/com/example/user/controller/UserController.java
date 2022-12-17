package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entities.Rating;
import com.example.user.entities.User;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	// create user
	
	@PostMapping("/save-user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		 User saveUser = userService.saveUser(user);
		 return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	// get single user get
	
	@GetMapping("/get-user/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable("id")String id) {
		
		User user = userService.getUserById(id);
		
		return ResponseEntity.ok(user);
		
	}
	// All user get
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
		
		List<User> allUser = userService.getAllUser();
		
		return ResponseEntity.ok(allUser);
	}
	
	@PostMapping("/create-rating/{id}")
	public ResponseEntity<Rating>createRatring(@PathVariable("id") String uid,@RequestBody Rating rating) {
		Rating createRatingwithUid = this.userService.createRatingwithUid(uid, rating);
		return ResponseEntity.ok(createRatingwithUid);
		
	}	
	
}
