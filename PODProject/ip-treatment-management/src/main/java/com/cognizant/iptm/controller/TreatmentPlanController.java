package com.cognizant.iptm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.iptm.exception.PatientNotFoundException;
import com.cognizant.iptm.exception.TreatmentPlanNotFoundException;
import com.cognizant.iptm.model.PatientDetail;
import com.cognizant.iptm.model.TreatmentPlan;
import com.cognizant.iptm.service.TreatmentPlanService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/treatment")
public class TreatmentPlanController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TreatmentPlanController.class);

	@Autowired
	TreatmentPlanService treatmentPlanService;
	
	@PostMapping("/formTimeTable")
	@ApiOperation(value = "Creates Time Table for new registered patient", 
	notes = "This method is used to register a new patient based on ailment and treatment package", 
	response = TreatmentPlan.class)
	public TreatmentPlan getTreatmentPlan(@RequestBody PatientDetail patientDetail) {
		System.out.println(patientDetail.toString());
		return treatmentPlanService.getTreatmentPlan(patientDetail);
	}
	
	@RequestMapping("/patients")
	@ApiOperation(value = "Gives list of all the patients", 
	notes = "Returns the list of all the patients registered in the hospital for a treatment", 
	response = PatientDetail.class)
	public List<PatientDetail> getAllPatients(){
		return treatmentPlanService.getAllPatient();
	}
	
	@GetMapping("/patient/{id}")
	@ApiOperation(value = "Finds a patient by ID", 
	notes = "This method is used to find the Patient by his/her ID registered in the hospital", 
	response = PatientDetail.class)
	public PatientDetail getPatient(@PathVariable long id) throws PatientNotFoundException{
		LOGGER.info("start");
		return treatmentPlanService.getPatient(id);
	}
	
	@GetMapping("/treatmentplans")
	public List<TreatmentPlan> getAllTreatmentPlans(){
		return treatmentPlanService.getAllTreatmentPlans();
	}
	
	@GetMapping("/treatmentplan/{id}")
	@ApiOperation(value = "Finds a treatment plan by ID", 
	notes = "This method is used to find the Treatment Plan by his/her ID going on in the hospital", 
	response = TreatmentPlan.class)
	public TreatmentPlan getTreatmentPlan(@PathVariable long id) throws TreatmentPlanNotFoundException {
		return treatmentPlanService.getTreatmentPlan(id);
	}
	
	
}
