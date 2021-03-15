package com.cts.portal.model;


public class SpecialistDetail {
	

	private int id;
	private String name;
	private String areaOfExpertise;
	private int experienceInYears;
	private String contactNumber;
	
	public SpecialistDetail() {
		super();
	}

	public SpecialistDetail(int id, String name, String areaOfExpertise, int experienceInYears, String contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.areaOfExpertise = areaOfExpertise;
		this.experienceInYears = experienceInYears;
		this.contactNumber = contactNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaOfExpertise() {
		return areaOfExpertise;
	}

	public void setAreaOfExpertise(String areaOfExpertise) {
		this.areaOfExpertise = areaOfExpertise;
	}

	public int getExperienceInYears() {
		return experienceInYears;
	}

	public void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "SpecialistDetail [id=" + id + ", name=" + name + ", areaOfExpertise=" + areaOfExpertise
				+ ", experienceInYears=" + experienceInYears + ", contactNumber=" + contactNumber + "]";
	}
	
}
