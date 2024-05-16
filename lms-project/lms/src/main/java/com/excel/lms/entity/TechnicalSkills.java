package com.excel.lms.entity;

import java.util.List;

import com.excel.lms.dto.technicalskillsdto.TechnicalSkillsDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
public class TechnicalSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer skillId;
	private String skillType;
	private Integer yearOfExperience;
	private String skillRatings;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EmployeePrimaryInfo>  employeePrimaryInfo;
}
