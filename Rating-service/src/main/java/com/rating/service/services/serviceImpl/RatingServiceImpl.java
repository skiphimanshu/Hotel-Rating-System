package com.rating.service.services.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.entities.Rating;
import com.rating.service.repository.RatingRepository;
import com.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		
		String randomId = UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		
		return this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUserId(String uId) {
		
		return this.ratingRepository.findByuserId(uId);
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hId) {
		
		return this.ratingRepository.findByhotelId(hId);
	}

}
