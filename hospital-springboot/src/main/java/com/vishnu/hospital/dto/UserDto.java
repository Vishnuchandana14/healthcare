package com.vishnu.hospital.dto;

import java.util.Set;

import com.vishnu.hospital.enums.Role;

public class UserDto {
	
	private Long id;
	private String username;
	private String password;
	private Set<Role> role;
	private String email;
	private String mobileNumber;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(Long id, String username, String password, Set<Role> role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	
}
