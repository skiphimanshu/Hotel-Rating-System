package com.rating.service.controller;

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

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	// create rating

	@PostMapping("/create-rating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {

		return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.createRating(rating));

	}

	// get All Ratings
	@GetMapping("/ratings")
	public ResponseEntity<List<Rating>> getAllRating() {

		return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getAllRatings());

	}

	// get All Ratings by UserId
	@GetMapping("/get-ratings-user/{uid}")
	public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable("uid") String uId) {

		return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getAllRatingsByUserId(uId));

	}
	
	// get All Ratings by UserId
	@GetMapping("/get-ratings-hotel/{hid}")
	public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable("hid") String hId) {

		return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getAllRatingsByHotelId(hId));

	}

}
