package com.vishnu.hospital.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.DoctorDto;
import com.vishnu.hospital.entity.Department;
import com.vishnu.hospital.entity.Doctor;
import com.vishnu.hospital.exceptions.DuplicateResourceException;
import com.vishnu.hospital.exceptions.ResourceNotFoundException;
import com.vishnu.hospital.repository.DepartmentRepository;
import com.vishnu.hospital.repository.DoctorRepository;
import com.vishnu.hospital.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DoctorDto createDoctor(DoctorDto dto) {
		Doctor doctor = modelMapper.map(dto, Doctor.class);
		Department department = departmentRepository.findById(dto.getDepartmentId())
				                                    .orElseThrow(()-> new ResourceNotFoundException("Department not found with id" + dto.getDepartmentId()));
		doctor.setDepartment(department);
		try {
			doctorRepository.save(doctor);
		} catch(DataIntegrityViolationException e) {
			throw new DuplicateResourceException("Doctor with same email or phone already exists!");
		}
		return modelMapper.map(doctor, DoctorDto.class);
	}

	@Override
	public DoctorDto getDoctorById(int id) {
		Doctor doctor = doctorRepository.findById(id)
		                                .orElseThrow(()-> new ResourceNotFoundException("Doctor Not found with id" + id));
		return modelMapper.map(doctor, DoctorDto.class);
	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		return doctorRepository.findAll().stream()
		                          .map(p -> modelMapper.map(p, DoctorDto.class))
		                          .collect(Collectors.toList());
		
	}

	@Override
	public DoctorDto updateDoctor(int id, DoctorDto dto) {
		Doctor doctor = modelMapper.map(dto, Doctor.class);
//		doctorRepository.findById(id)
//		                .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id" + id));
		Department department = departmentRepository.findById(dto.getDepartmentId())
                                                    .orElseThrow(()-> new ResourceNotFoundException("Department not found with id" + id));
        doctor.setDepartment(department);
		doctorRepository.save(doctor);
		return modelMapper.map(doctor, DoctorDto.class);
	}

	@Override
	public String deleteDoctor(int id) {
		
		if (doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
            return "doctor has been deleted from the record";
       } else {
            return "doctor with ID " + id + " does not exist";
       }
	}

}
