package com.cognizant.insuranceclaimservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.insuranceclaimservice.model.InsurerDetail;

public interface InsurerDetailRepository extends JpaRepository<InsurerDetail, Long> {
	<Optional>InsurerDetail findByInsurerPackageName(String insurerPackageName);
}
