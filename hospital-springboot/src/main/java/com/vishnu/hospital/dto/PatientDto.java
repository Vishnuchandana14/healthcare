package com.vishnu.hospital.dto;

import java.time.LocalDate;

public class PatientDto {
	
	public String name;
	public int age;
	public String gender;
	public String address;
	public String phoneNumber;
	public String email;
	public String bloodGroup;
	public String disease;	
	public LocalDate admissionDate;
	public LocalDate dischargeDate;
	public int roomId;
	
	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientDto(String name, int age, String gender, String address, String phoneNumber, String email,
			String bloodGroup, String disease, LocalDate admissionDate, LocalDate dischargeDate, int roomId) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.bloodGroup = bloodGroup;
		this.disease = disease;
		this.admissionDate = admissionDate;
		this.dischargeDate = dischargeDate;
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public String getDisease() {
		return disease;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public LocalDate getDischargeDate() {
		return dischargeDate;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public void setDischargeDate(LocalDate dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	
	

}
