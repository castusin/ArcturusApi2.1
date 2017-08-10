package com.digitalhealthcare;


public class DigitalHealthCareIncidentReportModel {
	
	
	public String patientId;
	public String userId;
	public String incidentType;
	public String staffFname;
	public String staffLname;
	public String incidentComment;
	public String aptId;
	public DigitalHealthCareIncidentReportModel(String patientId, String userId, String incidentType, String staffFname, String staffLname, String incidentComment, String aptId) {
		super();
		this.patientId = patientId;
		this.userId=userId;
		this.incidentType=incidentType;
		this.staffFname=staffFname;
		this.staffLname=staffLname;
		this.incidentComment=incidentComment;
		this.aptId=aptId;
	}

	public String getAptId() {
		return aptId;
	}

	public void setAptId(String aptId) {
		this.aptId = aptId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public String getStaffFname() {
		return staffFname;
	}

	public void setStaffFname(String staffFname) {
		this.staffFname = staffFname;
	}

	public String getStaffLname() {
		return staffLname;
	}

	public void setStaffLname(String staffLname) {
		this.staffLname = staffLname;
	}

	public String getIncidentComment() {
		return incidentComment;
	}

	public void setIncidentComment(String incidentComment) {
		this.incidentComment = incidentComment;
	}

	public DigitalHealthCareIncidentReportModel()
	{}
}
