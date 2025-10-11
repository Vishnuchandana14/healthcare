package com.vishnu.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="rooms")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@NotBlank(message="Room number is required")
	public String roomNo;
	
	@NotBlank(message="Room type is required") 
	public String type;
	
	@NotBlank(message="Room status is required") 
	@Pattern(regexp = "Available|Occupied", message="Status must be available or occupied")
	public String status;
	
	@OneToOne
	@JoinColumn(name = "patient_id")
	public Patient patient;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int id, String roomNo, String type, String status, Patient patient) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.type = type;
		this.status = status;
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
}
