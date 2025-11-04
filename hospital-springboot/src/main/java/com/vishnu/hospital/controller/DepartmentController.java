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

import com.vishnu.hospital.dto.DepartmentDto;
import com.vishnu.hospital.service.DepartmentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "6. Departments")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping()
	public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto dto){
		DepartmentDto department = departmentService.createDepartment(dto);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable int id){
		DepartmentDto dto = departmentService.getDepartmentById(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping()
	public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
		List<DepartmentDto> dto = departmentService.getAllDepartments();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable int id, @Valid @RequestBody DepartmentDto dto){
		DepartmentDto department = departmentService.updateDepartment(id, dto);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int id){
		String response = departmentService.deleteDepartment(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
