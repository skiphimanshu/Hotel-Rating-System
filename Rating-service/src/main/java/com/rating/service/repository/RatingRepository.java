package com.rating.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.service.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	
	
	// custom finder Method
	
	
	// Find ratings by user id
	List<Rating> findByuserId(String userId);
	
	// Find ratings by hotel Id

	List<Rating> findByhotelId(String hotelId);
}
