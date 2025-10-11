package com.vishnu.hospital.exceptions;

public class AppointmentConflictException extends RuntimeException{
	public AppointmentConflictException(String message) {
		super(message);
	}

}
