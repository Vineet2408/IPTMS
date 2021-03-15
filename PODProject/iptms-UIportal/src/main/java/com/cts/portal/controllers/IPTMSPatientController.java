package com.cts.portal.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.LoginData;
import com.cts.portal.model.PackageDetail;
import com.cts.portal.model.PatientDetail;
import com.cts.portal.model.TreatmentPlan;
import com.cts.portal.model.User;
import com.cts.portal.model.UserData;
import com.cts.portal.service.IPTMSAuthoriztionService;
import com.cts.portal.service.IPTMSInsuranceService;
import com.cts.portal.service.IPTMSOfferingsService;
import com.cts.portal.service.IPTMSPatientService;

@Controller
@RequestMapping("/patient")
public class IPTMSPatientController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IPTMSPatientController.class);

	LoginData loginData;
	@Autowired
	IPTMSPatientService patientService;
	@Autowired
	IPTMSOfferingsService offeringService;
	
	@Autowired
	IPTMSInsuranceService insuranceService;
	
	@Autowired
	IPTMSAuthoriztionService authService;
	
	User u=null;
	
	@GetMapping("/registerPatient")
	public String register(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
	    	return "Registration";
	    }
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
	}
	
	@PostMapping("/processform")
	public String handleForm(@ModelAttribute User user ,ModelMap map)
	{
		u=user;
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
			List<IPTreatmentPackages> list=offeringService.getIPTreatmentPackagesList();
			
			for(IPTreatmentPackages ip:list)
				System.out.println(ip.toString());
			
			map.put("iptreatmentPackageList", list);
			
			return "IPTreatmentPackagesServices";
	    }
		else
		{
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
		}

	}
	
	@RequestMapping("/getTreatment")
	public String getTreatment(@RequestParam("id") int id,ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
			String name = u.getName();
			int age = u.getAge();
			LOGGER.info("START");
			LOGGER.debug("IPTreatmentPackages "+id);
			LOGGER.info("END");
			
			IPTreatmentPackages pack=offeringService.getIPTreatmentPackage(id);
			System.out.println(pack.toString());
			
			PackageDetail pd=pack.getPackageDetail();
			String ailment = pack.getAilmentCategory();
			String tpn = pd.getTreatmentPackageName();
			String arr[]=tpn.split(" ");
			tpn=arr[0]+arr[1];
			tpn=tpn.toLowerCase();
			LOGGER.info("START");
			LOGGER.debug("IPTreatmentPackageName "+tpn);
			LOGGER.info("END");
			
			Date d=new Date();
			SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy");
			String date = sm.format(d);
			
			PatientDetail patient=new PatientDetail(name,age,ailment,tpn,date);
			try {
		
			
			TreatmentPlan res=patientService.addPatient(patient);
			System.out.println(res.toString());
			double balanceAmt=res.getCost();
			
			map.put("patientDetail", patient);
			map.put("treatmentPlan",res);
			map.put("treatmentCommencementDate", res.getTreatmentCommencementDate());
			map.put("treatmentEndDate",res.getTreatmentEndDate());
			map.put("balanceAmount", balanceAmt);
			
			}catch(Exception ex)
			{
				
			}
			return "Profile";
	    }
	    else
	    {
	    	map.put("message", "You need to login again");
	    	return "Login";
	    }
	}
	
	@GetMapping("/profile")
	public String profile(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
	    	return "profile";
	    }
	    else
	    {
	    	map.put("message", "You need to login again");
	    	return "Login";
	    }
	}
}
