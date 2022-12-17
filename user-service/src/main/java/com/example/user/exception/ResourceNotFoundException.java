package com.example.user.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	
	// You can add extra properties 

	public ResourceNotFoundException() {

		super("Resource Not Found Exception !!");
	}

	public ResourceNotFoundException(String msg) {

		super(msg);
	}

}
