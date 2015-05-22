package com.sap.selenium.c4c.components;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountTI extends BaseTI {

	public static final String NAME           			 = "inputfielddSRjw3ZkHacO5JfXXgdL";
	public static final String PROSPECT				     = "checkboxzWam5bcLE4kMVIGHS7o0QG";
	public static final String COUNTRY		 	         = "dropdownlistboxc2GHGjNnYaQvbwXRcZTt3G";
	public static final String HOUSENUMBER	 	         = "inputfieldXRlwUKAFZ4sQdybWQrGrxW";
	public static final String STREET		 	         = "inputfield9KGX_sWJ8kaQeaYEStOd";
	public static final String CITY            			 = "inputfieldD1AOvR_wlq6jrmjMx34m6W";
	public static final String STATE			         = "dropdownlistboxNZ_gD9nUQ4_vy8n_8ti8jG";
	public static final String POSTALCODE		         = "inputfield4z4tjsoFFKEpz_mnEaWoxm";
	public static final String PHONE		             = "inputfieldShtB_8xmp46zhufloxX080";
	public static final String FAX		                 = "inputfieldeQgv9u0Iu4Q8O3X8ac7h50";
	public static final String PARENT					 = "objectvalueselector_sL_sejJZWN46_s75a5hqaM1m";
	public static final String WEBSITE         			  = "linkK7fn0SEr8qYZC9xvIsqgZm";
	public static final String OWNER         			  = "objectvalueselectorcXr2_sqDywKEZoP1hhDnIHG";
	public static final String CLASSIFICATION   		  = "dropdownlistbox6hTedu0Fvq_ON3t3xCDGA0";
	public static final String INDUSTRY         			  = "dropdownlistboxApoV07d6IKUhNvaRSLEyh0";
	public static final String CONTACT         			  = "dropdownlistboxucfLlIvQy4klkC19XDraq0";
	
	public static final String FIRSTNAME		 	         = "inputfieldM05IfVLXPaUeKCCFxgjsLm";
	public static final String LASTNAME	 	         = "inputfieldCU01C4Z_sN4EWvuSj8o79lG";
	public static final String JOBTITLE		 	         = "inputfieldrciUr0cz6aEeo8y00Td0";
	public static final String FUNCTION            			 = "dropdownlistboxcMzmUGecCagf8J7rYBb7ym";
	public static final String DEPARTMENT			         = "dropdownlistboxnf978mbGEaQ5ldoaQMFE9W";
	public static final String MOBILE		                 = "inputfieldOdBTmqXAR4gzkGcxDs0lI0";
	public static final String EMAIL					="inputfieldqy94744Fs4IAdgDVamUT3W";
	
	protected static final String ACTION_SET_AS_BLOCKED = "childnavigationitem8v7EAJQWNqMSD2A_Y_s4Jhm_";
	protected static final String ACTION_SET_AS_OBSOLETE = "childnavigationitemnrmeZuzCwqcFRCJ8_CMaxG_";
	protected static final String ACTION_DERIVE_TERRITORY = "childnavigationitemg4Gg9ENnv4YQ7_6wO0KIWm_";
	protected static final String ACTION_SET_AS_ACTIVE = "childnavigationitemHKuIqMOoVKwC4whYj5EPYG_";
	
	
	protected final static String HITLIST_ITEM_PARTIAL_ID ="statictext"; 
	
		

	/* 
	 * Add/Cancel buttons have no specific ID
	 */
	protected static final String ADDRESS_DIALOG_ADD_BUTTON        = "Add";
	protected static final String ADDRESS_DIALOG_CANCEL_BUTTON     = "Cancel";
	
	public AccountTI(WebDriver webDriver)
	{
		
		super(webDriver);
		editButton = "-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle";
		summaryButton = "-actionBar-buttonGteIlpE4jqk9jpLh8rrAYG";
		saveButton = "-actionBar-buttonjEe_uS0qYKcnogIEZ1IwrW";
		actionButton = "button4SFXilGZmKY8EahApw_svo0";
		cancelButton = "-actionBar-buttonnY1FVCP3Fq2hLDqbbWb8BG";
		tiName = "Account";
	}
	
	/*
	 * Inner navigations
	 */
	
	public void changeTabToOverview() throws Exception
	{
		this.changeTab("navigationitemF9oKIIb_iKAUQeze4gfMLG_", "Overview");
	}
	
	public void changeTabToFeed() throws Exception
	{
		this.changeTab("navigationitem2p_sws637HqsiHpVMt3bRpW_", "Feeds");
	}
	
	public void changeTabToCharts() throws Exception
	{
		this.changeTab("navigationitemWJy_sS_YF5K_gPWa20DSh2m_", "Charts");
	}
	
	public void changeTabToActivities() throws Exception
	{
		this.changeTab("navigationitemdISOURhBPa2_shfLhYQaIpW_", "Activities");
	}
	
	public void changeTabToAccountTeam() throws Exception
	{
		this.changeTab("navigationitem_sXJ5RrqHzK6pyaH2E373Xm_", "AccountTeam");
	}
	
	public void changeTabToAddresses() throws Exception
	{
		this.changeTab("navigationitemEspQv1jP3awsHMdORSr4V0_", "Addresses");
		
	}
	
	public void changeTabToContacts() throws Exception
	{
		this.changeTab("navigationitemKXpvpFIOcKgJJ1quMzLTlG_", "Contacts");
	}

	public void changeTabToCampaigns() throws Exception
	{
		this.changeTab("navigationitemEvNeNLvgm4EhIDXUu2eoJ0_", "Campaing");
	}	
	
	public void changeTabToSalesLeads() throws Exception
	{
		this.changeTab("navigationitem8BmVg1XExKQMZMQtuX0v0W_", "SalesLeads");
	}	

	public void changeTabToOpportunities() throws Exception
	{
		this.changeTab("navigationitemu3p1aB5MBqswlRFv6wRSym_", "Opportunities");
	}
	
	public void changeTabToAttachements() throws Exception
	{
		this.changeTab("navigationitemB_s7GfiVvvKoQ9cXXcq858m_", "Attachments");
	}
	
	public void changeTabToSavo() throws Exception
	{
		this.changeTab("navigationitemVQLPQJ_LAqY_mZS00wB1hG_", "Savo");
	}
	
	public void changeTabToAccountHierarchy() throws Exception
	{
		this.changeTab("navigationitemrQSCMh_gwKYJGfMSCSpVLG_", "AccountHierarchy");
	}
	
	public void changeTabToTargetGroups() throws Exception
	{
		this.changeTab("navigationitem6NF3yQ74hqgj1LKE0V74kW_", "TargetGroups");
	}
	
	public void changeTabToRegisteredProducts() throws Exception
	{
		this.changeTab("navigationitem0zQRi__5sKo3arEfv_sFOyW_", "Products");
	}
	

	
	/*
	 * Contact tab
	 */
	private ContactQC navigateAndGetContactQC() throws Exception
	{
		 this.changeTabToContacts();
			
		 this.clickButton("button2gWQI0QaJaAO9a66IxaHdG", "CreateContact_"+tiName);
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
	 * Opportunity tab
	 */
	
	private OpportunityQC navigateAndGetOpportunityQC() throws Exception
	{
		this.changeTabToOpportunities();
			
		 this.clickButton("button7mU9LFknWa2LyNYac_c4w0", "CreateOpportunity_"+tiName);
		 Thread.sleep(5000);
		 return new OpportunityQC(driver, this.testName);
	}
	
	public void newOpportunity(Map<String, String> data) throws Exception
	{
		 this.navigateAndGetOpportunityQC().createAndSave(data);;
	}
	
	public void newOpportunityAndNew(Map<String, String> data) throws Exception
	{
		this.navigateAndGetOpportunityQC().createAndNew(data);
	}
	
	public void newOpportunityAndOpen(Map<String, String> data) throws Exception
	{
		this.navigateAndGetOpportunityQC().createAndOpen(data);
	}
	
	
	/*
	 * Sales Lead tab
	 */
	
	private SalesLeadQC navigateAndGetSalesLeadQC() throws Exception
	{
		this.changeTabToOpportunities();
			
		 this.clickButton("buttondWum_dCr142ynSQCQOWpeW_", "CreateSalesLead_"+tiName);
		 Thread.sleep(5000);
		 return new SalesLeadQC(driver,this.testName);
	}
	
	public void newSalesLead(Map<String, String> data) throws Exception
	{
		 this.navigateAndGetSalesLeadQC().createAndSave(data);;
	}
	
	public void newSalesLeadAndNew(Map<String, String> data) throws Exception
	{
		this.navigateAndGetSalesLeadQC().createAndNew(data);
	}
	
	public void newSalesLeadAndOpen(Map<String, String> data) throws Exception
	{
		this.navigateAndGetSalesLeadQC().createAndOpen(data);
	}
	
	
	
	
	/*
	 * Actions
	 */
	public void executeActionSetAsBlocked() throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, AccountTI.ACTION_SET_AS_BLOCKED));
	}
	
	public void executeActionSetAsActive() throws Exception
	{
		this.jsClick(this.getAction(this.actionButton, AccountTI.ACTION_SET_AS_ACTIVE));
	}
	
    public void execeuteActionSetAsObsolete() throws Exception
    {
		this.jsClick(this.getAction(this.actionButton, AccountTI.ACTION_SET_AS_OBSOLETE));
    }
	
    public void executeActionDeriveTerritory() throws Exception
    {
		this.jsClick(this.getAction(this.actionButton, AccountTI.ACTION_DERIVE_TERRITORY));
    }
    
	
	/*
	 * Country is mandatory, exception is field is not available
	 */
	
	public void editAccountSummary(Map<String, String> data) throws Exception{
		String value;		
		
		for (String key : data.keySet())
		{
			value = data.get(key);
			switch(key)
			{

			case AccountTI.NAME:
				this.elementToClear(By2.partialId(AccountTI.NAME), 60);
				this.elementToSendKey(By2.partialId(AccountTI.NAME), 60, value);
				break;
			case AccountTI.PROSPECT:
					this.elementToClick(By2.partialId(AccountTI.PROSPECT), 60);
					break;
			case AccountTI.COUNTRY:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(AccountTI.COUNTRY, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(AccountTI.COUNTRY, "-inpu"), value);
				}				
				break;			

			case AccountTI.HOUSENUMBER:
				this.elementToClear(By2.partialId(AccountTI.HOUSENUMBER), 60);
				this.elementToSendKey(By2.partialId(AccountTI.HOUSENUMBER), 60, value);
				break;
			case AccountTI.STREET:
				this.elementToClear(By2.partialId(AccountTI.STREET), 60);
				this.elementToSendKey(By2.partialId(AccountTI.STREET), 60, value);
				break;
			case AccountTI.CITY:
				this.elementToClear(By2.partialId(AccountTI.CITY), 60);
				this.elementToSendKey(By2.partialId(AccountTI.CITY), 60, value);
				break;
			case AccountTI.STATE:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(AccountTI.STATE, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(AccountTI.STATE, "-inpu"), value);
					Thread.sleep(2000);
				}				
				break;
			case AccountTI.POSTALCODE:
				this.elementToClear(By2.partialId(AccountTI.POSTALCODE), 60);
				this.elementToSendKey(By2.partialId(AccountTI.POSTALCODE), 60, value);
				break;
			case AccountTI.PHONE:
				this.elementToClear(By2.partialId(AccountTI.PHONE), 60);
				this.elementToSendKey(By2.partialId(AccountTI.PHONE), 60, value);
				break;
			case AccountTI.FAX:
				this.elementToClear(By2.partialId(AccountTI.FAX), 60);
				this.elementToSendKey(By2.partialId(AccountTI.FAX), 60, value);
				break;
			
			case AccountTI.PARENT:
				this.valueHelpDialog2(AccountTI.PARENT, value, "PARENT_ACCOUNT");
				break;
			
			case AccountTI.WEBSITE:
				this.elementToClear(By2.partialId(AccountTI.WEBSITE), 60);
				this.elementToSendKey(By2.partialId(AccountTI.WEBSITE), 60, value);
				break;
			case AccountTI.OWNER:
				this.valueHelpDialog2(AccountTI.OWNER, value, "OWNER");
				break;
			case AccountTI.CLASSIFICATION:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(AccountTI.CLASSIFICATION, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(AccountTI.CLASSIFICATION, "-inpu"), value);
					Thread.sleep(2000);
				}				
				break;
			case AccountTI.INDUSTRY:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(AccountTI.INDUSTRY, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(AccountTI.INDUSTRY, "-inpu"), value);
					Thread.sleep(2000);
				}				
				break;
			case AccountTI.CONTACT:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(AccountTI.CONTACT, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(AccountTI.CONTACT, "-inpu"), value);
					Thread.sleep(2000);
				}				
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
	
	public void addAddress(Map<String, String> data) throws Exception{
		String value;
		String ADDCOUNTRY		 	         = "dropdownlistboxVF_8e6okVK_K_w2VTW5iFm";
		String ADDHOUSENUMBER	 	         = "inputfieldIgRLw9UNsq2LYPRN_sKZRCW";
		String ADDSTREET		 	         = "inputfieldLWEalQO9UqsCiVK3zSRTwG";
		String ADDCITY            			 = "inputfieldlmB2nJ9F1qALfzM_TsaFbm";
		String ADDSTATE			         = "dropdownlistboxffSVhFKWtq6MOomdWXA4Vm";
		String ADDPOSTALCODE		         = "inputfield5w_GOMuNEaoTBHvZLokDg0";
		String ADDPHONE		             = "inputfieldFxBOB2BzAagz1fk4144FKm";
		String ADDFAX		                 = "inputfield8rQJF5MF7qs2_QxUlQ7icG";
		String ADDBUTTON					="buttonqIvHTMTziKYLgkzLwjLrOW";
		//String savebutton					="sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd";
		
		this.elementToClick(By2.partialId(ADDBUTTON), 60);
		
				
		for (String key : data.keySet())
		{
			value = data.get(key);
			switch(key)
			{
			case AccountTI.COUNTRY:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(ADDCOUNTRY, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(ADDCOUNTRY, "-inpu"), value);
				}				
				break;			

			case AccountTI.HOUSENUMBER:
				this.elementToClear(By2.partialId(ADDHOUSENUMBER), 60);
				this.elementToSendKey(By2.partialId(ADDHOUSENUMBER), 60, value);
				break;
			case AccountTI.STREET:
				this.elementToClear(By2.partialId(ADDSTREET), 60);
				this.elementToSendKey(By2.partialId(ADDSTREET), 60, value);
				break;
			case AccountTI.CITY:
				this.elementToClear(By2.partialId(ADDCITY), 60);
				this.elementToSendKey(By2.partialId(ADDCITY), 60, value);
				break;
			case AccountTI.STATE:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(ADDSTATE, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(ADDSTATE, "-inpu"), value);
				}				
				break;
			case AccountTI.POSTALCODE:
				this.elementToClear(By2.partialId(ADDPOSTALCODE), 60);
				this.elementToSendKey(By2.partialId(ADDPOSTALCODE), 60, value);
				break;
			case AccountTI.PHONE:
				this.elementToClear(By2.partialId(ADDPHONE), 60);
				this.elementToSendKey(By2.partialId(ADDPHONE), 60, value);
				break;
			case AccountTI.FAX:
				this.elementToClear(By2.partialId(ADDFAX), 60);
				this.elementToSendKey(By2.partialId(ADDFAX), 60, value);
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
		
		//this.elementToClick(By2.buttonByClassAndPartialId("sapUiBtn sapUiBtnNorm sapUiBtnS sapUiMenuButton sapclientcontrolscore-MenuButtonWrapper-menuButton sapUiBtnStd","__button"), 60);
		this.elementToClick(By2.buttonByPartialIdAndText("__button","Add"), 5);
		
		
		Thread.sleep(5000);
	}
	
	/**
	 * Create new contact and save
	 * @param data name-value pairs containing contact data
	 * @throws Exception
	 */
	public void addContact(Map<String, String> data) throws Exception{
		
		final String NEW_BUTTON					="button2gWQI0QaJaAO9a66IxaHdG";
		
		
		this.elementToClick(By2.partialId(NEW_BUTTON), 60);
		Thread.sleep(5000);
		ContactQC contactQC = new ContactQC(driver);
		
		contactQC.createAndSave(data);
		
		Thread.sleep(5000);
	}
	
}

