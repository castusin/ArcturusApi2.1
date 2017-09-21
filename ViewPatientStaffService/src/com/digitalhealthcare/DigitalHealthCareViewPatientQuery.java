package com.digitalhealthcare;

public class DigitalHealthCareViewPatientQuery {
	
	public static final String SQL_VIEWPATIENTSTAFF ="SELECT DISTINCT  St.Fname, St.Lname from Staff_table St join Appointments_table At on St.Staff_id=At.Apt_person_id where At.Patient_id=?";

}
