package com.vishnu.hospital.service;

import com.vishnu.hospital.payload.LoginRequest;
import com.vishnu.hospital.payload.LoginResponse;

public interface AuthService {
	
	LoginResponse login(LoginRequest request);

}
