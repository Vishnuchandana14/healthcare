package com.vishnu.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishnu.hospital.entity.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{
	
	List<Prescription> findByPatientId(int patientId);
	List<Prescription> findByDoctorId(int doctorId);

}
