package com.cts.portal.model;

public class UserCredential 
{
	private String name;
	private String role;
	private String password;
	
	public UserCredential() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserCredential(String name, String role, String password) {
		super();
		this.name = name;
		this.role = role;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserCredential [name=" + name + ", role=" + role + ", password=" + password + "]";
	}
	
}
