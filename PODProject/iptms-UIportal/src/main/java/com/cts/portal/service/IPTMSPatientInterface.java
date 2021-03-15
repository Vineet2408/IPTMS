package com.cts.portal.service;

import java.util.List;

import com.cts.portal.model.PatientDetail;
import com.cts.portal.model.TreatmentPlan;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IPTMSPatientInterface 
{
	@GET("/treatment/patient/{id}")
	public Call<PatientDetail> getPatient(@Path("id") long id);
	
	@GET("/treatment/treatmentplan/{id}")
	public Call<TreatmentPlan> getTreatmentPlan(@Path("id") long id );

	@POST("/treatment/formTimeTable")
	public Call<TreatmentPlan> addPatient(@Body PatientDetail pd);
	
	@GET("/treatment/treatmentplans")
	public Call<List<TreatmentPlan>> getAllTreatmentPlans();
	
	@GET("/treatment/patients")
	public Call<List<PatientDetail>> getAllPatientList();
	
}
