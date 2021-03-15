package com.cts.portal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.portal.model.InitiateClaim;
import com.cts.portal.model.InsurerDetail;
import com.cts.portal.model.LoginData;
import com.cts.portal.model.PatientDetail;
import com.cts.portal.model.TreatmentPlan;
import com.cts.portal.model.UserData;
import com.cts.portal.service.IPTMSAuthoriztionService;
import com.cts.portal.service.IPTMSInsuranceService;
import com.cts.portal.service.IPTMSPatientService;


@Controller
@RequestMapping("/insurance")
public class IPTMSInsuranceController
{
	LoginData loginData;
	@Autowired
	IPTMSInsuranceService service;
	@Autowired
	IPTMSPatientService patientService;
	
	@Autowired
	IPTMSAuthoriztionService authService;
	TreatmentPlan tp;
	
	@GetMapping("/viewApplications")
	public String viewApplication(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
	    	List<TreatmentPlan> treatmentPlanList = patientService.getAllTreatmentPlan();
	    	
	    	List<TreatmentPlan> filteredList = new ArrayList<>();
	    	int f=0;
	    	try {
	    		
	    		List<InitiateClaim> claimList = service.getAllInitiatedClaims();
	    		for(TreatmentPlan tp:treatmentPlanList)
				{
					for(InitiateClaim ic:claimList)
					{
						if(tp.getPatientDetail().getPatientId()==(ic.getPatientId()))
						{
							f=1;
							break;
						}
						
					}
					if(f==0)
					{
						filteredList.add(tp);
					}
					else
					{
						f=0;
					}
				
					System.out.println(tp.toString());
				}
	    	}
	    	catch(Exception e)
	    	{
	    		
	    	}
			if(filteredList.size()<=0)
				filteredList=treatmentPlanList;
			map.put("treatmentPlanList",filteredList);
			return "PatientForInsuranceClaim";
	    }
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
		
	}
	
	@GetMapping("/viewAllPackages")
	public String viewAllPackages(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
			List<InsurerDetail> list=service.getAllInsurerDetail();
			for(InsurerDetail id:list)
				System.out.println(id.toString());
			map.put("insurancePackagesList", list);
			return "InsurancePackages";
	    }
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
	}
	
	
	//from PatientForInsuranceClaim
	@GetMapping("/selectInsurance")
	public String selectInsurance(@RequestParam long tpid,ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
		
			TreatmentPlan tplan=patientService.getTreatmentPlan(tpid);
			tp=tplan;
			//patientService.getPatientDetail(tp.getPatientDetail());
			List<InsurerDetail> list=service.getAllInsurerDetail();
			map.put("insurerDetailList",list);
			return "SelectInsurance";
	    }
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
	}
	
	@GetMapping("/searchInsurancePackage")
	public String searchInsurancePackage(@RequestParam String packageName,ModelMap map)
	{
		UserData admin=LoginData.getUserData();
		if(authService.isSessionValid(admin.getAuthToken()))
		{
			InsurerDetail iDetail = service.getInsurerDetailByPackageName(packageName);
			List<InsurerDetail> list = new ArrayList<>();
			List<InsurerDetail> fullList = service.getAllInsurerDetail();
			try {
				list.add(iDetail);
			}
			catch(Exception e)
			{
				
			}
			if(iDetail==null||list.size()==0)
			{	
				list=fullList;
				map.put("message", "Wrong Package Name. Search again with right Package Name");
			}
			map.put("insurerDetailList",list);
			return "SelectInsurance";
		}
		else
		{
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
		}
	}
	@GetMapping("/initiateClaim")
	public String initiateClaimForPatient(@RequestParam String packageName,ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
		
			InsurerDetail insurerDetail=service.getInsurerDetailByPackageName(packageName);
			//Getting Patient
			PatientDetail pd = tp.getPatientDetail();
			String patientName=pd.getName();
			String ailment=pd.getAilment();
			String treatmentPackageName=pd.getTreatmentPackage();
			String insurerName=insurerDetail.getInsurerName();
			double cost = tp.getCost();
			double insurerAmountLimit = insurerDetail.getInsuranceAmountLimit();
			String status="Under Progress";
			InitiateClaim ic=new InitiateClaim(pd.getPatientId(),patientName,ailment,treatmentPackageName,insurerName,0,cost,insurerAmountLimit,status);
			double balanceAmount=service.initiateClaim(ic);
			ic.setBalance(balanceAmount);
			map.put("initiateClaim", ic);
			return "BalanceAmount";
	    }
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
	}
	

}
