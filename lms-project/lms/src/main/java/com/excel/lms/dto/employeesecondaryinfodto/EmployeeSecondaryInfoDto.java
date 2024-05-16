package com.excel.lms.dto.employeesecondaryinfodto;

import com.excel.lms.dto.technicalskillsdto.TechnicalSkillsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSecondaryInfoDto {

	private Integer employeeSecondaryId;
	private String panNo;
	private String aadharNo;
	private String fatherName;
	private String motherName;
	private String spouseNo;
	private String passportNo;
	private String maritalStatus;
}
