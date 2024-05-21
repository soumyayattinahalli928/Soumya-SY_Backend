package com.excel.onlinemeeting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.onlinemeeting.response.SuccessResponse;



@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<SuccessResponse<String>> userRegisterException(RuntimeException exp){
		return ResponseEntity.status(HttpStatus.OK)
				.body(SuccessResponse.<String>builder().data(null)
						.isError(true).message(exp.getMessage()).build());
	}
}
