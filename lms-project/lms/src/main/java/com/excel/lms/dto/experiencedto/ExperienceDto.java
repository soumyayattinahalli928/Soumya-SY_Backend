package com.excel.lms.dto.experiencedto;

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
public class ExperienceDto {

	private Integer experienceId;
	private String companyName;
	private Integer yearOfExperience;
	private LocalDate dateOfJoining;
	private LocalDate dataOfRelieving;
	private String designation;
	private String location;
}
