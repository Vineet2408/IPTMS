package com.cognizant.insuranceclaimservice.dao;

import java.util.List;

import com.cognizant.insuranceclaimservice.exception.InsurerDetailsNotFoundException;


import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;

public interface InsuranceClaimDao {
	List <InsurerDetail> getAllInsurerDetail() ;
	
	InsurerDetail getInsurerByPackageName(String packageName) throws InsurerDetailsNotFoundException;
	
	double initiateClaim(InitiateClaim initiateClaim);
	
	List<InitiateClaim> getAllInitiatedClaims() ;

	

}
