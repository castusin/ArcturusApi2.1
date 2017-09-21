package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigitalHealthCareIncidentReportBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigitalHealthCareIncidentReportDAO incidentReportDAO=(DigitalHealthCareIncidentReportDAO)ctx.getBean("IncidentReport");
	// private static final AtomicInteger count = new AtomicInteger(111101);
	public CISResults incidentReport(DigitalHealthCareIncidentReportModel report) throws Throwable{
		
		 final Logger logger = Logger.getLogger(DigitalHealthCareIncidentReportBL.class);
		
		 EmailCommunication sendMail=new EmailCommunication();
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
	     
	     String sessionId = UUID.randomUUID().toString();
	     String messageId=DigestUtils.sha1Hex(sessionId);
	     String  upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
	     messageId=upToNCharacters;
	        
	     //String patientEmail=report.getEmailId();
	     String DirectorEmail=CISConstants.DIRECTOREMAIL;
	     // why this hard coded here?
	     String message=report.getIncidentComment();
	     String incidentType=report.getIncidentType();
	     String cc= CISConstants.EMAILUSERNAME ;
         String bcc= CISConstants.ADMINEMAILID ;
         String firstName=report.getStaffFname();
         String lastName=report.getStaffLname();
         String patientId=report.getPatientId();
         String aptId=report.getAptId();
         String userId=report.getUserId();
         CISResults cisResult=incidentReportDAO.getPatientName(patientId);
			
        //   patientFirstName plz take proper names 
         DigiHealthCarePatientsModel  patientFirstName=(DigiHealthCarePatientsModel)cisResult.getResultObject();
		 String  patientFname=patientFirstName.getFirstName();
		  
		 String  patientLname=patientFirstName.getLastName();
		 String patientEmail=patientFirstName.getEmailId();
		 String messageType=CISConstants.SENT;
		 String subject="Your complaint has been submitted";
         String phoneNumber="19440069067";
         if(incidentType.equalsIgnoreCase(CISConstants.INCIDENTTYPEMISSED)){
        	
	     cisResult=sendMail.sendIncidentReportMail(firstName,lastName,patientFname,patientLname,DirectorEmail,message,cc,bcc);
	     
         }else   if(incidentType.equalsIgnoreCase(CISConstants.INCIDENTTYPECOMPLAINT)){
        	
        	 cisResult=sendMail.sendIncidentReportComplaintMail(firstName,lastName,patientFname,patientLname,DirectorEmail,message,cc,bcc);
     	    
         }else   if(incidentType.equalsIgnoreCase(CISConstants.INCIDENTTYPESUPPLIES)){
        	
        	 cisResult=sendMail.sendIncidentReportSuppliesMail(firstName,lastName,patientFname,patientLname,DirectorEmail,message,cc,bcc);
     	    
         }
	     // cisResult=smsCommunicaiton.sendIncidentReportSMS(phoneNumber,message);
	     cisResult=incidentReportDAO.messageTextIncident(messageId,aptId,patientId,userId,phoneNumber,patientEmail,message,createDate,messageType,incidentType);
			 
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 logger.info("Database time for incident report message service:: " +result );
		 return cisResult;
	}


}