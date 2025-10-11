package com.vishnu.hospital.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@NotNull(message = "Appointment date is required")
	public LocalDate appointmentDate;
	
	public String status;
	public String remarks;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	public Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	public Doctor doctor;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int id, LocalDate appointmentDate, String status, String remarks, Patient patient,
			Doctor doctor) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.status = status;
		this.remarks = remarks;
		this.patient = patient;
		this.doctor = doctor;
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

	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
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

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
