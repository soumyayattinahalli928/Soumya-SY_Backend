package com.excel.lms.entity;

import java.time.LocalDate;

import com.excel.lms.dto.technicalskillsdto.TechnicalSkillsDto;
import com.excel.lms.enums.EmployeeStatus;
import com.excel.lms.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class EmployeePrimaryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeePrimaryId;
	private String employeeId;
	private String employeeName;
	private LocalDate dateOfJoining;
	private LocalDate dateOfBirth;
	private String email;
	private String bloodGroup;
	private String designation;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String nationality;
	
	@Enumerated(EnumType.STRING)
	private EmployeeStatus employeeStatus;
	
}
