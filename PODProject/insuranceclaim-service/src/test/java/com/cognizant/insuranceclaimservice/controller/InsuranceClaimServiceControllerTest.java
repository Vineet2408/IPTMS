package com.cognizant.insuranceclaimservice.controller;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.cognizant.insuranceclaimservice.exception.InsurerDetailsNotFoundException;
import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;
import com.cognizant.insuranceclaimservice.service.InsuranceClaimService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class InsuranceClaimServiceControllerTest {

	@MockBean
	private InsuranceClaimController insuranceClaimController;

	@Autowired
	private MockMvc mvc;

	
	
	@Mock
	private InsuranceClaimService insuranceClaimService;

	@Test
	void contextLoads() {
		assertNotNull(insuranceClaimController);
	}

	@Test
	void testGetInsurerDetailsByPackageName() throws Exception {

		when(insuranceClaimController.getInsurerDetailByPackageName("Ipackage1"))
				.thenReturn(new InsurerDetail(1, "Insurer1", "Ipackage1", 3000, 10));
		ResultActions actions = mvc.perform(get("/insurance-claim/Ipackage1"));
		actions.andExpect(status().isOk());

		InsurerDetail insurerDetail = insuranceClaimController.getInsurerDetailByPackageName("Ipackage1");
		assertEquals(insurerDetail, insuranceClaimController.getInsurerDetailByPackageName("Ipackage1"));

	}
	

	@Test
	public void testGetAllInsurerDetail() throws Exception {
		List<InsurerDetail> insurerList = new ArrayList<>();
		InsurerDetail insurerDetail1 = new InsurerDetail((long) 1, "Insurer1", "Ipackage1", 3000, 10);
		InsurerDetail insurerDetail2 = new InsurerDetail((long) 2, "Insurer2", "Ipackage2", 2000, 12);
		insurerList.add(insurerDetail1);
		insurerList.add(insurerDetail2);

		Mockito.when(insuranceClaimController.getAllInsurerDetail()).thenReturn(insurerList);
		mvc.perform(get("/insurance-claim")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[0].insurerName", Matchers.equalTo("Insurer1")))
				.andExpect(jsonPath("$[1].insurerName", Matchers.equalTo("Insurer2")))
				.andExpect(jsonPath("$[0].id", Matchers.equalTo(1))).andExpect(jsonPath("$[1].id", Matchers.equalTo(2)))
				.andExpect(jsonPath("$[0].insurerPackageName", Matchers.equalTo("Ipackage1")))
				.andExpect(jsonPath("$[1].insurerPackageName", Matchers.equalTo("Ipackage2")))
				.andExpect(jsonPath("$[0].insuranceAmountLimit", Matchers.equalTo(3000.0)))
				.andExpect(jsonPath("$[1].insuranceAmountLimit", Matchers.equalTo(2000.0)))
				.andExpect(jsonPath("$[0].disbursementDuration", Matchers.equalTo(10)))
				.andExpect(jsonPath("$[1].disbursementDuration", Matchers.equalTo(12)));
	}


	
	@Test
	public void testGetAllInitiatedClaims() throws Exception {
		InitiateClaim initiateClaim = new InitiateClaim((long) 1,(long) 1,"Monica Geller", "Orthopaedics", "package1", "Insurer2",
				500, 2500, 2000, "Completed");
		List<InitiateClaim> list = new ArrayList<>();
		list.add(initiateClaim);
		Mockito.when(insuranceClaimController.getAllInitiatedClaims()).thenReturn(list);
		mvc.perform(get("/insurance-claim/initiate-claim")).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].insurerName", Matchers.equalTo("Insurer2")))
		.andExpect(jsonPath("$[0].id", Matchers.equalTo(1)))
		.andExpect(jsonPath("$[0].treatmentPackageName", Matchers.equalTo("package1")))
		.andExpect(jsonPath("$[0].insurerAmountLimit", Matchers.equalTo(2000.0)))
		.andExpect(jsonPath("$[0].status", Matchers.equalTo("Completed")))
		.andExpect(jsonPath("$[0].ailment", Matchers.equalTo("Orthopaedics")))
		.andExpect(jsonPath("$[0].balance", Matchers.equalTo(500.0)))
		.andExpect(jsonPath("$[0].treatmentCost", Matchers.equalTo(2500.0)))
		.andExpect(jsonPath("$[0].patientName", Matchers.equalTo("Monica Geller")));
		
	}
	
@Test
public void testInsurerDetailsNotFoundException() throws Exception{


	when(insuranceClaimController.getInsurerDetailByPackageName("package")).thenThrow(new InsurerDetailsNotFoundException ("Insurer Details not found"));
	 mvc.perform(get("/insurance-claim/{packageName}","package"))
     .andExpect(status().isNotFound()).andExpect(result -> assertTrue(result.getResolvedException() instanceof InsurerDetailsNotFoundException))
		.andExpect(result -> assertEquals("Insurer Details not found", result.getResolvedException().getMessage()));	
					
	 verify(insuranceClaimController, times(1)).getInsurerDetailByPackageName("package");
     verifyNoMoreInteractions(insuranceClaimController);
		
	}
@Test
public void testInitiateClaim() throws Exception {
	
	InitiateClaim initiateClaim=new InitiateClaim();
	initiateClaim.setId(1);
	initiateClaim.setPatientName("Latha");
	initiateClaim.setInsurerName("Insurer1");
	initiateClaim.setInsurerAmountLimit(2500);
	initiateClaim.setAilment("Urology");
	initiateClaim.setBalance(6000);
	initiateClaim.setTreatmentCost(6000);
	initiateClaim.setTreatmentPackageName("Package1");
	initiateClaim.setStatus("In Progress");
	when(insuranceClaimController.initiateClaim(initiateClaim)).thenReturn((double) 3500);
	ResultActions actions = mvc.perform(post("/insurance-claim").contentType(MediaType.APPLICATION_JSON).
		content(convertObjectToJsonBytes(initiateClaim)));
	        
	      actions.andExpect(status().isOk());
	     
	
}


public static byte[] convertObjectToJsonBytes(InitiateClaim initiateClaim) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return mapper.writeValueAsBytes(initiateClaim);
}
}
