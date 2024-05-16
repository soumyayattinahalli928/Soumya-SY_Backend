package com.excel.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.excel.demo.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto addEmployee(EmployeeDto dto);
	
	public void deleteEmployee(EmployeeDto dto);

	public  List<EmployeeDto>  getAllEmployees();

	public EmployeeDto updateEmployee(EmployeeDto dto);

	public EmployeeDto getByEmployeeId(Integer id);
}
