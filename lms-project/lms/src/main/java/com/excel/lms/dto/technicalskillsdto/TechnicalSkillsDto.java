package com.excel.lms.dto.technicalskillsdto;

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
public class TechnicalSkillsDto {

	private Integer skillId;
	private String skillType;
	private Integer yearOfExperience;
	private String skillRatings;
}
