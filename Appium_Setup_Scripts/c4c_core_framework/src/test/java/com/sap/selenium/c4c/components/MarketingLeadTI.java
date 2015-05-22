package com.sap.selenium.c4c.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MarketingLeadTI extends BaseTI {

	protected static final String ACTION_CONVERT_TO_SALESLEAD = "childnavigationitemQE3wEAkN_4MhmDCtornbQW";
	protected static final String ACTION_CONVERT_TO_OPPORTUNITY = "childnavigationitem_sN_sSWR_60KMmpqbBhFfZkG";
	protected static final String ACTION_CONVERT_TO_ACCOUNT_AND_CONTACT = "childnavigationitemeu4O52_8YaQl1zw4vKSKR0";
	protected static final String ACTION_ASSOCIATE_ACCOUNT_AND_CONTACT = "childnavigationitem8LtEWycqqKo37inyAI";
	protected static final String ACTION_REFRESH_SURVEY = "childnavigationitemhwP7_daVI4s9RmZF7dqygm";
	protected static final String ACTION_COPY = "childnavigationitemLGu5zfZSg4wehzUWTPFw7m";

	// Navigation FACETs
	protected static final String FACET_OVERVIEW = "navigationitemUjua_hE4dqQ1r74mZOyWAW";
	protected static final String FACET_FEED = "navigationitem6IdnbATp8qEIM_q2x_RmD0";
	protected static final String FACET_CONTACTS = "navigationitemR6dgFSjGXKko7hpMkVYc3W";
	protected static final String FACET_ACTIVITES = "navigationitemgEyqlPrD146Da_HRerGa";
	protected static final String FACET_CONVERSION = "navigationitemvsqdgxM5ia28G3PioqNEhW";
	protected static final String FACET_PRODUCTS = "navigationitemf6fZzLyjC4IrRak_se4FD6G";
	protected static final String FACET_SALESTEAM = "navigationitemxTPAZoga0KcVYpIoWTcgIG";
	protected static final String FACET_INVOLVEDPARTY = "navigationitemH4VDo92VPKAY29QXIK6Zr0";
	protected static final String FACET_ATTACHMENTS = "navigationitemzXaWgo_sL6aksO86OHFtJxm";//
	protected static final String FACET_MARKETING_PERMISSIONS = "navigationitemcG02IQCEqKs0e3vtttKBs0";

	// Activites partial ids
	protected static final String NEW_APPOINTMENT = "buttonmyLb1w4RvaIWe5ezNHNETG";
	protected static final String NEW_TASK = "buttonLhsqpFXiNK2fO8A7w9YWMm";
	protected static final String NEW_PHONECALL = "buttonkRd8HMMebak35x1ITc7g4W";

	// Edit Fields
	/**
	 * COMMON FIELDS FOR EXISTING AND NON EXISTING ACCOUNTS
	 */
	public static final String NAME = "inputfieldav2Clb0RHq_TkSRdy2j80m";
	public static final String STATUS = "dropdownlistboxwQCrVcgPYac0FlASY1bS0m";
	public static final String QUALIFICATION_LEVEL = "dropdownlistboxZqr5yFeb4qciNzoHu01cT0";//
	public static final String SOURCE = "dropdownlistboxHAMY3gCKTqQMJosV5la0b0";
	public static final String CATEGORY = "dropdownlistboxt1cZp65cfKoGEXn6ZkDIj0";
	public static final String PRIORITY = "dropdownlistboxb0f3JmtTV4Qc02A5jNtHBW";
	public static final String STARTDATE = "inputfieldrpDlO_sE6E4cnvNrVCLz_Pm";
	public static final String ENDDATE = "inputfieldnKspRpMxJqQcSe8j0h3feG";
	public static final String OWNER = "objectvalueselectorlOws41O3mqEtAPbeUAX9QW";
	public static final String MARKETINGUNIT = "objectvalueselectorGFDNEhV5AaIduiximYj1oW";
	public static final String NOTE = "__area";
	public final static String HITLIST_ITEM_PARTIAL_ID = "statictext";

	/**
	 * ONLY FOR EXISTING ACCOUNTS
	 */
	public static final String ACCOUNT = "objectvalueselectorPjx8_shXiKaws352ZCvsOyG";
	public static final String CONTACT = "objectvalueselectorbqMgQm9LvaIx9kfrxBbTb0";
	public static final String CAMPAIGN = "objectvalueselectorwZ_saEbEqLKkfNCEX3A1rp0";

	/**
	 * ONLY FOR NON EXISTING ACCOUNTS
	 */

	public static final String COMPANY = "inputfield4ltELp2BkqYCgaajtbw6uW";
	public static final String CONTACT_FIRST_NAME = "inputfieldGmfFSQitIKQdPUqqL6Yjn0";
	public static final String CONTACT_LAST_NAME = "inputfielde8lKGQZhYa_w9CXbztYvsm";
	
	public static final String HOUSE_NO = "inputfieldXRmaQSdb74cmTGuko";
	public static final String STREET = "inputfieldzeGKadpXN4U1MIYIupaCCm";
	public static final String CITY = "inputfieldnblSRyyVuqsTOirK_HaFem";
	public static final String COUNTRY = "dropdownlistbox8dlfmwGm3KE6tHvH8bLiZ0";
	public static final String STATE = "dropdownlistboxKe_No9yHEaE_GKvDinVpSm";
	
	public static final String POSTAL_CODE = "inputfield9_EHUtzsDKg9I6vTgL8UcW";
	public static final String LANGUAGE = "dropdownlistbox_ftAGODvhaoSuaqnETAnQG";
	public static final String PHONE = "inputfieldYbrjQa9WHKoRsAQ17NDg8G";
	public static final String MOBILE = "inputfield2nstqsd8nqgWEB0uXLm";
	public static final String EMAIL = "inputfieldDocimVy_swKMYCU9LA7zx4G";

	public static final String ADD_PRODUCTS_BUTTON = "buttonoq88oj7g04IT2Bu2sw9G7m";
	public static final String ADD_CONTACTS_BUTTON = "buttonsZOMeHKUAa2_aHxtYFY090";
	public static final String ADD_SALESTEAM_BUTTON = "buttonHpmMT4hH64wFrYsSbioSr0";
	public static final String ADD_INVOLVEDPARTY_BUTTON = "button7HOxSFDBNaIwqGweN4iATm";
	public static final String ADD_ATTACHMENTS_BUTTON = "buttonNpRCE_shlAagwzT_s5ACEYYW";

	public MarketingLeadTI(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		actionMenuButton = "buttonqpXYtnTxvqo6RD_spzIlokm";
		editButton = "actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle";
		saveButton = "actionBar-buttonri5eGNT8EK_NrSYPtZASbW";
		cancelButton = "actionBar-button5rtVsqpFkaYY0zNoRM8ADm";

		tiName = "MarketingLead";
	}

	/*
	 * Inner navigations
	 */

	public boolean changeTabToOverview() throws Exception {
		
		return this.changeTab(MarketingLeadTI.FACET_OVERVIEW, "NavigateToOverview");
	}

	public boolean changeTabToFeed() throws Exception {
		
		return this.changeTab(MarketingLeadTI.FACET_FEED, "NavigateToFeed");
	}

	public boolean changeTabToContacts() throws Exception {

		return this.changeTab(MarketingLeadTI.FACET_CONTACTS, "NavigateToContacts");

	}

	public boolean changeTabToActivities() throws Exception {

		return this.changeTab(MarketingLeadTI.FACET_ACTIVITES,"NavigateToSalesActivities");
	}

	public boolean changeTabToProducts() throws Exception {
		
		return this.changeTab(MarketingLeadTI.FACET_PRODUCTS, "NavigateToProducts");
	}

	public boolean changeTabToSalesTeam() throws Exception {
		
		return this.changeTab(MarketingLeadTI.FACET_SALESTEAM, "NavigateToSalesTeam");
	}

	public boolean changeTabToInvolvedParty() throws Exception {
		
		return this.changeTab(MarketingLeadTI.FACET_INVOLVEDPARTY,"NavigateToInvolvedParty");
	}

	public boolean changeTabToAttachments() throws Exception {
		
		return this.changeTab(MarketingLeadTI.FACET_ATTACHMENTS,"NavigateToAttachments");
	}
	
	public boolean changeTabToConversion() throws Exception {
		
		return this.changeTab(MarketingLeadTI.FACET_CONVERSION,"NavigateToConversions");
	}

	/*
	 * Contact tab
	 */
	private ContactQC navigateAndGetContactQC() throws Exception {

		this.clickButton(MarketingLeadTI.ADD_CONTACTS_BUTTON, "CreateContact_"
				+ tiName);
		Thread.sleep(5000);
		return new ContactQC(driver);
	}

	public void newContactAndOpen(Map<String, String> data) throws Exception {
		this.navigateAndGetContactQC().createAndOpen(data);
	}

	public void newContactAndNew(Map<String, String> data) throws Exception {
		this.navigateAndGetContactQC().createAndNew(data);
	}

	public void newContact(Map<String, String> data) throws Exception {
		this.navigateAndGetContactQC().createAndSave(data);
	}

	/*
	 * Activites tab
	 */

	private AppointmentQC navigateAndGetAppointmentQC() throws Exception {

		this.clickButton(MarketingLeadTI.NEW_APPOINTMENT, "CreateContact_"
				+ tiName);
		Thread.sleep(5000);
		return new AppointmentQC(driver, this.testName);
	}

	private ProductFacet navigateAndGetProductsFacet() throws Exception {

		this.clickButton(MarketingLeadTI.ADD_PRODUCTS_BUTTON, "AddProduct_"
				+ tiName);
		Thread.sleep(5000);
		return new ProductFacet(driver, this.tiName, this.testName);
	}

	private ContactFacet navigateAndGetContactFacet() throws Exception {

		this.clickButton(MarketingLeadTI.ADD_CONTACTS_BUTTON, "AddContact_"
				+ tiName);
		Thread.sleep(5000);
		return new ContactFacet(driver, this.tiName, this.testName);
	}

	private SalesAndMarketingTeamFacet navigateAndGetSalesTeamFacet()
			throws Exception {

		this.clickButton(MarketingLeadTI.ADD_SALESTEAM_BUTTON, "AddSalesTeam_"
				+ tiName);
		Thread.sleep(5000);
		return new SalesAndMarketingTeamFacet(driver, this.tiName,
				this.testName);
	}

	private InvolvedPartiesFacet navigateAndGetInvolvedPartiesfacet()
			throws Exception {

		this.clickButton(MarketingLeadTI.ADD_INVOLVEDPARTY_BUTTON,
				"AddInvolvedParty_" + tiName);
		Thread.sleep(5000);
		return new InvolvedPartiesFacet(driver, this.tiName, this.testName);
	}

	// private AttachmentsFacet navigateAndGetAttachmentsFacet() throws
	// Exception
	// {
	// this.changeTabToAttachments();
	//
	// this.clickButton(MarketingLeadTI.ADD_ATTACHMENTS_BUTTON,
	// "AddAttachments_"+tiName);
	// Thread.sleep(5000);
	// return new AttachmentsFacet(driver,this.tiName, this.testName);
	// }

	private TaskQC navigateAndGetTaskQC() throws Exception {

		this.clickButton(MarketingLeadTI.NEW_TASK, "CreateTask_" + tiName);
		Thread.sleep(5000);
		return new TaskQC(driver, this.testName);
	}

	private PhoneCallQC navigateAndGetPhoneCallQC() throws Exception {

		this.clickButton(MarketingLeadTI.NEW_PHONECALL, "CreatePhoneCall_"
				+ tiName);
		Thread.sleep(5000);
		return new PhoneCallQC(driver, this.testName);
	}

	public void newAppointment(Map<String, String> data) throws Exception {
		this.navigateAndGetAppointmentQC().createAndSave(data);
	}

	public void addProduct(Map<String, String> data) throws Exception {
		this.navigateAndGetProductsFacet().addAndSave(data);
	}

	public void addAndNewProduct(Map<String, String> data) throws Exception {
		this.navigateAndGetProductsFacet().addAndNew(data);
	}

	public void addContact(Map<String, String> data) throws Exception {
		this.navigateAndGetContactFacet().addAndSave(data);
	}

	public void addAndNewContact(Map<String, String> data) throws Exception {
		this.navigateAndGetContactFacet().addAndNew(data);
	}

	public void addSalesTeam(Map<String, String> data) throws Exception {
		this.navigateAndGetSalesTeamFacet().addAndSave(data);
	}

	public void addAndNewSalesTeam(Map<String, String> data) throws Exception {
		this.navigateAndGetSalesTeamFacet().addAndNew(data);
	}

	public void addInvolvedParty(Map<String, String> data) throws Exception {
		this.navigateAndGetInvolvedPartiesfacet().addAndSave(data);
	}

	public void addAndNewInvolvedParty(Map<String, String> data)
			throws Exception {
		this.navigateAndGetInvolvedPartiesfacet().addAndNew(data);
	}

	public void newTask(Map<String, String> data) throws Exception {
		this.navigateAndGetTaskQC().createAndSave(data);
	}

	public void newTaskAndNew(Map<String, String> data) throws Exception {
		this.navigateAndGetTaskQC().createAndNew(data);
	}

	public void newTaskAndOpen(Map<String, String> data) throws Exception {
		this.navigateAndGetTaskQC().createAndOpen(data);
	}

	public void newTaskAndComplete(Map<String, String> data) throws Exception {
		this.navigateAndGetTaskQC().createAndComplete(data);
	}

	public void newPhoneCall(Map<String, String> data) throws Exception {
		this.navigateAndGetPhoneCallQC().createAndSave(data);
	}

	public void newPhoneCallAndNew(Map<String, String> data) throws Exception {
		this.navigateAndGetPhoneCallQC().createAndNew(data);
	}

	public void newPhoneCallAndOpen(Map<String, String> data) throws Exception {
		this.navigateAndGetPhoneCallQC().createAndOpen(data);
	}

	/*
	 * Actions
	 */
	public Boolean executeActionConvertToSalesLead() throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(MarketingLeadTI.ACTION_CONVERT_TO_SALESLEAD))

		{
			if (isActionEnabled(MarketingLeadTI.ACTION_CONVERT_TO_SALESLEAD))

			{
				this.jsClick(this.getAction(MarketingLeadTI.ACTION_CONVERT_TO_SALESLEAD));
				isexecuted = true;
			} else

			{
				System.out.println("Called ACTION_CONVERT_TO_SALESLEAD not Enabled");
				isexecuted = false;

			}
		} else

		{
			System.out.println("Called ACTION_CONVERT_TO_SALESLEAD not exists");
			isexecuted = false;
		}

		return isexecuted;

	}

	public Boolean executeActionConvertToOpportunity() throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(MarketingLeadTI.ACTION_CONVERT_TO_OPPORTUNITY))

			{
						if (isActionEnabled(MarketingLeadTI.ACTION_CONVERT_TO_OPPORTUNITY))

								{
										this.jsClick(this.getAction(MarketingLeadTI.ACTION_CONVERT_TO_OPPORTUNITY));
										isexecuted = true;
								} 
						else

								{
										System.out.println("Called ACTION_CONVERT_TO_OPPORTUNITY not Enabled");
										isexecuted = false;

								}
			} 
		
		else

			{
					System.out.println("Called ACTION_CONVERT_TO_OPPORTUNITY not exists");
					isexecuted = false;
			}

		return isexecuted;

	}

	public Boolean executeActionConvertToAccountAndContact() throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(MarketingLeadTI.ACTION_CONVERT_TO_ACCOUNT_AND_CONTACT))

			{
				if (isActionEnabled(MarketingLeadTI.ACTION_CONVERT_TO_ACCOUNT_AND_CONTACT))

					{
							this.jsClick(this.getAction(MarketingLeadTI.ACTION_CONVERT_TO_ACCOUNT_AND_CONTACT));
							isexecuted = true;
					} 
			
			else

					{
							System.out.println("Called ACTION_CONVERT_TO_ACCOUNT_AND_CONTACT not Enabled");
							isexecuted = false;

					}
			} 
		
		else

				{
							System.out.println("Called ACTION_CONVERT_TO_ACCOUNT_AND_CONTACT not exists");
							isexecuted = false;
				}

		return isexecuted;

	}

	public boolean executeActionAssociateAccountAndContact() throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(MarketingLeadTI.ACTION_ASSOCIATE_ACCOUNT_AND_CONTACT))

		{
			if (isActionEnabled(MarketingLeadTI.ACTION_ASSOCIATE_ACCOUNT_AND_CONTACT))

			{
				this.jsClick(this
						.getAction(MarketingLeadTI.ACTION_ASSOCIATE_ACCOUNT_AND_CONTACT));
			} else

			{
				System.out
						.println("Called ACTION_ASSOCIATE_ACCOUNT_AND_CONTACT not Enabled");
				isexecuted = false;

			}
		} else

		{
			System.out
					.println("Called ACTION_ASSOCIATE_ACCOUNT_AND_CONTACT not exists");
			isexecuted = false;
		}

		return isexecuted;

	}

	public Boolean executeActionRefreshSurvey() throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(MarketingLeadTI.ACTION_REFRESH_SURVEY))

		{
			if (isActionEnabled(MarketingLeadTI.ACTION_REFRESH_SURVEY))

			{
				this.jsClick(this
						.getAction(MarketingLeadTI.ACTION_REFRESH_SURVEY));
			} else

			{
				System.out.println("Called ACTION_REFRESH_SURVEY not Enabled");
				isexecuted = false;

			}
		} else

		{
			System.out.println("Called ACTION_REFRESH_SURVEY not exists");
			isexecuted = false;
		}

		return isexecuted;

	}

	public boolean executeActionCopy() throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(MarketingLeadTI.ACTION_COPY))

		{
			if (isActionEnabled(MarketingLeadTI.ACTION_COPY))

			{

				this.jsClick(this.getAction(MarketingLeadTI.ACTION_COPY));
			}

			else

			{
				System.out.println("Called ACTION_COPY not Enabled");
				isexecuted = false;

			}
		} else

		{
			System.out.println("Called Action Copy not exists");
			isexecuted = false;
		}

		return isexecuted;
	}

	public void ModifyMarketingLeadSummary(Map<String, String> data)
			throws InterruptedException {
		String value;
		WebElement elem;

		for (String key : data.keySet()) {
			value = data.get(key);
			switch (key) {

			case MarketingLeadTI.NAME:

				elementToSendKey(By2.partialId(MarketingLeadTI.NAME), 1, value);

				break;

			case MarketingLeadTI.ACCOUNT:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(MarketingLeadTI.ACCOUNT, value,
							"Account", MarketingLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case MarketingLeadTI.COMPANY:

				elementToSendKey(By2.partialId(MarketingLeadTI.COMPANY), 1,
						value);

				break;

			case MarketingLeadTI.CONTACT:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(MarketingLeadTI.CONTACT, value,
							"Contact", MarketingLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case MarketingLeadTI.CONTACT_FIRST_NAME:

				elementToSendKey(
						By2.partialId(MarketingLeadTI.CONTACT_FIRST_NAME), 1,
						value);

				break;

			case MarketingLeadTI.CONTACT_LAST_NAME:

				elementToSendKey(
						By2.partialId(MarketingLeadTI.CONTACT_LAST_NAME), 1,
						value);

				break;

			case MarketingLeadTI.STATUS:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(MarketingLeadTI.STATUS,
								"input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case MarketingLeadTI.QUALIFICATION_LEVEL:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								MarketingLeadTI.QUALIFICATION_LEVEL, "input"),
						1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case MarketingLeadTI.SOURCE:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(MarketingLeadTI.SOURCE,
								"input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case MarketingLeadTI.CATEGORY:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(MarketingLeadTI.CATEGORY,
								"input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case MarketingLeadTI.PRIORITY:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(MarketingLeadTI.PRIORITY,
								"input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case MarketingLeadTI.STARTDATE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(MarketingLeadTI.STARTDATE), 1)) != null) {
					// this.fill_datetime(MarketingLeadTI_Model.STARTDATE,
					// value);

					this.DatePickerbyID(MarketingLeadTI.STARTDATE, value);

				}
				break;

			case MarketingLeadTI.ENDDATE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(MarketingLeadTI.ENDDATE), 1)) != null) {
					this.fill_datetimebyID(MarketingLeadTI.ENDDATE, value);

					// this.DatePicker(MarketingLeadTI_Model.STARTDATE_ELEMENT_NAME,
					// value);

				}
				break;

			case MarketingLeadTI.CAMPAIGN:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(MarketingLeadTI.CAMPAIGN,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(MarketingLeadTI.CAMPAIGN, value,
							"Campaign", MarketingLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case MarketingLeadTI.OWNER:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(MarketingLeadTI.OWNER, value, "Owner",
							MarketingLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case MarketingLeadTI.MARKETINGUNIT:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(

						"objectvalueselector", "ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(MarketingLeadTI.MARKETINGUNIT, value,
							"Marketing Unit",
							MarketingLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case MarketingLeadTI.NOTE:

				elementToSendKey(By2.partialId(MarketingLeadTI.NOTE), 1, value);

				break;
				
			case MarketingLeadTI.HOUSE_NO:
				elementToSendKey(By2.partialId(MarketingLeadTI.HOUSE_NO), 1, value);

				break;

			// done
			case MarketingLeadTI.STREET:

				if ((elem = this.getElementIfExisting(
						By2.partialId(MarketingLeadTI.STREET), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;
				

			case MarketingLeadTI.CITY:
				elementToSendKey(By2.partialId(MarketingLeadTI.CITY), 1, value);

				break;

			// done
			case MarketingLeadTI.COUNTRY:

				if ((elem = this.getElementIfExisting(
						By2.partialId(MarketingLeadTI.COUNTRY), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			// done
			case MarketingLeadTI.STATE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(MarketingLeadTI.STATE), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;
				
			case MarketingLeadTI.POSTAL_CODE:

				elementToSendKey(By2.partialId(MarketingLeadTI.POSTAL_CODE), 1, value);
				break;

				// done
			case MarketingLeadTI.LANGUAGE:

								if ((elem = this.getElementIfExisting(
										By2.startsWithAndPartialId(MarketingLeadTI.LANGUAGE,"input"), 1)) != null) {
									this.fillDropDown(elem, value);
								}
								break;
			case MarketingLeadTI.PHONE:

				elementToSendKey(By2.partialId(MarketingLeadTI.PHONE), 1, value);
				break;

			case MarketingLeadTI.MOBILE:

				elementToSendKey(By2.partialId(MarketingLeadTI.MOBILE), 1,
						value);
				break;

			case MarketingLeadTI.EMAIL:

				elementToSendKey(By2.partialId(MarketingLeadTI.EMAIL), 1, value);

				break;
			default:
				// Fill the remaining simple fields
				try {
					this.elementToClear(By2.partialId(key), 60);
					this.elementToSendKey(By2.partialId(key), 60, value);
				} catch (Exception nopartialID) {
					try {
						this.elementToClear(By2.label(key), 60);
						this.elementToSendKey(By2.label(key), 60, value);
					} catch (Exception nolabel) {

						Assert.fail("Field with name " + value
								+ " was not found in web page");

					}
				}
			}
		}

		Thread.sleep(5000);
	}

	/*
	 * Attachment facet
	 */
	private void navigateAndGetAttachementFacet() throws Exception {
		this.changeTabToAttachments();
		Thread.sleep(5000);
		this.clickButton("buttonNpRCE_shlAagwzT_s5ACEYYW", "Add attachment"	+ tiName);
		Thread.sleep(5000);
		//return new AttachmentFacet(driver, testCaseName);
	}

	public void addAttachement_LocalFile(String pathOfFile)
			throws Exception {
		this.navigateAndGetAttachementFacet();// .createAndOpen(data);

		this.jsClick(this.getAction(ConstantAttachment.Attachement_LocaLFile));

		Thread.sleep(5000);
		this.clickButton1("//*[contains(./@id, 'fileuploadhL3U_sxKp64o90AzezqBg1W') and contains(./@id, 'form')]//*[ contains(./@id, 'button')]",
				"addAttachement_Weblink");
		Thread.sleep(5000);
		new AttachmentFacet(driver, this.testName).AddAttachment_LocalFile(pathOfFile);

		this.clickButton("button_sN_sfJr_zSqwrn4o4HCd","addAttachement_Weblink" + tiName);

	}

	public void addAttachement_Weblink(Map<String, String> data) throws Exception {
		this.navigateAndGetAttachementFacet();// .createAndNew(data);
		this.jsClick(this.getAction(ConstantAttachment.Attachement_Weblink));
		Thread.sleep(5000);

		new AttachmentFacet(driver, this.testName).AddAttachment_WebLink(data);
		Thread.sleep(2000);

		this.clickButton("buttontdiGV_dgy4YZluDYDy4Wam","addAttachement_Weblink" + tiName);
	}

	public void addAttachement_FromLibrary(String data) throws Exception {
		this.navigateAndGetAttachementFacet();
		this.clickButton(ConstantAttachment.Attachement_FromLibrary,"addAttachement_FromLibrary" + tiName);
		
		new AttachmentFacet(driver, this.testName).AddAttachment_FromLibrary("");
		
		Thread.sleep(5000);
	}
	
	
	protected void clickButton1(String xPath,String measurementName) throws InterruptedException {
		WebElement elem = this.elementToFindExplicit(By2.Xpath(xPath),1);

		PerformanceRunner.startMeasurement(measurementName);
		elem.click();
		PerformanceRunner.stopMeasurement();

		Thread.sleep(3000);
	}
}



