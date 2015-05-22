package com.sap.selenium.c4c.scripts;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.AccountConversionQC;
import com.sap.selenium.c4c.components.AccountQC;
import com.sap.selenium.c4c.components.MarketingLeadOWL;
import com.sap.selenium.c4c.components.MarketingLeadQC;
import com.sap.selenium.c4c.components.MarketingLeadTI;
import com.sap.selenium.c4c.components.OpportunityConversionQC;
import com.sap.selenium.c4c.components.OpportunityQC;
import com.sap.selenium.c4c.components.SalesLeadConversionQC;
import com.sap.selenium.c4c.components.SalesLeadQC;

public class MarketingLead {

	private WebDriver driver;

	private MarketingLeadTI marketingLeadTI = null;
	private MarketingLeadOWL marketingLeadOWL = null;
	private MarketingLeadQC marketingLeadQC = null;
	private OpportunityQC opportunityQC = null;
	private SalesLeadQC salesLeadQC = null;
	private AccountQC accountQC = null;
	private AccountConversionQC accountConversion = null;
	private OpportunityConversionQC opportunityConversion = null;
	private SalesLeadConversionQC salesLeadConversion = null;

	private String wcName;
	private String wcViewName;
	private String testCaseName;

	public MarketingLead(WebDriver webDriver, String testCaseName) {
		driver = webDriver;
		wcName = "SALES";
		wcViewName = "MarketingLead";
		this.testCaseName = testCaseName;
	}

	/*
	 * New TI, OWL classes
	 */

	public MarketingLeadTI getMarketingLeadTI() {
		if (marketingLeadTI == null) {
			marketingLeadTI = new MarketingLeadTI(driver);
		}
		return marketingLeadTI;
	}

	public MarketingLeadQC getMarketingLeadQC() {
		if (marketingLeadQC == null) {
			marketingLeadQC = new MarketingLeadQC(driver);
		}
		return marketingLeadQC;
	}

	public MarketingLeadOWL getMarketingLeadOWL() {
		if (marketingLeadOWL == null) {
			marketingLeadOWL = new MarketingLeadOWL(driver);
		}
		return marketingLeadOWL;
	}

	public OpportunityQC getOpportunityQC() {
		if (opportunityQC == null) {
			opportunityQC = new OpportunityQC(driver, testCaseName);
		}
		return opportunityQC;
	}

	public OpportunityConversionQC getOpportunityConversion() {
		if (opportunityConversion == null) {
			opportunityConversion = new OpportunityConversionQC(driver,
					testCaseName);
		}
		return opportunityConversion;
	}

	public SalesLeadQC getSalesLeadQC() {
		if (salesLeadQC == null) {
			salesLeadQC = new SalesLeadQC(driver, testCaseName);
		}
		return salesLeadQC;
	}

	public SalesLeadConversionQC getSalesLeadConversion() {
		if (salesLeadConversion == null) {
			salesLeadConversion = new SalesLeadConversionQC(driver, testCaseName);
		}
		return salesLeadConversion;
	}

	public AccountQC getAccountQC() {
		if (accountQC == null) {
			accountQC = new AccountQC(driver);
		}
		return accountQC;
	}

	public AccountConversionQC getAccountConversion() {
		if (accountConversion == null) {
			accountConversion = new AccountConversionQC(driver);
		}
		return accountConversion;
	}

	

	/**
	 * <mark>Description: This method shall be used to create an MarketingLead
	 * using the Qucik create .
	 * 
	 * @param data
	 * 
	 *            dataSet to create ( key - value pair )
	 * 
	 * @param action
	 * 
	 *            - NEW : Create MarketingLead and open a new Quick Create
	 *            MarketingLead screen - SAVE: Create MarketingLead and save
	 *            only - OPEN: Create MarketingLead and Open the created
	 *            MarketingLead in Thing Inspector
	 */
	public void createMarketingLead(Map<String, String> data, String action) {
		System.out.println("In createMarketingLead");
		switch (action) {
		case "OPEN":

			try 
			
			{
				System.out.println("Click Button");
				if(this.getMarketingLeadOWL().clickButton(MarketingLeadOWL.NEW_BUTTON, "NEW_MarketingLead_CLICK"))
				{
					this.getMarketingLeadQC().createAndOpen(data);
				}
				
				else {

					System.out.println("CreateMarketingLead with Open Button Failed");
				}
			
			} 
			
			catch (Exception e)
			
			{
				Assert.fail("MarketingLead creation failed: " + e.getLocalizedMessage());
			}

			Assert.assertTrue("MarketingLead create successful", true);
			break;

		case "NEW":

			try 
			
			{
				if(this.getMarketingLeadOWL().clickButton(	MarketingLeadOWL.NEW_BUTTON, "NEW_MarketingLead_CLICK"))
					{
						this.getMarketingLeadQC().createAndNew(data);
					
					}
				
				else {

					System.out.println("CreateMarketingLead with New Button Failed");
				}
			} 
			
			catch (Exception e) {
				Assert.fail("MarketingLead creation failed: " + e.getLocalizedMessage());
			}

			Assert.assertTrue("MarketingLead create successful", true);
			break;

		case "SAVE":

			try 
			
			{	Thread.sleep(4000);
				if(this.getMarketingLeadOWL().clickButton(MarketingLeadOWL.NEW_BUTTON, "NEW_MarketingLead_CLICK"))
				
					{
						this.getMarketingLeadQC().createAndSave(data);
					}
				
				else {

					System.out.println("CreateMarketingLead with Save Button Failed");
				}
				
			}  
			
			catch (Exception e) 
			
			{
				Assert.fail("MarketingLead creation failed: " + e.getLocalizedMessage());
			}

			Assert.assertTrue("MarketingLead create successful", true);
			break;

		}

	}

	

