package com.cognizant.iptm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.iptm.model.TreatmentPlan;

public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Long> {

}
