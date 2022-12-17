package com.example.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.example.user.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		 ApiResponse response = ApiResponse.builder().
		 message(message).success(true).status(org.springframework.http.HttpStatus.NOT_FOUND).build();
		 
		 
		 return new ResponseEntity<ApiResponse>(response,org.springframework.http.HttpStatus.NOT_FOUND);
	}

}
