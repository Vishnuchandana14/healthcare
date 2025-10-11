package com.vishnu.hospital.dto;

public class RoomDto {
	
	public int id;
	public String roomNo;
	public String type;
	public String status;
	public int patientId;
	
	public RoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDto(int id, String roomNo, String type, String status, int patientId) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.type = type;
		this.status = status;
		this.patientId = patientId;
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

	public int getPatientId() {
		return patientId;
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

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	

}
