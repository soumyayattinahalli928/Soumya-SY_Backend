package com.excel.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.lms.dto.BankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.ListOfAddressDetailsDto;
import com.excel.lms.dto.ListOfContactDto;
import com.excel.lms.dto.ListOfEducationDetailsDto;
import com.excel.lms.dto.ListOfExperienceDto;
import com.excel.lms.dto.ListOfTechnicalSkillsDto;
import com.excel.lms.dto.TechnicalSkillsDto;
import com.excel.lms.entity.AddressDetails;
import com.excel.lms.entity.BankDetails;
import com.excel.lms.entity.Contact;
import com.excel.lms.entity.EducationDetails;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.Experience;
import com.excel.lms.entity.TechnicalSkills;
import com.excel.lms.exception.EmployeeExistenceException;
import com.excel.lms.repository.AddressRepository;
import com.excel.lms.repository.ContactRepository;
import com.excel.lms.repository.EducationRepository;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.repository.ExperienceRepository;
import com.excel.lms.repository.SecondaryRepository;
import com.excel.lms.repository.SkillsRepository;
import com.excel.lms.util.EmployeeUtil;

@Service
public class EmployeeRegisterService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private SecondaryRepository secondaryRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private EducationRepository educationRepository;
	@Autowired
	private ExperienceRepository experienceRepository;
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private SkillsRepository skillsRepository;

	public Integer savePrimaryInfo(EmployeePrimaryInfoDto dto) {

		if (!employeeRepository.findByEmployeeId(dto.getEmployeeId()).isPresent()) {
			EmployeePrimaryInfo employee1 = EmployeeUtil.dtoToEntity(dto);
			EmployeePrimaryInfo save = employeeRepository.save(employee1);
			return save.getEmployeePrimaryId();
		}

		throw new EmployeeExistenceException("Check EmployeeId entered");
	}

	public String saveSecondaryInfo(EmployeeSecondaryInfoDto dto) {

		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
			if (employeePrimaryInfo.getEmployeeSecondaryInfo() == null) {

				EmployeeSecondaryInfo employeeSecondaryInfo = EmployeeUtil.dtoToEntity(dto);
				employeePrimaryInfo.setEmployeeSecondaryInfo(employeeSecondaryInfo);
				employeeSecondaryInfo.setEmployeePrimaryInfo(employeePrimaryInfo);

				return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
			} else {
				EmployeeSecondaryInfo employeeSecondaryInfo = employeePrimaryInfo.getEmployeeSecondaryInfo();
				employeeSecondaryInfo.setPanNo(dto.getPanNo());
				employeeSecondaryInfo.setAadharNo(dto.getAadharNo());
				employeeSecondaryInfo.setFatherName(dto.getFatherName());
				employeeSecondaryInfo.setMotherName(dto.getMotherName());
				employeeSecondaryInfo.setMaritalStatus(dto.getMaritalStatus());
				employeeSecondaryInfo.setPassportNo(dto.getPassportNo());
				employeeSecondaryInfo.setSpouseName(dto.getSpouseName());
			}
		}
		throw new EmployeeExistenceException("Employee Not Registered..Please Register First");

	}

	public String saveBankDetails(BankDetailsDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
			if (employeePrimaryInfo.getBankDetails() == null) {
				BankDetails bankDetails = EmployeeUtil.dtoToEntity(dto);
				employeePrimaryInfo.setBankDetails(bankDetails);
				bankDetails.setEmployeePrimaryInfo(employeePrimaryInfo);

				return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
			} else {
				BankDetails bankDetails = employeePrimaryInfo.getBankDetails();
				bankDetails.setAccountNo(dto.getAccountNo());
				bankDetails.setAccountType(dto.getAccountType());
				bankDetails.setBankName(dto.getBankName());
				bankDetails.setBranch(dto.getBranch());
				bankDetails.setIfscCode(dto.getIfscCode());
				bankDetails.setState(dto.getState());

				return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
			}

		}
		throw new EmployeeExistenceException("Employee not registered!! Please register first");
	}

	public String saveEducationDetails(ListOfEducationDetailsDto dto) {

		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();

			List<EducationDetails> educations = dto.getEducationDetails().stream()
					.map(edu -> EducationDetails.builder().yearOfPassing(edu.getYearOfPassing())
							.educationType(edu.getEducationType()).instituteName(edu.getInstituteName())
							.percentage(edu.getPercentage()).universityName(edu.getUniversityName())
							.state(edu.getState()).specialization(edu.getSpecialization()).build())
					.collect(Collectors.toList());

			if (employeePrimaryInfo.getEducationdDetails() != null) {

				employeePrimaryInfo.getEducationdDetails().stream().forEach(educationRepository::delete);
				employeePrimaryInfo.setEducationdDetails(null);
			}

			employeePrimaryInfo.setEducationdDetails(educations);
			educations.stream().forEach(edu -> edu.setEmployeePrimaryInfo(employeePrimaryInfo));
			return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
		}
		throw new EmployeeExistenceException("Employee not registered!! Please register first");

	}

	public String saveAddressDetails(ListOfAddressDetailsDto dto) {

		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();

			List<AddressDetails> addresses = dto.getAddressDtos().stream()
					.map(edu -> AddressDetails.builder().addressType(edu.getAddressType()).doorNo(edu.getDoorNo())
							.city(edu.getCity()).state(edu.getState()).street(edu.getStreet())
							.locality(edu.getLocality()).landMark(edu.getLandMark()).pinCode(edu.getPinCode()).build())
					.collect(Collectors.toList());

			employeePrimaryInfo.setAddressDetails(addresses);
			addresses.stream().forEach(edu -> edu.setEmployeePrimaryInfo(employeePrimaryInfo));
			return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
		}
		throw new EmployeeExistenceException("Employee not registered!! Please register first");
	}

	public String saveExperience(ListOfExperienceDto dto) {

		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();

			List<Experience> experiences = dto.getExperiences().stream()
					.map(edu -> Experience.builder().companyName(edu.getCompanyName())
							.dateOfJoining(edu.getDateOfJoining()).designation(edu.getDesignation())
							.dataOfRelieving(edu.getDataOfRelieving()).yearOfExperience(edu.getYearOfExperience())
							.location(edu.getLocation()).build())
					.collect(Collectors.toList());

			employeePrimaryInfo.setExperiences(experiences);
			experiences.stream().forEach(edu -> edu.setEmployeePrimaryInfo(employeePrimaryInfo));
			return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
		}
		throw new EmployeeExistenceException("Employee not registered!! Please register first");
	}

	public String saveContact(ListOfContactDto dto) {

		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();

			List<Contact> contacts = dto.getContacts().stream().map(
					edu -> Contact.builder().contactType(edu.getContactType()).contactNo(edu.getContactNo()).build())
					.collect(Collectors.toList());

			employeePrimaryInfo.setContacts(contacts);
			contacts.stream().forEach(edu -> edu.setEmployeePrimaryInfo(employeePrimaryInfo));
			return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
		}
		throw new EmployeeExistenceException("Employee not registered!! Please register first");
	}

