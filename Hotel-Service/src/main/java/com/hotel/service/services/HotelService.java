package com.hotel.service.services;

import java.util.List;

import com.hotel.service.entities.Hotel;
import com.hotel.service.entities.Rating;

public interface HotelService {
	
	// create Hotel
	
	Hotel saveHotel(Hotel hotel);
	
	
	//Get all Hotel
	
	List<Hotel> getAllHotel();
	
	
	// Get Single hotel
	
	
	Hotel getSingleHotel(String id);
	
	
	//Get Hotel Rating
	
	List<Rating> getRatingByHid(String hId);

}
