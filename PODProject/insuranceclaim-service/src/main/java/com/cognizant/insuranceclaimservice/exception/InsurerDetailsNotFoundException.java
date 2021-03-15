package com.cognizant.insuranceclaimservice.exception;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InsurerDetailsNotFoundException extends RuntimeException {

	public InsurerDetailsNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}




