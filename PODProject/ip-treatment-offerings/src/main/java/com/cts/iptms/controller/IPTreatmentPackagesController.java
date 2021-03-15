package com.cts.iptms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iptms.model.IPTreatmentPackages;
import com.cts.iptms.model.SpecialistDetail;
import com.cts.iptms.service.IPTMSPackageDetailService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/iptms")
public class IPTreatmentPackagesController {

	@Autowired
	IPTMSPackageDetailService packageDetailService;

	@GetMapping("/IPTreatmentPackages")
	@ApiOperation(value = "Show all Treatment Packages", notes = "Shows all the Treatments available for the Iternational Patients", response = IPTreatmentPackages.class)
	public List<IPTreatmentPackages> getIPTreatmentPackages() {
		return packageDetailService.getIPTreatmentPackages();
	}

	@GetMapping(path = "/IPTreatmentPackageByName/{category}/{packageName}")
	@ApiOperation(value = "Find Treatment Package by Ailment and Package Name", notes = "This method is use to find the Treatment Package by Ailment category and Package name provided by the user", response = IPTreatmentPackages.class)
	public IPTreatmentPackages getIPTreatmentPackageByAilmentCategoryAndName(
			@ApiParam(value = "Ailment Category for the Treatment Package you need to retrieve", required = true) @PathVariable String category,
			@ApiParam(value = "Package Name for the Treatment Package you need to retrieve", required = true) @PathVariable String packageName) {

		return packageDetailService.getIPTreatmentPackageByAilmentCategoryAndName(packageName, category);
	}

	@GetMapping("/SpecialistDetail")
	@ApiOperation(value = "Show all Specialist Available", notes = "Shows all the Specialist available for the Iternational Patients", response = SpecialistDetail.class)
	public List<SpecialistDetail> getSpecialistDetail() {
		return packageDetailService.getSpecialistDetail();
	}
}