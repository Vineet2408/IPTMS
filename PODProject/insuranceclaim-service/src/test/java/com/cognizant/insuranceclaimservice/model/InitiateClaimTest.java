package com.cognizant.insuranceclaimservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InitiateClaimTest {
	
	InitiateClaim initiateClaim=new InitiateClaim();
	
	@Test
	void testSetId() {
		initiateClaim.setId(12);
		assertEquals(12,initiateClaim.getId());
	
		
	}
	@Test
	void testGetId() {
		initiateClaim.setId(12);
		assertEquals(12,initiateClaim.getId());
	
		
	}
	@Test
	void testGetPatientId() {
		initiateClaim.setPatientId(3);
		assertEquals(3,initiateClaim.getPatientId());
	}
	@Test
	void testSetPatientId() {
		initiateClaim.setPatientId(3);
		assertEquals(3,initiateClaim.getPatientId());
	}
	
	@Test
	void testSetAilment() {
		initiateClaim.setAilment("Urology");
		assertEquals("Urology",initiateClaim.getAilment());
		
	}
	@Test
	void testGetAilment() {
		initiateClaim.setAilment("Urology");
		assertEquals("Urology",initiateClaim.getAilment());
		
	}
	
	@Test
	void testSetBalance() {
		initiateClaim.setBalance(50000);
		assertEquals(50000,initiateClaim.getBalance());
		
	}
	@Test
	void testGetBalance() {
		initiateClaim.setBalance(50000);
		assertEquals(50000,initiateClaim.getBalance());
		
	}
	
	@Test
	void testSetInsurerAmountLimit() {
		initiateClaim.setInsurerAmountLimit(7000);
		assertEquals(7000,initiateClaim.getInsurerAmountLimit());
		
	}
	@Test
	void testGetInsurerAmountLimit() {
		initiateClaim.setInsurerAmountLimit(7000);
		assertEquals(7000,initiateClaim.getInsurerAmountLimit());
		
	}
	@Test
	void testSetInsurerName() {
		initiateClaim.setInsurerName("XYZ");
		
		assertEquals("XYZ",initiateClaim.getInsurerName());
		
	}
	@Test
	void testGetInsurerName() {
		initiateClaim.setInsurerName("XYZ");
		
		assertEquals("XYZ",initiateClaim.getInsurerName());
		
	}
	@Test
	void testSetPatientName() {
		initiateClaim.setPatientName("ABC");
		
		assertEquals("ABC",initiateClaim.getPatientName());
		
	}
	@Test
	void testGetPatientName() {
		initiateClaim.setPatientName("ABC");
		
		assertEquals("ABC",initiateClaim.getPatientName());
		
	}
	@Test
	void testSetStatus() {
		initiateClaim.setStatus("In Progress");
		
		assertEquals("In Progress",initiateClaim.getStatus());
		
	}
	@Test
	void testGetStatus() {
		initiateClaim.setStatus("In Progress");
		
		assertEquals("In Progress",initiateClaim.getStatus());
		
	}
	
	@Test
	void testSetTreatmentCost() {
		initiateClaim.setTreatmentCost(50000);
		
		assertEquals(50000,initiateClaim.getTreatmentCost());
		
	}
	
	@Test
	void testGetTreatmentCost() {
		initiateClaim.setTreatmentCost(50000);
		
		assertEquals(50000,initiateClaim.getTreatmentCost());
		
	}
	
	@Test
	void testSetTreatmentPackageName() {
		initiateClaim.setTreatmentPackageName("Package1");
		
		assertEquals("Package1",initiateClaim.getTreatmentPackageName());
		
	}
	@Test
	void testGetTreatmentPackageName() {
		initiateClaim.setTreatmentPackageName("Package1");
		
		assertEquals("Package1",initiateClaim.getTreatmentPackageName());
		
	}
	@Test
	void testGetInitiateClaimDetail() {
		InitiateClaim initiateClaim=new InitiateClaim(6,5,"ABC","Urology","Package1","XYZ",43000,50000,7000,"Completed");
		
		assertEquals("Package1",initiateClaim.getTreatmentPackageName());
		
	}
	
	

}
