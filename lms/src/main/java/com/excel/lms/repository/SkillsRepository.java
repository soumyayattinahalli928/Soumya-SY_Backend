package com.excel.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.TechnicalSkills;

public interface SkillsRepository extends JpaRepository<TechnicalSkills, Integer>{
	
	Optional<TechnicalSkills> findBySkillTypeAndSkillRatingsAndYearOfExperience(String skillType, String skillRatings, Integer yearOfExperience);

}
