package com.cognizant.iptm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.iptm.dao.TreatmentPlanDao;
import com.cognizant.iptm.exception.PatientNotFoundException;
import com.cognizant.iptm.exception.TreatmentPlanNotFoundException;
import com.cognizant.iptm.model.PatientDetail;
import com.cognizant.iptm.model.TreatmentPlan;

@Service
public class TreatmentPlanService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TreatmentPlanService.class);
	
	@Autowired
	TreatmentPlanDao treatmentPlanDao;
	
	public TreatmentPlan getTreatmentPlan(PatientDetail patientDetail) {
		return treatmentPlanDao.getTreatmentPlan(patientDetail);
	}

	public List<PatientDetail> getAllPatient() {
		return treatmentPlanDao.getAllPatients();
	}

	public PatientDetail getPatient(long id) throws PatientNotFoundException {
		LOGGER.info("start");
		return treatmentPlanDao.getPatient(id);
	}

	public List<TreatmentPlan> getAllTreatmentPlans() {
		return treatmentPlanDao.getAllTreatmentPlans();
	}
	
	public TreatmentPlan getTreatmentPlan(long id) throws TreatmentPlanNotFoundException {
		return treatmentPlanDao.getTreatmentPlan(id);
	}
}
