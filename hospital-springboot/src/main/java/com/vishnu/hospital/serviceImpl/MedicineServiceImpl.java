package com.vishnu.hospital.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.dto.MedicineDto;
import com.vishnu.hospital.dto.PrescribedMedicineDto;
import com.vishnu.hospital.entity.Medicine;
import com.vishnu.hospital.exceptions.DuplicateResourceException;
import com.vishnu.hospital.exceptions.InvalidRequestException;
import com.vishnu.hospital.exceptions.ResourceNotFoundException;
import com.vishnu.hospital.repository.MedicineRepository;
import com.vishnu.hospital.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MedicineDto addMedicine(MedicineDto dto) {
        if (medicineRepository.findByNameIgnoreCase(dto.getName()).isPresent()) {
            throw new DuplicateResourceException("Medicine already exists: " + dto.getName());
        }
        Medicine medicine = modelMapper.map(dto, Medicine.class);
        Medicine saved = medicineRepository.save(medicine);
        return modelMapper.map(saved, MedicineDto.class);
    }

    @Override
    public MedicineDto updateStock(String name, int quantity) {
        Medicine medicine = medicineRepository.findByNameIgnoreCase(name)
            .orElseThrow(() -> new ResourceNotFoundException("Medicine not found: " + name));

        medicine.setQuantityInStock(medicine.getQuantityInStock() + quantity);
        Medicine updated = medicineRepository.save(medicine);
        return modelMapper.map(updated, MedicineDto.class);
    }

    @Override
    public List<MedicineDto> getAllMedicines() {
        return medicineRepository.findAll()
            .stream()
            .map(med -> modelMapper.map(med, MedicineDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public MedicineDto getMedicineByName(String name) {
        Medicine medicine = medicineRepository.findByNameIgnoreCase(name)
            .orElseThrow(() -> new ResourceNotFoundException("Medicine not found: " + name));

        return modelMapper.map(medicine, MedicineDto.class);
    }

    @Override
    public List<MedicineDto> getExpiredMedicines() {
        return medicineRepository.findByExpiryDateBefore(LocalDate.now())
            .stream()
            .map(med -> modelMapper.map(med, MedicineDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public void deductStock(PrescribedMedicineDto medicineDto, int quantity) {
        Medicine medicine = medicineRepository.findByNameIgnoreCase(medicineDto.getMedicineName())
            .orElseThrow(() -> new ResourceNotFoundException("Medicine not found: " + medicineDto.getMedicineName()));

        if (medicine.getQuantityInStock() < quantity) {
            throw new InvalidRequestException("Not enough stock for medicine: " + medicineDto.getMedicineName());
        }

        medicine.setQuantityInStock(medicine.getQuantityInStock() - quantity);
        medicineRepository.save(medicine);
    }
}