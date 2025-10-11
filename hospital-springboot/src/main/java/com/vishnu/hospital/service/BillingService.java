package com.vishnu.hospital.service;

import java.util.List;

import com.vishnu.hospital.dto.BillingDto;

public interface BillingService {
	
	BillingDto generateBill(BillingDto dto);
	BillingDto getBillById(int id);
	List<BillingDto> getAllBills();
	String deleteBill(int id);

}
