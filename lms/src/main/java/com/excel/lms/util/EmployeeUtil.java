package com.excel.lms.util;

import com.excel.lms.dto.BankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.entity.BankDetails;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.enums.AccountType;

public class EmployeeUtil {

	public static EmployeePrimaryInfo dtoToEntity(EmployeePrimaryInfoDto dto) {
		return EmployeePrimaryInfo.builder()
				.employeeId(dto.getEmployeeId())
//				.employeePrimaryId(dto.getEmployeePrimaryId())
				.employeeName(dto.getEmployeeName())
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
}
