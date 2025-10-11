package com.vishnu.hospital.service;

import java.util.List;

import com.vishnu.hospital.dto.AppointmentDto;

public interface AppointmentService {
	
	AppointmentDto createAppointment(AppointmentDto dto);
	AppointmentDto getAppointmentById(int id);
	List<AppointmentDto> getAllAppointments();
	AppointmentDto updateAppointment(int id, AppointmentDto dto);
	String deleteAppointment(int id);

}
