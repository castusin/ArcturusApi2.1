package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISResults;


public class DigitalHealthCareIncidentReportWebservice {
	
	static Logger logger = Logger.getLogger(DigitalHealthCareIncidentReportWebservice.class);
	
	DigitalHealthCareIncidentReportBL incidentReportBL=new DigitalHealthCareIncidentReportBL();

	public CISResults incidentReport(DigitalHealthCareIncidentReportModel report) throws Throwable{
	CISResults cisResult = incidentReportBL.incidentReport(report);
	logger.info(" DigitalHealthCare:incident report webService :"+cisResult);
    return cisResult;
	}
}