package com.sap.selenium.c4c.testcases;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AccountOWL;
import com.sap.selenium.c4c.components.AccountQC;
import com.sap.selenium.c4c.components.AccountTI;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.scripts.Account;
import com.sap.selenium.c4c.scripts.Task;

public class AccountTest extends PerformanceTest{
		
	@Before
	public void setUp() throws Exception {
		AccessHelper.login("German");
	}

	@After
	public void tearDown() throws Exception {
		AccessHelper.logout("German");
	}

	@Test
	public void test() throws Exception {
		String accname = AccessHelper.getname(1);
		
		Account account = new Account(driver);
		
		//Create account from Toolbar
		Map<String, String>accountdataQC = new LinkedHashMap<String, String>();
		accountdataQC.put(AccountQC.NAME, accname);
		accountdataQC.put(AccountQC.COUNTRY, "US");
		accountdataQC.put(AccountQC.WEBSITE,"www.sap.com");
		accountdataQC.put(AccountQC.CITY,"HOUSTON");
		accountdataQC.put(AccountQC.STATE,"TX");
		account.createAccountFromToolBar(accountdataQC, "SAVE");
		
		//Open Account
		//account.navigate("CUSTOMERS", "ACCOUNTS");
		//account.openAccount(accname, "All");
		
		account.navigate("KUNDEN", "KUNDEN"); 
		account.openAccount(accname, "Alle");
		
		//Edit Account Summary information
		Map<String, String>accountdataTI = new LinkedHashMap<String, String>();
		accountdataTI.put(AccountTI.COUNTRY, "US");
		accountdataTI.put(AccountTI.HOUSENUMBER, "256");
		accountdataTI.put(AccountTI.STREET, "Joshua Tree Ln");
		accountdataTI.put(AccountTI.CITY, "Austin");
		accountdataTI.put(AccountTI.POSTALCODE, "77389");
		accountdataTI.put(AccountTI.PHONE, "111-111-1111");
		accountdataTI.put(AccountTI.FAX, "111-111-1112");
		//accountdataTI.put(AccountTI.CLASSIFICATION, "A-Account");
		//accountdataTI.put(AccountTI.INDUSTRY, "Construction");
		account.editAccountSummary(accountdataTI);
		account.saveAccount();
		
		//Add contact to Account
		Map<String, String>accountContact = new LinkedHashMap<String, String>();		
		accountContact.put(AccountTI.FIRSTNAME, "Frank");
		accountContact.put(AccountTI.LASTNAME, "Bach");
		accountContact.put(AccountTI.JOBTITLE, "Manager");
		//accountContact.put(AccountTI.FUNCTION, "Distributor");
		//accountContact.put(AccountTI.DEPARTMENT, "Import Dept");
		accountContact.put(AccountTI.PHONE, "111-111-1111");
		accountContact.put(AccountTI.EMAIL, "email@domain.com");
		account.addContact(accountContact);		
		account.closeAccount();
			
	}

}
