package com.vishnu.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.hospital.dto.MedicineDto;
import com.vishnu.hospital.service.MedicineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	@PostMapping()
	public ResponseEntity<MedicineDto> addMedicine(@Valid @RequestBody MedicineDto dto){
		MedicineDto medicine = medicineService.addMedicine(dto);
		return new ResponseEntity<>(medicine, HttpStatus.CREATED);
	}
	
	@PutMapping("/{name}/update-stock")
	public ResponseEntity<MedicineDto> updateStock(@PathVariable String name, @RequestParam int quantity){
		MedicineDto medicine = medicineService.updateStock(name, quantity);
		return new ResponseEntity<>(medicine, HttpStatus.OK);	
	}
	
	@GetMapping()
	public ResponseEntity<List<MedicineDto>> getAllMedicines(){
		List<MedicineDto> medicines = medicineService.getAllMedicines();
		return new ResponseEntity<>(medicines, HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<MedicineDto> getMedicineByName(@PathVariable String name){
		MedicineDto medicine = medicineService.getMedicineByName(name);
		return new ResponseEntity<>(medicine, HttpStatus.OK);
 	}
	
	@GetMapping("/expired")
	public ResponseEntity<List<MedicineDto>> getExpiredMedicines(){
		List<MedicineDto> medicine = medicineService.getExpiredMedicines();
		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}

}
