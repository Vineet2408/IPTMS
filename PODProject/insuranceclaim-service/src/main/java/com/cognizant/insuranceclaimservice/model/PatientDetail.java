package com.cognizant.insuranceclaimservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class PatientDetail {

	@Id
	private long patientId;
	private String name;
	private int age;
	private String treatmentPackage;
	private String ailment;
	private Date treatmentCommencementDate;
	
	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTreatmentPackage() {
		return treatmentPackage;
	}

	public void setTreatmentPackage(String treatmentPackage) {
		this.treatmentPackage = treatmentPackage;
	}

	public String getAilment() {
		return ailment;
	}

	public void setAilment(String ailment) {
		this.ailment = ailment;
	}

	public Date getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}

	public void setTreatmentCommencementDate(Date treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	public PatientDetail() {
		super();
	}

	public PatientDetail(long patientId, String name, int age, String treatmentPackage, String ailment,
			Date treatmentCommencementDate) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.treatmentPackage = treatmentPackage;
		this.ailment = ailment;
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	@Override
	public String toString() {
		return "PatientDetail [patientId=" + patientId + ", name=" + name + ", age=" + age + ", treatmentPackage=" + treatmentPackage
				+ ", ailment=" + ailment + ", treatmentCommencementDate=" + treatmentCommencementDate + "]";
	}

}
