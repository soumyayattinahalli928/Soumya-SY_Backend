package com.excel.lms.util;

import java.util.ArrayList;

import com.excel.lms.dto.BankDetailsDto;
import com.excel.lms.dto.EducationDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.TechnicalSkillsDto;
import com.excel.lms.entity.BankDetails;
import com.excel.lms.entity.EducationDetails;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.TechnicalSkills;
import com.excel.lms.enums.AccountType;

public class EmployeeUtil {

	public static EmployeePrimaryInfo dtoToEntity(EmployeePrimaryInfoDto dto) {
		return EmployeePrimaryInfo.builder()
				.employeeId(dto.getEmployeeId())
//				.employeePrimaryId(dto.getEmployeePrimaryId())
				.employeeName(dto.getEmployeeName())
				.bloodGroup(dto.getBloodGroup())
				.email(dto.getEmail())
				.nationality(dto.getNationality())
				.dateOfBirth(dto.getDateOfBirth())
				.dateOfJoining(dto.getDateOfJoining())
				.gender(dto.getGender())
				.employeeStatus(dto.getEmployeeStatus())
				.designation(dto.getDesignation())
				.build();
	}
	

	public static EmployeeSecondaryInfo dtoToEntity(EmployeeSecondaryInfoDto dto) {
		return EmployeeSecondaryInfo.builder().panNo(dto.getPanNo())
				.aadharNo(dto.getAadharNo()).motherName(dto.getMotherName())
				.fatherName(dto.getFatherName()).passportNo(dto.getPassportNo())
				.spouseName(dto.getSpouseName()).maritalStatus(dto.getMaritalStatus()).build();
	}

	
	public static BankDetails dtoToEntity(BankDetailsDto dto) {
		return BankDetails.builder().accountNo(dto.getAccountNo())
				.accountType(dto.getAccountType())
				.branch(dto.getBranch()).bankName(dto.getBankName())
				.ifscCode(dto.getIfscCode()).state(dto.getState()).build();
	}
	
//	public static EducationDetails dtoToEducation(EducationDetailsDto dto) {
//		return EducationDetails.builder().stream()
//				.map(edu -> EducationDetails.builder().yearOfPassing(edu.getYearOfPassing())
//						.educationType(edu.getEducationType())
//						.instituteName(edu.getInstituteName())
//						.percentage(edu.getPercentage())
//						.universityName(edu.getUniversityName())
//						.state(edu.getState())
//						.specialization(edu.getSpecialization())
//						.build()).toList();
//	}
	
	public static TechnicalSkills dtoToSkillEntity(TechnicalSkillsDto dto) {
		return TechnicalSkills.builder().skillType(dto.getSkillType())
				.skillRatings(dto.getSkillRatings())
				.yearOfExperience(dto.getYearOfExperience()).employeePrimaryInfo(new ArrayList<>()).build();
	}
}
