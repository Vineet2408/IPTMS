package com.cts.iptms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Specialist Detail")
public class SpecialistDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique ID for each Specialist")
	private int id;
	@ApiModelProperty(notes = "Name of the Specialist")
	private String name;
	@ApiModelProperty(notes = "Area of the Specialist in which they Expertise")
	private String areaOfExpertise;
	@ApiModelProperty(notes = "Experience of Specialist")
	private int experienceInYears;
	@ApiModelProperty(notes = "Contact Number of the Specialist")
	private String contactNumber;

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

	public SpecialistDetail(int id, String name, String areaOfExpertise, int experienceInYears, String contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.areaOfExpertise = areaOfExpertise;
		this.experienceInYears = experienceInYears;
		this.contactNumber = contactNumber;
	}

	public SpecialistDetail() {
		super();
	}
}
