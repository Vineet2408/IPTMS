package com.cts.portal.service;

import java.util.List;

import com.cts.portal.model.InitiateClaim;
import com.cts.portal.model.InsurerDetail;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IPTMSInsuranceInterface 
{
	@GET("/insurance-claim")
	public Call<List<InsurerDetail>> getAllInsurerDetail();
		
	@GET("/insurance-claim/{packageName}")
	public Call<InsurerDetail> getInsurerDetailByPackageName(@Path("packageName") String packageName);
		
	@POST("/insurance-claim")
	public Call<Double> initiateClaim(@Body InitiateClaim initiateClaim);
	
	@GET("/insurance-claim/initiate-claim")
	public Call<List<InitiateClaim>> getAllInitiatedClaims();
	
}
