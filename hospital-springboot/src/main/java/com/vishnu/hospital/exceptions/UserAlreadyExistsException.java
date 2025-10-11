package com.vishnu.hospital.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
	
	public UserAlreadyExistsException(String message) {
		
		super(message);
		
	}

}
