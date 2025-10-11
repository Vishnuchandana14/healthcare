package com.vishnu.hospital.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishnu.hospital.dto.PrescribedMedicineDto;
import com.vishnu.hospital.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{
	
	Optional<Medicine> findByNameIgnoreCase(String name);
	List<Medicine> findByExpiryDateBefore(LocalDate date);

}
