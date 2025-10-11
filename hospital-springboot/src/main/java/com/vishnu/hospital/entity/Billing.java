package com.vishnu.hospital.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="billings")
public class Billing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Positive(message = "Total amount must be greater than zero.")
	public double totalAmount;
	
	public double roomCharges;
	public double doctorCharges;
	public double otherCharges;
	
	@NotNull(message = "Billing date is required")
	public LocalDate paymentDate;
	
	@Column(nullable = false)
	private double paidAmount;
	
	public Billing(int id, double totalAmount, double roomCharges, double doctorCharges, double otherCharges,
			LocalDate paymentDate, double paidAmount, Patient patient) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
		this.roomCharges = roomCharges;
		this.doctorCharges = doctorCharges;
		this.otherCharges = otherCharges;
		this.paymentDate = paymentDate;
		this.paidAmount = paidAmount;
		this.patient = patient;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	@ManyToOne
	@JoinColumn(name = "patient_id")
	public Patient patient;

	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public double getRoomCharges() {
		return roomCharges;
	}

	public double getDoctorCharges() {
		return doctorCharges;
	}

	public double getOtherCharges() {
		return otherCharges;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setRoomCharges(double roomCharges) {
		this.roomCharges = roomCharges;
	}

	public void setDoctorCharges(double doctorCharges) {
		this.doctorCharges = doctorCharges;
	}

	public void setOtherCharges(double otherCharges) {
		this.otherCharges = otherCharges;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
}
