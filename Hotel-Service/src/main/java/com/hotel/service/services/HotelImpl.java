package com.hotel.service.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel.service.entities.Hotel;
import com.hotel.service.entities.Rating;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepository;

@Service
public class HotelImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public Hotel saveHotel(Hotel hotel) {
		
		String randomId = UUID.randomUUID().toString();
		hotel.setId(randomId);
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel getSingleHotel(String id) {

		return this.hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with Particular Not Found") );
	}

	@Override
	public List<Rating> getRatingByHid(String hId) {
		
		Rating[] forObject = restTemplate.getForObject("http://API-GATEWAY/rating/get-ratings-hotel/"+hId, Rating[].class);
		List<Rating> list = Arrays.stream(forObject).toList();

		return list;
	}

}
