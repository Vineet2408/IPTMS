package com.cts.iptms.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.cts.iptms.service.IPTMSPackageDetailService;
import com.cts.iptms.model.SpecialistDetail;
import com.cts.iptms.exception.PackageDetailNotFoundException;
import com.cts.iptms.model.IPTreatmentPackages;
import com.cts.iptms.model.PackageDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(IPTreatmentPackagesController.class)
class IPTreatmentPackagesControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	IPTMSPackageDetailService iPTMSPackageDetailService;

	@Test
	public void get_allTreatmentPackages_returnsListOfPackages() throws Exception {

		List<IPTreatmentPackages> iPTreatmentPackages = new ArrayList<>();
		PackageDetail packageDetail = new PackageDetail();
		IPTreatmentPackages iPTreatmentPackages1 = new IPTreatmentPackages(1, "Orthopaedics", packageDetail);
		IPTreatmentPackages iPTreatmentPackages2 = new IPTreatmentPackages(2, "Urology", packageDetail);
		iPTreatmentPackages.add(iPTreatmentPackages1);
		iPTreatmentPackages.add(iPTreatmentPackages2);

		// Mocking out the SpecialistDetail service
		Mockito.when(iPTMSPackageDetailService.getIPTreatmentPackages()).thenReturn(iPTreatmentPackages);

		mockMvc.perform(MockMvcRequestBuilders.get("/iptms/IPTreatmentPackages").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[0].id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$[0].ailmentCategory", Matchers.equalTo("Orthopaedics")))
				.andExpect(jsonPath("$[1].id", Matchers.equalTo(2)))
				.andExpect(jsonPath("$[1].ailmentCategory", Matchers.equalTo("Urology")));
	}
	
	@Test
	public void get_allSpecialist_returnsListOfSpecialist() throws Exception {

		List<SpecialistDetail> SpecialistDetailList = new ArrayList<>();
		SpecialistDetail specialistDetail1 = new SpecialistDetail(1, "Dr. Vineet", "Urology", 4, "1234569632");
		SpecialistDetail specialistDetail2 = new SpecialistDetail(2, "Dr. Shailey", "Orthopaedics", 6, "1234759632");
		SpecialistDetailList.add(specialistDetail1);
		SpecialistDetailList.add(specialistDetail2);

		// Mocking out the SpecialistDetail service
		Mockito.when(iPTMSPackageDetailService.getSpecialistDetail()).thenReturn(SpecialistDetailList);

		mockMvc.perform(MockMvcRequestBuilders.get("/iptms/SpecialistDetail").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[0].id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$[0].name", Matchers.equalTo("Dr. Vineet")))
				.andExpect(jsonPath("$[0].areaOfExpertise", Matchers.equalTo("Urology")))
				.andExpect(jsonPath("$[0].experienceInYears", Matchers.equalTo(4)))
				.andExpect(jsonPath("$[0].contactNumber", Matchers.equalTo("1234569632")))
				.andExpect(jsonPath("$[1].id", Matchers.equalTo(2)))
				.andExpect(jsonPath("$[1].name", Matchers.equalTo("Dr. Shailey")))
				.andExpect(jsonPath("$[1].areaOfExpertise", Matchers.equalTo("Orthopaedics")))
				.andExpect(jsonPath("$[1].experienceInYears", Matchers.equalTo(6)))
				.andExpect(jsonPath("$[1].contactNumber", Matchers.equalTo("1234759632")));
	}
	
	@Test
	public void testGetPackageDetailByAilmentCategoryAndPackageName() throws Exception {
		PackageDetail packageDetail1 = new PackageDetail("package1","UPT1, UPT2", 3000, 6);
		IPTreatmentPackages iPTreatmentPackages = new IPTreatmentPackages(1, "Urology", packageDetail1);
		Mockito.when(iPTMSPackageDetailService.getIPTreatmentPackageByAilmentCategoryAndName("package1","Urology")).thenReturn(iPTreatmentPackages);

		mockMvc.perform(MockMvcRequestBuilders.get("/iptms/IPTreatmentPackageByName/Urology/package1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.ailmentCategory", Matchers.equalTo("Urology")))
				.andExpect(jsonPath("$.packageDetail.treatmentPackageName", Matchers.equalTo("package1")))
				.andExpect(jsonPath("$.packageDetail.testDetails", Matchers.equalTo("UPT1, UPT2")))
				.andExpect(jsonPath("$.packageDetail.cost", Matchers.equalTo(3000)))
				.andExpect(jsonPath("$.packageDetail.treatmentDuration", Matchers.equalTo(6)));
	}
	
	@Test
	public void testPackageNotFoundException() throws Exception{
		String exceptionParam = "not_found";
		
		mockMvc.perform(get("/Orthopaedics/package6" , exceptionParam)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertFalse(result.getResolvedException() instanceof PackageDetailNotFoundException));
	}

}
