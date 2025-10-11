package com.vishnu.hospital.service;

import java.util.List;

import com.vishnu.hospital.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto createDepartment(DepartmentDto dto);
	DepartmentDto getDepartmentById(int id);
	List<DepartmentDto> getAllDepartments();
	DepartmentDto updateDepartment(int id, DepartmentDto dto);
	String deleteDepartment(int id);

}
