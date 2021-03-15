package com.cts.portal.model;

import org.springframework.stereotype.Component;

@Component
public class PatientDetail {

	private long patientId;
	private String name;
	private int age;
	private String ailment;
	private String treatmentPackage;
	private String treatmentCommencementDate;

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

	public String getAilment() {
		return ailment;
	}

	public void setAilment(String ailment) {
		this.ailment = ailment;
	}

	public String getTreatmentPackage() {
		return treatmentPackage;
	}

	public void setTreatmentPackage(String treatmentPackage) {
		this.treatmentPackage = treatmentPackage;
	}

	public String getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}

	public void setTreatmentCommencementDate(String treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	public PatientDetail() {
		super();
	}

	public PatientDetail(String name, int age, String ailment, String treatmentPackage,
			String treatmentCommencementDate) {
		super();
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		this.treatmentPackage = treatmentPackage;
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	public PatientDetail(long patientId, String name, int age, String ailment, String treatmentPackage,
			String treatmentCommencementDate) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		this.treatmentPackage = treatmentPackage;
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	@Override
	public String toString() {
		return "PatientDetail [patientId=" + patientId + ", name=" + name + ", age=" + age + ", ailment=" + ailment
				+ ", treatmentPackage=" + treatmentPackage + ", treatmentCommencementDate=" + treatmentCommencementDate
				+ "]";
	}

}
