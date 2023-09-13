package com.it.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = InvalidNameException.class)
	public ErrorInfo InvalidNameExc() {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_GATEWAY.toString(),"Invalid Name Entered by user");
		return info;
	}
}
