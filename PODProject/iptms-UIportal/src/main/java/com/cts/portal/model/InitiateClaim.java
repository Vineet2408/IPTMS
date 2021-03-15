package com.cts.portal.model;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class InitiateClaim {
	@NotNull
	@NumberFormat(style = Style.NUMBER)

	private long id;

	private long patientId;
	private String patientName;
	private String ailment;
	private String treatmentPackageName;
	private String insurerName;
	private double balance;
	private double treatmentCost;
	private double insurerAmountLimit;
	private String status;

	public double getInsurerAmountLimit() {
		return insurerAmountLimit;
	}

	public void setInsurerAmountLimit(double insurerAmountLimit) {
		this.insurerAmountLimit = insurerAmountLimit;
	}

	public double getTreatmentCost() {
		return treatmentCost;
	}

	public void setTreatmentCost(double treatmentCost) {
		this.treatmentCost = treatmentCost;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAilment() {
		return ailment;
	}

	public void setAilment(String ailment) {
		this.ailment = ailment;
	}

	public String getTreatmentPackageName() {
		return treatmentPackageName;
	}

	public void setTreatmentPackageName(String treatmentPackageName) {
		this.treatmentPackageName = treatmentPackageName;
	}

	public String getInsurerName() {
		return insurerName;
	}

	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}

	public InitiateClaim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	
	
	public InitiateClaim(long patientId, String patientName, String ailment, String treatmentPackageName,
			String insurerName, double balance, double treatmentCost, double insurerAmountLimit, String status) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.ailment = ailment;
		this.treatmentPackageName = treatmentPackageName;
		this.insurerName = insurerName;
		this.balance = balance;
		this.treatmentCost = treatmentCost;
		this.insurerAmountLimit = insurerAmountLimit;
		this.status = status;
	}

	public InitiateClaim( long id,  long patientId, String patientName, String ailment,
			String treatmentPackageName, String insurerName, double balance, double treatmentCost,
			double insurerAmountLimit, String status) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.patientName = patientName;
		this.ailment = ailment;
		this.treatmentPackageName = treatmentPackageName;
		this.insurerName = insurerName;
		this.balance = balance;
		this.treatmentCost = treatmentCost;
		this.insurerAmountLimit = insurerAmountLimit;
		this.status = status;
	}

	@Override
	public String toString() {
		return "InitiateClaim [id=" + id + ", patientId=" + patientId + ", patientName=" + patientName + ", ailment="
				+ ailment + ", treatmentPackageName=" + treatmentPackageName + ", insurerName=" + insurerName
				+ ", balance=" + balance + ", treatmentCost=" + treatmentCost + ", insurerAmountLimit="
				+ insurerAmountLimit + ", status=" + status + "]";
	}

	

}
