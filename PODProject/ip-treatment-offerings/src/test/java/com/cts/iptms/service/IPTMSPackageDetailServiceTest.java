package com.cts.iptms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.iptms.repository.IPTMSPackageDetail;
import com.cts.iptms.repository.IPTMSSpecialistDetail;
import com.cts.iptms.exception.PackageDetailNotFoundException;
import com.cts.iptms.model.IPTreatmentPackages;
import com.cts.iptms.model.SpecialistDetail;

@ExtendWith(MockitoExtension.class)
class IPTMSPackageDetailServiceTest {

	@Mock
	IPTMSPackageDetail iptmsPackageDetail;
	@Mock
	IPTMSSpecialistDetail iptmsSpecialistDetail;

	@InjectMocks
	IPTMSPackageDetailService iPTMSPackageDetailService;

	@Test
	void testGetIPTreatmentPackages() {
		List<IPTreatmentPackages> ipTreatmentPackages = new ArrayList<IPTreatmentPackages>();
		when(iptmsPackageDetail.findAll()).thenReturn(ipTreatmentPackages);

		assertEquals(ipTreatmentPackages, iPTMSPackageDetailService.getIPTreatmentPackages());

	}

	@Test
	void testGetIPTreatmentPackageByAilmentCategoryAndName() {
		IPTreatmentPackages iPTreatmentPackage1 = new IPTreatmentPackages();
		when(iptmsPackageDetail.findByName("Package 1", "Urology")).thenReturn(iPTreatmentPackage1);
		assertEquals(iPTreatmentPackage1,
				iPTMSPackageDetailService.getIPTreatmentPackageByAilmentCategoryAndName("package1", "Urology"));
	}

	@Test
	void testNotFoundIPTreatmentPackageByAilmentCategoryAndName() {
		assertThrows(PackageDetailNotFoundException.class,
				() -> iPTMSPackageDetailService.getIPTreatmentPackageByAilmentCategoryAndName("package2", "c3"));
	}

	@Test
	void testGetSpecialists() {
		List<SpecialistDetail> specialistDetails = new ArrayList<SpecialistDetail>();
		when(iptmsSpecialistDetail.findAll()).thenReturn(specialistDetails);

		assertEquals(specialistDetails, iPTMSPackageDetailService.getSpecialistDetail());

	}

}
