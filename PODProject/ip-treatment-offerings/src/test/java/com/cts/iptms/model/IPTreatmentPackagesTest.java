package com.cts.iptms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IPTreatmentPackagesTest {

	IPTreatmentPackages iptreatment = new IPTreatmentPackages();
	
	@Test
	void testIPTreatmentPackageLongStringPackageDetail() {
		PackageDetail detail=new PackageDetail();
		IPTreatmentPackages treatment=new IPTreatmentPackages(101,"Urology",detail);
		
		assertEquals(101,treatment.getId());
	}

	
	
	@Test
	void testSetId() {
		iptreatment.setId(10);
		assertEquals(10,iptreatment.getId());
	}

	@Test
	void testGetId() {
		iptreatment.setId(10);
		assertEquals(10,iptreatment.getId());
		
	}

	@Test
	void testSetAilmentCategory() {
		iptreatment.setAilmentCategory("Urology");
		assertEquals("Urology",iptreatment.getAilmentCategory());
	}

	@Test
	void testGetAilmentCategory() {
		iptreatment.setAilmentCategory("Urology");
		assertEquals("Urology",iptreatment.getAilmentCategory());
	}

	@Test
	void testSetPackageDetail() {
		PackageDetail detail=new PackageDetail();
		iptreatment.setPackageDetail(detail);
		assertEquals(detail,iptreatment.getPackageDetail());
	}
	
	@Test
	void testGetPackageDetail() {
		PackageDetail detail=new PackageDetail();
		iptreatment.setPackageDetail(detail);;
		assertEquals(detail,iptreatment.getPackageDetail());
	}

}
