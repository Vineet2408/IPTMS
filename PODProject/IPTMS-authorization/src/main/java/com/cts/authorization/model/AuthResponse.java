package com.cts.authorization.model;

public class AuthResponse 
{
	
	private String uid;

	private String name;

	private boolean isValid;

	private String jwt;
	
	

	@Override
	public String toString() {
		return "AuthResponse [uid=" + uid + ", name=" + name + ", isValid=" + isValid + ", jwt=" + jwt + "]";
	}

	public AuthResponse() {
		super();
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public AuthResponse(String uid, String name, boolean isValid, String jwt) {
		super();
		this.uid = uid;
		this.name = name;
		this.isValid = isValid;
		this.jwt = jwt;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}


}
