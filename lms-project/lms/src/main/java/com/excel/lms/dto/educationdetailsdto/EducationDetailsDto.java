package com.excel.lms.dto.educationdetailsdto;

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
public class EducationDetailsDto {

	private Integer educationId;
	private String educationType;
	private String yearOfPassing;
	private String universityName;
	private String percentage;
	private String instituteName;
	private String state;
}
