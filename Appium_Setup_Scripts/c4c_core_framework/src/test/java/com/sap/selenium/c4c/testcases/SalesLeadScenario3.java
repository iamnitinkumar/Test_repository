package com.sap.selenium.c4c.testcases;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.OpportunityQC;
import com.sap.selenium.c4c.components.NavigationBar;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.scripts.SalesLead;

public class SalesLeadScenario3 extends PerformanceTest {
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
	public void testCreate() throws InterruptedException {

		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(methodName);
		SalesLead RV_SalesLead = new SalesLead(driver, methodName);

		/*
		 * Step - 1 . Go to Sales leads OWL from Sales Work Center.
		 */

		RV_SalesLead.navigate("SALES", "SALES LEADS");

		/*
		 * Step - 2. Click on actions and select “ Convert to opportunity “ . A
		 * pop up the with the following fields value defaulted should appear: -
		 * Name : Same as the name field in the sale lead header. - Account :
		 * same as the account field in the sales lead header. - Primary contact
		 * : same as the primary contact field in the sales lead header. -
		 * Source : same as the source field in the sales lead header. -
		 * Category : same as the category field in the sales lead header -
		 * Campaign : same as the Campaign field in the sales lead header -
		 * Owner : same as the Owner field in the sales lead header - Notes :
		 * same as the Notes field in the sales lead header Check the publish to
		 * forecast box and enter some value in the expected value field and
		 * click save.
		 */

		RV_SalesLead.searchandOpenSalesLead("Rahul Test123", "All");

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

		// RV_SalesLead.goToOpportunitiesFacet();

		/*
		 * Step - 3. Click on the name in the conversion facet opportunities
		 * table. Verify the data shown in the overview facet of the
		 * opportunity. - Products table : should have the data same as the
		 * products facet in the sales lead thing inspector. - Contacts table:
		 * should have the data same as the contacts facet in the sales lead
		 * thing inspector. - Lead table : should have details about the sales
		 * lead from which the opportunity has been created. Name : sales lead
		 * name. Account : data in the account field in sales lead thing
		 * inspector.
		 */

		// Still not implemented

		/*
		 * Step - 4.After first conversion in the sales lead thing inspector,
		 * click on actions the all the actions except for “copy” should be
		 * disabled.
		 */

		//RV_SalesLead.salesLead_VerifyDisabledActions("Rahul Test");

		/*
		 * Step - 5. Check if all the add actions in all the facets except for
		 * attachments facet is disabled.
		 */

		// Still not implemented
	}
}
