package com.sap.selenium.c4c.testcases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AccountOWL;
import com.sap.selenium.c4c.components.AccountQC;
//import com.sap.selenium.c4c.components.AccountQC;
import com.sap.selenium.c4c.components.AccountTI;
import com.sap.selenium.c4c.components.AppointmentQC;
import com.sap.selenium.c4c.components.ContactQC;
import com.sap.selenium.c4c.components.PerformanceRunner;
import com.sap.selenium.c4c.components.PerformanceTest;
//import com.sap.selenium.c4c.scripts.Account;
//import com.sap.selenium.c4c.scripts.Login;


import com.sap.selenium.c4c.components.TestDataLoader;
import com.sap.selenium.c4c.scripts.Account;
import com.sap.selenium.c4c.scripts.Appointment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTestScenario extends PerformanceTest {

	@Before
    public void setUp() throws Exception {
		AccessHelper.login("English");
    }
                
    @After
    public void tearDown() throws Exception {
    	AccessHelper.logout("English");
    }

/*
	@Test
	public void testCreateFromFile()
	{
		Account account = new Account(driver);
		
		
	//	account.createAccountsFromFile("com/sap/selenium/c4c/TestCase/TestData/TestData.xlsx");
	}
   */
    
    
 /*
	@Test
	public void getUITexts() throws InterruptedException
	{
		Account account = new Account(driver);
		toolArea.openAccountQC();
		Thread.sleep(5000);
		
		try {
			account.getAccountQC().addTextsToFile("com/sap/selenium/c4c/TestCase/TestData/LanguageData.xlsx", "English");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(5000);
		
	}

*/


	@Test
	public void testOpenAccount() throws Exception
	{
		Account account = new Account(driver);
		
		account.navigate("CUSTOMERS", "ACCOUNTS");
		
	
		toolArea.openAccountQC();
		
		
		Map<String, String>data = new LinkedHashMap<String, String>();
		data.put(AccountQC.NAME, "SpiceTest777");
		data.put(AccountQC.COUNTRY, "US");
		data.put(AccountQC.STATE, "CA");
		data.put(AccountQC.CITY, "San Francisco");
		data.put(AccountQC.PROSPECT, "X");
		data.put(AccountQC.CLASSIFICATION, "A");
		data.put(AccountQC.WEBSITE, "www.test.com");
		
		account.createAccountFromNew(data, "SAVE");
		
		
				
		account.openAccount("SpiceTest777", AccountOWL.SIMPLE_SEARCH_FILTER_ALL);
		
		account.getAccountTI().edit();
		
		account.getAccountTI().save();
		
		account.getAccountTI().changeTabToActivities();
		
		
		account.getAccountTI().changeTabToContacts();
		
		Map<String, String>contactData = new LinkedHashMap<String, String>();
		 
		contactData.put(ContactQC.FIRSTNAME, "Nice first one");
		contactData.put(ContactQC.LASTNAME, "Nice last one");
	
		
		account.getAccountTI().addContact(contactData);
				
		account.getAccountTI().close();
	
	}
  
  
    /*
	@Test
	public void testAppointment()
	{
		
		Appointment appointment = new Appointment(driver);
		
	    toolArea.openAppointmentQC();
	    
		Map<String, String>data = new LinkedHashMap<String, String>();
		 
		data.put(AppointmentQC.SUBJECT_ELEMENT_ID, "Nice first one");
		data.put(AppointmentQC.ACCOUNT_VALUE_HELP_ELEMENT_ID, "SpiceCorporation");
	    
	    appointment.createAppointment(data);
		
	    //appointment.closeAppointment();
	}
    */
    /*
	@Test
	public void testTop20()
	{
		
		Account account = new Account(driver);
		
	//    toolArea.openAccountQC();
	//    account.createAccountFromFile("com/sap/selenium/c4c/TestCase/TestData/TestData.xlsx");
	    
	    
		Map<String, String>data = new LinkedHashMap<String, String>();
		 
		data.put(ContactQC.FIRST_NAME_FIELD, "Nice first one");
		data.put(ContactQC.LAST_NAME_FIELD, "Nice last one");
	    account.editAccountToAddContact("SpiceFromFile", data);
	    
	    account.closeAccount();
	}
	*/
    /*
	@Test
	public void testEdit()
	{
		
		Account account = new Account(driver);
		
		Map<String, String>data = new LinkedHashMap<String, String>();
		 
		data.put(ContactQC.FIRST_NAME_FIELD, "Nice first one");
		data.put(ContactQC.LAST_NAME_FIELD, "Nice last one");
		account.editAccountToAddContact("Spice", data);

		data.clear();
		 
		data.put(AccountTI.ADDRESS_DIALOG_COUNTRY_FIELD, "US");
		data.put(AccountTI.ADDRESS_DIALOG_STATE_FIELD, "CA");
		data.put(AccountTI.ADDRESS_DIALOG_CITY_FIELD, "San Francisco");
		data.put(AccountTI.ADDRESS_DIALOG_POSTAL_CODE_FIELD, "94109");
	
		account.editAccountToAddAddress("Spice", data);
				
		account.closeAccount();		
	}
*/


/*	
	
	@Test
	public void testCreate()
	{
		Account account = new Account(driver);
		//todo: fix the access to teh toolbar so that it can be called from anywhere!!!!
		toolArea.openAccountQCAndMeasure("test");
		
		Map<String, String>data = new LinkedHashMap<String, String>();
		data.put(AccountQC.NAME_ELEMENT, "SpiceTest");
		data.put(AccountQC.COUNTRY_ELEMENT, "US");
		data.put(AccountQC.STATE_ELEMENT, "CA");
		data.put(AccountQC.CITY_ELEMENT, "San Francisco");
		data.put(AccountQC.PROSPECT_ELEMENT, "X");
		data.put(AccountQC.CLASSIFICATION_ELEMENT, "A");
		data.put(AccountQC.WEBSITE_ELEMENT, "www.test.com");
		account.createAccount(data);
	
	}

*/

}
