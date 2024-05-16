package com.excel.lms.entity;

import com.excel.lms.dto.technicalskillsdto.TechnicalSkillsDto;
import com.excel.lms.enums.AccountType;

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
public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankId;
	private Long accountNo;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	private String branch;
	private String bankName;
	private String ifscCode;
	private String state;
}
