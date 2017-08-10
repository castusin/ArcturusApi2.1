package com.digitalhealthcare;

import java.sql.Date;

public class DigitalHealthCareViewPatientModel {
	
	public String fname;
	public String lname;
	public String patientId;
	//public int staffId;
	public String aptPersonId;
	
	public DigitalHealthCareViewPatientModel(String fname, String lname, String patientId, int staffId, String aptPersonId) {
		super();
		this.fname = fname;
		this.lname=lname;
		this.patientId=patientId;
		//this.staffId=staffId;
		this.aptPersonId=aptPersonId;

	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getPatientId() {
		return patientId;
	}



	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}



	/*public int getStaffId() {
		return staffId;
	}



	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}*/



	public String getAptPersonId() {
		return aptPersonId;
	}



	public void setAptPersonId(String aptPersonId) {
		this.aptPersonId = aptPersonId;
	}



	public DigitalHealthCareViewPatientModel()
	{}
}
