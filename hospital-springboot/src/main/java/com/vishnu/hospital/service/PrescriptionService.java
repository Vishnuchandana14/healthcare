package com.vishnu.hospital.service;

import java.util.List;

import com.vishnu.hospital.dto.PrescriptionDto;

public interface PrescriptionService {
	
	PrescriptionDto createPrescription(PrescriptionDto dto);
	PrescriptionDto getPrescriptionById(int id);
	List<PrescriptionDto> getPrescriptionByPatientId(int patientId);
	List<PrescriptionDto> getPrescriptionByDoctorId(int doctorId);
	String deletePrescription(int id);

}
