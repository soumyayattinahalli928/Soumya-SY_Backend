package com.excel.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.demo.commonresponse.CommanResponse;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<CommanResponse<String>> employeeNotFound(RuntimeException exp){
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommanResponse.<String>builder().data(null)
						.isError(true).message(exp.getMessage()).build());
	}
}
