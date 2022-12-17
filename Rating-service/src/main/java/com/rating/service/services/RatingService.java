package com.rating.service.services;

import java.util.List;

import com.rating.service.entities.Rating;

public interface RatingService {
	
	// create rating
	
	
	Rating createRating(Rating rating);
	
	
	
	// get rating 
	
	List<Rating> getAllRatings();
	
	
	//get all by user id
	
	List<Rating> getAllRatingsByUserId(String uId);
	
	// get all by hotel id
	
	List<Rating> getAllRatingsByHotelId(String hId);

}
