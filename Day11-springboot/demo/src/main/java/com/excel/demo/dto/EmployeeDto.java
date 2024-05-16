package com.excel.demo.dto;

import com.excel.demo.entity.Employee.EmployeeBuilder;

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
public class EmployeeDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String panNo;
	private String adharNo;
	private String empNo;

}
