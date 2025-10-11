package com.vishnu.hospital.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.hospital.dto.UserDto;
import com.vishnu.hospital.enums.Role;
import com.vishnu.hospital.payload.RegistrationRequest;
import com.vishnu.hospital.payload.RegistrationResponse;
import com.vishnu.hospital.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<RegistrationResponse> signup(@Validated @RequestBody RegistrationRequest request, @RequestParam("role") Set<Role> role){
		RegistrationResponse response = userService.signup(request, role);
	    return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/profile")
	public ResponseEntity<UserDto> getProfileDetails(){
		UserDto user = userService.getUserDetails();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
