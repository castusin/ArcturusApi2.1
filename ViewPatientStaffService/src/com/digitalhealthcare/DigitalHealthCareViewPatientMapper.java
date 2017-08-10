package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
public class DigitalHealthCareViewPatientMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	DigitalHealthCareViewPatientModel viewPatientstaff = new DigitalHealthCareViewPatientModel();
	   
	viewPatientstaff.setFname(rs.getString("Fname"));
	viewPatientstaff.setLname(rs.getString("Lname"));
	//viewPatientstaff.setPatientId(rs.getString("Patient_id"));
	//viewPatientstaff.setStaffId(rs.getInt("Staff_id"));
	//viewPatientstaff.setAptPersonId(rs.getString("Apt_person_id"));
	
	   
	   return viewPatientstaff;
	}
}
