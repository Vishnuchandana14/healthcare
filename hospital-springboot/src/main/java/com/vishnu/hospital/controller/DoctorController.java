package com.vishnu.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.hospital.dto.DoctorDto;
import com.vishnu.hospital.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
	public ResponseEntity<DoctorDto> createDoctor(@Valid @RequestBody DoctorDto dto){
		DoctorDto doctor = doctorService.createDoctor(dto);
		return new ResponseEntity<>(doctor, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DoctorDto> getDoctorById(@PathVariable int id){
		DoctorDto dto = doctorService.getDoctorById(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<DoctorDto>> getAllDoctors(){
		List<DoctorDto> dto = doctorService.getAllDoctors();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DoctorDto> updateDoctor(@PathVariable int id,@Valid @RequestBody DoctorDto dto){
		DoctorDto doctor = doctorService.updateDoctor(id, dto);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id){
		String response = doctorService.deleteDoctor(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
