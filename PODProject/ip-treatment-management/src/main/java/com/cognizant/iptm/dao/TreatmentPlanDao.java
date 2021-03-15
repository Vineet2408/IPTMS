package com.cognizant.iptm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.iptm.exception.PatientNotFoundException;
import com.cognizant.iptm.exception.TreatmentPlanNotFoundException;
import com.cognizant.iptm.model.PatientDetail;
import com.cognizant.iptm.model.TreatmentPlan;

@Component
public interface TreatmentPlanDao {

	public TreatmentPlan getTreatmentPlan(PatientDetail patientDetail);
	
	public List<PatientDetail> getAllPatients();

	public PatientDetail getPatient(long id) throws PatientNotFoundException;
	
	public List<TreatmentPlan> getAllTreatmentPlans();
	
	public TreatmentPlan getTreatmentPlan(long id) throws TreatmentPlanNotFoundException;
	
	
}
