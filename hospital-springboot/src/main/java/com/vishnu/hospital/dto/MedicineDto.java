package com.vishnu.hospital.dto;

import java.time.LocalDate;

public class MedicineDto {

    private int id;
    private String name;
    private String manufacturer;
    private int quantityInStock;
    private double pricePerUnit;
    private LocalDate expiryDate;
    private String batchNumber;
	public MedicineDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicineDto(int id, String name, String manufacturer, int quantityInStock, double pricePerUnit,
			LocalDate expiryDate, String batchNumber) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantityInStock = quantityInStock;
		this.pricePerUnit = pricePerUnit;
		this.expiryDate = expiryDate;
		this.batchNumber = batchNumber;
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

    
}