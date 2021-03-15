package com.cognizant.iptm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Treatment Plan not Found")
public class TreatmentPlanNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
