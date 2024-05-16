package com.excel.lms.entity;

import java.time.LocalDate;

import com.excel.lms.dto.technicalskillsdto.TechnicalSkillsDto;
import com.excel.lms.enums.ContactType;

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
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactId;

	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	
	private Long contactNo;
	
}
