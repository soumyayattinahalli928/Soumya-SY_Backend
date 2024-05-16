package com.excel.lms.dto.contactdto;

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
public class ContactDto {

	private Integer contactId;
	private String contactType;
	private Long contactNo;
}
