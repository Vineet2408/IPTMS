package com.cts.portal.model;

public class IPTreatmentPackages {

	private int id;
	private String ailmentCategory;
	PackageDetail packageDetail;

	public IPTreatmentPackages() {
		super();
	}

	public IPTreatmentPackages(int id, String ailmentCategory, PackageDetail packageDetail) {
		super();
		this.id = id;
		this.ailmentCategory = ailmentCategory;
		this.packageDetail = packageDetail;
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

	@Override
	public String toString() {
		return "IPTreatmentPackages [id=" + id + ", ailmentCategory=" + ailmentCategory + ", packageDetail="
				+ packageDetail + "]";
	}
}
