package com.sap.selenium.c4c.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AppointmentQC;
import com.sap.selenium.c4c.components.EmailOWL;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.scripts.Appointment;
import com.sap.selenium.c4c.scripts.Email;


public class EmailTest extends PerformanceTest {

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
	public void emailTest() throws Exception {
		
		
			
		Email email = new Email(driver);
		
		email.openFirstEmail();
		Thread.sleep(5000);
		
		//Change to related items
		email.changeToFacetRelatedItems();
		
		Thread.sleep(5000);
		
		// Click on each facet one by one 
		email.changeToFacetFeed();
		email.changeToFacetChanges();
		email.changeToFacetRelatedItems();
		email.changeToFacetAttachments();
		
		
		//close email
		email.closeEmail();
		
	}

}
