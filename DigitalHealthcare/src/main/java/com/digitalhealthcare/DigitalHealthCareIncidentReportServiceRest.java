package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Incident report Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareIncidentReportServiceRest {
	
	
	@RequestMapping(value="/incidentReport",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String incidentReport(HttpServletRequest request,@RequestBody DigitalHealthCareIncidentReportModel report) throws Throwable{
		 
		Logger logger = Logger.getLogger(DigitalHealthCareIncidentReportServiceRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.incidentReportValidation(request,report);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigitalHealthCareIncidentReportWebservice incidentReportWebservice= new DigitalHealthCareIncidentReportWebservice();
		    	cisResults  = incidentReportWebservice.incidentReport(report);
		        logger.info(" DigitalHealthCare: incident report rest service :"+cisResults);
		     }
		       return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
}
