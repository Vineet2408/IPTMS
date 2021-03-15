package com.cognizant.iptm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.iptm.dao.TreatmentPlanDaoImpl;
import com.cognizant.iptm.exception.PatientNotFoundException;
import com.cognizant.iptm.exception.TreatmentPlanNotFoundException;
import com.cognizant.iptm.model.PatientDetail;
import com.cognizant.iptm.model.TreatmentPlan;
import com.cognizant.iptm.repository.PatientDetailRepository;
import com.cognizant.iptm.repository.TreatmentPlanRepository;
import com.cognizant.iptm.service.TreatmentPlanService;

@SpringBootTest
class IpTreatmentManagementServiceTests {

	@InjectMocks
	TreatmentPlanService treatmentPlanService;
	
	@Mock
	TreatmentPlanDaoImpl treatmentPlanDaoImpl;
	
	@Resource
	PatientDetailRepository patientDetailRepository;
	
	@Resource
	TreatmentPlanRepository treatmentPlanRepository;
	
	@Test
	public void testGetAllPatients() throws Exception {
		List<PatientDetail> patientList = new ArrayList<>();
		PatientDetail patient1 = new PatientDetail((long) 1, "Monica Geller", 32, "package1", "Orthopaedics",
				"05-03-2021");
		PatientDetail patient2 = new PatientDetail((long) 2, "Sheldon Cooper", 23, "package2", "Urology",
				"14-01-2021");
		
		patientDetailRepository.save(patient1);
		patientDetailRepository.save(patient2);
		patientList.add(patient1);
		patientList.add(patient2);
		
		Mockito.when(treatmentPlanService.getAllPatient()).thenReturn(patientList);
		assertEquals(patientList, treatmentPlanService.getAllPatient());

	}
	

	@Test
	public void testGetPatientById() throws Exception {
		PatientDetail patient1 = new PatientDetail((long) 1, "Monica Geller", 32, "package1", "Orthopaedics",
				"05-03-2021");
		
		patientDetailRepository.save(patient1);
		
		Mockito.when(treatmentPlanService.getPatient(1)).thenReturn(patient1);
		assertEquals(patient1, treatmentPlanService.getPatient(1));
		
	}
	
	@Test
	public void testGetAllTreatmentPlans() throws Exception {
		List<TreatmentPlan> planList = new ArrayList<>();
		PatientDetail patient1 = new PatientDetail((long) 1, "Monica Geller", 32, "package1", "Orthopaedics",
				"05-03-2021");
		PatientDetail patient2 = new PatientDetail((long) 2, "Sheldon Cooper", 23, "package2", "Urology",
				"14-01-2021");
		TreatmentPlan plan1 = new TreatmentPlan((long) 1, patient1, "package1", "OTP1, OTP2", "In Progress", 2500,
				"Junior Specialist","05-03-2021", "14-01-2021");
		TreatmentPlan plan2 = new TreatmentPlan((long) 2, patient2, "package2", "UTP3, UTP4", "Completed", 5000,
				"Senior Specialist", "14-01-2021", "24-02-2021");

		treatmentPlanRepository.save(plan1);
		treatmentPlanRepository.save(plan2);
		planList.add(plan1);
		planList.add(plan2);

		Mockito.when(treatmentPlanService.getAllTreatmentPlans()).thenReturn(planList);
		assertEquals(planList, treatmentPlanService.getAllTreatmentPlans());
	}
	
	@Test
	public void testGetTreatmentPlanById() throws Exception {
		PatientDetail patient2 = new PatientDetail((long) 2, "Sheldon Cooper", 23, "package2", "Urology",
				"14-01-2021");
		TreatmentPlan plan2 = new TreatmentPlan((long) 2, patient2, "package2", "UTP3, UTP4", "Completed", 5000,
				"Senior Specialist", "14-01-2021", "24-02-2021");
		treatmentPlanRepository.save(plan2);
		Mockito.when(treatmentPlanService.getTreatmentPlan(2)).thenReturn(plan2);
		assertEquals(plan2, treatmentPlanService.getTreatmentPlan(2));
			
	}
	
	@Test
	public void testGetTeatmentPlan1() throws Exception {
		Date today = new Date();
		SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
		PatientDetail patient = new PatientDetail((long) 1, "Jake Peralta", 27, "package1", "Urology",
				sm.format(today));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());            
		calendar.add(Calendar.WEEK_OF_YEAR, 4);
		Date date = calendar.getTime();
		TreatmentPlan plan = new TreatmentPlan((long)1, patient, "package1", "UTP1, UTP2", "In Progress", 4000, "Junior Specialist", 
				sm.format(today), sm.format(date));
		
		treatmentPlanRepository.save(plan);
		
    	Mockito.when(treatmentPlanService.getTreatmentPlan(patient)).thenReturn(plan);
		assertEquals(plan, treatmentPlanService.getTreatmentPlan(patient));
        
	}
	
	@Test
	public void testGetTeatmentPlan2() throws Exception {
		Date today = new Date();
		SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
		PatientDetail patient = new PatientDetail((long) 1, "Raymond Holt", 27, "package2", "Urology",
				sm.format(today));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());            
		calendar.add(Calendar.WEEK_OF_YEAR, 6);
		Date date = calendar.getTime();
		TreatmentPlan plan = new TreatmentPlan((long)1, patient, "package2", "UTP3, UTP4", "In Progress", 5000, "Senior Specialist", 
				sm.format(today), sm.format(date));
		
		treatmentPlanRepository.save(plan);
		
		Mockito.when(treatmentPlanService.getTreatmentPlan(patient)).thenReturn(plan);
		assertEquals(plan, treatmentPlanService.getTreatmentPlan(patient));
		
	}
	
	@Test
	public void testPatientNotFoundException() throws PatientNotFoundException {
		Mockito.when(treatmentPlanService.getPatient(10)).thenThrow(new PatientNotFoundException());
				assertThrows(PatientNotFoundException.class, () -> {
			treatmentPlanService.getPatient(10);
		});
	}
	
	@Test
	public void testTreatmentPlanNotFoundException() throws TreatmentPlanNotFoundException {
		
		Mockito.when(treatmentPlanService.getTreatmentPlan(10)).thenThrow(new TreatmentPlanNotFoundException());
		 assertThrows(TreatmentPlanNotFoundException.class, () -> {
			 treatmentPlanService.getTreatmentPlan(10);
		});
	}

}
