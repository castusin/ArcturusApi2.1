
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigitalHealthCareViewPatientBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigitalHealthCareViewPatientDAO viewPatientDAO=(DigitalHealthCareViewPatientDAO)ctx.getBean("ViewPatientStaff");


	public CISResults viewPatientStaff(String patientId) {
		final Logger logger = Logger.getLogger(DigitalHealthCareViewPatientBL.class);
		CISResults cisResult = viewPatientDAO.viewPatientStaff(patientId);
		logger.info("DigitalHealthCare:view patient staff BL  service" +cisResult );
		return cisResult;
	}
	

}
