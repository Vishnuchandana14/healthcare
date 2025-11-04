package com.vishnu.hospital.service;

import com.vishnu.hospital.entity.User;

public interface JwtService {
	
	String generateToken(User user);
	Long getUserIdFromToken(String token);
}
