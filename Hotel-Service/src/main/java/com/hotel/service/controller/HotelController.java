package com.hotel.service.controller;

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

import com.hotel.service.entities.Hotel;
import com.hotel.service.entities.Rating;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	// create Hotel
	
	@PostMapping("/create-hotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		
		Hotel saveHotel = this.hotelService.saveHotel(hotel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveHotel);
		
	}
	
	
	// get Single Hotel
	
	@GetMapping("/get-hotel/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id) {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(this.hotelService.getSingleHotel(id));
		
	}
	
	
	// get All Hotel
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getAllHotel() {
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(this.hotelService.getAllHotel());
	}
	
	@GetMapping("/hotel-rating/{hid}")
	public ResponseEntity<List<Rating>> getRatingsByHid(@PathVariable("hid") String hid) {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.hotelService.getRatingByHid(hid));
		
	}
	
	
	

}
