package com.example.user.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.entities.Hotel;
import com.example.user.entities.Rating;
import com.example.user.entities.User;
import com.example.user.exception.ResourceNotFoundException;
import com.example.user.external.services.HotelService;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RestTemplate  restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		
		String randomUid = UUID.randomUUID().toString();
		user.setUserId(randomUid);
		return this.userRepository.save(user); 
	}

	@Override
	public List<User> getAllUser() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		
		User user = this.userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User with particular id not found "+userId));
		
		//fetch the rating with particular id 
		//http://localhost:8598/rating/get-ratings-user/{id}
		
		Rating[] userRatings = restTemplate.getForObject("http://API-GATEWAY/rating/get-ratings-user/"+user.getUserId(),Rating[].class);
		logger.info("{}",userRatings);
		
		List<Rating> ratings = Arrays.stream(userRatings).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			
			// api call to hotl service
			//http://localhost:8597/hotel/get-hotel/13d777b9-041c-43e4-af1f-00c2a53ffdb6
			
			//Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/get-hotel/"+rating.getHotelId(), Hotel.class);
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
				
			// Set the hotel to rating
			rating.setHotel(hotel);
			
			// return ratring
			
			return rating;
			
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);		
		return user;
	}

	@Override
	public Rating createRatingwithUid(String userId,Rating rating) {
		
		rating.setUserId(userId);
		
		Hotel hotel = hotelService.getHotel(rating.getHotelId());
		logger.info(hotel.toString());
		rating.setHotel(hotel);
		
		Rating postForObject = restTemplate.postForObject("http://RATING-SERVICE/rating/create-rating", rating,Rating.class);
		
		return postForObject;
	}

}
