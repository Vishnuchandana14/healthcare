package com.vishnu.hospital.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.PatientDto;
import com.vishnu.hospital.entity.Patient;
import com.vishnu.hospital.entity.Room;
import com.vishnu.hospital.exceptions.DuplicateResourceException;
import com.vishnu.hospital.exceptions.InvalidRequestException;
import com.vishnu.hospital.exceptions.ResourceNotFoundException;
import com.vishnu.hospital.exceptions.RoomNotAvailableException;
import com.vishnu.hospital.repository.PatientRepository;
import com.vishnu.hospital.repository.RoomRepository;
import com.vishnu.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public PatientDto createPatient(PatientDto dto) {
		Patient patient = modelMapper.map(dto, Patient.class);
		
		if(dto.getRoomId() != 0) {
			Room room = roomRepository.findById(dto.getRoomId())
					                  .orElseThrow(()-> new RoomNotAvailableException("Room was not found with id" + dto.getRoomId()));
			
			if("Occupied".equalsIgnoreCase(room.getStatus())) {
				throw new RuntimeException("Room was already occupied");
			}
			room.setStatus("occupied");
			roomRepository.save(room);
			patient.setRoom(room);
		}
		else {
           patient.setRoom(null); 
        }

		try {
			patientRepository.save(patient);
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateResourceException("Patient with same email or phone already exists!");
		}
		
		return modelMapper.map(patient, PatientDto.class);

	}

	@Override
	public PatientDto getPatientById(int id) {
	    Patient patient = patientRepository.findById(id)
	    		                           .orElseThrow(()-> new ResourceNotFoundException("Patient Not found with id" + id));
		return modelMapper.map(patient, PatientDto.class);
	}

	@Override
	public List<PatientDto> getAllPatients() {
		return patientRepository.findAll().stream()
				                          .map(p -> modelMapper.map(p, PatientDto.class))
				                          .collect(Collectors.toList());
	}

	@Override
	public PatientDto updatePatient(int id, PatientDto dto) {
		Patient patient = patientRepository.findById(id)
                                           .orElseThrow(()-> new ResourceNotFoundException("Patient Not found with id" + id));
        //modelMapper.map(dto, patient);

    patient.setName(dto.getName());
    patient.setAge(dto.getAge());
    patient.setGender(dto.getGender());
    patient.setEmail(dto.getEmail());
    patient.setPhoneNumber(dto.getPhoneNumber());
    patient.setDisease(dto.getDisease());
    patient.setAdmissionDate(dto.getAdmissionDate());
    patient.setDischargeDate(dto.getDischargeDate());
    patient.setBloodGroup(dto.getBloodGroup());
    patient.setAddress(dto.getAddress());

        
        if(dto.getRoomId() != 0) {
			Room room = roomRepository.findById(dto.getRoomId())
					                  .orElseThrow(()-> new RoomNotAvailableException("Room was not found eith id" + dto.getRoomId()));
			
			if("Occupied".equalsIgnoreCase(room.getStatus())) {
				throw new RuntimeException("Room was already occupied");
			}
			room.setStatus("occupied");
			roomRepository.save(room);
			patient.setRoom(room);
		}
        
        if(dto.getDischargeDate() != null && patient.getRoom() != null) {
        	Room room = patient.getRoom();
        	room.setStatus("Available");
        	roomRepository.save(room);
        	patient.setRoom(null);
        }

		return modelMapper.map(patientRepository.save(patient), PatientDto.class);
	}


    @Override
    public String deletePatient(int id) {
       if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return "Patient has been deleted from the record";
       } else {
            return "Patient with ID " + id + " does not exist";
       }
    }

	@Override
	public PatientDto dischargePatient(int id, LocalDate dischargeDate) {
	    Patient patient = patientRepository.findById(id)
	    		                           .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id" + id));
	    
	    if(patient.getDischargeDate() != null) {
	    	throw new InvalidRequestException("Patient is already discharged!");
	    }
	    patient.setDischargeDate(dischargeDate);
	    
	    if(patient.getRoom() != null) {
	    	Room room = patient.getRoom();
        	room.setStatus("Available");
        	roomRepository.save(room);
        	patient.setRoom(null);
	    }
		return modelMapper.map(patientRepository.save(patient), PatientDto.class);
	}

}
