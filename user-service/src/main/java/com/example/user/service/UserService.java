package com.example.user.service;

import java.util.List;

import com.example.user.entities.Rating;
import com.example.user.entities.User;

public interface UserService {
	
	//user Operation
	
	//Create user
	
	User saveUser(User user);
	
	
	//Get All User
	
	List<User> getAllUser();
	
	//Get single user by Id
	
	User getUserById(String userId);
	
	
	//TODO:DELETE
	
	//TODO: update

	Rating createRatingwithUid(String userId,Rating rating);
}
