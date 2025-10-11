package com.vishnu.hospital.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@NotBlank(message="Patient name is required")
	@Size(min = 2, max = 50, message = "Name must be between 2-50 characters")
	public String name;
	
	@Min(value = 0, message = "Age cannot be negative")
	@Max(value = 120, message = "Age cannot exceed 120 years")
	public int age;
	
	@NotBlank(message="Gender is required")
	public String gender;
	
	@NotBlank(message="Address is required")
	public String address;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits and start with 6-9")
	@NotBlank(message = "Phone number is required")
	public String phoneNumber;
	
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	public String email;
	
	@NotBlank(message = "Blood group is required")
	public String bloodGroup;
	
	@NotBlank(message = "Disease is required")
	public String disease;	
	
	@NotNull(message = "Admission date is required")
	public LocalDate admissionDate;
	
	public LocalDate dischargeDate;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	public List<Appointment> appointments;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	public List<Billing> billings;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	public Room room;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int id, String name, int age, String gender, String address, String phoneNumber, String email,
			String bloodGroup, String disease, LocalDate admissionDate, LocalDate dischargeDate,
			List<Appointment> appointments, List<Billing> billings, Room room) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.bloodGroup = bloodGroup;
		this.disease = disease;
		this.admissionDate = admissionDate;
		this.dischargeDate = dischargeDate;
		this.appointments = appointments;
		this.billings = billings;
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public String getDisease() {
		return disease;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public LocalDate getDischargeDate() {
		return dischargeDate;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public List<Billing> getBillings() {
		return billings;
	}

	public Room getRoom() {
		return room;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public void setDischargeDate(LocalDate dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void setBillings(List<Billing> billings) {
		this.billings = billings;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}


