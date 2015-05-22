package com.sap.selenium.c4c.testcases;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AttachmentFacet;
import com.sap.selenium.c4c.components.ContactFacet;
import com.sap.selenium.c4c.components.InvolvedPartiesFacet;
import com.sap.selenium.c4c.components.OpportunityQC;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.components.ProductFacet;
import com.sap.selenium.c4c.components.SalesAndMarketingTeamFacet;
import com.sap.selenium.c4c.components.SalesLeadQC;
import com.sap.selenium.c4c.scripts.SalesLead;

public class SalesLeadScenario1 extends PerformanceTest {
	public static String methodName;

	@Before
	public void setUp() throws Exception {
		AccessHelper.login("English");

	}

	@After
	public void tearDown() throws Exception {
		AccessHelper.logout("English");
	}

	@Test
	public void testCreate() throws Exception {

		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(methodName);
		SalesLead RV_SalesLead = new SalesLead(driver, methodName);

		/*
		 * Step - 1 . Go to Sales leads OWL from Sales Work Center.
		 */

		RV_SalesLead.navigate("SALES", "SALES LEADS");
		
		Thread.sleep(15000);

		
		/*
		 * 
		 * Step - 2.Click on save and open.
		 */
		Map<String, String> data = new LinkedHashMap<String, String>();
		data.put(SalesLeadQC.NAME, "Sales Lead Test Rahul 10");
		// data.put(SalesLeadQC.ACCOUNT, "436126");//for qxl
		data.put(SalesLeadQC.ACCOUNT, "1016512");// For pjh

		// data.put(SalesLeadQC.PRIMARYCONTACT, "1002561");
		// data.put(SalesLeadQC.COMPANY, "US");
		// data.put(SalesLeadQC.CONTACT, "449080");
		// data.put(SalesLeadQC.CONTACT_FIRST_NAME, "CA");
		// data.put(SalesLeadQC.CONTACT_LAST_NAME, "Sa");
		// data.put(SalesLeadQC.STATUS, "new");
		data.put(SalesLeadQC.QUALIFICATIONLEVEL, "Hot");
		data.put(SalesLeadQC.SOURCE, "Roadshow");
		data.put(SalesLeadQC.CATEGORY, "Prospect for product sales");
		// data.put(SalesLeadQC.PRIORITY, "Low");
		// data.put(SalesLeadQC.STARTDATE, "07-Aug-2014");
		// data.put(SalesLeadQC.ENDDATE, "08.09.2014");

		// data.put(SalesLeadQC.CAMPAIGN, "86");//for qxl
		data.put(SalesLeadQC.CAMPAIGN, "11");// for pjh

		data.put(SalesLeadQC.MARKETINGUNIT, "2000");
		data.put(SalesLeadQC.SALESUNIT, "2000");
		// data.put(SalesLeadQC.OWNER_MARKETING, "Low");
		// data.put(SalesLeadQC.OWNER_SALES, "Low");
		// data.put(SalesLeadQC.NOTE, "note");
		// data.put(SalesLeadQC.SALESTERRITORYID, "Low");
		// data.put(SalesLeadQC.FIRSTCOFFEEORDER, "5-FOT");
		// data.put(SalesLeadQC.MACHINES, "5-FOT");
		// data.put(SalesLeadQC.MONTHLYCAPSULES, "5-FOT");
		// data.put(SalesLeadQC.CITY, "bangalore");
		// data.put(SalesLeadQC.COUNTRY, "IN");
		// data.put(SalesLeadQC.STATE, "10");
		// data.put(SalesLeadQC.PHONE, "92");
		// data.put(SalesLeadQC.MOBILE, "92");
		// data.put(SalesLeadQC.EMAIL, "com");
		RV_SalesLead.createSalesLead(data, "OPEN");

		// Thread.sleep(5000);

		/*
		 * Step - 4 Go to the sales lead thing inspector ->Sales and marketing
		 * team a. Verify if the sales employee and employee responsible data
		 * has been defaulted automatically in the table .(Name should be same
		 * as the name in the owner field in the sales lead header) b. click add
		 * and select a role from the drop down and select a name from the OVS
		 * (f4 help) . Click ok ( the data has to reflect in the sales and
		 * marketing team table
		 */


		Map<String, String> SalesAndmarketingTeamData = new LinkedHashMap<String, String>();
		SalesAndmarketingTeamData.put(SalesAndMarketingTeamFacet.getSalesAndMarketingLead_Role(),"Partner");
		SalesAndmarketingTeamData.put(SalesAndMarketingTeamFacet.getSalesAndMarketingLead_Name(),"1005022");
		SalesAndmarketingTeamData.put(SalesAndMarketingTeamFacet.getSalesAndMarketingLead_Primary(),"false");
		RV_SalesLead.AddSalesAndMarketingTeamtoSalesLead(SalesAndmarketingTeamData);

		/*
		 * Step - 5. Go to Involved parties facet | click add and select a role
		 * from the drop down and select a name from the ovs (f4 help) and click
		 * ok. The data has to reflect in the involved parties table.
		 */

		Thread.sleep(5000);

		Map<String, String> involedPartData = new LinkedHashMap<String, String>();
		involedPartData.put(InvolvedPartiesFacet.getINVOLVEDPARTY_ROLE(),
				"Partner");
		involedPartData.put(InvolvedPartiesFacet.getINVOLVEDPARTY_NAME(),
				"1036101");
		involedPartData.put(InvolvedPartiesFacet.getINVOLVEDPARTY_PRIMARY(),
				"false");
		involedPartData.put(
				InvolvedPartiesFacet.getINVOLVEDPARTY_PRIMARY_CONTACT(), "");

		RV_SalesLead.AddInvolvedPartytoSalesLead(involedPartData);

		/*
		 * Step - 6. Go to attachments facet | click ad and add all the three
		 * types of files .
		 */

		/*
		  * 
		  * Add Attachment Data (Local File) to the MarketingLead in Activites
		  * 
		   */
		   RV_SalesLead.AddAttachementToSalesLead_LocalFile("C:\\TestData\\test.txt");
						 
	    /*
	      * 
		  * Add Attachment Data (WebLink) to the MarketingLead in Activites
		  * 
		  */
	    
	    Map<String, String> attachmentWebLinkData = new LinkedHashMap<String,String>();
		attachmentWebLinkData.put(AttachmentFacet.LINK, "www.google.com");
	    attachmentWebLinkData.put(AttachmentFacet.TITLE, "Title from selenium");
	    RV_SalesLead.AddAttachementToSalesLead_WebLink(attachmentWebLinkData);
		
		
		 /*
		  * 
		  * Add Attachment Data (From Library) to the MarketingLead in Activites
		  * 
		  */
		
	    RV_SalesLead.AddAttachementToSalesLead_FromLibrary("");

		/*
		 * Step - 7. Go to contacts facet | click add and click on the value
		 * selection, a table appears with the contacts related to the account
		 * (data in account field in the sales lead header) . Select a value
		 * from the table and click ok. The data should reflect in the contacts
		 * table.
		 */

		Thread.sleep(5000);

		Map<String, String> contactData = new LinkedHashMap<String, String>();
		contactData.put(ContactFacet.getContactFacet_Name(), "1124892");
		contactData.put(ContactFacet.getContactFacet_PrimaryConatct(), "true");

		RV_SalesLead.AddContacttoSalesLead(contactData);

		/*
		 * Step -8. Go to Products facet | click on add ->click on value help |
		 * select a value from the table and click add . The data has to reflect
		 * in the products table.
		 */

		// Thread.Leasleep(5000);

		Map<String, String> productData = new LinkedHashMap<String, String>();
		productData.put(ProductFacet.getProduct_ID(),
				"MM160976");

		RV_SalesLead.AddProductToSalesLead(productData);

		/*
		 * Step -9. Go to Feed facet | enter data in the text bar and click on
		 * the arrow on the right side . The feed should be posted successfully.
		 */

		// Still not implemented

		/*
		 * Step -10. Go to overview facet -> verify the following table :The
		 * latest updates should show the feeds from the feed facet. Sales and
		 * marketing team table should have the data same as the sales and
		 * marketing team facet. Products table should have the data same as the
		 * products facet . Contacts table should have the data same as the
		 * contacts facet.
		 */

		// Still not implemented

		/*
		 * Step -11. After adding data in all facets successfully . Click
		 * actions on the top left and select accept . A pop appears ->select a
		 * value from the drop down and click save. The status in the header
		 * should change to accepted. The value selected from the drop down
		 * should be populated in the Reason for status field in the header.
		 */

		// Still not implemented
		
		Map<String, String> oppdata = new LinkedHashMap<String, String>();
		// oppdata.put(OpportunityQC.NAME, "Name Test Opportunity");
		// oppdata.put(OpportunityQC.ACCOUNT, "sunil");
		// data.put(OpportunityQC.PRIMARY_CONTACT,"Sunil");
		// data.put(OpportunityQC.SOURCE,"Source");
		oppdata.put(OpportunityQC.EXPECTED_VALUE, "200-AED");
		// data.put(OpportunityQC.EXPECTED_VALUE_CURRENCY_CODE,"Expected Value Currency");
		// data.put(OpportunityQC.START_DATE,"30-Jul-2014");
		// data.put(OpportunityQC.CLOSE_DATE,"31.08.2014");
		// data.put(OpportunityQC.SALES_CYCLE,"Sales Cycle");
		// data.put(OpportunityQC.SALES_PHASE,"Sales Phase");
		oppdata.put(OpportunityQC.PROBABILITY, "20");
		// data.put(OpportunityQC.PUBLISH_TO_FORECAST,"Publish to Forecast");
		//
		// data.put(OpportunityQC.FORECAST_CATEGORY,"Forecast Category");
		// data.put(OpportunityQC.CATEGORY,"Category");
		// data.put(OpportunityQC.CAMPAIGN,"Campaign");
		// data.put(OpportunityQC.OWNER,"Owner");
		//
		// data.put(OpportunityQC.NOTE,"Note");
		// data.put(OpportunityQC.INSTANCE_TYPE,"Instance Type");

		RV_SalesLead.salesLead_ConvertToOpportunity(oppdata);

	}

}
