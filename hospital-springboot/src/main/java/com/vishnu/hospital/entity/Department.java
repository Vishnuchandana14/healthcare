package com.vishnu.hospital.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@NotBlank(message="Department name is required")
	public String name;
	
	@Size(max = 200, message = "Description cannot exceed 200 characters")
	public String description;

	@OneToMany(mappedBy="department", cascade = CascadeType.ALL)
	public List<Doctor> doctors;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String name, String description, List<Doctor> doctors) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.doctors = doctors;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	

}
