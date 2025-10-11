package com.vishnu.hospital.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.entity.User;
import com.vishnu.hospital.payload.LoginRequest;
import com.vishnu.hospital.payload.LoginResponse;
import com.vishnu.hospital.service.AuthService;
import com.vishnu.hospital.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;

	@Override
	public LoginResponse login(LoginRequest request) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmailOrMobileNumber(), request.getPassword()));
		User user = (User) authenticate.getPrincipal();
		String token = jwtService.generateToken(user);
		LoginResponse response = new LoginResponse();
		response.setType("JWT");
		response.setToken(token);
		return response;
	}

}
