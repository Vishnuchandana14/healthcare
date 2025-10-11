package com.vishnu.hospital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private int quantityInStock;

    @Column(nullable = false)
    private double pricePerUnit;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    private String batchNumber;

    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrescribedMedicine> prescriptions = new ArrayList<>();

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicine(int id, String name, String manufacturer, int quantityInStock, double pricePerUnit,
			LocalDate expiryDate, String batchNumber, List<PrescribedMedicine> prescriptions) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantityInStock = quantityInStock;
		this.pricePerUnit = pricePerUnit;
		this.expiryDate = expiryDate;
		this.batchNumber = batchNumber;
		this.prescriptions = prescriptions;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public List<PrescribedMedicine> getPrescriptions() {
		return prescriptions;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setPrescriptions(List<PrescribedMedicine> prescriptions) {
		this.prescriptions = prescriptions;
	}

    
}