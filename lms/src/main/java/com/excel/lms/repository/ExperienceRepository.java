package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer>{

}
