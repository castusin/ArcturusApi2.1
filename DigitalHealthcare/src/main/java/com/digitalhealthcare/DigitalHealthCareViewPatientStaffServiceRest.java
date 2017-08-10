package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : view patient staff Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareViewPatientStaffServiceRest {
	
	@RequestMapping(value="/viewPatientStaff",method=RequestMethod.GET,produces={"application/json"})

	 public String viewMessages(@RequestParam ("patientId") String patientId,HttpServletRequest request){
		    Logger logger = Logger.getLogger(DigitalHealthCareViewPatientStaffServiceRest.class);
			String viewPatientstaffParameters = "patientId=" +patientId;
		    logger.info(" DigitalHealthCare:view patient staff:"+viewPatientstaffParameters);
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.viewMessagesValidation(patientId,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigitalHealthCareViewPatientWebservice viewPatientWebservice= new DigitalHealthCareViewPatientWebservice();
		       cisResults  = viewPatientWebservice.viewPatientStaff(patientId);
		       logger.info(" DigitalHealthCare: view patient staff service :"+cisResults);
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
