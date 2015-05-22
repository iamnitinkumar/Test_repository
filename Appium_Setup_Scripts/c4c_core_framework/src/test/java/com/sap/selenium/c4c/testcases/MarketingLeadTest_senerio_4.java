package com.sap.selenium.c4c.testcases;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AccountConversionQC;
import com.sap.selenium.c4c.components.AccountOWL;
import com.sap.selenium.c4c.components.AccountQC;
import com.sap.selenium.c4c.components.AppointmentQC;
import com.sap.selenium.c4c.components.ContactFacet;
import com.sap.selenium.c4c.components.InvolvedPartiesFacet;
import com.sap.selenium.c4c.components.MarketingLeadQC;
import com.sap.selenium.c4c.components.MarketingLeadTI;
import com.sap.selenium.c4c.components.OpportunityConversionQC;
import com.sap.selenium.c4c.components.OpportunityQC;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.components.PhoneCallQC;
import com.sap.selenium.c4c.components.ProductFacet;
import com.sap.selenium.c4c.components.SalesLeadConversionQC;
import com.sap.selenium.c4c.components.SalesLeadQC;
import com.sap.selenium.c4c.components.SalesLeadTI;
import com.sap.selenium.c4c.components.SalesLeadQC;
import com.sap.selenium.c4c.components.TaskQC;
import com.sap.selenium.c4c.scripts.MarketingLead;

public class MarketingLeadTest_senerio_4 extends PerformanceTest {

	@Before
	public void setUp() throws Exception {

		AccessHelper.login("English");
	}

	@After
	public void tearDown() throws Exception {
		AccessHelper.logout("English");
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

		
		// Create Marketing Lead with Existing account
		 data = new LinkedHashMap<String, String>();
		 data.put(MarketingLeadQC.USE_EXISTING_ACCOUNT, "True");
		 data.put(MarketingLeadQC.NAME, "Rahul_ML_8");
		 data.put(MarketingLeadQC.ACCOUNT, "1316589");
//		 data.put(MarketingLeadQC.CONTACT, "Rahul_Sel_test__1");
		 data.put(MarketingLeadQC.STATUS, "Qualified");
		 data.put(MarketingLeadQC.QUALIFICATION_LEVEL, "hot");
		 data.put(MarketingLeadQC.SOURCE, "Campaign");
		 data.put(MarketingLeadQC.CATEGORY, "Prospect for service");
		 data.put(MarketingLeadQC.PRIORITY, "low");
//		 data.put(MarketingLeadQC.STARTDATE, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.ENDDATE, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.CAMPAIGN, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.OWNER, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.MARKETINGUNIT, "Rahul_Sel_test__1");
		 data.put(MarketingLeadQC.NOTE, "Rahul_Sel_test__1");
		 ml.createMarketingLead(data, "SAVE");
		
		// Create Marketing Lead with Existing account
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

		
		ml.searchandOpenMarketingLead("Rahul_ML_8", "All");


		

		/*
		 * Step 12: ------- Actions: convert to saleslead
		 */

		 Thread.sleep(2000);
		 Map<String, String> slData = new LinkedHashMap<String, String>();
		 slData.put(SalesLeadConversionQC.ACCOUNT, "1001430");
		 ml.MarketingLead_ConvertToSalesLead(slData);

		
		
		// /*
		// * Step 18: -------
		// *
		// * Close the mlortunity Thing Inspector
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
