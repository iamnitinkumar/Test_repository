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
import com.sap.selenium.c4c.components.AttachmentFacet;
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

public class MarketingLeadTest_senerio_1 extends PerformanceTest {

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
		 * Navigate to Sales/ Marketing Lead 
		 * 
		 */
		//ml.navigate("MARKETING", "LEADS");
		ml.navigate("Marketing", "Leads");
		
//		// Create Marketing Lead with Existing account
//		 data = new LinkedHashMap<String, String>();
//		 data.put(MarketingLeadQC.USE_EXISTING_ACCOUNT, "True");
//		 data.put(MarketingLeadQC.NAME, "Rahul_ML_2");
//		 data.put(MarketingLeadQC.ACCOUNT, "1316589");
////		 data.put(MarketingLeadQC.CONTACT, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.STATUS, "Qualified");
//		 data.put(MarketingLeadQC.QUALIFICATION_LEVEL, "hot");
//		 data.put(MarketingLeadQC.SOURCE, "Campaign");
//		 data.put(MarketingLeadQC.CATEGORY, "Prospect for service");
//		 data.put(MarketingLeadQC.PRIORITY, "low");
////		 data.put(MarketingLeadQC.STARTDATE, "Rahul_Sel_test__1");
////		 data.put(MarketingLeadQC.ENDDATE, "Rahul_Sel_test__1");
////		 data.put(MarketingLeadQC.CAMPAIGN, "Rahul_Sel_test__1");
////		 data.put(MarketingLeadQC.OWNER, "Rahul_Sel_test__1");
////		 data.put(MarketingLeadQC.MARKETINGUNIT, "Rahul_Sel_test__1");
//		 data.put(MarketingLeadQC.NOTE, "Rahul_Sel_test__1");
//		 ml.createMarketingLead(data, "OPEN");
		
		// Create Marketing Lead with Non 	Existing account
				 data = new LinkedHashMap<String, String>();
				 data.put(MarketingLeadQC.USE_EXISTING_ACCOUNT, "False");
				 data.put(MarketingLeadQC.NAME, "Rahul_ML_4");
				 data.put(MarketingLeadQC.COMPANY, "1316589");
				 data.put(MarketingLeadQC.CONTACT_FIRST_NAME, "Rahul_Sel_test_4");
				 data.put(MarketingLeadQC.CONTACT_LAST_NAME, "Qualified");
				  data.put(MarketingLeadQC.STATUS, "Open");
				  data.put(MarketingLeadQC.QUALIFICATION_LEVEL, "Hot");
				  //data.put(MarketingLeadQC.SOURCE, "Campaign");
				  //data.put(MarketingLeadQC.CATEGORY, "Prospect for service");
//				 data.put(MarketingLeadQC.PRIORITY, "low");
//				 data.put(MarketingLeadQC.STARTDATE, "Rahul_Sel_test__1");
//				 data.put(MarketingLeadQC.ENDDATE, "Rahul_Sel_test__1");
//				 data.put(MarketingLeadQC.CAMPAIGN, "Rahul_Sel_test__1");
				 //data.put(MarketingLeadQC.OWNER, "Rahul_Sel_test__1");
				 //data.put(MarketingLeadQC.MARKETINGUNIT, "Rahul_Sel_test__1");
				  //data.put(MarketingLeadQC.NOTE, "Rahul_Sel_test_4");
				  //data.put(MarketingLeadQC.CITY, "CITY");
				  //data.put(MarketingLeadQC.COUNTRY, "US");
				 	//data.put(MarketingLeadQC.STATE, "CA");
				  //data.put(MarketingLeadQC.PHONE, "12345678");
				  //data.put(MarketingLeadQC.MOBILE, "098765432");
				  //data.put(MarketingLeadQC.EMAIL, "ABC@GMAIL.COM");
				 
				 ml.createMarketingLead(data, "OPEN");

		/*
		 * Step 2:
		 * 
		 * -------
		 * 
		 * Edit mlortunity Modify the mlortunity Summary Data Save the
		 * mlortunity after
		 */

	//	ml.searchandOpenMarketingLead("Rahul_ML_3", "All");

		 /***** Edit and Modify MarketingLead and then Save ***/
		 Thread.sleep(20000);
		System.out.println("Step2:Edit the Marketing Lead");
		 ml.editMarketingLead();
		
		 // prepare data to modify MarketingLead
		
		 Map<String, String> editdata = new LinkedHashMap<String, String>();
		 editdata.put(MarketingLeadTI.HOUSE_NO, "2345");
		 //editdata.put(MarketingLeadTI.STREET, "hanoi Street");
		 editdata.put(MarketingLeadTI.POSTAL_CODE, "90210");
		 editdata.put(MarketingLeadTI.LANGUAGE, "English");
		
