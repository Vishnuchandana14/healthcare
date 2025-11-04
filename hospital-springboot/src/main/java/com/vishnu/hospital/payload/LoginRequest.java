package com.vishnu.hospital.payload;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequest(@NotBlank(message = "username is mandatory") String username,
			@NotBlank(message = "Password is mandatory") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPassword(String password) {
        this.password = password;
    }

	public String getUsername() {
		return username;
	}


}
