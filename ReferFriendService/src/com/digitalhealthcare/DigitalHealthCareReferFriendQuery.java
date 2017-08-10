package com.digitalhealthcare;

public class DigitalHealthCareReferFriendQuery {
	
	public static final String SQL_REFERFRIEND ="insert into ReferFriend_table(patientId,familyMemeberId,friendName,emailId,phoneNumber,freeText,datetime)"+"values(?,?,?,?,?,?,?)";

	public static String SQL_GETPATIENTEMAIL = " select First_name,Last_name,Phone_no,Email_id from Profile_table where User_id= ? "; 

}
