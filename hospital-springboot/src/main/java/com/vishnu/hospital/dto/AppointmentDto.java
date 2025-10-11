package com.vishnu.hospital.dto;

import java.time.LocalDate;

public class AppointmentDto {
	
    public int id;
	public LocalDate appointmentDate;
	public String status;
	public String remarks;
	public int patientId;
	public int doctorId;
	
	public AppointmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppointmentDto(int id, LocalDate appointmentDate, String status, String remarks, int patientId,
			int doctorId) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.status = status;
		this.remarks = remarks;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}

	public int getId() {
		return id;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getPatientId() {
		return patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
}
