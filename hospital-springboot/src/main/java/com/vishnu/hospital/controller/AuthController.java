package com.vishnu.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.hospital.payload.LoginRequest;
import com.vishnu.hospital.payload.LoginResponse;
import com.vishnu.hospital.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping()
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
		LoginResponse response = authService.login(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
