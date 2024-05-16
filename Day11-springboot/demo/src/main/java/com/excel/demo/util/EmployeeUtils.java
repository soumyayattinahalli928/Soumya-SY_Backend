package com.excel.demo.util;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;

public class EmployeeUtils {

	public static EmployeeDto entityToDto(Employee employee) {
		
		return EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName())
				.lastName(employee.getLastName()).mobileNo(employee.getMobileNo())
				.panNo(employee.getPanNo()).adharNo(employee.getAdharNo())
				.empNo(employee.getEmpNo()).build();
	 
	}
	
	public static Employee updateValues(Employee employee, EmployeeDto dto) {
		employee.setFirstName(dto.getFirstName());
		employee.setAdharNo(dto.getAdharNo());
		employee.setEmpNo(dto.getEmpNo());
		employee.setLastName(dto.getLastName());
		employee.setPanNo(dto.getPanNo());
		employee.setMobileNo(dto.getMobileNo());
		
		return  employee;
	}
}
