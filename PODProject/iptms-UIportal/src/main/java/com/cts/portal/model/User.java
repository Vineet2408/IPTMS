package com.cts.portal.model;

public class User 
{
	private String name;
	private int age;
	private String ailment;
	
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAilment() {
		return ailment;
	}
	public void setAilment(String ailment) {
		this.ailment = ailment;
	}
	public User(String name, int age, String ailment) {
		super();
		this.name = name;
		this.age = age;
		this.ailment = ailment;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", ailment=" + ailment + "]";
	}
	
}
