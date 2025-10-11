package com.vishnu.hospital.service;

import com.vishnu.hospital.dto.MedicineDto;
import com.vishnu.hospital.dto.PrescribedMedicineDto;

import java.util.List;

public interface MedicineService {

    MedicineDto addMedicine(MedicineDto dto);

    MedicineDto updateStock(String name, int quantity);

    List<MedicineDto> getAllMedicines();

    MedicineDto getMedicineByName(String name);

    List<MedicineDto> getExpiredMedicines();

    void deductStock(PrescribedMedicineDto medicineDto, int quantity);
}
