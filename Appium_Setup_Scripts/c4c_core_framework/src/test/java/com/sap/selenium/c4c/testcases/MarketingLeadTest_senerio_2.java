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

public class MarketingLeadTest_senerio_2 extends PerformanceTest {

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
		 data.put(MarketingLeadQC.NAME, "Rahul_ML_6");
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

		/*
		 * Step 2:
		 * 
		 * -------
		 * 
		 * Edit mlortunity Modify the mlortunity Summary Data Save the
		 * mlortunity after
		 */

		ml.searchandOpenMarketingLead("Rahul_ML_6", "All");


		/*
		 * Step 11: ------- Actions: convert to opportunity
		 */

		// Thread.sleep(2000);
		// Map<String, String> oppData = new LinkedHashMap<String, String>();
		// oppData.put(OpportunityConversion.NAME, "ml to opp coversion 1");
		// ml.MarketingLead_ConvertToOpportunity(oppData);

		/*
		 * Step 12: ------- Actions: convert to saleslead
		 */

		// Thread.sleep(2000);
		// Map<String, String> slData = new LinkedHashMap<String, String>();
		// slData.put(SalesLeadConversion.NAME, "ml to sl coversion 1");
		// ml.MarketingLead_ConvertToSalesLead(slData);

		/*
		 * Step 13: ------- Actions: convert to Account and Contacts
		 */

		Thread.sleep(2000);
		Map<String, String> acData = new LinkedHashMap<String, String>();
		acData.put(AccountConversionQC.TITLE, "Mr.");
		acData.put(AccountConversionQC.ACADEMIC_TITLE, "MBA");
		acData.put(AccountConversionQC.FUNCTION, "Engineer");
		acData.put(AccountConversionQC.DEPARTMENT, "IT Dept");
		ml.MarketingLead_ConvertToAccountAndContact(acData);
		
		
		ml.GoToConversionFacet();

		// /*
		// * Step 14: ------- Actions: Associate Account and Contacts
		// with/without
		// * a reason
		// */
		// Thread.sleep(2000);
		// Map<String, String> acontactData = new LinkedHashMap<String,
		// String>();
		// acontactData.put(AccountQC.NAME, "Sunil");
		// ml.MarketingLead_AssociateAccountAndContact(acontactData);
		//
		// /*
		// * Step 15: ------- Action: Refresh Survey
		// */
		//
		// Thread.sleep(2000);
		//
		// ml.Action_To_RefreshSurvey(acData);
		//
		
		/*
		 * Step 1: -------------- Actions: Copy Marketing Lead
		 * 
		 *
		 */
		
//		Map<String, String>  copyData = new LinkedHashMap<String, String>();
//		copyData.put(MarketingLeadQC.USE_EXISTING_ACCOUNT, "True");
//		copyData.put(MarketingLeadQC.NAME, "Rahul_ML_copy_1");
//		copyData.put(MarketingLeadQC.ACCOUNT, "1285058");
//		copyData.put(MarketingLeadQC.CONTACT, "Rahul_Sel_test__1");
//		copyData.put(MarketingLeadQC.STATUS, "open");
//		copyData.put(MarketingLeadQC.QUALIFICATION_LEVEL, "hot");
//		copyData.put(MarketingLeadQC.SOURCE, "Rahul_Sel_test__1");
//		copyData.put(MarketingLeadQC.CATEGORY, "Prospect for service");
//		copyData.put(MarketingLeadQC.PRIORITY, "low");
//		copyData.put(MarketingLeadQC.STARTDATE, "Rahul_Sel_test__1");
//		copyData.put(MarketingLeadQC.ENDDATE, "Rahul_Sel_test__1");
//		copyData.put(MarketingLeadQC.CAMPAIGN, "Rahul_Sel_test__1");
//		copyData.put(MarketingLeadQC.OWNER, "Rahul_Sel_test__1");
//		copyData.put(MarketingLeadQC.MARKETINGUNIT, "Rahul_Sel_test__1");
//		copyData.put(MarketingLeadQC.NOTE, "Rahul_Sel_test__1");
//		 ml.copyMarketingLead(copyData);
		
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
