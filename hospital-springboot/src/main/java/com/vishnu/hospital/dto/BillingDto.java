package com.vishnu.hospital.dto;

import java.time.LocalDate;

public class BillingDto {
	
    public int id;
	public double totalAmount;
	public double roomCharges;
	public double doctorCharges;
	public double otherCharges;
	public LocalDate paymentDate;
	public int patientId;
	public double paidAmount;
	
	public BillingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public BillingDto(int id, double totalAmount, double roomCharges, double doctorCharges, double otherCharges,
			LocalDate paymentDate, int patientId, double paidAmount) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
		this.roomCharges = roomCharges;
		this.doctorCharges = doctorCharges;
		this.otherCharges = otherCharges;
		this.paymentDate = paymentDate;
		this.patientId = patientId;
		this.paidAmount = paidAmount;
	}



	public double getPaidAmount() {
		return paidAmount;
	}



	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
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

	public int getPatientId() {
		return patientId;
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

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	
	
	}

