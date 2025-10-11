package com.vishnu.hospital.dto;

public class DoctorDto {
	
	public int id;
	public String name;
	public String specialization;
	public String phoneNumber;
	public String email;
	public int expYears;
	public int departmentId;
	
	public DoctorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorDto(int id, String name, String specialization, String phoneNumber, String email, int expYears,
			int departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.expYears = expYears;
		this.departmentId = departmentId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public int getExpYears() {
		return expYears;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExpYears(int expYears) {
		this.expYears = expYears;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

}
