package com.sap.selenium.c4c.testcases;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.MarketingLeadQC;
import com.sap.selenium.c4c.components.OpportunityConversionQC;
import com.sap.selenium.c4c.components.PerformanceTest;

import com.sap.selenium.c4c.scripts.MarketingLead;

public class MarketingLeadTest_senerio_3 extends PerformanceTest {

	@Before
	public void setUp() throws Exception {

		AccessHelper.login("English");
	}

	@After
	public void tearDown() throws Exception {
		//AccessHelper.logout("English");
	}

	@Test
	public void testCreate() throws InterruptedException {

		Map<String, String> data = null;
		MarketingLead ml = new MarketingLead(driver, "testCreate");

		/*
		 * Step 1: -------
		 * 
		 * Navigate to Sales/ mlortunities Create mlortunity from Short Cuts
		 * Area ( tool Area ) and Open the mlortunity TI after creation
		 */
		ml.navigate("MARKETING", "LEADS");

//		
		// Create Marketing Lead with Existing account
		 data = new LinkedHashMap<String, String>();
		 data.put(MarketingLeadQC.USE_EXISTING_ACCOUNT, "true");
		 data.put(MarketingLeadQC.NAME, "Rahul_ML_21");
		 data.put(MarketingLeadQC.ACCOUNT, "1316589");
//		 data.put(MarketingLeadQC.CONTACT, "Rahul_Sel_test__1");
		 data.put(MarketingLeadQC.STATUS, "Open");
		 //data.put(MarketingLeadQC.QUALIFICATION_LEVEL, "Hot");
		 //data.put(MarketingLeadQC.SOURCE, "Campaign");
		 //data.put(MarketingLeadQC.CATEGORY, "Prospect for service");
		 //data.put(MarketingLeadQC.PRIORITY, "Low");
//		 data.put(MarketingLeadQC.STARTDATE, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.ENDDATE, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.CAMPAIGN, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.OWNER, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.MARKETINGUNIT, "Rahul_Sel_test__1");
		 data.put(MarketingLeadQC.NOTE, "Rahul_Sel_test__1");
		 ml.createMarketingLead(data, "SAVE");
		
//		// Create Marketing Lead with Non Existing account
//				 data = new LinkedHashMap<String, String>();
//				 data.put(MarketingLeadQC.USE_EXISTING_ACCOUNT, "False");
//				 data.put(MarketingLeadQC.NAME, "Rahul_ML_3");
//				 data.put(MarketingLeadQC.COMPANY, "1316589");
//				 data.put(MarketingLeadQC.CONTACT_FIRST_NAME, "Rahul_Sel_test_3");
//				 data.put(MarketingLeadQC.CONTACT_LAST_NAME, "Qualified");
//				 data.put(MarketingLeadQC.STATUS, "Open");
//				 data.put(MarketingLeadQC.QUALIFICATION_LEVEL, "hot");
//				 data.put(MarketingLeadQC.SOURCE, "Campaign");
//				 data.put(MarketingLeadQC.CATEGORY, "Prospect for service");
//				 data.put(MarketingLeadQC.PRIORITY, "low");
////				 data.put(MarketingLeadQC.STARTDATE, "Rahul_Sel_test__1");
////				 data.put(MarketingLeadQC.ENDDATE, "Rahul_Sel_test__1");
////				 data.put(MarketingLeadQC.CAMPAIGN, "Rahul_Sel_test__1");
////				 data.put(MarketingLeadQC.OWNER, "Rahul_Sel_test__1");
////				 data.put(MarketingLeadQC.MARKETINGUNIT, "Rahul_Sel_test__1");
//				 data.put(MarketingLeadQC.NOTE, "Rahul_Sel_test__1");
//				 data.put(MarketingLeadQC.CITY, "CITY");
//				 data.put(MarketingLeadQC.COUNTRY, "US");
//				 data.put(MarketingLeadQC.STATE, "ca");
//				 data.put(MarketingLeadQC.PHONE, "12345678");
//				 data.put(MarketingLeadQC.MOBILE, "098765432");
//				 data.put(MarketingLeadQC.EMAIL, "ABC@GMAIL.COM");
//				 
//				 ml.createMarketingLead(data, "OPEN");

		
		 ml.searchandOpenMarketingLead("Rahul_ML_21", "All");

		/*
		 * Step 2: ------- Actions: convert to opportunity
		 */

		 Thread.sleep(10000);
		 Map<String, String> oppData = new LinkedHashMap<String, String>();
		 oppData.put(OpportunityConversionQC.EXPECTED_VALUE, "100-Afghani");
		 ml.MarketingLead_ConvertToOpportunity(oppData);
		 System.out.println("Test 3 passed");
		
		
		// /*
		// * Step 18: -------
		// *
		// * Close the Marketing Lead Thing Inspector
		// */
		//
		// Thread.sleep(2000);
		//
		// ml.closeMarketingLead();
		//
		// /*
		// * Step 19: -------
		// *
		// * Naviagte to Work Center and Work Center View Filter and Search for
		// * created mlortunity Open the searched mlorutnity
		// */
		//
		// ml.navigate("MARKETING", "LEADS");
		//
		// ml.searchandOpenMarketingLead("MarketingLeadName", "filterName");
		//
	}
}
