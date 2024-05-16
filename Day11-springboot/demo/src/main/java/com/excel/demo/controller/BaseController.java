package com.excel.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excel.demo.commonresponse.CommanResponse;
import com.excel.demo.constant.EmployeeConstant;
import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.service.EmployeeService;

@RestController
public class BaseController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public ResponseEntity<String> homeGetReq(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello");
	}
	
//	@PostMapping("/home/{str}")
//	public ResponseEntity<String> homePostReq(@PathVariable String str){
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(str);
//	}
//	
//	@PutMapping("/put/{str}")
//	public ResponseEntity<String> homePutReq(@PathVariable String str){
//		return ResponseEntity.status(HttpStatus.OK).body("hii");
//	}
//	
//	@DeleteMapping("/delete")
//	public ResponseEntity<String> homeDeleteReq(){
//		return ResponseEntity.status(HttpStatus.OK).body("deleted");
//	}
	
	@PostMapping("/add")
	public ResponseEntity<CommanResponse<EmployeeDto>> addEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto dto = employeeService.addEmployee(employeeDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommanResponse.<EmployeeDto>builder().data(dto)
				.isError(false).message(EmployeeConstant.EMPLOYEE_ADDED_MESSAGE).build());
	}
	
	@DeleteMapping("/delete")
	public void deleteEmployee(@RequestBody EmployeeDto dto){
		employeeService.deleteEmployee(dto);
		ResponseEntity.ok(EmployeeConstant.EMPLOYEE_ID_NOT_FOUND);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<EmployeeDto>> fetchAllEmployees(){
		
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto){
		
		EmployeeDto updatedEmployee = employeeService.updateEmployee(dto);
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDto> getByEmployeeId(@PathVariable Integer id){
		EmployeeDto employeeDto = employeeService.getByEmployeeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
	}
	
	
}
