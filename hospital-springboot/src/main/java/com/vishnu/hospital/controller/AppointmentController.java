package com.vishnu.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.hospital.dto.AppointmentDto;
import com.vishnu.hospital.service.AppointmentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "8. Appointment")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	
	@Autowired
	public AppointmentService appointmentService;
	
	@PreAuthorize("hasRole('ADMIN','PATIENT')")
	@PostMapping()
	public ResponseEntity<AppointmentDto> createAppointment(@Valid @RequestBody AppointmentDto dto){
		AppointmentDto appointment = appointmentService.createAppointment(dto);
		return new ResponseEntity<>(appointment,HttpStatus.CREATED);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable int id){
		AppointmentDto appointment = appointmentService.getAppointmentById(id);
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping()
	public ResponseEntity<List<AppointmentDto>> getAllAppointments(){
		List<AppointmentDto> appointment = appointmentService.getAllAppointments();
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<AppointmentDto> updateAppointment(@Valid @RequestBody AppointmentDto dto, @PathVariable int id){
		AppointmentDto appointment = appointmentService.updateAppointment(id, dto);
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable int id) {
		String response = appointmentService.deleteAppointment(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
