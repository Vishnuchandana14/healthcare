package com.vishnu.hospital.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vishnu.hospital.dto.PatientDto;

public interface PatientService {
	
	PatientDto createPatient(PatientDto dto);
	PatientDto getPatientById(int id);
	List<PatientDto> getAllPatients();
	PatientDto updatePatient(int id, PatientDto dto);
	String deletePatient(int id);
	
	PatientDto dischargePatient(int id, LocalDate dischargeDate);
	
	

}
