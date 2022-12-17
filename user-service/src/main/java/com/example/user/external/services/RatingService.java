package com.example.user.external.services;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.user.entities.Rating;


@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ratings")
	Rating getRating();
	
}
