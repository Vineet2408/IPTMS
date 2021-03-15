package com.cts.portal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.LoginData;
import com.cts.portal.model.SpecialistDetail;
import com.cts.portal.model.UserData;
import com.cts.portal.service.IPTMSAuthoriztionService;
import com.cts.portal.service.IPTMSOfferingsService;
@Controller
public class IPTMSOfferingsController
{
	LoginData loginData;
	@Autowired
	IPTMSOfferingsService service;
	
	@Autowired
	IPTMSAuthoriztionService authService;
	
	@RequestMapping("/tpack")
	public String  getIPTreatmentPackages(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
			List<IPTreatmentPackages> list=service.getIPTreatmentPackagesList();
			
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
	
	@GetMapping("/searchPackage")
	public String search(@RequestParam String packageName,@RequestParam String ailment,ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
			IPTreatmentPackages pack = service.getIPTreatmentPackageByName(ailment, packageName);
			List<IPTreatmentPackages> fullList = service.getIPTreatmentPackagesList();
			List<IPTreatmentPackages> list = new ArrayList<IPTreatmentPackages>();
			try {
				list.add(pack);
			}
			catch(Exception e)
			{
				
			}
			if(pack==null||list.size()==0)
			{	
				list=fullList;
				map.put("message", "Wrong Package Name or Ailment");
			}
			map.put("iptreatmentPackageList", list);
			return "IPTreatmentPackagesServices";
	    }
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
	}
	@GetMapping("/listAllTreatmentPackages")
	public String displayAllTreatmentPackages(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
			List<IPTreatmentPackages> list=service.getIPTreatmentPackagesList();
			map.put("iPTreatmentPackageList", list);
			return "IPTreatmentPackages";
	    }
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
		
	}
	
	@GetMapping("/listAllSpecialist")
	public String displaySpecialistList(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    if(authService.isSessionValid(admin.getAuthToken()))
	    {
			List<SpecialistDetail> list=service.getSpecialistList();
			map.put("specialistList", list);
			return "Specialist";
	    }
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
	}

}
