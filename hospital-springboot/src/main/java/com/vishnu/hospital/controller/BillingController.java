package com.vishnu.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.hospital.dto.BillingDto;
import com.vishnu.hospital.service.BillingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bills")
public class BillingController {
	
	@Autowired
	public BillingService billingService;
	
	@PostMapping()
	public ResponseEntity<BillingDto> generateBill(@Valid @RequestBody BillingDto dto){
		BillingDto billing = billingService.generateBill(dto);
		return new ResponseEntity<>(billing, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BillingDto> getBillById(@PathVariable int id){
		BillingDto billing = billingService.getBillById(id);
		return new ResponseEntity<>(billing, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<BillingDto>> getAllBills(){
		List<BillingDto> bills = billingService.getAllBills();
		return new ResponseEntity<>(bills, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable int id){
		String response = billingService.deleteBill(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
