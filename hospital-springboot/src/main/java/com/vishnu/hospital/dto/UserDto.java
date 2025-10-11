package com.vishnu.hospital.dto;

import com.vishnu.hospital.enums.Role;

public class UserDto {
	
	private int id;
	private String username;
	private String password;
	private Role role;
	private String email;
	private String mobileNumber;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int id, String username, String password, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
