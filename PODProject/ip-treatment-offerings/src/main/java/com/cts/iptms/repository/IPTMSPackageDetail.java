package com.cts.iptms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.iptms.model.IPTreatmentPackages;

@Repository
public interface IPTMSPackageDetail extends JpaRepository<IPTreatmentPackages, Long> {

	@Query(value=" from IPTreatmentPackages p where p.packageDetail.treatmentPackageName=:packageName and p.ailmentCategory=:category")
	IPTreatmentPackages findByName(@Param("packageName") String packageName, String category);
}
