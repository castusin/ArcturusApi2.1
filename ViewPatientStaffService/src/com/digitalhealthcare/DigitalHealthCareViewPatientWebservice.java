
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigitalHealthCareViewPatientWebservice {

	public CISResults viewPatientStaff(String patientId) {
		DigitalHealthCareViewPatientBL viewPatientBL = new DigitalHealthCareViewPatientBL();
		 Logger logger = Logger.getLogger(DigitalHealthCareViewPatientWebservice.class);
		 CISResults cisResult = viewPatientBL.viewPatientStaff(patientId);
		 logger.info(" DigitalHealthCare: view patient staff webservice :"+cisResult);
		return cisResult;
	}

}
