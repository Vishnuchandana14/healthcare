package com.vishnu.hospital.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegistrationRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Enter valid email")
    private String email;

    @NotBlank(message = "Mobile Number is mandatory")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password should be greater than 6 character")
    private String password;


	public RegistrationRequest(@NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Email is mandatory") @Email(message = "Enter valid email") String email,
			@NotBlank(message = "Mobile Number is mandatory") @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter 10 digits") String mobileNumber,
			@NotBlank(message = "Password is mandatory") @Size(min = 6, message = "Password should be greater than 6 character") String password) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	public RegistrationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    

}
