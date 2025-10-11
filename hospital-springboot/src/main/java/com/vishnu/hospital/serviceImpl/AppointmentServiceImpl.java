package com.vishnu.hospital.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.AppointmentDto;
import com.vishnu.hospital.entity.Appointment;
import com.vishnu.hospital.entity.Doctor;
import com.vishnu.hospital.entity.Patient;
import com.vishnu.hospital.exceptions.ResourceNotFoundException;
import com.vishnu.hospital.repository.AppointmentRepository;
import com.vishnu.hospital.repository.DoctorRepository;
import com.vishnu.hospital.repository.PatientRepository;
import com.vishnu.hospital.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public AppointmentRepository appointmentRepository;
	
	@Autowired
	public DoctorRepository doctorRepository;
	
	@Autowired
	public PatientRepository patientRepository;

	@Override
	public AppointmentDto createAppointment(AppointmentDto dto) {
		Appointment appointment = modelMapper.map(dto, Appointment.class);
		
		Patient patient = patientRepository.findById(dto.getPatientId())
				                           .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id" + dto.getPatientId()));
	    appointment.setPatient(patient);
		
		Doctor doctor = doctorRepository.findById(dto.getDoctorId())
				                        .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id" + dto.getDoctorId()));
		
		appointment.setDoctor(doctor);
		return modelMapper.map(appointmentRepository.save(appointment), AppointmentDto.class);
	}

	@Override
	public AppointmentDto getAppointmentById(int id) {
		Appointment appointment = appointmentRepository.findById(id)
				                                       .orElseThrow(()-> new ResourceNotFoundException("Appointment not found with id" + id));
		return modelMapper.map(appointment, AppointmentDto.class);
	}

	@Override
	public List<AppointmentDto> getAllAppointments() {
		return appointmentRepository.findAll().stream()
		                               .map(p-> modelMapper.map(p, AppointmentDto.class))
		                               .collect(Collectors.toList());
		
	}

	@Override
	public AppointmentDto updateAppointment(int id, AppointmentDto dto) {
		Appointment appointment = appointmentRepository.findById(id)
				                                       .orElseThrow(()-> new ResourceNotFoundException("Appointment not found with id" + id));
		//modelMapper.map(dto, appointment);

       appointment.setAppointmentDate(dto.getAppointmentDate());
       appointment.setStatus(dto.getStatus());
       appointment.setRemarks(dto.getRemarks());

		
		Patient patient = patientRepository.findById(dto.getPatientId())
				                           .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id" + dto.getPatientId()));
		appointment.setPatient(patient);
		
		Doctor doctor = doctorRepository.findById(dto.getDoctorId())
				                        .orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id" + dto.getDoctorId()));
		appointment.setDoctor(doctor);
		return modelMapper.map(appointmentRepository.save(appointment), AppointmentDto.class);
	}
    
	@Override
	public String deleteAppointment(int id) {
		if (appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
            return "Appointment has been deleted from the record";
       } else {
            return "appointment with ID " + id + " does not exist";
       }
	}
	   
      

}
