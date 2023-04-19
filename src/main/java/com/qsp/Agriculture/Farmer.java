package com.qsp.Agriculture;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Farmer {
	@Id
	private int id;
	@Column(nullable=false)
	private String name;
	private String location;
	@Column(unique=true)
	private int mbn;
	private String email;
	private String pass;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMbn() {
		return mbn;
	}
	public void setMbn(int mbn) {
		this.mbn = mbn;
	}
	
	 
	 

}
