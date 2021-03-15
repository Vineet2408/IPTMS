package com.cts.portal.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InsurerDetail {
	
	private long id;
	@NotNull
	@Size(min = 1, max = 30, message = "Name should contain between 1 and 30 characters")
	private String insurerName;
	@NotNull
	@Size(min = 1, max = 30, message = "Name should contain between 1 and 30 characters")
	private String insurerPackageName;
	@NotNull
	private double insuranceAmountLimit;
	@NotNull
	private int disbursementDuration;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInsurerName() {
		return insurerName;
	}
	public void setInsurerName(String name) {
		this.insurerName = name;
	}
	public String getInsurerPackageName() {
		return insurerPackageName;
	}
	public void setInsurerPackageName(String insurerPackageName) {
		this.insurerPackageName = insurerPackageName;
	}
	public double getInsuranceAmountLimit() {
		return insuranceAmountLimit;
	}
	public void setInsuranceAmountLimit(double insurerAmountLimit) {
		this.insuranceAmountLimit = insurerAmountLimit;
	}
	public int getDisbursementDuration() {
		return disbursementDuration;
	}
	public void setDisbursementDuration(int disbursementDuration) {
		this.disbursementDuration = disbursementDuration;
	}
	
	public InsurerDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InsurerDetail(@NotNull int id,
			@NotNull @Size(min = 1, max = 30, message = "Name should contain between 1 and 30 characters") String insurerName,
			@NotNull @Size(min = 1, max = 30, message = "Name should contain between 1 and 30 characters") String insurerPackageName,
			@NotNull double insurerAmountLimit, @NotNull int disbursementDuration) {
		super();
		this.id = id;
		this.insurerName = insurerName;
		this.insurerPackageName = insurerPackageName;
		this.insuranceAmountLimit = insurerAmountLimit;
		this.disbursementDuration = disbursementDuration;
	}
	@Override
	public String toString() {
		return "InsurerDetail [id=" + id + ", insurerName=" + insurerName + ", insurerPackageName=" + insurerPackageName
				+ ", insuranceAmountLimit=" + insuranceAmountLimit + ", disbursementDuration=" + disbursementDuration + "]";
	}
}
