package com.vishnu.hospital.service;

import java.util.Set;


import com.vishnu.hospital.dto.UserDto;
import com.vishnu.hospital.entity.User;
import com.vishnu.hospital.enums.Role;
import com.vishnu.hospital.payload.RegistrationRequest;
import com.vishnu.hospital.payload.RegistrationResponse;

public interface UserService {
	
	RegistrationResponse signup(RegistrationRequest request, Set<Role> role);

	
	User getUserById(Long userId);
//
//    UserDto getUserDetails();

}
