package com.cognizant.insuranceclaimservice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import com.cognizant.insuranceclaimservice.exception.InsurerDetailsNotFoundException;
import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;
import com.cognizant.insuranceclaimservice.repository.InitiateClaimRepository;
import com.cognizant.insuranceclaimservice.service.InsuranceClaimService;



@SpringBootTest
class InsuranceclaimServiceApplicationTests {
	@Mock
	private InsuranceClaimService insuranceClaimService;
	@Resource
	private InitiateClaimRepository initiateClaimRepo;


	@Test
	void contextLoads() {
		assertNotNull(insuranceClaimService);
	}
	@Test
	void testGetInsurerDetailsByPackageName() throws Exception {

		when(insuranceClaimService.getInsurerByPackageName("Ipackage1"))
				.thenReturn(new InsurerDetail(1, "Insurer1", "Ipackage1", 3000, 10));
		

		InsurerDetail insurerDetail = insuranceClaimService.getInsurerByPackageName("Ipackage1");
		assertEquals(insurerDetail, insuranceClaimService.getInsurerByPackageName("Ipackage1"));

	}
	

	@Test
	public void testGetAllInsurerDetail() throws Exception {
		List<InsurerDetail> insurerList = new ArrayList<>();
		InsurerDetail insurerDetail1 = new InsurerDetail((long) 1, "Insurer1", "Ipackage1", 3000, 10);
		InsurerDetail insurerDetail2 = new InsurerDetail((long) 2, "Insurer2", "Ipackage2", 2000, 12);
		insurerList.add(insurerDetail1);
		insurerList.add(insurerDetail2);

		Mockito.when(insuranceClaimService.getAllInsurerDetail()).thenReturn(insurerList);
		assertEquals(insurerList,insuranceClaimService.getAllInsurerDetail());
	}


	
	@Test
	public void testGetAllInitiatedClaims() throws Exception {
		InitiateClaim initiateClaim = new InitiateClaim((long) 1, (long)1, "Monica Geller", "Orthopaedics", "package1", "Insurer2",
				500, 2500, 2000, "Completed");
		List<InitiateClaim> initiatedClaimList = new ArrayList<>();
		initiatedClaimList.add(initiateClaim);
		Mockito.when(insuranceClaimService.getAllInitiatedClaims()).thenReturn(initiatedClaimList);
		assertEquals(initiatedClaimList,insuranceClaimService.getAllInitiatedClaims());
		
		
	}
	
@Test
public void testInsurerDetailsNotFoundException() throws Exception{


	when(insuranceClaimService.getInsurerByPackageName("package")).thenThrow(new InsurerDetailsNotFoundException ("Insurer Details not found"));
	assertThrows(InsurerDetailsNotFoundException.class, () -> {
		insuranceClaimService.getInsurerByPackageName("package");});
	 
		
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
	when(insuranceClaimService.initiateClaim(initiateClaim)).thenReturn((double) 3500);
	assertEquals(3500,insuranceClaimService.initiateClaim(initiateClaim));
	
	     
	
}




}