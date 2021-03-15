package com.cognizant.insuranceclaimservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class TreatmentPlan {

	@NotNull
	@Id
	private long treatmentPlanId;
	
	@ManyToOne( fetch = FetchType.EAGER, targetEntity = PatientDetail.class)
	@JoinColumn(name = "tp_pt_id")
	private PatientDetail patientDetail;
	private String packageName;
	private String testDetail;
	private String status;
	private double cost;
	private String specialist;
	private Date treatmentCommencementDate;
	private Date treatmentEndDate;

	public long getTreatmentPlanId() {
		return treatmentPlanId;
	}

	public void setTreatmentPlanId(long treatmentPlanId) {
		this.treatmentPlanId = treatmentPlanId;
	}

	public PatientDetail getPatientDetail() {
		return patientDetail;
	}

	public void setPatientDetail(PatientDetail patientDetail) {
		this.patientDetail = patientDetail;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getTestDetail() {
		return testDetail;
	}

	public void setTestDetail(String testDetail) {
		this.testDetail = testDetail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public Date getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}

	public void setTreatmentCommencementDate(Date treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	public Date getTreatmentEndDate() {
		return treatmentEndDate;
	}

	public void setTreatmentEndDate(Date treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}

	

	public TreatmentPlan(@NotNull long treatmentPlanId, PatientDetail patientDetail, String packageName,
			String testDetail, String status, double cost, String specialist, Date treatmentCommencementDate,
			Date treatmentEndDate) {
		super();
		this.treatmentPlanId = treatmentPlanId;
		this.patientDetail = patientDetail;
		this.packageName = packageName;
		this.testDetail = testDetail;
		this.status = status;
		this.cost = cost;
		this.specialist = specialist;
		this.treatmentCommencementDate = treatmentCommencementDate;
		this.treatmentEndDate = treatmentEndDate;
	}

	public TreatmentPlan() {
		super();
	}

	@Override
	public String toString() {
		return "TreatmentPlan [treatmentPlanId=" + treatmentPlanId + ", patientDetail=" + patientDetail
				+ ", packageName=" + packageName + ", testDetail=" + testDetail + ", status=" + status + ", cost="
				+ cost + ", specialist=" + specialist + ", treatmentCommencementDate=" + treatmentCommencementDate
				+ ", treatmentEndDate=" + treatmentEndDate + "]";
	}

}
