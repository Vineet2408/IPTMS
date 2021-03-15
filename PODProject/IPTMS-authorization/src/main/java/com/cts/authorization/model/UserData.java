package com.cts.authorization.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/** Model class for the business details */
@Entity
public class UserData {

	public UserData() {
		super();
	}
	

	@Id
	private String uname;
	private String userid;

	
	private String upassword;
	
	private String authToken;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public UserData(String userid,  String uname,String upassword, String authToken) {
		super();
		this.userid = userid;
		this.upassword = upassword;
		this.uname = uname;
		this.authToken = authToken;
	}

	@Override
	public String toString() {
		return "UserData [userid=" + userid + ", upassword=" + upassword + ", uname=" + uname + ", authToken="
				+ authToken + "]";
	}


	

}
