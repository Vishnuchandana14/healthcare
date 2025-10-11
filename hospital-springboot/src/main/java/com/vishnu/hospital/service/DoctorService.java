package com.vishnu.hospital.service;

import java.util.List;

import com.vishnu.hospital.dto.DoctorDto;

public interface DoctorService {
	
	DoctorDto createDoctor(DoctorDto dto);
	DoctorDto getDoctorById(int id);
	List<DoctorDto> getAllDoctors();
	DoctorDto updateDoctor(int id, DoctorDto dto);
	String deleteDoctor(int id);
	

}
