package com.sap.selenium.c4c.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AppointmentQC;
import com.sap.selenium.c4c.components.AppointmentTI;
import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.scripts.Appointment;

public class AppointmentTest extends PerformanceTest{
	//LoginLogout loginLogout = new LoginLogout();
	
	@Before
	public void setUp() throws Exception {
		AccessHelper.login("English");
	}

	@After
	public void tearDown() throws Exception {
	//	loginLogout.logout();
		AccessHelper.logout("English");
	}

	@Test
	public void ApptTest() throws Exception {
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //new SimpleDateFormat("MM/dd/yyyy"); DD.MM.YYYY
	    Date date = new Date(); 
	    date=AccessHelper.addDays(date,7);
	    String dateStr = dateFormat.format(date).toString();
		String objectname = AccessHelper.getname(4);
		
		Map<String, String> data = new HashMap<String, String>();
		data.put(AppointmentQC.SUBJECT_ELEMENT_ID, objectname); 
		data.put(AppointmentQC.ACCOUNT_VALUE_HELP_ELEMENT_ID, "walmart" );  //PerformanceRunner.getProperty("Account_Appointment")
		data.put(AppointmentQC.PRIMARY_CONTACT_VALUE_HELP_ELEMENT_ID, "");
		data.put(AppointmentQC.TO_DATE_ELEMENT_ID, dateStr); 
		data.put(AppointmentQC.CATEGORY_ELEMENT_ID, "Customer visit"); 
		data.put(AppointmentQC.PRIORITY_ELEMENT_ID, "Normal"); 
		data.put(AppointmentQC.OWNER_VALUE_HELP_ELEMENT_ID, "");
		data.put(AppointmentQC.TERRITORY_VALUE_HELP_ELEMENT_ID, "");
		data.put(AppointmentQC.NOTES, "Appointment created from selenium");
		data.put(AppointmentQC.LOCATION, "Palo Alto");
		
		Appointment appointment = new Appointment(driver);
		
		//QC of Appointment
		appointment.quickCreateAppointment(data);
		
		Thread.sleep(5000);
		
		//Generate Summary
		appointment.generateSummary();
		
		Thread.sleep(5000);

		//Add attachments
		appointment.addAttachments("www.sap.com","Link Title");
		
		Thread.sleep(5000);
		
		//Add involved parties
		appointment.addInvolvedParties();
		
		Thread.sleep(5000);
		
		//status change to inprocess
		appointment.setToInProcess();
		
		Thread.sleep(5000);
		
		//save
		appointment.saveAppointment();
		
		Thread.sleep(5000);
		
		//Change to feed
		appointment.changeToFacetFeed();
		
		Thread.sleep(5000);
		
		//check if edit is not enabled.
		appointment.checkNotEditable();
		
		Thread.sleep(5000);
		
		//Change to related items
		appointment.changeToFacetRelatedItems();
		
		Thread.sleep(5000);
		
		//Add related items and follow up items
		appointment.addRelatedItemsAppointments();
		
		Thread.sleep(5000);
		
		//Add follow up items
		appointment.addFollowupItemsAppointments();
		
		Thread.sleep(5000);
		
		//delete follow up and related items
		appointment.deleteFromFollowup();
		
		Thread.sleep(5000);
		
		appointment.deleteFromRelatedItems();
		
		Thread.sleep(5000);
		
		//Edit fields on header
		appointment.editHeaderAppointments();
		
		Thread.sleep(5000);
		
		//change status to completed
		appointment.completeAppointment();
		
		Thread.sleep(5000);
		
		appointment.saveAppointment();
		
		Thread.sleep(5000);
		
		//Change to changes
		appointment.changeToFacetChanges();
		
		Thread.sleep(5000);
		
		//edit
		appointment.editAppointment();
		
		Thread.sleep(5000);
		
		//check for entries for logged in user
		appointment.checkChangesAppointments();
		
		Thread.sleep(5000);
		
		//Save
		appointment.saveAppointment();
		
		Thread.sleep(5000);
		
		//change status to cancelled.
		appointment.cancelAppointment();
		
		Thread.sleep(5000);
		
		//Save
		appointment.saveAppointment();
		
		Thread.sleep(5000);
		
		//close appointment
		appointment.closeAppointment();
		
	}

}
