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

import com.vishnu.hospital.dto.PrescriptionDto;
import com.vishnu.hospital.service.PrescriptionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/prescriptions")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@PostMapping()
	private ResponseEntity<PrescriptionDto> createPrescription(@Valid @RequestBody PrescriptionDto dto){
		PrescriptionDto prescription = prescriptionService.createPrescription(dto);
		return new ResponseEntity<>(prescription, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<PrescriptionDto> getPrescriptionById(@PathVariable int id){
		PrescriptionDto prescription = prescriptionService.getPrescriptionById(id);
		return new ResponseEntity<>(prescription, HttpStatus.OK);
	}
	
	@GetMapping("/patient/{patientId}")
	private ResponseEntity<List<PrescriptionDto>> getPrescriptionByPatientId(@PathVariable int patientId){
		List<PrescriptionDto> prescription = prescriptionService.getPrescriptionByPatientId(patientId);
		return new ResponseEntity<>(prescription, HttpStatus.OK);
	}
	
	@GetMapping("/doctor/{doctorId}")
	private ResponseEntity<List<PrescriptionDto>> getPrescriptionByDoctorId(@PathVariable int doctorId){
		List<PrescriptionDto> prescription = prescriptionService.getPrescriptionByDoctorId(doctorId);
		return new ResponseEntity<>(prescription, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> deletePrescription(@PathVariable int id){
		String response = prescriptionService.deletePrescription(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
