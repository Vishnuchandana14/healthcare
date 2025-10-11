package com.vishnu.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotBlank(message = "Diagnosis is required")
    private String diagnosis;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrescribedMedicine> medicines = new ArrayList<>();

    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public List<PrescribedMedicine> getMedicines() {
		return medicines;
	}

	public String getNotes() {
		return notes;
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

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public void setMedicines(List<PrescribedMedicine> medicines) {
		this.medicines = medicines;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prescription(int id, @NotNull(message = "Date is required") LocalDate date,
			@NotBlank(message = "Diagnosis is required") String diagnosis, List<PrescribedMedicine> medicines,
			@Size(max = 500, message = "Notes cannot exceed 500 characters") String notes, Patient patient,
			Doctor doctor) {
		super();
		this.id = id;
		this.date = date;
		this.diagnosis = diagnosis;
		this.medicines = medicines;
		this.notes = notes;
		this.patient = patient;
		this.doctor = doctor;
	}

    
}