package com.sap.selenium.c4c.components;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OpportunityTI extends BaseTI {

	protected static final String ACTION_SET_AS_IN_PROCESS			 = "childnavigationitemSgPufdIZQagt3hZuZ1fRQW_";
	protected static final String ACTION_SET_AS_OPEN 				 = "childnavigationitembfOT6sWBAqA8Z9ArNOJs2G_";
	protected static final String ACTION_SET_AS_WON 				 = "childnavigationitemHkw_aZcD1aIRI_sfj4p_74m_";
	protected static final String ACTION_SET_AS_LOST				 = "childnavigationitemjpKxwweD1Kk3Yyn8S43utm_";
	protected static final String ACTION_SET_AS_STOPPED				 = "childnavigationitemPlb3lmfjyKQDCyz2ZW8mlG_";
	protected static final String ACTION_COPY						 = "childnavigationitem2y02e0zg1awua8mRt0yQ_";
	protected static final String ACTION_SUBMIT_FOR_APPROVAL		 = "childnavigationitemetPGLUdqyKUXfGk4H_sH5ZG_";
	protected static final String ACTION_WITHDRAW_FROM_APPROVAL		 = "childnavigationitemjyZWF_gVEawl0fn1UM_ia0_";

	// Navigation FACETs
	public static final String FACET_OVERVIEW					     = "OVERVIEW";
	public static final String FACET_FEED						     = "navigationitemHnYQXmNzpKsQ_svo9v_7Ucm";
	public static final String FACET_CONTACTS					     = "navigationitemFWZk1s_sFJKoD2aGe6F_saYW";
	public static final String FACET_ACTIVITES					     = "navigationitemAPb3M2Dc14oYbC9UnR2nmW_";
	public static final String FACET_PRODUCTS					     = "navigationitemNCkvR0ZHXKgmQFks1tvHvG";
	public static final String FACET_SALESTEAM					     = "navigationitembnmA5f4XVK_1waGBR";
	public static final String FACET_INVOLVEDPARTY					 = "navigationitem4jNgg9kvhKQGhD3t9kmXjm";
	public static final String FACET_ATTACHMENTS					 = "navigationitemj1QuCToZNK6RuFGhGMCOvG";

	//Activites partial ids
	public static final String NEW_APPOINTMENT					     = "button1IxaBXGsVKk0JPAv_s3jEtm";
	public static final String NEW_TASK					     		 = "buttonhG1v_Iuuia6eDRejoSxDYW";
	public static final String NEW_PHONECALL					     = "buttonPzhnmLYwnqwcOi3LFHxs";



	public static final String REASON_WON_PRICE						 = "Price";
	public static final String REASON_WON_PRODUCT					 = "Product";
	public static final String REASON_WON_SERVICE					 = "Service";
	public static final String REASON_OK_BUTTON						 = "buttonXp43b3SAdKAuiF9i6u_se2G";
	public static final String REASON_INPUT							 = "dropdownlistboxTq8RO7Pspq6kxfKFIATeX0";


	//Edit Fields
	public static final String NAME		 	 					= "inputfieldHbbYnd2cE4YZQmthHAFbKW";
	public static final String ACCOUNT 							= "objectvalueselector4J96LVhlA4ANZjksGyH85m";
	public static final String SOURCE       					= "dropdownlistboxxzBTOjQeYaoIkyMgJQ";	
	public static final String EXPECTED_VALUE          			= "inputfield_sR0o6216nKk0OMMVYKEFpm";
	public static final String CURRENCY_CODE         			= "dropdownlistboxqLSjBd4NA46mIS1lKR5SI0";
	public static final String START_DATE                 		= "inputfieldrvbong50WaIbVGrxYF9Qx0";
	public static final String CLOSE_DATE                   	= "inputfieldmXQ16kSIsawyhMolbsZ01G";
	public static final String SALES_PHASE                  	= "dropdownlistbox0Pr6R5XAkK2FxUIQp1ZzZG";
	public static final String PROBABILITY              	    = "inputfieldYyLIDgqGr4oFHUihGyn";
	public static final String PUBLISH_TO_FORECAST      	    = "checkboxuWFS_OsdkqwzbiZp6RYglm";
	public static final String FORECAST_CATEGORY            	= "dropdownlistboxy4sHaEeLk4ABNiTBg2CrzW";
	public static final String CATEGORY                 		= "dropdownlistboxWb6BzXEy_qs326jpX6OP3W";
	public static final String CAMPAIGN        	       	        = "objectvalueselector6z_54m252aMx_MYlYhnrVm";
	public static final String OWNER            	            = "objectvalueselectorv4gYcCK4RakKNww9xxawaW";
	public static final String NOTE          		            = "__area";
	public static final String DISTRIBUTION_CHANNEL         	= "dropdownlistboxO_dFzD2gBqon3B8D_srBUsG";
	public static final String SALES_ORG         	       		= "objectvalueselectorRMi4kAj9OaIOz1T84WA730";
	public static final String DIVISON         	       			= "dropdownlistboxkZshot3rmqYpUGLFZ8DOpG";
	public static final String SALES_UNIT         	       		= "objectvalueselectorJ1ql7GAZ5aICVAkmD0ucDm";

	public static final String ADD_PRODUCTS_BUTTON   = "button16KvLH3KBa6I4znnykfY0G";
	public static final String ADD_CONTACTS_BUTTON   = "button5dCi_srRP6qcFJqnl_NxFQG";
	public static final String ADD_SALESTEAM_BUTTON   = "buttonMMHStg93hqAOnn0WefYeo0";
	public static final String ADD_INVOLVEDPARTY_BUTTON   = "buttonSAbeF097h46x6Jxpx0ad5G";
	public static final String ADD_ATTACHMENTS_BUTTON   = "buttonNpRCE_shlAagwzT_s5ACEYYW";
	
	public static final String STATUS_TEXT   = "dropdownlistbox26PhTKUO0qkm7sqOzI8HLG"; //*[contains(@id, 'dropdownlistbox26PhTKUO0qkm7sqOzI8HLG')]
	public static final String APPROVAL_STATUS_TEXT   = "dropdownlistboxZOjwiS_sr74EWFFnGkOeCpm";

	protected final static String HITLIST_ITEM_PARTIAL_ID 		= "statictext";

	public OpportunityTI(WebDriver webDriver)
	{

		super(webDriver);

		actionButton = "buttonrOqB8wNObqAYSyFkw2g5HG_";
		editButton   = "-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle_";
		saveButton   = "-actionBar-buttonfTMr5KSpcKYD_PKI0YkMC0";
		cancelButton = "-actionBar-buttong6UVwFietqIzS9nzw22FqG_"; 

		tiName = "Opportunity";

	}

	/*
	 * Inner navigations
	 */

	public void changeTabToOverview() throws Exception
	{
		this.changeTab("navigationitemCcuq0IkG74_K2rh3LWQ_s4W_", "NavigateToOverview");
		//		this.NaviagteToFacet(OpportunityTI.FACET_OVERVIEW, "NavigateToOverview");
	}

	public void changeTabToFeed() throws Exception
	{
		this.changeTab(OpportunityTI.FACET_FEED, "NavigateToFeed");
		//		this.NaviagteToFacet(OpportunityTI.FACET_FEED, "NavigateToFeed");
	}


	public void changeTabToContacts() throws Exception
	{
		this.changeTab(OpportunityTI.FACET_CONTACTS, "NavigateToContacts");
		//		this.NaviagteToFacet(OpportunityTI.FACET_CONTACTS, "NavigateToContatcs");
	}

	public void changeTabToActivities() throws Exception
	{
		this.changeTab(OpportunityTI.FACET_ACTIVITES, "NavigateToSalesActivities");
		//		this.NaviagteToFacet(OpportunityTI.FACET_CONTACTS, "NavigateToContatcs");
	}

	public void changeTabToProducts() throws Exception
	{
		this.changeTab(OpportunityTI.FACET_PRODUCTS, "NavigateToProducts");
		//		this.NaviagteToFacet(OpportunityTI.FACET_FEED, "NavigateToFeed");
	}

	public void changeTabToSalesTeam() throws Exception
	{
		this.changeTab(OpportunityTI.FACET_SALESTEAM, "NavigateToSalesTeam");
		//		this.NaviagteToFacet(OpportunityTI.FACET_FEED, "NavigateToFeed");
	}

	public void changeTabToInvolvedParty() throws Exception
	{
		this.changeTab(OpportunityTI.FACET_INVOLVEDPARTY, "NavigateToInvolvedParty");
		//		this.NaviagteToFacet(OpportunityTI.FACET_FEED, "NavigateToFeed");
	}

	public void changeTabToAttachments() throws Exception
	{
		this.changeTab(OpportunityTI.FACET_ATTACHMENTS, "NavigateToAttachments");
		//		this.NaviagteToFacet(OpportunityTI.FACET_FEED, "NavigateToFeed");
	}



	/*
	 * Contact tab
	 */
	private ContactQC navigateAndGetContactQC() throws Exception
	{
		this.changeTabToContacts();

		this.clickButton("button5dCi_srRP6qcFJqnl_NxFQG", "CreateContact_"+tiName);
		Thread.sleep(5000);
		return new ContactQC(driver);
	}

	public void newContactAndOpen(Map<String, String> data) throws Exception
	{
		this.navigateAndGetContactQC().createAndOpen(data);
	}

	public void newContactAndNew(Map<String, String> data) throws Exception
	{
		this.navigateAndGetContactQC().createAndNew(data);
	}

	public void newContact(Map<String, String> data) throws Exception
	{
		this.navigateAndGetContactQC().createAndSave(data);
	}

	/*
	 * Activites tab
	 */

	private AppointmentQC navigateAndGetAppointmentQC() throws Exception
	{
		this.changeTabToActivities();

		this.clickButton(OpportunityTI.NEW_APPOINTMENT, "CreateContact_"+tiName);
		Thread.sleep(5000);
		return new AppointmentQC(driver, this.testName);
	}

	private ProductFacet navigateAndGetProductsFacet() throws Exception
	{
		this.changeTabToProducts();

		this.clickButton(OpportunityTI.ADD_PRODUCTS_BUTTON, "AddProduct_"+tiName);
		Thread.sleep(5000);
		//		 return new ProductFacet_Old(driver, this.testName);
		return new ProductFacet(driver, this.tiName, this.testName);
	}

	private ContactFacet navigateAndGetContactFacet() throws Exception
	{

		this.changeTabToContacts();

		this.clickButton(OpportunityTI.ADD_CONTACTS_BUTTON, "AddContact_"+tiName);
		Thread.sleep(5000);
		return new ContactFacet(driver, this.tiName, this.testName);
	}

	private SalesAndMarketingTeamFacet navigateAndGetSalesTeamFacet() throws Exception
	{
		this.changeTabToSalesTeam();

		this.clickButton(OpportunityTI.ADD_SALESTEAM_BUTTON, "AddSalesTeam_"+tiName);
		Thread.sleep(5000);
		return new SalesAndMarketingTeamFacet(driver, this.tiName, this.testName);
	}

	private InvolvedPartiesFacet navigateAndGetInvolvedPartiesfacet() throws Exception
	{
		this.changeTabToInvolvedParty();

		this.clickButton(OpportunityTI.ADD_INVOLVEDPARTY_BUTTON, "AddInvolvedParty_"+tiName);
		Thread.sleep(5000);
		return new InvolvedPartiesFacet(driver, this.tiName, this.testName);
	}

	//	private AttachmentsFacet navigateAndGetAttachmentsFacet() throws Exception
	//	{
	//		 this.changeTabToAttachments();
	//			
	//		 this.clickButton(OpportunityTI.ADD_ATTACHMENTS_BUTTON, "AddAttachments_"+tiName);
	//		 Thread.sleep(5000);
	//		 return new AttachmentsFacet(driver, this.testName);
	//	}

	private TaskQC navigateAndGetTaskQC() throws Exception
	{
		this.changeTabToActivities();

		this.clickButton(OpportunityTI.NEW_TASK, "CreateTask_"+tiName);
		Thread.sleep(5000);
		return new TaskQC(driver, this.testName);
	}

	private PhoneCallQC navigateAndGetPhoneCallQC() throws Exception
	{
		this.changeTabToActivities();

		this.clickButton(OpportunityTI.NEW_PHONECALL, "CreatePhoneCall_"+tiName);
		Thread.sleep(5000);
		return new PhoneCallQC(driver, this.testName);
	}


	public void newAppointment(Map<String, String> data) throws Exception
	{
		this.navigateAndGetAppointmentQC().createAndSave(data);
	}

	public void addProduct(Map<String, String> data) throws Exception
	{
		this.navigateAndGetProductsFacet().addAndSave(data);
	}

	public void addAndNewProduct(Map<String, String> data) throws Exception
	{
		this.navigateAndGetProductsFacet().addAndNew(data);
	}

	public void addContact(Map<String, String> data) throws Exception
	{
		this.navigateAndGetContactFacet().addAndSave(data);
	}

	public void addAndNewContact(Map<String, String> data) throws Exception
	{
		this.navigateAndGetContactFacet().addAndNew(data);
	}

	public void addSalesTeam(Map<String, String> data) throws Exception
	{
		this.navigateAndGetSalesTeamFacet().addAndSave(data);
	}

	public void addAndNewSalesTeam(Map<String, String> data) throws Exception
	{
		this.navigateAndGetSalesTeamFacet().addAndNew(data);
	}

	public void addInvolvedParty(Map<String, String> data) throws Exception
	{
		this.navigateAndGetInvolvedPartiesfacet().addAndSave(data);
	}

	public void addAndNewInvolvedParty(Map<String, String> data) throws Exception
	{
		this.navigateAndGetInvolvedPartiesfacet().addAndNew(data);
	}

	public void newTask(Map<String, String> data) throws Exception
	{
		this.navigateAndGetTaskQC().createAndSave(data);
	}

	public void newTaskAndNew(Map<String, String> data) throws Exception
	{
		this.navigateAndGetTaskQC().createAndNew(data);
	}

	public void newTaskAndOpen(Map<String, String> data) throws Exception
	{
		this.navigateAndGetTaskQC().createAndOpen(data);
	}

	public void newTaskAndComplete(Map<String, String> data) throws Exception
	{
		this.navigateAndGetTaskQC().createAndComplete(data);
	}

	public void newPhoneCall(Map<String, String> data) throws Exception
	{
		this.navigateAndGetPhoneCallQC().createAndSave(data);
	}

	public void newPhoneCallAndNew(Map<String, String> data) throws Exception
	{
		this.navigateAndGetPhoneCallQC().createAndNew(data);
	}

	public void newPhoneCallAndOpen(Map<String, String> data) throws Exception
	{
		this.navigateAndGetPhoneCallQC().createAndOpen(data);
	}


	/*
	 * Actions
	 */
	public void executeActionSetAsOpen() throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, OpportunityTI.ACTION_SET_AS_OPEN));
	}

	public void executeActionSetAsInProcess() throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, OpportunityTI.ACTION_SET_AS_IN_PROCESS));

	}

	public void executeActionSetAsWon(String Reason) throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, OpportunityTI.ACTION_SET_AS_WON));
		//to do 

		if (Reason!=null)	//select the reason for won id reason is passed
		{
			WebElement elem = driver.findElement(By2.startsWithAndPartialId(OpportunityTI.REASON_INPUT,"-input"));
			this.fillDropDown(elem, Reason);
		}

		// click on ok 
		this.clickButton(OpportunityTI.REASON_OK_BUTTON, "Reason_OK_Button_Click");

	}


	public void executeActionSetAsLost(String Reason) throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, OpportunityTI.ACTION_SET_AS_LOST));
		//to do 

		if (Reason!=null)	//select the reason for won id reason is passed
		{
			WebElement elem = driver.findElement(By2.startsWithAndPartialId(OpportunityTI.REASON_INPUT,"-input"));
			this.fillDropDown(elem, Reason);
		}

		// click on ok 
		this.clickButton(OpportunityTI.REASON_OK_BUTTON, "Reason_OK_Button_Click");

	}

	public void executeActionSetAsStopped() throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, OpportunityTI.ACTION_SET_AS_STOPPED));
	}

	public void executeActionCopy() throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, OpportunityTI.ACTION_COPY));
	}

	public void executeActionSubmitforApproval() throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, OpportunityTI.ACTION_SUBMIT_FOR_APPROVAL));
	}

	public void executeActionWithdrawFromApproval() throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, OpportunityTI.ACTION_WITHDRAW_FROM_APPROVAL));
	}


	public void ModifyOppurtunitySummary(Map<String, String> data) throws InterruptedException{
		String value;	
		WebElement elem;

		for (String key : data.keySet())
		{
			value = data.get(key);
			switch(key)
			{

			case OpportunityTI.NAME:
				this.elementToClear(By2.partialId(OpportunityTI.NAME), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.NAME), 60, value);
				break;
			case OpportunityTI.ACCOUNT:
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(OpportunityTI.ACCOUNT,"ButtonValueHelp"), 1))!= null)
				{
					this.valueHelpDialog(OpportunityTI.ACCOUNT, value, "MODIFY_OPP_ACCOUNT", OpportunityTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;
			case OpportunityTI.SOURCE:
				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityTI.SOURCE), 1))!= null)
				{
					this.fillDropDown(elem, value);
				}
				break;		

			case OpportunityTI.SALES_PHASE:
				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityTI.SALES_PHASE), 1))!= null)
				{
					this.fillDropDown(elem, value);
				}
				break;
			case OpportunityTI.PROBABILITY:
				this.elementToClear(By2.partialId(OpportunityTI.PROBABILITY), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.PROBABILITY), 60, value);
				break;
			case OpportunityTI.EXPECTED_VALUE:
				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityTI.EXPECTED_VALUE), 1))!= null)
				{
					this.fill_CompundField(OpportunityTI.EXPECTED_VALUE, OpportunityTI.CURRENCY_CODE, value);
				}
				break;
			case OpportunityTI.START_DATE:
				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityTI.START_DATE), 1))!= null)
				{
					this.fill_datetimebyID(OpportunityTI.START_DATE, value);
				}
				break;
			case OpportunityTI.CLOSE_DATE:
				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityTI.CLOSE_DATE), 1))!= null)
				{
					this.fill_datetimebyID(OpportunityTI.CLOSE_DATE, value);

				}
				break;
			case OpportunityTI.FORECAST_CATEGORY:
				this.elementToClear(By2.partialId(OpportunityTI.FORECAST_CATEGORY), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.FORECAST_CATEGORY), 60, value);
				break;
			case OpportunityTI.CATEGORY:
				this.elementToClear(By2.partialId(OpportunityTI.CATEGORY), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.CATEGORY), 60, value);
				break;
			case OpportunityTI.OWNER:
				this.elementToClear(By2.partialId(OpportunityTI.OWNER), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.OWNER), 60, value);
				break;
			case OpportunityTI.SALES_ORG:
				this.elementToClear(By2.partialId(OpportunityTI.SALES_ORG), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.SALES_ORG), 60, value);
				break;
			case OpportunityTI.DISTRIBUTION_CHANNEL:
				this.elementToClear(By2.partialId(OpportunityTI.DISTRIBUTION_CHANNEL), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.DISTRIBUTION_CHANNEL), 60, value);
				break;
			case OpportunityTI.DIVISON:
				this.elementToClear(By2.partialId(OpportunityTI.DIVISON), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.DIVISON), 60, value);
				break;
			case OpportunityTI.SALES_UNIT:
				this.elementToClear(By2.partialId(OpportunityTI.SALES_UNIT), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.SALES_UNIT), 60, value);
				break;
			case OpportunityTI.CAMPAIGN:
				this.elementToClear(By2.partialId(OpportunityTI.CAMPAIGN), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.CAMPAIGN), 60, value);
				break;
			case OpportunityTI.NOTE:
				this.elementToClear(By2.partialId(OpportunityTI.NOTE), 60);
				this.elementToSendKey(By2.partialId(OpportunityTI.NOTE), 60, value);
				break;
			default:
				//Fill the remaining simple fields
				try
				{
					this.elementToClear(By2.partialId(key), 60);
					this.elementToSendKey(By2.partialId(key), 60, value);
				}
				catch(Exception nopartialID)
				{
					try
					{
						this.elementToClear(By2.label(key), 60);
						this.elementToSendKey(By2.label(key), 60, value);					
					}
					catch(Exception nolabel)
					{

						Assert.fail("Field with name " + value + " was not found in web page");


					}
				}
			}
		}		

		Thread.sleep(5000);
	}

	
	public String getOpportunityStatus()
	{
		return this.getElementIfExisting(By2.partialId(this.STATUS_TEXT), 2).getText();
		
	}
	
	public String getOpportunityApprovalStatus()
	{
		return this.getElementIfExisting(By2.partialId(this.APPROVAL_STATUS_TEXT), 2).getText();
		
	}
	
}


