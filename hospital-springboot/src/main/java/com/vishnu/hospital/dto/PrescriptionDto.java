package com.vishnu.hospital.dto;

import java.time.LocalDate;
import java.util.List;

public class PrescriptionDto {
	
	private int id;
	private LocalDate date;
	private String diagnosis;
	private List<PrescribedMedicineDto> medicines;
	private String notes;
	private int patientId;
	private int doctorId;
	
	public PrescriptionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PrescriptionDto(int id, LocalDate date, String diagnosis, List<PrescribedMedicineDto> medicines,
			String notes, int patientId, int doctorId) {
		super();
		this.id = id;
		this.date = date;
		this.diagnosis = diagnosis;
		this.medicines = medicines;
		this.notes = notes;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}

	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public List<PrescribedMedicineDto> getMedicines() {
		return medicines;
	}

	public String getNotes() {
		return notes;
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

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public void setMedicines(List<PrescribedMedicineDto> medicines) {
		this.medicines = medicines;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	
}
