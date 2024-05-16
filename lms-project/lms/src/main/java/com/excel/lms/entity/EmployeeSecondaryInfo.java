package com.excel.lms.entity;

import java.time.LocalDate;

import com.excel.lms.dto.technicalskillsdto.TechnicalSkillsDto;
import com.excel.lms.enums.MaritalStatus;

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
public class EmployeeSecondaryInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeSecondaryId;
	private String panNo;
	private String aadharNo;
	private String fatherName;
	private String motherName;
	private String spouseNo;
	private String passportNo;
	
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
}
