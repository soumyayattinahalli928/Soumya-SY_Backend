package com.excel.lms.dto.employeeprimaryinfodto;

import java.time.LocalDate;

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
public class EmployeePrimaryInfoDto {

	private Integer employeePrimaryId;
	private String employeeId;
	private String employeeName;
	private LocalDate dateOfJoining;
	private LocalDate dateOfBirth;
	private String email;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String employeeStatus;
}
