
package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigitalHealthCareReferFriendBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigitalHealthCareReferFriendDAO referFriendDAO=(DigitalHealthCareReferFriendDAO)ctx.getBean("ReferFriend");
	// private static final AtomicInteger count = new AtomicInteger(111101);
	public CISResults referFriend(DigitalHealthCareReferFriendModel referFriend){
		
		 final Logger logger = Logger.getLogger(DigitalHealthCareReferFriendBL.class);
		
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
	     String patientId=referFriend.getPatientId();
	     String friendEmail=referFriend.getEmailId();
	     String message=referFriend.getFreeText();
	     String friendPhone=referFriend.getPhoneNumber();
	     String friendName=referFriend.getFriendName();
		 CISResults cisResult = referFriendDAO.referFriend(referFriend.getPatientId(),referFriend.getFamilyMemeberId(),referFriend.getFriendName(),referFriend.getEmailId(),referFriend.getPhoneNumber(),referFriend.getFreeText(),createDate);
		
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	      {
			 			  
			  cisResult=referFriendDAO.getPatientEmail(patientId);
			
			  DigitalHealthCarePatientModel  patientEmailId=(DigitalHealthCarePatientModel)cisResult.getResultObject();
			  String  patientEmail=patientEmailId.getEmailId();
			  DigitalHealthCarePatientModel  patientFname=(DigitalHealthCarePatientModel)cisResult.getResultObject();
			  String  patientFirstName=patientFname.getFirstName();
			  DigitalHealthCarePatientModel  patientLname=(DigitalHealthCarePatientModel)cisResult.getResultObject();
			  String  patientLastName=patientLname.getLastName();
			  String cc= CISConstants.EMAILUSERNAME ;
              String bcc= CISConstants.EMAILUSERNAME ;
             
            // String subject="Your care plan schedule has been deleted.";
             String messageType=CISConstants.RECIEVED;;
            // String directorMail="udaykatikala@gmail.com";
            
			  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			   {
				  cisResult=sendMail.sendReferFriendMail(patientFirstName,patientLastName,patientEmail,friendEmail,friendPhone,friendName,message,cc,bcc);
				  cisResult=sendMail.sendReferFriendMailAdmin(patientFirstName,patientLastName,patientEmail,friendEmail,friendPhone,friendName,message,cc,bcc);
					 
			   }
	      }
		 
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for save staff member service:: " +result );
		  
		return cisResult;
	}


}