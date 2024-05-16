package com.excel.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.excel.demo.constant.EmployeeConstant;
import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.exception.EmployeeExceptionHandler;
import com.excel.demo.exception.EmployeeNotFound;
import com.excel.demo.repository.EmployeeRepository;
import com.excel.demo.util.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
		
		Employee employee = Employee.builder().firstName(dto.getFirstName())
					.lastName(dto.getLastName()).mobileNo(dto.getMobileNo())
					.panNo(dto.getPanNo()).adharNo(dto.getAdharNo()).empNo(dto.getEmpNo()).build();
	
		Employee save = employeeRepository.save(employee);
		
		return EmployeeUtils.entityToDto(employee); //code re-usability
		 
	}

	@Override
	public void deleteEmployee(EmployeeDto dto) {
		
		Optional<Employee> optional = employeeRepository.findById(dto.getId());
	
		if(optional.isPresent()) {
			employeeRepository.delete(optional.get());
		}
		else {
			throw new EmployeeNotFound(EmployeeConstant.EMPLOYEE_ID_NOT_FOUND);
		}
	
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		return employeeRepository.findAll().stream()
			.map(e -> EmployeeDto.builder().id(e.getId()).firstName(e.getFirstName()).lastName(e.getLastName())
				.mobileNo(e.getMobileNo()).panNo(e.getPanNo())
				.adharNo(e.getAdharNo()).empNo(e.getEmpNo()).build()).toList();
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto) {

		try {
			
			 Optional<Employee> optional = employeeRepository.findById(dto.getId());
				
			 if(optional.isPresent()) {
				 Employee employee = optional.get();
				 Employee updateValues = EmployeeUtils.updateValues(employee, dto);
				 Employee save = employeeRepository.save(updateValues);
				
			 }
			 throw new EmployeeNotFound("Employee Not Found with ID " + dto.getId());
		}catch(EmployeeNotFound e) {
			throw e;
		}catch(Exception e) {
			throw new EmployeeNotFound("Something went wrong while updating employee id");
		}
		 
	}

	@Override
	public EmployeeDto getByEmployeeId(Integer id) {
		
		try {
			
			Optional<Employee> optional = employeeRepository.findById(id);
			
			if(optional.isPresent()) {
				Employee employee = optional.get();
				
				return EmployeeUtils.entityToDto(employee);
			}
			throw new EmployeeNotFound("Employee Not Found with ID " + id);
		}catch(EmployeeNotFound e) {
			throw e;
		}catch(Exception e) {
			throw new EmployeeNotFound("Something went wrong while fetching employee id");
		}
		
	}
	
	

	
}
