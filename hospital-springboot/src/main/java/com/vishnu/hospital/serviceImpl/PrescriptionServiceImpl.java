package com.vishnu.hospital.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.PrescribedMedicineDto;
import com.vishnu.hospital.dto.PrescriptionDto;
import com.vishnu.hospital.entity.Doctor;
import com.vishnu.hospital.entity.Medicine;
import com.vishnu.hospital.entity.Patient;
import com.vishnu.hospital.entity.PrescribedMedicine;
import com.vishnu.hospital.entity.Prescription;
import com.vishnu.hospital.exceptions.InvalidRequestException;
import com.vishnu.hospital.exceptions.ResourceNotFoundException;
import com.vishnu.hospital.repository.DoctorRepository;
import com.vishnu.hospital.repository.MedicineRepository;
import com.vishnu.hospital.repository.PatientRepository;
import com.vishnu.hospital.repository.PrescriptionRepository;
import com.vishnu.hospital.service.MedicineService;
import com.vishnu.hospital.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PrescriptionDto createPrescription(PrescriptionDto dto) {
	    Patient patient = patientRepository.findById(dto.getPatientId())
	        .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + dto.getPatientId()));

	    Doctor doctor = doctorRepository.findById(dto.getDoctorId())
	        .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + dto.getDoctorId()));

	    Prescription prescription = new Prescription();
	    prescription.setDate(LocalDate.now());
	    prescription.setDiagnosis(dto.getDiagnosis());
	    prescription.setNotes(dto.getNotes());
	    prescription.setPatient(patient);
	    prescription.setDoctor(doctor);

	    List<PrescribedMedicine> prescribedMedicines = new ArrayList<>();

	    for (PrescribedMedicineDto medDto : dto.getMedicines()) {
	        Medicine medicine = medicineRepository.findByNameIgnoreCase(medDto.getMedicineName())
	            .orElseThrow(() -> new ResourceNotFoundException("Medicine not found: " + medDto.getMedicineName()));

	        if (medicine.getQuantityInStock() < medDto.getQuantity()) {
	            throw new InvalidRequestException("Not enough stock for medicine: " + medicine.getName());
	        }

	        medicine.setQuantityInStock(medicine.getQuantityInStock() - medDto.getQuantity());
	        medicineRepository.save(medicine);

	        PrescribedMedicine prescribed = new PrescribedMedicine();
	        prescribed.setMedicine(medicine);
	        prescribed.setPrescription(prescription);
	        prescribed.setQuantity(medDto.getQuantity());
	        prescribed.setDosage(medDto.getDosage());
	        prescribed.setFrequency(medDto.getFrequency());
	        prescribed.setDurationDays(medDto.getDurationDays());

	        prescribedMedicines.add(prescribed);
	    }

	    prescription.setMedicines(prescribedMedicines);

	    Prescription saved = prescriptionRepository.save(prescription);
	    return modelMapper.map(saved, PrescriptionDto.class);
	}


	@Override
	public PrescriptionDto getPrescriptionById(int id) {
		Prescription prescription = prescriptionRepository.findById(id)
				                                          .orElseThrow(()-> new ResourceNotFoundException("Prescription not found with id" + id));
		return modelMapper.map(prescription, PrescriptionDto.class);
	}

	@Override
	public List<PrescriptionDto> getPrescriptionByPatientId(int patientId) {
		return prescriptionRepository.findByPatientId(patientId).stream()
				                                                .map(p -> modelMapper.map(p, PrescriptionDto.class))
				                                                .collect(Collectors.toList());
 	}

	@Override
	public List<PrescriptionDto> getPrescriptionByDoctorId(int doctorId) {
		return prescriptionRepository.findByDoctorId(doctorId).stream()
                                                              .map(p -> modelMapper.map(p, PrescriptionDto.class))
                                                              .collect(Collectors.toList());

	}

	@Override
	public String deletePrescription(int id) {
		 if (prescriptionRepository.existsById(id)) {
			 prescriptionRepository.deleteById(id);
	            return "Prescription has been deleted from the record";
	       } else {
	            return "Prescription with ID " + id + " does not exist";
	       }
	}

}
