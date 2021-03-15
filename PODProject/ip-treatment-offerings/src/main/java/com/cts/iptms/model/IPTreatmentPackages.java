package com.cts.iptms.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Treatment Packages")
public class IPTreatmentPackages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes="Unique ID for each Package")
	private int id;
	@ApiModelProperty(notes="Ailment Name")
	private String ailmentCategory;
	@Embedded
	@ApiModelProperty(notes="Treatment Package Details")
	PackageDetail packageDetail;

	@Override
	public String toString() {
		return "IPTreatmentPackages [id=" + id + ", ailmentCategory=" + ailmentCategory + ", packageDetail="
				+ packageDetail + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAilmentCategory() {
		return ailmentCategory;
	}

	public void setAilmentCategory(String ailmentCategory) {
		this.ailmentCategory = ailmentCategory;
	}

	public PackageDetail getPackageDetail() {
		return packageDetail;
	}

	public void setPackageDetail(PackageDetail packageDetail) {
		this.packageDetail = packageDetail;
	}

	public IPTreatmentPackages(int id, String ailmentCategory, PackageDetail packageDetail) {
		super();
		this.id = id;
		this.ailmentCategory = ailmentCategory;
		this.packageDetail = packageDetail;
	}

	public IPTreatmentPackages() {
		super();
	}

}
