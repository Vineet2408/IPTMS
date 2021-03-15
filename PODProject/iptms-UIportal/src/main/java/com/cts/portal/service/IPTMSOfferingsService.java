package com.cts.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.SpecialistDetail;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Service
public class IPTMSOfferingsService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IPTMSOfferingsService.class);

	private final String BASEURL="http://localhost:8081"; 
	IPTreatmentPackages packageDetail = null;
	List<IPTreatmentPackages> iPTreatmentPackagesList=null;
	
	OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	Retrofit retrofit = new Retrofit.Builder()
	  .baseUrl(BASEURL)
	  .addConverterFactory(GsonConverterFactory.create())
	  .client(httpClient.build())
	  .build();
	
	public IPTreatmentPackages getIPTreatmentPackageByName(String category,String packageName)
	{
		IPTMSOfferingInterface service = retrofit.create(IPTMSOfferingInterface.class);
		Call<IPTreatmentPackages> callsync=service.getIPTreatmentPackageByName(category,packageName);
		try {
		    Response<IPTreatmentPackages> response = callsync.execute();
		    IPTreatmentPackages packageBean = response.body();
		    packageDetail=packageBean;
		}
		catch (Exception ex) 
		{ 
			LOGGER.info("START");
			LOGGER.debug("error in getIPTreatmentPackageByName() method in IPTMSOfferingsService class");
			LOGGER.info("END");  
		}
		
		return packageDetail;
	}
	public List<IPTreatmentPackages> getIPTreatmentPackagesList()

	{
		iPTreatmentPackagesList=new ArrayList<IPTreatmentPackages>();
		IPTMSOfferingInterface service = retrofit.create(IPTMSOfferingInterface.class);
		
		Call<List<IPTreatmentPackages>> callsync=service.getIPTPackagesList();
		try {
		    Response<List<IPTreatmentPackages>> response = callsync.execute();
		    List<IPTreatmentPackages> list = response.body();
		    iPTreatmentPackagesList=list;
		} 
		catch (Exception ex) 
		{ 
			LOGGER.info("START");
			LOGGER.debug("error in getIPTreatmentPackagesList() method in IPTMSOfferingsService class");
			LOGGER.info("END"); 
		}
		
		return iPTreatmentPackagesList;
	}

	public List<SpecialistDetail> getSpecialistList()
	{
		List<SpecialistDetail> list=new ArrayList<>();
		IPTMSOfferingInterface service = retrofit.create(IPTMSOfferingInterface.class);
		Call<List<SpecialistDetail>> callsync = service.getAllSpecialist();
		try {
			Response<List<SpecialistDetail>> response=callsync.execute();
			list=response.body();
			
		}catch(Exception ex)
		{ 
			LOGGER.info("START");
			LOGGER.debug("error in getSpecialistList() method in IPTMSOfferingsService class");
			LOGGER.info("END"); 
		}
		
		return list;
	}
	public IPTreatmentPackages getIPTreatmentPackage(int id)
	{
		iPTreatmentPackagesList=new ArrayList<IPTreatmentPackages>();
		IPTMSOfferingInterface service = retrofit.create(IPTMSOfferingInterface.class);
		
		Call<List<IPTreatmentPackages>> callsync=service.getIPTPackagesList();
		try {
		    Response<List<IPTreatmentPackages>> response = callsync.execute();
		    List<IPTreatmentPackages> list = response.body();
		    iPTreatmentPackagesList=list;
		} 
		catch (Exception ex) 
		{ 
			LOGGER.info("START");
			LOGGER.debug("error in getIPTreatmentPackage() method in IPTMSOfferingsService class");
			LOGGER.info("END");
		}
		
		for(IPTreatmentPackages ips:iPTreatmentPackagesList)
		{
			if(ips.getId()==id)
			{
				packageDetail=ips;
			}
		}
		return packageDetail;
	}
}
