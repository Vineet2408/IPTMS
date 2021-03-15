package com.cognizant.iptm.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.iptm.exception.PatientNotFoundException;
import com.cognizant.iptm.exception.TreatmentPlanNotFoundException;
import com.cognizant.iptm.model.PatientDetail;
import com.cognizant.iptm.model.TreatmentPlan;
import com.cognizant.iptm.repository.PatientDetailRepository;
import com.cognizant.iptm.repository.TreatmentPlanRepository;

@Component
public class TreatmentPlanDaoImpl implements TreatmentPlanDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(TreatmentPlanDaoImpl.class);

	@Autowired
	TreatmentPlan treatmentPlan;

	@Autowired
	PatientDetail patientDetail;

	@Autowired
	PatientDetailRepository patientDetailRepository;

	@Autowired
	TreatmentPlanRepository treatmentPlanRepo;

	@Override
	public TreatmentPlan getTreatmentPlan(PatientDetail patientDetail) {
		// creating Patient Detail from SamplePatient
//		PatientDetail patientDetail =new PatientDetail();
//		patientDetail.setAge(sd.getAge()); patientDetail.setAilment(sd.getAilment());
//		patientDetail.setName(sd.getName()); patientDetail.setTreatmentPackage(sd.getTreatmentPackage());

		// setting the dates for treatment plan

		SimpleDateFormat smipleFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		patientDetail.setTreatmentCommencementDate(smipleFormat.format(today));
		patientDetailRepository.save(patientDetail);

		// setting specialist according to the package
		String specialist = "";
		String testDetail = "";
		double cost = 0;
//		patientDetail.setTreatmentCommencementDate(currentDate);
//		String tpn = patientDetail.getTreatmentPackage();
//		System.out.println(tpn);
		if (patientDetail.getTreatmentPackage().equalsIgnoreCase("package1")
				|| patientDetail.getTreatmentPackage().equalsIgnoreCase("package 1")) {
			specialist = "Junior Specialist";
			calendar.add(Calendar.WEEK_OF_YEAR, 4);
			if (patientDetail.getAilment().equalsIgnoreCase("Urology")) {
				cost = 4000;
				testDetail = "UPT1, UPT2";
			} else {
				cost = 2500;
				testDetail = "OPT1, OPT2";
			}
		} else if (patientDetail.getTreatmentPackage().equalsIgnoreCase("package2")) {
			specialist = "Senior Specialist";
			calendar.add(Calendar.WEEK_OF_YEAR, 6);
			if (patientDetail.getAilment().equalsIgnoreCase("Urology")) {
				cost = 5000;
				testDetail = "UPT3, UPT4";
			} else {
				cost = 3000;
				testDetail = "OTP3, OTP4";
			}
		}
		patientDetailRepository.save(patientDetail);
		Date endDate = calendar.getTime();
		TreatmentPlan treatmentPlan = new TreatmentPlan(patientDetail, patientDetail.getTreatmentPackage(), testDetail,
				"In Progress", cost, specialist, smipleFormat.format(today), smipleFormat.format(endDate));
		treatmentPlanRepo.save(treatmentPlan);
		return treatmentPlan;
	}

	@Override
	public List<PatientDetail> getAllPatients() {
		// TODO Auto-generated method stub
		return (List<PatientDetail>) patientDetailRepository.findAll();
	}

	@Override
	public PatientDetail getPatient(long id) throws PatientNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("start");
		return patientDetailRepository.findById(id).orElseThrow(() -> new PatientNotFoundException());
	}

	@Override
	public List<TreatmentPlan> getAllTreatmentPlans() {
		// TODO Auto-generated method stub
		return treatmentPlanRepo.findAll();
	}

	@Override
	public TreatmentPlan getTreatmentPlan(long id) throws TreatmentPlanNotFoundException {
		// TODO Auto-generated method stub
		return treatmentPlanRepo.findById(id).orElseThrow(() -> new TreatmentPlanNotFoundException());
	}

}
