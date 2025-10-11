package com.vishnu.hospital.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@NotBlank(message="Doctor name is required")
	public String name;
	
	@NotBlank(message="Specialization is required")
	public String specialization;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits and start with 6-9")
	@NotBlank(message = "Phone number is required")
	public String phoneNumber;
	
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	public String email;
	
	public int expYears;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	public List<Appointment> appointments;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	public Department department;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int id, String name, String specialization, String phoneNumber, String email, int expYears,
			List<Appointment> appointments, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.expYears = expYears;
		this.appointments = appointments;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public int getExpYears() {
		return expYears;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public Department getDepartment() {
		return department;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExpYears(int expYears) {
		this.expYears = expYears;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
