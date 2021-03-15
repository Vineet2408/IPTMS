package com.cognizant.insuranceclaimservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.insuranceclaimservice.InsuranceclaimServiceApplication;
import com.cognizant.insuranceclaimservice.exception.InsurerDetailsNotFoundException;

import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;

import com.cognizant.insuranceclaimservice.service.InsuranceClaimService;

@RestController
@RequestMapping("/insurance-claim")
public class InsuranceClaimController {
	@Autowired
	private InsuranceClaimService insuranceClaimService;

	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceclaimServiceApplication.class);

	@GetMapping
	public List<InsurerDetail> getAllInsurerDetail() {
		LOGGER.info("START");
		LOGGER.info("END");
		return insuranceClaimService.getAllInsurerDetail();
	}

	@GetMapping("/{packageName}")
	public InsurerDetail getInsurerDetailByPackageName(@PathVariable String packageName)
			throws InsurerDetailsNotFoundException {
		LOGGER.info("START");
		LOGGER.info("END");
		
		return insuranceClaimService.getInsurerByPackageName(packageName);
	}

	@GetMapping("/initiate-claim")
	public List<InitiateClaim> getAllInitiatedClaims() {
		LOGGER.info("START");
		LOGGER.info("END");
		return insuranceClaimService.getAllInitiatedClaims();
	}

	@PostMapping
	public double initiateClaim(@RequestBody @Valid InitiateClaim initiateClaim) {
		LOGGER.info("START");
		LOGGER.info("END");
		return insuranceClaimService.initiateClaim(initiateClaim);
	}

}
