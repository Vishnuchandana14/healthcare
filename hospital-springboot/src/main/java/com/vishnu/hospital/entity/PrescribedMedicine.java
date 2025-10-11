package com.vishnu.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prescribed_medicines")
public class PrescribedMedicine {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @ManyToOne
	    @JoinColumn(name = "prescription_id", nullable = false)
	    private Prescription prescription;

	    @ManyToOne
	    @JoinColumn(name = "medicine_id", nullable = false)
	    private Medicine medicine;

	    @Column(nullable = false)
	    private int quantity;
	    
	    private String dosage;
	    private String frequency;
	    private int durationDays;
	    
		public PrescribedMedicine() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PrescribedMedicine(int id, Prescription prescription, Medicine medicine, int quantity, String dosage,
				String frequency, int durationDays) {
			super();
			this.id = id;
			this.prescription = prescription;
			this.medicine = medicine;
			this.quantity = quantity;
			this.dosage = dosage;
			this.frequency = frequency;
			this.durationDays = durationDays;
		}

		public int getId() {
			return id;
		}

		public Prescription getPrescription() {
			return prescription;
		}

		public Medicine getMedicine() {
			return medicine;
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

		public void setPrescription(Prescription prescription) {
			this.prescription = prescription;
		}

		public void setMedicine(Medicine medicine) {
			this.medicine = medicine;
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
