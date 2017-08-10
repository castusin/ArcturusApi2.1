package com.digitalhealthcare;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigitalHealthCareIncidentReportDAO extends JdbcDaoSupport {

	public CISResults getPatientName(String patientId) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//DigitalHealthCarePatientModel getPatientEmail=new DigitalHealthCarePatientModel();
		Object[] inputs = new Object[]{patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 DigiHealthCarePatientsModel res=(DigiHealthCarePatientsModel)getJdbcTemplate().queryForObject(DigitalHealthCareReferFriendQuery.SQL_GETPATIENTEMAIL,inputs,new DigitalHealthCarePatientsMapper());
		   	 //String emailId=getPatientEmail.getEmailId();
			 cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("patient email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	public CISResults messageTextIncident(String messageId, String aptId,
			String patientId,String userId, String phoneNumber, String patientEmail,
			String subject, String createDate, String messageType) {


		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		Object[] inputs = new Object[]{subject,patientId,aptId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigitalHealthCareIncidentReportQuery.SQL_MESSAGETEXT,messageId,aptId,patientId,userId,phoneNumber,patientEmail,subject,createDate,messageType);
				 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("message query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	
	//

}
