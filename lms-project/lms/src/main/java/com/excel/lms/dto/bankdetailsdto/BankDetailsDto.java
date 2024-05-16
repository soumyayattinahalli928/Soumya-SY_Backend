package com.excel.lms.dto.bankdetailsdto;

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
public class BankDetailsDto {

	private Integer id;
	private Long accountNo;
	private String accountType;
	private String branch;
	private String bankName;
	private String ifscCode;
	private String state;
}
