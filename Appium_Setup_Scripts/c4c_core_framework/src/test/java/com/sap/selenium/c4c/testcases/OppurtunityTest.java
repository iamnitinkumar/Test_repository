package com.sap.selenium.c4c.testcases;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AppointmentQC;
import com.sap.selenium.c4c.components.ContactFacet;
import com.sap.selenium.c4c.components.InvolvedPartiesFacet;
import com.sap.selenium.c4c.components.OpportunityQC;
import com.sap.selenium.c4c.components.OpportunityTI;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.components.PhoneCallQC;
import com.sap.selenium.c4c.components.ProductFacet;
import com.sap.selenium.c4c.components.SalesAndMarketingTeamFacet;
import com.sap.selenium.c4c.components.TaskQC;
import com.sap.selenium.c4c.scripts.Opportunity;

public class OppurtunityTest extends PerformanceTest {

	@Before
	public void setUp() throws Exception {

		AccessHelper.login("English");
	}
	
	@After
	public void tearDown() throws Exception {
		AccessHelper.logout("English");
		System.out.println("TestCase Passed");
	}

	@Test
	public void testCreate() throws InterruptedException {
		System.out.println("Next Page");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Map<String, String> data = null;
		Opportunity opp = new Opportunity(driver, "testCreate");
		
		
		/*
		 * Step 1: -------
		 * 
		 * Navigate to Sales/ Opportunitie
		 * s Create Opportunity from Short Cuts
		 * Area ( tool Area ) and Open the Opportunity TI after creation
		 */
		System.out.println("Step:1 Navigate to Sales/ Opportunitie");
		opp.navigate("SALES", "OPPORTUNITIES");
		//opp.navigatemob("SALES", "OPPORTUNITIES");
		System.out.println("Done");
		data = new LinkedHashMap<String, String>();
		data.put(OpportunityQC.NAME, "Sunil_Sel_test_opp35");
		data.put(OpportunityQC.ACCOUNT, "sunil");
		//data.put(OpportunityQC.START_DATE, "30-Jul-2014");
		data.put(OpportunityQC.EXPECTED_VALUE, "200-AED");
		//data.put(OpportunityQC.CLOSE_DATE, "31-Dec-2014");
		data.put(OpportunityQC.PROBABILITY, "50");
		// data.put(OpportunityQC.EXPECTED_VALUE_CURRENCY_CODE_ELEMENT_NAME,"Expected Value Currency");
		// data.put(OpportunityQC.START_DATE_ELEMENT_NAME,"30.07.2014");
		// data.put(OpportunityQC.SALES_CYCLE_ELEMENT_NAME,"Sales Cycle");
		// data.put(OpportunityQC.SALES_PHASE_ELEMENT_NAME,"Sales Phase");
		// data.put(OpportunityQC.PRIMARY_CONTACT_ELEMENT_NAME,"Sunil");
		//data.put(OpportunityQC.SOURCE_ELEMENT_NAME,"Source");
		// data.put(OpportunityQC.PUBLISH_TO_FORECAST_ELEMENT_NAME,"Publish to Forecast");
		// data.put(OpportunityQC.FORECAST_CATEGORY_ELEMENT_NAME,"Forecast Category");
		// data.put(OpportunityQC.CATEGORY_ELEMENT_NAME,"Category");
		// data.put(OpportunityQC.CAMPAIGN_ELEMENT_NAME,"Campaign");
		 data.put(OpportunityQC.OWNER,"");
		// data.put(OpportunityQC.NOTE_ELEMENT_NAME,"Note");
		// data.put(OpportunityQC.INSTANCE_TYPE_ELEMENT_NAME,"Instance Type");
		 System.out.println("Create Oppurtunity");
		 opp.createOpportunity(data, "OPEN");

		
		

		/*
		 * Step 2:
		 * 
		 * -------
		 * 
		 * Edit Opportunity Modify the Opportunity Summary Data Save the
		 * Opportunity after
		 */

		/***** Edit and Modify Opportunity and then Save ***/
		Thread.sleep(2000);
		System.out.println("Step 2:Edit and Modify Opportunity and then Save ");
		opp.editOpportunity();

		// prepare data to modify Opportunity
		Map<String, String> editdata = new LinkedHashMap<String, String>();
		editdata.put(OpportunityTI.NAME, "Sunil_Sel_test_opp35_MODIFY");
		editdata.put(OpportunityTI.EXPECTED_VALUE, "300-AUD");
		editdata.put(OpportunityTI.START_DATE, "10.10.2014");
		editdata.put(OpportunityTI.CLOSE_DATE, "31.12.2014");
		editdata.put(OpportunityTI.PROBABILITY, "20");
		// editdata.put(OpportunityTI.ACCOUNT,"sunil");
		System.out.println("modify oppurtunity");
		opp.modifyOpportunitySummary(editdata);

		// Save Opportunity
		System.out.println("Save Opportunity");
		opp.saveOpportunity();
		 
		 //Verify Opportunity status
		 System.out.println("Verify Oppurtunity");
		// opp.verifyOpportunityStatus("Open");

		 
		 
		/*
		 * Step 3: -------
		 * 
		 * Add Contact to the Opportunity
		 */
		 Thread.sleep(3000);
		Map<String, String> contactdata = new LinkedHashMap<String, String>();
		// contactdata.put(ContactFacet.getContactFacet_Role(), "");
		contactdata.put(ContactFacet.getContactFacet_Name(), "1049433");
		contactdata.put(ContactFacet.getContactFacet_PrimaryConatct(), "False");
		System.out.println("Step 3:Add Contact to Oppurtunity");
		opp.addContactToOpportunity(contactdata);

		
		
		/*
		 * Step 4: -------
		 * 
		 * Add Product to the Opportunity
		 */

		// add product to opportunity //
		 Thread.sleep(3000);
		Map<String, String> producttdata = new LinkedHashMap<String, String>();
		producttdata.put(ProductFacet.getProduct_ID(), "MM160976");
		producttdata.put(ProductFacet.getProduct_Quantity(), "2");
		// contactdata.put(AccountQC.COUNTRY_ELEMENT_NAME, "US");
		// contactdata.put(AccountQC.STATE_ELEMENT_NAME, "CA");
		// contactdata.put(AccountQC.CITY_ELEMENT_NAME, "San Francisco");
		// contactdata.put(AccountQC.PROSPECT_ELEMENT_NAME, "X");
		// contactdata.put(AccountQC.CLASSIFICATION_ELEMENT_NAME, "A");
		// contactdata.put(AccountQC.WEBSITE_ELEMENT_NAME, "www.test.com");
		System.out.println("Step 4 :Add product to oppurtunity");
		opp.addProductToOpportunity(producttdata);

		
		
		/*
		 * Step 5: -------
		 * 
		 * Add Sales Team data to the Opportunity
		 */
		 Thread.sleep(8000);
		Map<String, String> salesTeamData = new LinkedHashMap<String, String>();
		salesTeamData.put(SalesAndMarketingTeamFacet.getSalesAndMarketingLead_Role(),"Sales Employee");
		salesTeamData.put(SalesAndMarketingTeamFacet.getSalesAndMarketingLead_Name(),"Sunil");
		System.out.println("Step5: Add Sales Team data to the Opportunity");
		opp.addSalesTeamToOpportunity(salesTeamData);

		
		
		/*
		 * Step 6: -------
		 * 
		 * Add Involved Party data to the Opportunity
		 */
		 Thread.sleep(5000);
		Map<String, String> partyData = new LinkedHashMap<String, String>();
		//partyData.put(InvolvedPartiesFacet.getINVOLVEDPARTY_ROLE(), "Partner");
		partyData.put(InvolvedPartiesFacet.getINVOLVEDPARTY_NAME(), "1036101");
		// partyData.put(InvolvedPartiesFacet.getINVOLVEDPARTY_PRIMARY(), "");
		// partyData.put(InvolvedPartiesFacet.getINVOLVEDPARTY_PRIMARY_CONTACT(),
		// "");
		System.out.println("Step 6 :Add Involved Party data to the Opportunity");
		opp.addInvolvedPartyToOpportunity(partyData);

		
		
		/*
		 * Step 7: -------
		 * 
		 * Add Attachments data to the Opportunity
		 */

		 
		 
		/*
		 * Step 8: -------
		 * 
		 * Add Appointment data to the Opportunity in Activites
		 */
		long lDateTime = new Date().getTime(); // get datetime in milliselconds
		Map<String, String> apptdata = new LinkedHashMap<String, String>();
		apptdata.put(AppointmentQC.SUBJECT_ELEMENT_ID,
				"Opportunity Appointment_" + lDateTime);
		apptdata.put(AppointmentQC.ACCOUNT_VALUE_HELP_ELEMENT_ID, "Sunil"); // PerformanceRunner.getProperty("Account_Appointment")
		//apptdata.put(AppointmentQC.PRIMARY_CONTACT_VALUE_HELP_ELEMENT_ID, "");
		//apptdata.put(AppointmentQC.TO_DATE_ELEMENT_ID, "31.12.2014");
		//apptdata.put(AppointmentQC.CATEGORY_ELEMENT_ID, "Customer visit");
		//apptdata.put(AppointmentQC.PRIORITY_ELEMENT_ID, "Normal");
		 apptdata.put(AppointmentQC.OWNER_VALUE_HELP_ELEMENT_ID, "");
		// apptdata.put(AppointmentQC.TERRITORY_VALUE_HELP_ELEMENT_ID, "");
		apptdata.put(AppointmentQC.NOTES, "Appointment created from selenium");
		// apptdata.put(AppointmentQC.LOCATION, "Palo Alto");
		System.out.println("Step 8: Add Appointment data to the Opportunity in Activites");
		opp.AddAppointmentActivitytoOpportunity(apptdata);


		
		/*
		 * Step 9: -------
		 * 
		 * Add task data to the Opportunity in Activites
		 */
		Map<String, String> taskdata = new LinkedHashMap<String, String>();
		taskdata.put(TaskQC.SUBJECT, "Opportunity Task_" + lDateTime);
		taskdata.put(TaskQC.ACCOUNT, "Sunil"); // PerformanceRunner.getProperty("Account_Appointment")
		//taskdata.put(TaskQC.PRIMARY_CONTACT, "");
		//taskdata.put(TaskQC.TO_DATE, "31.12.2014");
		//taskdata.put(TaskQC.CATEGORY, "Customer visit");
		//taskdata.put(TaskQC.PRIORITY, "Normal");
		// taskdata.put(TaskQC.OWNER_VALUE_HELP_ELEMENT_ID, "");
		// taskdata.put(TaskQC.TERRITORY_VALUE_HELP_ELEMENT_ID, "");
		taskdata.put(TaskQC.NOTES, "Task created from selenium");
		// taskdata.put(TaskQC.LOCATION, "Palo Alto");
		System.out.println("Step 9: Add task data to the Opportunity in Activites");
		opp.AddTaskActivitytoOpportunity(taskdata);

		
		
		/*
		 * Step 10: -------
		 * 
		 * Add Phone call data to the Opportunity
		 */

		Map<String, String> phoneCallData = new LinkedHashMap<String, String>();
		phoneCallData.put(PhoneCallQC.SUBJECT, "Opportunity PhoneCall_"
				+ lDateTime);
		phoneCallData.put(PhoneCallQC.ACCOUNT, "Sunil"); // PerformanceRunner.getProperty("Account_Appointment")
		phoneCallData.put(PhoneCallQC.PRIMARY_CONTACT, "");
		//phoneCallData.put(PhoneCallQC.DATE, "31.08.2014");
		phoneCallData.put(PhoneCallQC.TIME, "");
		//phoneCallData.put(PhoneCallQC.DIRECTION, "Inbound");
		//phoneCallData.put(PhoneCallQC.CATEGORY, "Sales call");
		//phoneCallData.put(PhoneCallQC.PRIORITY, "Normal");
		//phoneCallData.put(PhoneCallQC.TERRITORY, "");
		phoneCallData.put(PhoneCallQC.NOTES, "Phone Call created from selenium");
		System.out.println("Step 10: Add Phone call data to the Opportunity");
		opp.AddPhoneCallActivitytoOpportunity(phoneCallData);
		opp.saveOpportunity();

		 
		 
		/*
		 * Step 11: ------- Actions: Set the Opportunity to In Process
		 */
		Thread.sleep(2000);
		System.out.println("Step 11: Actions: Set the Opportunity to In Process");
		opp.setOpportunitytoInProcess();
		//Verify Opportunity status
		// opp.verifyOpportunityStatus("In Process");

		
		
		/*
		 * Step 12: ------- Actions: Set the Opportunity to Won with a reason
		 */
		 System.out.println("Step 12: ------- Actions: Set the Opportunity to Won with a reason");
		Thread.sleep(2000);
		opp.setOpportunitytoWonWithReason("Won due to service");
		//Verify Opportunity status
		//opp.verifyOpportunityStatus("Won");

		
		
		/*
		 * Step 13: ------- Actions: Set the Opportunity status back to in
		 * process
		 */
		 System.out.println("Step 13: ------- Actions: Set the Opportunity status back to in process");
		Thread.sleep(2000);
		opp.setOpportunitytoInProcess();
		//Verify Opportunity status
		// opp.verifyOpportunityStatus("In Process");

		
		
		/*
		 * Step 14: ------- Actions: Set the Opportunity status to LOST
		 * with/without a reason
		 */
		 System.out.println("Step 14: -Actions: Set the Opportunity status to LOST");
		Thread.sleep(2000);
		opp.setOpportunitytoLostWithReason(null);
		//Verify Opportunity status
		// opp.verifyOpportunityStatus("Lost");

		
		/*
		 * Step 15: ------- Action: Set the Opportunity status back to in
		 * process
		 */
		Thread.sleep(2000);
		System.out.println("Step 15: - Action: Set the Opportunity status back to in");
		opp.setOpportunitytoInProcess();
		//Verify Opportunity status
		 //opp.verifyOpportunityStatus("In Process");

		
		/*
		 * Step 16: ------- Action: Set the Opportunity as Stopped
		 */
		 System.out.println("Step 16:- Action: Set the Opportunity as Stopped");
		Thread.sleep(2000);
		opp.setOpportunitytoStopped();
		//Verify Opportunity status
		// opp.verifyOpportunityStatus("Stopped");

		
		
		/*
		 * Step 17: ------- Action Copy the Opportunity to create a new
		 * opportunity
		 */
		Thread.sleep(2000);
		System.out.println("Step 17: - Action Copy the Opportunity to create a new");
		Map<String, String> copydata = new LinkedHashMap<String, String>();
		copydata.put(OpportunityQC.NAME, "Sunil_Sel_test_opp14_copy");
		copydata.put(OpportunityQC.ACCOUNT, "sunil");
		copydata.put(OpportunityQC.EXPECTED_VALUE, "100000000-AED");
		copydata.put(OpportunityQC.PROBABILITY, "40");
		//opp.copyOpportunity(copydata, "OPEN");
		//Verify Opportunity status
		// opp.verifyOpportunityStatus("In Approval");

		
		/*
		 * Step 18: -------
		 * 
		 * Close the Opportunity Thing Inspector
		 */
		 System.out.println("Step 18:Close the Opportunity Thing Inspecto");
		Thread.sleep(2000);
		opp.closeOpportunity();

		
		/*
		 * Step 19: -------
		 * 
		 * Naviagte to Work Center and Work Center View Filter and Search for
		 * created Opportunity Open the searched opporutnity
		 */
		System.out.println("Step 19: -Naviagte to Work Center and Work Center View Filter and Search");
		opp.navigate("SALES", "OPPORTUNITIES");
		opp.searchandOpenOpportunity("sunil", "All");
		System.out.println("Oppurtunity test Done");

	}

	
}
