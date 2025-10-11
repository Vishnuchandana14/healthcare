package com.vishnu.hospital.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.DepartmentDto;
import com.vishnu.hospital.entity.Department;
import com.vishnu.hospital.exceptions.DuplicateResourceException;
import com.vishnu.hospital.exceptions.ResourceNotFoundException;
import com.vishnu.hospital.repository.DepartmentRepository;
import com.vishnu.hospital.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto createDepartment(DepartmentDto dto) {
		Department department = modelMapper.map(dto, Department.class);
		try {
		    departmentRepository.save(department);
		} catch(DataIntegrityViolationException e) {
			throw new DuplicateResourceException("Department with name already exists!");
		}
		return modelMapper.map(department, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentById(int id) {
		Department department = departmentRepository.findById(id)
		                    .orElseThrow(()-> new ResourceNotFoundException("Department not found with id" + id));
		return modelMapper.map(department, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		return departmentRepository.findAll().stream()
		                              .map(p -> modelMapper.map(p, DepartmentDto.class))
		                              .collect(Collectors.toList());
		
	}

	@Override
	public DepartmentDto updateDepartment(int id, DepartmentDto dto) {
		Department department = modelMapper.map(dto, Department.class);
		departmentRepository.findById(id);
		departmentRepository.save(department);
		return modelMapper.map(department, DepartmentDto.class);
	}

	@Override
	public String deleteDepartment(int id) {
		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
            return "department has been deleted from the record";
       } else {
            return "department with ID " + id + " does not exist";
       }
	}

}
