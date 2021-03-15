package com.cts.portal.model;

import org.springframework.stereotype.Component;

@Component
public class TreatmentPlan {

	private long treatmentPlanId;

	private PatientDetail patientDetail;
	private String packageName;
	private String testDetail;
	private String status;
	private double cost;
	private String specialist;
	private String treatmentCommencementDate;
	private String treatmentEndDate;

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

	public String getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}

	public void setTreatmentCommencementDate(String treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	public String getTreatmentEndDate() {
		return treatmentEndDate;
	}

	public void setTreatmentEndDate(String treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}

	public TreatmentPlan(PatientDetail patientDetail, String packageName, String testDetail, String status, double cost,
			String specialist, String treatmentCommencementDate, String treatmentEndDate) {
		super();
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

	public TreatmentPlan(long treatmentPlanId, PatientDetail patientDetail, String packageName, String testDetail,
			String status, double cost, String specialist, String treatmentCommencementDate, String treatmentEndDate) {
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

	@Override
	public String toString() {
		return "TreatmentPlan [treatmentPlanId=" + treatmentPlanId + ", patientDetail=" + patientDetail
				+ ", packageName=" + packageName + ", testDetail=" + testDetail + ", status=" + status + ", cost="
				+ cost + ", specialist=" + specialist + ", treatmentCommencementDate=" + treatmentCommencementDate
				+ ", treatmentEndDate=" + treatmentEndDate + "]";
	}

}
