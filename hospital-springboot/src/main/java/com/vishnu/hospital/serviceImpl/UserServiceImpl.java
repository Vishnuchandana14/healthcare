package com.vishnu.hospital.serviceImpl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.UserDto;
import com.vishnu.hospital.entity.User;
import com.vishnu.hospital.enums.Role;
import com.vishnu.hospital.exceptions.UserAlreadyExistsException;
import com.vishnu.hospital.exceptions.UserNotExistsException;
import com.vishnu.hospital.payload.RegistrationRequest;
import com.vishnu.hospital.payload.RegistrationResponse;
import com.vishnu.hospital.repository.UserRepository;
import com.vishnu.hospital.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public RegistrationResponse signup(RegistrationRequest request, Set<Role> role) {
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException("User already exists!");
		}
		if(userRepository.findByMobileNumber(request.getMobileNumber()).isPresent()) {
			throw new UserAlreadyExistsException("User already exists!");
		}
		
		User user = new User();
		user.setUsername(request.getName());
		user.setEmail(request.getEmail());
		user.setMobileNumber(request.getMobileNumber());
		user.setRoles(role);
		user.setPassword(passwordEncoder.encode(request.getPassword()));

		
		User savedUser = userRepository.save(user);
		
		RegistrationResponse response = new RegistrationResponse();
		response.setId(savedUser.getId());
		response.setEmail(savedUser.getEmail());
		response.setMobileNumber(savedUser.getMobileNumber());
		response.setName(savedUser.getUsername());
		return response;
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
                .orElseThrow(() -> new UserNotExistsException("User not found with ID: " + id));

	}

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    return userRepository.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	 
	}
	
}


