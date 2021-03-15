package com.cognizant.insuranceclaimservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InsurerDetailTest {
	InsurerDetail insurerdetail=new InsurerDetail();

	@Test
	void testSetId() {
		insurerdetail.setId(12);
		assertEquals(12,insurerdetail.getId());
	}

	@Test
	void testGetId() {
		insurerdetail.setId(12);
		assertEquals(12,insurerdetail.getId());
	}

	
	@Test
	void testSetInsurerName() {
		insurerdetail.setInsurerName("XYZ");
		assertEquals("XYZ",insurerdetail.getInsurerName());
	}
	
	@Test
	void testGetInsurerName() {
		insurerdetail.setInsurerName("XYZ");
		assertEquals("XYZ",insurerdetail.getInsurerName());
	}

	@Test
	void testSetInsurerPackageName() {
		insurerdetail.setInsurerPackageName("Package1");
				assertEquals("Package1",insurerdetail.getInsurerPackageName());
	}
	
	@Test
	void testGetInsurerPackageName() {
		insurerdetail.setInsurerPackageName("Package1");
		assertEquals("Package1",insurerdetail.getInsurerPackageName());
	}


	@Test
	void testSetInsuranceAmountLimit() {
		insurerdetail.setInsuranceAmountLimit(123456);
		assertEquals(123456,insurerdetail.getInsuranceAmountLimit());
	}
	
	@Test
	void testGetInsuranceAmountLimit() {
		insurerdetail.setInsuranceAmountLimit(123456);
		assertEquals(123456,insurerdetail.getInsuranceAmountLimit());
	}

	@Test
	void testSetDisbursementDuration() {
		insurerdetail.setDisbursementDuration(10);
		assertEquals(10,insurerdetail.getDisbursementDuration());
	}

	@Test
	void testGetDisbursementDuration() {
		insurerdetail.setDisbursementDuration(10);
		assertEquals(10,insurerdetail.getDisbursementDuration());
	}

	@Test
	void testInsurerDetailLongStringStringIntInt() {
		InsurerDetail insurer=new InsurerDetail(12,"XYZ","Package1",123456,10);
		assertEquals("XYZ",insurer.getInsurerName());
	}

}