//	public String saveTechnicalSkills(ListOfTechnicalSkillsDto dto) {
//		
//		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
//		if(optional.isPresent()) {
//			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
//			
//			List<TechnicalSkills> skills = dto.getTechnicalSkills().stream()
//					.map(edu -> TechnicalSkills.builder().skillType(edu.getSkillType())
//							.skillRatings(edu.getSkillRatings())
//							.yearOfExperience(edu.getYearOfExperience())
//							.employeePrimaryInfo(new ArrayList<>())
//							.build()).collect(Collectors.toList());
//		
//			employeePrimaryInfo.setTechnicalSkills(skills);
//			skills.stream().forEach(edu -> edu.getEmployeePrimaryInfo().add(employeePrimaryInfo));
//			return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
//		}
//		throw new EmployeeExistenceException("Employee not registered!! Please register first");
//		
//	
//	}

	public String saveTechnicalSkills(ListOfTechnicalSkillsDto dto) {

		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
			List<TechnicalSkills> skills = dto.getTechnicalSkills().stream().map(edu -> {
				Optional<TechnicalSkills> optional1 = skillsRepository
						.findBySkillTypeAndSkillRatingsAndYearOfExperience(edu.getSkillType(), edu.getSkillRatings(),
								edu.getYearOfExperience());

				return optional1.isPresent() ? optional1.get() : EmployeeUtil.dtoToSkillEntity(edu);
			}).collect(Collectors.toList());

			if (employeePrimaryInfo.getTechnicalSkills() != null) {
				employeePrimaryInfo.getTechnicalSkills().clear();
			}

			skills.stream().forEach(x -> {
				if (!x.getEmployeePrimaryInfo().contains(employeePrimaryInfo))
					x.getEmployeePrimaryInfo().add(employeePrimaryInfo);
			});

			employeePrimaryInfo.setTechnicalSkills(skills);
			return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
		}
		return null;

	}

}
