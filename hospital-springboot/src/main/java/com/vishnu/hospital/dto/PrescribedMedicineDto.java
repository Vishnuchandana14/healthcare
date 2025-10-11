package com.vishnu.hospital.dto;

public class PrescribedMedicineDto {
	
	private int id;
	private String medicineName;
	private int quantity;
	private String dosage;
	private String frequency;
	private int durationDays;
	
	public PrescribedMedicineDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrescribedMedicineDto(int id, String medicineName, int quantity, String dosage, String frequency,
			int durationDays) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.dosage = dosage;
		this.frequency = frequency;
		this.durationDays = durationDays;
	}

	public int getId() {
		return id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDosage() {
		return dosage;
	}

	public String getFrequency() {
		return frequency;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}
	
	

}
