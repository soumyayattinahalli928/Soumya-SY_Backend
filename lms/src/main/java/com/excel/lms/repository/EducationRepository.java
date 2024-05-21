package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EducationDetails;
import com.excel.lms.entity.EmployeePrimaryInfo;

public interface EducationRepository extends JpaRepository<EducationDetails, Integer>{

	
}
