package com.vishnu.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishnu.hospital.entity.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer>{

}
