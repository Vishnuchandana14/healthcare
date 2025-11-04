package com.vishnu.hospital.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.hospital.dto.PatientDto;
import com.vishnu.hospital.service.PatientService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "7. Patients")
@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto dto) {
		return new ResponseEntity<>(patientService.createPatient(dto), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN','RECEPTIONIST','DOCTOR')")
	@GetMapping("/{id}")
	public ResponseEntity<PatientDto> getPatient(@PathVariable int id) {
		return new ResponseEntity<>(patientService.getPatientById(id),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN','RECEPTIONIST','DOCTOR')")
	@GetMapping
	public ResponseEntity<List<PatientDto>> getAllPatients(){
		return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN','RECEPTIONIST')")
	@PutMapping("/{id}")
	public ResponseEntity<PatientDto> updatePatient(@PathVariable int id,@Valid @RequestBody PatientDto dto) {
		return new ResponseEntity<>(patientService.updatePatient(id, dto), HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN','RECEPTIONIST')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable int id) {
		String response = patientService.deletePatient(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	 
	}
	
	@PreAuthorize("hasRole('ADMIN','RECEPTIONIST')")
	@PutMapping("/{id}/discharge")
	public ResponseEntity<PatientDto> dischargePatient(@PathVariable int id, 
			                                           @RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate dischargeDate){
		PatientDto patient = patientService.dischargePatient(id, dischargeDate);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

}