		 ml.modifyMarketingLeadSummary(editdata);
		
		 // Save MarketingLead
		 ml.saveMarketingLead();
		
		/*
		 * Step 3: ------- Add Product to the MarketingLead
		 * Go to Products facet and click on add button on the right . 
		 * click on Value help ,select a product from the list click OK and then click save.  
		 * The Product should be shown in the facet.
		 * 
		 */
		 System.out.println("Step 3: Add product to Marketing Lead");
		Thread.sleep(15000);
		 Map<String, String> producttdata = new LinkedHashMap<String,
		 String>();
		// producttdata.put(ProductFacet.getProduct_ID(), "MM160976");
		 producttdata.put(ProductFacet.getProduct_Quantity(), "2");
		
		 ml.addProductToMarketingLead(producttdata);
		
		
		/*
		 * Step 4: ------- Verify product addition
		 * d.	In the product facet, hover over the  Product name to check if the Quick view pop up appears and verify the data shown in the fields 
		 * is same as the data shown in the table. Click on the Product name ,the Product Thing inspector Should be launched. 
		 * (Close the product Thing Inspector that has been opened to go back to Marketing lead Thing Inspector )
		 */
		
		
		 //		Not Implemented yet
		
		
		
		
		 // * Step 5: -------
		// * Add Appointment data to the Marketing Lead in Activites
		// */
				System.out.println("Step 5:Add Appointment data to the Marketing Lead in Activites");
		 Map<String, String> apptdata = new LinkedHashMap<String, String>();
				
		 apptdata.put(AppointmentQC.SUBJECT_ELEMENT_ID, "Marketing Lead Appointment" );
				
		 apptdata.put(AppointmentQC.NOTES,"Appointment created from selenium");
				 
		 ml.AddAppointmentActivitytoMarketingLead(apptdata);
				 
		 /*
		  * Step 6: -------
		  * Add task data to the MarketingLead in Activites
		  * 
		   */
		 System.out.println("Step 6:Add task data to the MarketingLead in Activites");
		 Map<String, String> taskdata = new LinkedHashMap<String, String>();
					
		 taskdata.put(TaskQC.SUBJECT, "ML Task_4");
		 taskdata.put(TaskQC.NOTES, "ML Task_4");
		// taskdata.put(TaskQC.COMPLETION, "30");
					 
		 ml.AddTaskActivitytoMarketingLead(taskdata);
					 

		 
		 /*
		  * Step 7: -------
		  * Add Phone Call data to the MarketingLead in Activites
		  * 
		   */
					System.out.println("Step 7:Add Phone Call data to the MarketingLead in Activites");	
		Map<String, String> phoneCallData = new LinkedHashMap<String,String>();
		phoneCallData.put(PhoneCallQC.SUBJECT, "mlortunity PhoneCall_4");
		phoneCallData.put(PhoneCallQC.NOTES, "Phone Call created from selenium");
		ml.AddPhoneCallActivitytoMarketingLead(phoneCallData);
					 
					 
		 /*
		  * Step 8: -------
		  * Add Attachment Data (Local File) to the MarketingLead in Activites
		  * 
		   */Thread.sleep(10000);
		System.out.println("Step8:Add Attachment Data (Local File) to the MarketingLead in Activites ");
	   // ml.AddAttachementToMarketingLead_LocalFile("/Root/T Memo/T Memo Share via/Text.vnt");
						 
	    /*
	      * Step 9: -------
		  * Add Attachment Data (WebLink) to the MarketingLead in Activites
		  * 
		  */
	    System.out.println("Step 9:Add Attachment Data (WebLink) to the MarketingLead in Activites");
	    Map<String, String> attachmentWebLinkData = new LinkedHashMap<String,String>();
		attachmentWebLinkData.put(AttachmentFacet.LINK, "www.google.com");
	    attachmentWebLinkData.put(AttachmentFacet.TITLE, "Title from selenium");
		ml.AddAttachementToMarketingLead_WebLink(attachmentWebLinkData);
		
		
		 /*
		  * Step 10: -------
		  * Add Attachment Data (From Library) to the MarketingLead in Activites
		  * 
		  */
		System.out.println("Step 10:Add Attachment Data (From Library) to the MarketingLead in Activites");
		ml.AddAttachementToMarketingLead_FromLibrary("");
		
		
		 /*
		  * Step 11: -------
		  * Save MarketingLead 
		  * 		  
		  */
		ml.saveMarketingLead();
						
		System.out.println("TestCase Passed");

	
	}
}
