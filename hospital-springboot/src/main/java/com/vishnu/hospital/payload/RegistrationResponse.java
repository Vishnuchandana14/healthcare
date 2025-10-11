 package com.vishnu.hospital.payload;

public class RegistrationResponse {
	
	 private int id;
	 private String name;
	 private String email;
	 private String mobileNumber;
	 
	 
	public RegistrationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RegistrationResponse(int id, String name, String email, String mobileNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}


	public int getId() {
		return id;
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


	public void setId(int i) {
		this.id = i;
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
	 
	 

}
