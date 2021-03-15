package com.cognizant.insuranceclaimservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.insuranceclaimservice.model.InitiateClaim;


public interface InitiateClaimRepository extends JpaRepository<InitiateClaim, Long>{
	InitiateClaim findById(long id);
	

}
