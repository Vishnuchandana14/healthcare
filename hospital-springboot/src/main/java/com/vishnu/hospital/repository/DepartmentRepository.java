package com.vishnu.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishnu.hospital.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
