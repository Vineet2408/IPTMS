package com.cognizant.insuranceclaimservice.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.cognizant.insuranceclaimservice.InsuranceclaimServiceApplication;
import com.cognizant.insuranceclaimservice.exception.InsurerDetailsNotFoundException;


import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;

import com.cognizant.insuranceclaimservice.repository.InitiateClaimRepository;
import com.cognizant.insuranceclaimservice.repository.InsurerDetailRepository;

@Component
public class InsuranceClaimDaoImpl implements InsuranceClaimDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceclaimServiceApplication.class);

	@Autowired
	InsurerDetailRepository insurerDetailRepository;

	@Autowired
	InitiateClaimRepository initiateClaimRepo;

	public InsuranceClaimDaoImpl() {

		LOGGER.info("Start");
		LOGGER.info("End");
	}

	public List<InsurerDetail> getAllInsurerDetail() {
		LOGGER.info("Start");
		LOGGER.info("End");
			return insurerDetailRepository.findAll();
	}

	@Override
	public InsurerDetail getInsurerByPackageName(String packageName) throws InsurerDetailsNotFoundException {
		LOGGER.info("Start");
		LOGGER.info("End");
		InsurerDetail insurerDetail=null;
	   

			insurerDetail=insurerDetailRepository.findByInsurerPackageName(packageName);
	  
	  
	   
	   if(insurerDetail==null) {
		   throw new InsurerDetailsNotFoundException("Insurer Details not found");
	   }
		return insurerDetail;

	}

	@Override
	public double initiateClaim(InitiateClaim initiateClaim) {
		LOGGER.info("Start");
		initiateClaim.setStatus("Completed");
		initiateClaimRepo.save(initiateClaim);
		double balance;
		balance = initiateClaim.getTreatmentCost() - initiateClaim.getInsurerAmountLimit();
		balance = balance < 0 ? 0 : balance;
		InitiateClaim updatedBalanceAndStatus = initiateClaimRepo.findById(initiateClaim.getId());
		updatedBalanceAndStatus.setBalance(balance);
		
		initiateClaimRepo.save(updatedBalanceAndStatus);
		LOGGER.info("End");
		return balance;

	}

	@Override
	public List<InitiateClaim> getAllInitiatedClaims(){
			return initiateClaimRepo.findAll();
	}

}
