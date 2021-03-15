package com.cognizant.iptm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.cognizant.iptm.controller.TreatmentPlanController;
import com.cognizant.iptm.exception.PatientNotFoundException;
import com.cognizant.iptm.exception.TreatmentPlanNotFoundException;
import com.cognizant.iptm.model.PatientDetail;
import com.cognizant.iptm.model.TreatmentPlan;
import com.cognizant.iptm.service.TreatmentPlanService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class TreatmentPlanControllerTest {

	@InjectMocks
	TreatmentPlanController treatmentPlanController;

	@Mock
	TreatmentPlanService treatmentPlanService;
	
	@Autowired
	private MockMvc mvc;
	
	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetAllPatients() throws Exception {
		List<PatientDetail> patientList = new ArrayList<>();
		PatientDetail patient1 = new PatientDetail((long) 1, "Monica Geller", 32, "package1", "Orthopaedics",
				"05-03-2021");
		PatientDetail patient2 = new PatientDetail((long) 2, "Sheldon Cooper", 23, "package2", "Urology",
				"14-01-2021");
		patientList.add(patient1);
		patientList.add(patient2);

		Mockito.when(treatmentPlanController.getAllPatients()).thenReturn(patientList);
		mvc.perform(get("/treatment/patients")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[0].name", Matchers.equalTo("Monica Geller")))
				.andExpect(jsonPath("$[1].name", Matchers.equalTo("Sheldon Cooper")))
				.andExpect(jsonPath("$[0].patientId", Matchers.equalTo(1)))
				.andExpect(jsonPath("$[1].patientId", Matchers.equalTo(2)))
				.andExpect(jsonPath("$[0].age", Matchers.equalTo(32)))
				.andExpect(jsonPath("$[1].age", Matchers.equalTo(23)))
				.andExpect(jsonPath("$[0].ailment", Matchers.equalTo("Orthopaedics")))
				.andExpect(jsonPath("$[1].ailment", Matchers.equalTo("Urology")))
				.andExpect(jsonPath("$[0].treatmentPackage", Matchers.equalTo("package1")))
				.andExpect(jsonPath("$[1].treatmentPackage", Matchers.equalTo("package2")))
				.andExpect(jsonPath("$[0].treatmentCommencementDate", Matchers.equalTo("05-03-2021")))
				.andExpect(jsonPath("$[1].treatmentCommencementDate", Matchers.equalTo("14-01-2021")));
	}

	@Test
	public void testGetPatientById() throws Exception {
		PatientDetail patient1 = new PatientDetail((long) 1, "Monica Geller", 32, "package1", "Orthopaedics",
				"05-03-2021");
		Mockito.when(treatmentPlanController.getPatient(1)).thenReturn(patient1);
		mvc.perform(get("/treatment/patient/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.name", Matchers.equalTo("Monica Geller")))
				.andExpect(jsonPath("$.patientId", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.age", Matchers.equalTo(32)))
				.andExpect(jsonPath("$.ailment", Matchers.equalTo("Orthopaedics")))
				.andExpect(jsonPath("$.treatmentPackage", Matchers.equalTo("package1")))
				.andExpect(jsonPath("$.treatmentCommencementDate", Matchers.equalTo("05-03-2021")));
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
		planList.add(plan1);
		planList.add(plan2);

		Mockito.when(treatmentPlanController.getAllTreatmentPlans()).thenReturn(planList);
		mvc.perform(get("/treatment/treatmentplans")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[0].patientDetail.name", Matchers.equalTo("Monica Geller")))
				.andExpect(jsonPath("$[0].patientDetail.patientId", Matchers.equalTo(1)))
				.andExpect(jsonPath("$[0].patientDetail.age", Matchers.equalTo(32)))
				.andExpect(jsonPath("$[0].patientDetail.ailment", Matchers.equalTo("Orthopaedics")))
				.andExpect(jsonPath("$[0].patientDetail.treatmentPackage", Matchers.equalTo("package1")))
				.andExpect(jsonPath("$[0].patientDetail.treatmentCommencementDate", Matchers.equalTo("05-03-2021")))
				
				.andExpect(jsonPath("$[1].patientDetail.name", Matchers.equalTo("Sheldon Cooper")))
				.andExpect(jsonPath("$[1].patientDetail.patientId", Matchers.equalTo(2)))
				.andExpect(jsonPath("$[1].patientDetail.age", Matchers.equalTo(23)))
				.andExpect(jsonPath("$[1].patientDetail.ailment", Matchers.equalTo("Urology")))
				.andExpect(jsonPath("$[1].patientDetail.treatmentPackage", Matchers.equalTo("package2")))
				.andExpect(jsonPath("$[1].patientDetail.treatmentCommencementDate", Matchers.equalTo("14-01-2021")))
				
				.andExpect(jsonPath("$[0].treatmentCommencementDate", Matchers.equalTo("05-03-2021")))
				.andExpect(jsonPath("$[1].treatmentCommencementDate", Matchers.equalTo("14-01-2021")))

				.andExpect(jsonPath("$[0].treatmentEndDate", Matchers.equalTo("01-04-2021")))
				.andExpect(jsonPath("$[1].treatmentEndDate", Matchers.equalTo("24-02-2021")))
				
				.andExpect(jsonPath("$[0].treatmentPlanId", Matchers.equalTo(1)))
				.andExpect(jsonPath("$[1].treatmentPlanId", Matchers.equalTo(2)))

				.andExpect(jsonPath("$[0].packageName", Matchers.equalTo("package1")))
				.andExpect(jsonPath("$[1].packageName", Matchers.equalTo("package2")))
				
				.andExpect(jsonPath("$[0].testDetail", Matchers.equalTo("OPT1, OPT2")))
				.andExpect(jsonPath("$[1].testDetail", Matchers.equalTo("UPT3, UPT4")))
				
				.andExpect(jsonPath("$[0].status", Matchers.equalTo("In Progress")))
				.andExpect(jsonPath("$[1].status", Matchers.equalTo("Completed")))

				.andExpect(jsonPath("$[0].specialist", Matchers.equalTo("Junior Specialist")))
				.andExpect(jsonPath("$[1].specialist", Matchers.equalTo("Senior Specialist")))
				
				.andExpect(jsonPath("$[0].cost", Matchers.equalTo(2500.0)))
				.andExpect(jsonPath("$[1].cost", Matchers.equalTo(5000.0)));
	}

	@Test
	public void testGetTreatmentPlanById() throws Exception {
		PatientDetail patient2 = new PatientDetail((long) 2, "Sheldon Cooper", 23, "package2", "Urology",
				"14-01-2021");
		TreatmentPlan plan2 = new TreatmentPlan((long) 2, patient2, "package2", "UTP3, UTP4", "Completed", 5000,
				"Senior Specialist", "14-01-2021", "24-02-2021");
		
		Mockito.when(treatmentPlanController.getTreatmentPlan(2)).thenReturn(plan2);
		
		mvc.perform(get("/treatment/treatmentplan/2")).andExpect(status().isOk())
			.andExpect(jsonPath("$.patientDetail.name", Matchers.equalTo("Sheldon Cooper")))
			.andExpect(jsonPath("$.patientDetail.patientId", Matchers.equalTo(2)))
			.andExpect(jsonPath("$.patientDetail.age", Matchers.equalTo(23)))
			.andExpect(jsonPath("$.patientDetail.ailment", Matchers.equalTo("Urology")))
			.andExpect(jsonPath("$.patientDetail.treatmentPackage", Matchers.equalTo("package2")))
			.andExpect(jsonPath("$.patientDetail.treatmentCommencementDate", Matchers.equalTo("14-01-2021")))
			.andExpect(jsonPath("$.treatmentCommencementDate", Matchers.equalTo("14-01-2021")))
			.andExpect(jsonPath("$.treatmentPlanId", Matchers.equalTo(2)))
			.andExpect(jsonPath("$.packageName", Matchers.equalTo("package2")))
			.andExpect(jsonPath("$.testDetail", Matchers.equalTo("UPT3, UPT4")))
			.andExpect(jsonPath("$.status", Matchers.equalTo("Completed")))
			.andExpect(jsonPath("$.specialist", Matchers.equalTo("Senior Specialist")))
			.andExpect(jsonPath("$.treatmentEndDate", Matchers.equalTo("24-02-2021")))
			.andExpect(jsonPath("$.cost", Matchers.equalTo(5000.0)));
		
	}
	
	@Test
	public void testGetTeatmentPlan1() throws Exception {
		SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		PatientDetail patient = new PatientDetail((long) 3, "Jake Peralta", 27, "package1", "Urology",
				sm.format(today));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());            
		calendar.add(Calendar.WEEK_OF_YEAR, 4);
		Date date = calendar.getTime();
			TreatmentPlan plan = new TreatmentPlan((long)3, patient, "package1", "UTP1, UTP2", "In Progress", 4000, "Junior Specialist", 
					sm.format(today), sm.format(date));
	
		Mockito.when(treatmentPlanController.getTreatmentPlan(patient)).thenReturn(plan);
		
        String json = mapper.writeValueAsString(patient);
        
        mvc.perform(post("/treatment/formTimeTable").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.patientDetail.name", Matchers.equalTo("Jake Peralta")))
		.andExpect(jsonPath("$.patientDetail.patientId", Matchers.equalTo(3)))
		.andExpect(jsonPath("$.patientDetail.age", Matchers.equalTo(27)))
		.andExpect(jsonPath("$.patientDetail.ailment", Matchers.equalTo("Urology")))
		.andExpect(jsonPath("$.patientDetail.treatmentPackage", Matchers.equalTo("package1")))
		.andExpect(jsonPath("$.patientDetail.treatmentCommencementDate", Matchers.equalTo(sm.format(today))))
		.andExpect(jsonPath("$.treatmentCommencementDate", Matchers.equalTo(sm.format(today))))
		.andExpect(jsonPath("$.treatmentPlanId", Matchers.equalTo(3)))
		.andExpect(jsonPath("$.packageName", Matchers.equalTo("package1")))
		.andExpect(jsonPath("$.testDetail", Matchers.equalTo("UPT1, UPT2")))
		.andExpect(jsonPath("$.status", Matchers.equalTo("In Progress")))
		.andExpect(jsonPath("$.specialist", Matchers.equalTo("Junior Specialist")))
		.andExpect(jsonPath("$.treatmentEndDate", Matchers.equalTo(sm.format(date))))
		.andExpect(jsonPath("$.cost", Matchers.equalTo(4000.0)));
		
	}
	
	@Test
	public void testGetTeatmentPlan2() throws Exception {
		SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		PatientDetail patient = new PatientDetail((long) 4, "Raymond Holt", 27, "package2", "Urology",
				sm.format(today));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());            
		calendar.add(Calendar.WEEK_OF_YEAR, 6);
		Date date = calendar.getTime();
		TreatmentPlan plan = new TreatmentPlan((long)4, patient, "package2", "UTP3, UTP4", "In Progress", 5000, "Senior Specialist", 
				sm.format(today), sm.format(date));
	
		Mockito.when(treatmentPlanController.getTreatmentPlan(patient)).thenReturn(plan);
		
        String json = mapper.writeValueAsString(patient);
        
        mvc.perform(post("/treatment/formTimeTable").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.patientDetail.name", Matchers.equalTo("Raymond Holt")))
		.andExpect(jsonPath("$.patientDetail.patientId", Matchers.equalTo(4)))
		.andExpect(jsonPath("$.patientDetail.age", Matchers.equalTo(27)))
		.andExpect(jsonPath("$.patientDetail.ailment", Matchers.equalTo("Urology")))
		.andExpect(jsonPath("$.patientDetail.treatmentPackage", Matchers.equalTo("package2")))
		.andExpect(jsonPath("$.patientDetail.treatmentCommencementDate", Matchers.equalTo(sm.format(today))))
		.andExpect(jsonPath("$.treatmentCommencementDate", Matchers.equalTo(sm.format(today))))
		.andExpect(jsonPath("$.treatmentPlanId", Matchers.equalTo(4)))
		.andExpect(jsonPath("$.packageName", Matchers.equalTo("package2")))
		.andExpect(jsonPath("$.testDetail", Matchers.equalTo("UPT3, UPT4")))
		.andExpect(jsonPath("$.status", Matchers.equalTo("In Progress")))
		.andExpect(jsonPath("$.specialist", Matchers.equalTo("Senior Specialist")))
		.andExpect(jsonPath("$.treatmentEndDate", Matchers.equalTo(sm.format(date))))
		.andExpect(jsonPath("$.cost", Matchers.equalTo(5000.0)));
	}
	
	@Test
	public void testPatientNotFoundException() throws Exception{
		String exceptionParam = "not_found";
		
		mvc.perform(get("/treatment/patient/7" , exceptionParam)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof PatientNotFoundException));
	}
	
	@Test
	public void testTreatmentPlanNotFoundException() throws Exception{
		String exceptionParam = "not_found";
		
		mvc.perform(get("/treatment/treatmentplan/7" , exceptionParam)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof TreatmentPlanNotFoundException));
	}
	
}