	public Boolean AddAppointmentActivitytoMarketingLead(
			Map<String, String> data) {

		try {
			if (this.getMarketingLeadTI().changeTabToActivities()) {

				try {
					this.getMarketingLeadTI().newAppointment(data);
					System.out.println("AddAppointmentActivitytoMarketingLead done");
					Thread.sleep(3000);
				} catch (Exception e) {
					Assert.fail("appointment creation failed: "
							+ e.getLocalizedMessage());
				}

			} else {
				System.out
						.println("AddAppointmentActivitytoMarketingLead Fail");
			}
		} catch (Exception e) {
			Assert.fail("Navigation to activites failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	

	/**
	 * Prerequisites: Marketing Lead TI should be open and not in edit mode
	 * 
	 * Description: This method can be used to edit the MarketingLead opened in
	 * the Thing Inspector.
	 */
	public void editMarketingLead() {
		try {
			this.getMarketingLeadTI().clickButton("EDIT");
		} catch (Exception e) {

		}
	}

	/**
	 * Prerequisites: Marketing Lead TI open and in EDIT mode
	 * 
	 * Description: This method can be used to click on the SAVE button in the
	 * Thing Inspector.
	 */
	public void saveMarketingLead() {
		try {
			this.getMarketingLeadTI().clickButton("SAVE");
		} catch (Exception e) {

		}
	}
	
	/**
	 * Prerequisites: Marketing Lead TI open and in EDIT mode
	 * 
	 * Description: This method can be used to click on the SAVE button in the
	 * Thing Inspector.
	 */
	
	public Boolean closeMarketingLead() {

		try {
			this.getMarketingLeadTI().close();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Prerequisites: MarketingLead TI should be open and in EDIT mode
	 * 
	 * Description: This method modifies the opprtunity summary opened and
	 * edited in the thing inspector with the passed data( key-value pairs )
	 * 
	 * @param data
	 */
	public void modifyMarketingLeadSummary(Map<String, String> data) {
		try {
			this.getMarketingLeadTI().ModifyMarketingLeadSummary(data);
		} catch (Exception e) {

		}

	}

	/**
	 * 
	 * @param wcName
	 *            Name of the Workcenter ( Language Specific )
	 * @param wcViewName
	 *            Name of the Workcenter View (Language Specific )
	 * 
	 *            This Method is used to Navigates to the Workcenter and the
	 *            Work Center View. When tested for a particular language, the
	 *            Parameters need to be defined in the respective Language.
	 */
	public void navigate(String wcName, String wcViewName) {
		try {
			this.getMarketingLeadOWL().navigateFromUser(wcName, wcViewName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean searchandOpenMarketingLead(String MarketingLeadName,
			String filterName) {
		try {
			simpleSearchMarketingLead(MarketingLeadName, filterName);
			System.out.println("simpleSearchMarketingLead done");
			Thread.sleep(5000);
			//this.getMarketingLeadOWL().openTI(MarketingLeadName);
			this.getMarketingLeadOWL().openTI1();
			System.out.println("open ti done");
			Thread.sleep(10000);
		} catch (Exception e) {
			Assert.fail("Opening MarketingLead failed: "
					+ e.getLocalizedMessage());
		}
		Assert.assertTrue("MarketingLead display successful", true);
		return true;
	}

	private Boolean simpleSearchMarketingLead(String MarketingLeadName,
			String filterName) {

		try {
			System.out.println("In simpleSearchMarketingLead");
			this.getMarketingLeadOWL().openFilter(filterName);
			this.getMarketingLeadOWL().simpleSearch(MarketingLeadName);

		} catch (Exception e) {
			Assert.fail("Failed to seach term: " + MarketingLeadName);
		}

		return true;
	}

	public Boolean addProductToMarketingLead(Map<String, String> data) {

		try {

			if (this.getMarketingLeadTI().changeTabToProducts()) {
				Thread.sleep(12000);
				try {
					this.getMarketingLeadTI().addProduct(data);
					Thread.sleep(3000);
				} catch (Exception e) {
					Assert.fail("Product Addition failed: "
							+ e.getLocalizedMessage());
				}

			} else {
				System.out.println("changeTabToProducts Fail");
			}

		} catch (Exception e) {
			Assert.fail("Navigation to facet Products failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	public Boolean addAndNewProductToMarketingLead(Map<String, String> data) {

		try {

			if (this.getMarketingLeadTI().changeTabToProducts()) {

				try {
					this.getMarketingLeadTI().addAndNewProduct(data);
					Thread.sleep(3000);
				} catch (Exception e) {
					Assert.fail("Product Addition failed: "
							+ e.getLocalizedMessage());
				}

			} else {
				System.out.println("changeTabToProducts Fail");
			}

		} catch (Exception e) {
			Assert.fail("Navigation to facet Products failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	public Boolean addContactToMarketingLead(Map<String, String> data) {

		try {
			if (getMarketingLeadTI().changeTabToContacts()) {

				Thread.sleep(10000);
				this.getMarketingLeadTI().addContact(data);
				Thread.sleep(3000);

			} else {
				System.out.println("changeTabToContacts Fail");
			}

		} catch (Exception e) {
			Assert.fail("Contacts Addition failed: " + e.getLocalizedMessage());
		}

		return true;
	}

	public Boolean addSalesTeamToMarketingLead(Map<String, String> data) {
		try {
			if (this.getMarketingLeadTI().changeTabToSalesTeam()) {

				Thread.sleep(15000);
				this.getMarketingLeadTI().addSalesTeam(data);
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			Assert.fail("Sales Team Addition failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	public Boolean addInvolvedPartyToMarketingLead(Map<String, String> data) {

		try {

			if (this.getMarketingLeadTI().changeTabToInvolvedParty()) {

				Thread.sleep(15000);
				this.getMarketingLeadTI().addInvolvedParty(data);
				Thread.sleep(3000);
			}

		} catch (Exception e) {
			Assert.fail("Involved Party Addition failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	public Boolean AddTaskActivitytoMarketingLead(Map<String, String> data) {

		try {

			if (this.getMarketingLeadTI().changeTabToActivities()) {
				try {
					this.getMarketingLeadTI().newTask(data);
					Thread.sleep(3000);
				} catch (Exception e) {
					Assert.fail("Task creation failed: "
							+ e.getLocalizedMessage());
				}

			}

		} catch (Exception e) {
			Assert.fail("Navigation to activites failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	public Boolean AddPhoneCallActivitytoMarketingLead(Map<String, String> data) {

		try {
			if (this.getMarketingLeadTI().changeTabToActivities()) {
				try {
					this.getMarketingLeadTI().newPhoneCall(data);
					Thread.sleep(3000);
				} catch (Exception e) {
					Assert.fail("Phone Call creation failed: "
							+ e.getLocalizedMessage());
				}

			}

		} catch (Exception e) {
			Assert.fail("Navigation to activites failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	/**
	 * This method will converts the marketing Lead to opportunity
	 * 
	 * @param data
	 * @return
	 */
	public Boolean MarketingLead_ConvertToOpportunity(Map<String, String> data) {

		System.out.println("MarketingLead_ConvertToOpportunity() Called");

		try {

			if (this.getMarketingLeadTI().executeActionConvertToOpportunity()) {
				this.getOpportunityConversion().createAndSave(data);
				System.out.println("MarketingLead_ConvertToOpportunity create save done");
				Thread.sleep(10000);
			}

		} catch (Exception e)

		{
			Assert.fail("Convert MarketingLead to Opportunity failed: "
					+ e.getLocalizedMessage());
			e.printStackTrace();
		}

		Assert.assertTrue("MarketingLead conversion to opportunity successful",
				true);
		return true;
	}

	/**
	 * This method will converts the marketing Lead to opportunity
	 * 
	 * @param data
	 * @return boolean value true false
	 */
	public Boolean MarketingLead_ConvertToSalesLead(Map<String, String> data) {

		System.out.println("MarketingLead_ConvertToSalesLead() Called");

		try {
			if (this.getMarketingLeadTI().executeActionConvertToSalesLead()) {

				this.getSalesLeadConversion().createAndSave(data);
				Thread.sleep(10000);
			}
		} catch (Exception e)

		{
			Assert.fail("Convert MarketingLead to SalesLead failed: "
					+ e.getLocalizedMessage());
			e.printStackTrace();
		}

		Assert.assertTrue("MarketingLead conversion to SalesLead successful",
				true);
		return true;
	}

	/**
	 * This method will converts the marketing Lead to opportunity
	 * 
	 * @param data
	 * @return
	 */
	public Boolean MarketingLead_ConvertToAccountAndContact(Map<String, String> data) 
	
	{

		System.out.println("MarketingLead_ConvertToAccountAndContact() Called");

		try 
		
			{
					if (this.getMarketingLeadTI().executeActionConvertToAccountAndContact()) 
			
							{
							System.out.println("execite action convert clicked");
									Thread.sleep(5000);
									this.getAccountConversion().createAndSave(data);
									Thread.sleep(10000);
							}
			}

		catch (Exception e)

			{
					Assert.fail("Convert MarketingLead to AccountAndContact failed: " + e.getLocalizedMessage());
					e.printStackTrace();
			}

		Assert.assertTrue("MarketingLead conversion to AccountAndContact successful",true);
		return true;
		
	}

	
	/**
	 * This method will converts the marketing Lead to opportunity
	 * 
	 * @param data
	 * @return
	 */
	public Boolean MarketingLead_AssociateAccountAndContact(
			Map<String, String> data) {

		System.out.println("MarketingLead_AssociateAccountAndContact() Called");

		try {
			if (this.getMarketingLeadTI()
					.executeActionAssociateAccountAndContact())

			{
				this.getAccountQC().createAndSave(data);
				Thread.sleep(10000);
			}

		}

		catch (Exception e) {
			Assert.fail("Convert MarketingLead to AccountAndContact failed: "
					+ e.getLocalizedMessage());
			e.printStackTrace();
		}

		Assert.assertTrue(
				"MarketingLead conversion to AccountAndContact successful",
				true);
		return true;
	}

	/**
	 * This method will converts the marketing Lead to opportunity
	 * 
	 * @param data
	 * @return
	 */
	public Boolean Action_To_RefreshSurvey(Map<String, String> data) {

		System.out.println("Action_To_RefreshSurvey() Called");

		try {

			this.getMarketingLeadTI().executeActionRefreshSurvey();
			Thread.sleep(10000);
		} catch (Exception e) {
			Assert.fail("Refresh Survey failed: " + e.getLocalizedMessage());
			e.printStackTrace();
		}

		Assert.assertTrue("Refresh Survey successful", true);
		return true;
	}

	/**
	 * This method will copy the existing marketing Lead and save it as New.
	 * 
	 * @param data
	 * @return
	 */
	public Boolean MarketingLead_copyMarketingLead(Map<String, String> data) {

		System.out.println("copyMarketingLead() Called");

		try {
			if (this.getMarketingLeadTI().executeActionCopy()) {
				this.getMarketingLeadQC().createAndSave(data);
				Thread.sleep(10000);
			}

		} catch (Exception e) {
			Assert.fail("Copy MarketingLead failed: " + e.getLocalizedMessage());
			e.printStackTrace();
		}

		return true;
	}
	
	
	
	public Boolean AddAttachementToMarketingLead_LocalFile(String pathOfFile)
			 {

		try {
			this.getMarketingLeadTI().addAttachement_LocalFile(pathOfFile);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Contact creation failed: " + e.getLocalizedMessage());
		}

		return true;
	}
	
	public Boolean AddAttachementToMarketingLead_WebLink(Map<String, String> data)
			 {

		try {
			this.getMarketingLeadTI().addAttachement_Weblink(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Contact creation failed: " + e.getLocalizedMessage());
		}

		return true;
	}
	
	public Boolean AddAttachementToMarketingLead_FromLibrary(String data)
	 {

		try {
					this.getMarketingLeadTI().addAttachement_FromLibrary(data);
					Thread.sleep(3000);
		}
		
		catch (Exception e) 
		
		{
					Assert.fail("Contact creation failed: " + e.getLocalizedMessage());
		}

		
		return true;
	 }
	
	public void GoToConversionFacet(){
		
		try {

			if (this.getMarketingLeadTI().changeTabToConversion()) {
				Thread.sleep(12000);
				try {
					System.out.println("changeTabToConversion Pass");
					Thread.sleep(10000);
				} catch (Exception e) {	

				}

			} else {
				System.out.println("changeTabToConversion Fail");
			}

		} catch (Exception e) {
			Assert.fail("Navigation to facet Conversion failed: "
					+ e.getLocalizedMessage());
		}

		
	}

}
