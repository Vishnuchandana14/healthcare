package com.vishnu.hospital.serviceImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.BillingDto;
import com.vishnu.hospital.entity.Billing;
import com.vishnu.hospital.entity.Patient;
import com.vishnu.hospital.entity.Room;
import com.vishnu.hospital.exceptions.InvalidRequestException;
import com.vishnu.hospital.exceptions.ResourceNotFoundException;
import com.vishnu.hospital.repository.BillingRepository;
import com.vishnu.hospital.repository.PatientRepository;
import com.vishnu.hospital.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService{
	
	@Autowired
	public BillingRepository billingRepository;
	
	@Autowired
	public PatientRepository patientRepository;
	
	@Autowired
	public ModelMapper modelMapper;

	@Override
	public BillingDto generateBill(BillingDto dto) {
		Patient patient = patientRepository.findById(dto.getPatientId())
				                           .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id" + dto.getPatientId()));
        Billing billing = new Billing();
        billing.setPaymentDate(LocalDate.now());
        
        if(patient.getAdmissionDate() == null || patient.getDischargeDate() == null) {
        	throw new InvalidRequestException("Patient must be discharged before generating bill!");
        }
        
        long daysStayed = ChronoUnit.DAYS.between(patient.getAdmissionDate(), patient.getDischargeDate());
        
        if(daysStayed == 0) {
        	daysStayed = 1;
        }
        
        double roomChargePerDay = 0;
        Room room = patient.getRoom();
        
        if(room != null) {
        	switch(room.getType().toLowerCase()) {
        	case "icu": 
        		roomChargePerDay = 5000;
        	    break;
        	case "private": 
        		roomChargePerDay = 3000;
        		break;
        	default:
        		roomChargePerDay = 2000;
        		break;
            }
        }
        
        double totalRoomCharges = daysStayed * roomChargePerDay;
        
        billing.setPaidAmount(0.0);
        billing.setRoomCharges(totalRoomCharges);
        billing.setDoctorCharges(dto.doctorCharges);
        billing.setDoctorCharges(dto.getOtherCharges());
        billing.setTotalAmount(totalRoomCharges + dto.getDoctorCharges() + dto.getOtherCharges());
        billing.setPatient(patient);
        
		return modelMapper.map(billingRepository.save(billing), BillingDto.class);
	}

	@Override
	public BillingDto getBillById(int id) {
		Billing billing = billingRepository.findById(id)
				                           .orElseThrow(()-> new ResourceNotFoundException("Bill not found"));
		
		return modelMapper.map(billing, BillingDto.class);
	}

	@Override
	public List<BillingDto> getAllBills() {
		return billingRepository.findAll().stream()
				                          .map(p -> modelMapper.map(p, BillingDto.class))
				                          .collect(Collectors.toList());
		
	}

	@Override
	public String deleteBill(int id) {
		if (billingRepository.existsById(id)) {
			billingRepository.deleteById(id);
            return "Billing has been deleted from the record";
       } else {
            return "Billing with ID " + id + " does not exist";
       }
	}

}
