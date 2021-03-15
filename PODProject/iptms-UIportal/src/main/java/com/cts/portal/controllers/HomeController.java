package com.cts.portal.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.LoginData;
import com.cts.portal.model.SpecialistDetail;
import com.cts.portal.model.UserCredential;
import com.cts.portal.model.UserData;
import com.cts.portal.service.IPTMSAuthoriztionService;
import com.cts.portal.service.IPTMSOfferingsService;

@Controller
public class HomeController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	LoginData loginData;
	@Autowired
	IPTMSOfferingsService offeringService;
	
	@Autowired
	IPTMSAuthoriztionService authService;
	
	
	@GetMapping
	public String defaultPage(ModelMap map)
	{
		return "Login";
	}
	
	@PostMapping("/loginuser")
	public String LoginUser(@ModelAttribute UserCredential userCredential,ModelMap map)
	{
		List<IPTreatmentPackages> list=offeringService.getIPTreatmentPackagesList();
		List<SpecialistDetail> sList=offeringService.getSpecialistList();
		map.put("iPTreatmentPackageList", list);
		map.put("specialistList", sList);
		
		UserData admin=LoginData.getUserData();
		LOGGER.info("START");
		LOGGER.info("username from login page : "+userCredential.getName());
		LOGGER.info("END");
		
	    admin.setUname(userCredential.getName());
		admin.setUpassword(userCredential.getPassword());
		admin.setAuthToken(authService.loginUser(admin));
		LOGGER.info("START");
		LOGGER.info("in loginuser"+admin.getAuthToken());
		LOGGER.info("END");
		if (authService.isSessionValid(admin.getAuthToken()))
		{
			return "MainPortal";
		}
		
		map.put("message", "Invalid Credentials");
		return "Login";
		
	}
	
	@GetMapping("/main-portal")
	public String mainPortal(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
		LOGGER.info("START");
		LOGGER.info("sending this token to validate : "+admin.getAuthToken());
		LOGGER.info("END");
	    if(authService.isSessionValid(admin.getAuthToken()))
	    	return "MainPortal";
	    else
	    {
	    	map.put("message"," You Need To Login Again");
	    	return "Login";
	    }
	}
	
	@GetMapping("/logout")
	public String logout(ModelMap map)
	{
		UserData admin=LoginData.getUserData();
	    admin.setAuthToken("");
	    admin.setUname("");
	    admin.setUserid("");
	    map.put("message", "Logout Successful");
		return "Login";
	}
	
}
