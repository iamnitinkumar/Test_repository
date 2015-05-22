package com.sap.selenium.c4c.components;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class SalesLeadTI extends BaseTI {
	
	// ID's for Modify
		public static final String NAME = "inputfieldrMuuBhAvJ4QSHNxfsZlERG";//
		public static final String ACCOUNT = "objectvalueselectorWOlR8wTtj4QQKp6ZD8NYMG";//
		public static final String PRIMARYCONTACT = "objectvalueselectorXErecx0wR4_rVhhKOSKPf0";//

		public static final String STATUS_REASON = "inputfieldwGZNW_sjfnqUkyZVPg9k_sR0";//
//		public static final String SOURCE = "dropdownlistbox2WDyNvQLP4A6yKNtaQtSfG";
		public static final String QUALIFICATIONLEVEL = "dropdownlistboxphQy0PXsn4krHZB0_s0d3Rm";//
		public static final String CATEGORY = "dropdownlistboxIFt19rDewagwE97HFY3CEm";//
		public static final String PRIORITY = "dropdownlistboxMn9B2qy_sTq6oM8TVw_U5vW";//
		public static final String STARTDATE = "inputfieldc26sAUuI1qwcadIJmeqysW";//
		public static final String ENDDATE = "inputfieldLpN3rZtyfaor8qnHCR_GM0";//

		public static final String CAMPAIGN = "objectvalueselector_glVkkFAF4gvQuADfdZiRW";//
		public static final String OWNER_SALES = "objectvalueselectorl4eTm1J_cqQ1H_s7YFxPlGm";//
		public static final String OWNER_MARKETING = "objectvalueselectorKulKgmAoR4QFgabJf0TPZG";//

		public static final String MARKETINGUNIT = "objectvalueselectorG03f6DiCm4MRCWPkejx";//
		public static final String NOTE = "__area";
		public static final String SALESUNIT = "objectvalueselector7J0dGpxR94MTGfhBbDotDW";//

		public static final String TERRITORY_ID = "objectvalueselectorRg4LeeUS2Kgj7H1_ttdIq0";

		
		protected final static String HITLIST_ITEM_PARTIAL_ID = "statictext";

	protected static final String ACTION_SET_AS_ACCEPTED = "childnavigationitemhPpdnyQMp4U8IyV0_";
	protected static final String ACTION_SET_AS_DECLINE = "childnavigationitemwjnxfC0Q94wwSEtiLM3kwm";
	protected static final String ACTION_COPY = "childnavigationitemr4u2_ssXA2KA5p_sibJuyQiW";
	protected static final String ACTION_CONVERT_TO_OPPORTUNITY = "childnavigationitemAC4p7mxQqK2y2EtuLji0QG";

	private String testCaseName;

	/*
	 * Add/Cancel buttons have no specific ID
	 */
	protected static final String ADDRESS_DIALOG_ADD_BUTTON = "Add";
	protected static final String ADDRESS_DIALOG_CANCEL_BUTTON = "Cancel";

	protected static final String ADDRESS_ADD_BUTTON = "buttonqIvHTMTziKYLgkzLwjLrOW_";

	public static final String REASON_INPUT = "dropdownlistboxbWaRtgcosKEUHEZdYD71Am_";
	public static final String REASON_OK_BUTTON = "buttonYaZrJYQcwaskOwo3kzaJ7G_";
	
	private static final String NEW_PHONECALL = "button0lhweg4sx4wn31Y8vMg";
	private static final String NEW_TASK = "buttonepeXbliF74_GwIveNSyrYG";

	/*
	 * 
	 */

	public SalesLeadTI(WebDriver webDriver, String testCaseName) {

		super(webDriver);
		// ToDo change all the IDs !!!!!

		actionMenuButton = "buttonFoosqTxKz4ku2WgTMOVtBG_";

		editButton = "-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle_";
		saveButton = "-actionBar-buttonfZKh0hBYQKEb08_sdsV6WYm_";
		cancelButton = "-actionBar-button9WJx1Kntpq_iYxpe67uram_";
		this.testCaseName = testCaseName;
		tiName = "Saleslead";
	}

	/*
	 * Inner navigations
	 */

	public Boolean changeTabToActivities() throws Exception {
		return this.changeTab("navigationitemdQRIJUGOaKAjBaQj71_sak0_",
				"NavigateToActivities");
	}

	public Boolean changeTabToContacts() throws Exception {

		System.out.println("changeTabToContacts() Called");
		return this.changeTab("navigationitemTeZe5HZ6yqAMVHMpqeaRiG_",
				"NavigateToContatcs");
	}

	public boolean changeTabToOverview() throws Exception {
		return this.changeTab("navigationitemFqGbbNCnY4YTmF2lmwdsnW_",
				"NavigateToOverview");
	}

	public boolean changeTabToProducts() throws Exception {
		return this.changeTab("navigationitemc5xq2QXW4qU6wPMbZebTP0_",
				"NavigateToFeed");
	}

	public boolean changeTabToFeed() throws Exception {
		return this.changeTab("navigationitemGM7IWPdD_sawX8lY4K6Dfhm_",
				"NavigateToFeed");
	}

	public boolean changeTabToSalesAndMarketingTeam() throws Exception {
		return this.changeTab("navigationitemrLccD69qwaUY1MIKHLwRDG_",
				"NavigateToAccountTeam");
	}

	public boolean changeTabToInvolvedParties() throws Exception {
		return this.changeTab("navigationitemwWu_sKaq80K2u7_sr1LD8fZm_",
				"NavigateToAccountAddresses");
	}

	public boolean changeTabToOpportunities() throws Exception {
		return this.changeTab("navigationitemSbMkxR4djKMaQt9p822nmm_",
				"NavigateToOpportunities");
	}

	public boolean changeTabToAttachements() throws Exception {
		return this.changeTab("navigationitemUmQVyYc5zKw_s8fpxxC8yx0_",
				"NavigateToAttachments");
	}

	public boolean changeTabToSavo() throws Exception {
		return this.changeTab("navigationitemgqLP_sWjaJakQ7gdQ9yzpF0_",
				"NavigateToSavo");
	}

	/*
	 * Activities tab
	 */

	/*
	 * Appointment
	 */

	private AppointmentQC navigateAndGetAppointmentQC() throws Exception {
		this.changeTabToActivities();

		this.clickButton("buttonZge2qAR9E4AZQq2GhkH7P0_", "CreateAppointment_"
				+ tiName);
		Thread.sleep(5000);
		return new AppointmentQC(driver, testCaseName);
	}

	public void newAppointment(Map<String, String> data) throws Exception {
		this.navigateAndGetAppointmentQC().createAndSave(data);
		;
	}

	public void newAppointmentAndNew(Map<String, String> data) throws Exception {
		this.navigateAndGetAppointmentQC().createAndNew(data);
	}

	public void newAppointmentAndOpen(Map<String, String> data) throws Exception {
		this.navigateAndGetAppointmentQC().createAndOpen(data);
	}

	/*
	 * Task
	 */

	private TaskQC navigateAndGetTasksQC() throws Exception {
		this.changeTabToActivities();

		this.clickButton("buttonepeXbliF74_GwIveNSyrYG_", "CreateTasks_"
				+ tiName);
		Thread.sleep(5000);
		return new TaskQC(driver, testCaseName);
	}

	public void newTasks(Map<String, String> data) throws Exception {
		this.navigateAndGetTasksQC().createAndSave(data);
		;
	}

	public void newTasksAndNew(Map<String, String> data) throws Exception {
		this.navigateAndGetTasksQC().createAndNew(data);
	}

	public void newTasksAndOpen(Map<String, String> data) throws Exception {
		this.navigateAndGetTasksQC().createAndOpen(data);
	}

	/*
	 * Contact tab
	 */
	private ContactQC navigateAndGetContactQC() throws Exception {
		this.changeTabToContacts();

		this.clickButton("buttonGNt3C7cSBaUHwsb9WbM4zG", "CreateContact_"
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
	 * Opportunity tab
	 */

	private OpportunityQC navigateAndGetOpportunityQC() throws Exception {
		this.changeTabToOpportunities();

		this.clickButton("button7mU9LFknWa2LyNYac_c4w0", "CreateOpportunity_"
				+ tiName);
		Thread.sleep(5000);
		return new OpportunityQC(driver, this.testCaseName);
	}

	
	private TaskQC navigateAndGetTaskQC() throws Exception {

		this.clickButton(SalesLeadTI.NEW_TASK, "CreateTask_" + tiName);
		Thread.sleep(5000);
		return new TaskQC(driver, this.testName);
	}

	private PhoneCallQC navigateAndGetPhoneCallQC() throws Exception {

		this.clickButton(SalesLeadTI.NEW_PHONECALL, "CreatePhoneCall_"
				+ tiName);
		Thread.sleep(5000);
		return new PhoneCallQC(driver, this.testName);
	}
	
	public void newOpportunity(Map<String, String> data) throws Exception {
		this.navigateAndGetOpportunityQC().createAndSave(data);
		;
	}

	public void newOpportunityAndNew(Map<String, String> data) throws Exception {
		this.navigateAndGetOpportunityQC().createAndNew(data);
	}

	public void newOpportunityAndOpen(Map<String, String> data) throws Exception {
		this.navigateAndGetOpportunityQC().createAndOpen(data);
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

	
	public boolean executeActionSetAsAccept(String Reason) throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(SalesLeadTI.ACTION_SET_AS_ACCEPTED))

		{
			if (isActionEnabled(SalesLeadTI.ACTION_SET_AS_ACCEPTED))

			{

				if(this.jsClick(this.getAction(SalesLeadTI.ACTION_SET_AS_ACCEPTED)))
				{
					if (Reason != null) // select the reason for won id reason is passed
					{
						WebElement elem = driver.findElement(By2.startsWithAndPartialId(SalesLeadTI.REASON_INPUT, "-input"));
						this.fillDropDown(elem, Reason);
					}

					// click on ok
					this.clickButton(SalesLeadTI.REASON_OK_BUTTON, "Reason_OK_Button_Click");
				}
							
				
			}

			else

			{
				System.out.println("Called ACTION_Set_As_Accept not Enabled");
				isexecuted = false;

			}
		} else

		{
			System.out.println("Called ACTION_Set_As_Accept not exists");
			isexecuted = false;
		}

		return isexecuted;
	}
	
	
	public boolean executeActionSetAsDecline(String Reason) throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(SalesLeadTI.ACTION_SET_AS_DECLINE))

		{
			if (isActionEnabled(SalesLeadTI.ACTION_SET_AS_DECLINE))

			{

				if(this.jsClick(this.getAction(SalesLeadTI.ACTION_SET_AS_DECLINE)))
				{
					if (Reason != null) // select the reason for won id reason is passed
					{
						WebElement elem = driver.findElement(By2.startsWithAndPartialId(SalesLeadTI.REASON_INPUT, "-input"));
						this.fillDropDown(elem, Reason);
					}

					// click on ok
					this.clickButton(SalesLeadTI.REASON_OK_BUTTON, "Reason_OK_Button_Click");
				}
				
				
				
				
			}

			else

			{
				System.out.println("Called ACTION_Set_As_Decline not Enabled");
				isexecuted = false;

			}
		} else

		{
			System.out.println("Called ACTION_Set_As_Decline not exists");
			isexecuted = false;
		}

		return isexecuted;
	}

	

	public boolean executeActionCopy() throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(SalesLeadTI.ACTION_COPY))

		{
			if (isActionEnabled(SalesLeadTI.ACTION_COPY))

			{

				this.jsClick(this.getAction(SalesLeadTI.ACTION_COPY));
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

	
	public Boolean executeActionConvertToOpportunity() throws Exception {

		Boolean isexecuted = false;

		this.jsClick(this.getActionMenuButton());

		if (isActionExist(SalesLeadTI.ACTION_CONVERT_TO_OPPORTUNITY))

			{
						if (isActionEnabled(SalesLeadTI.ACTION_CONVERT_TO_OPPORTUNITY))

								{
										this.jsClick(this.getAction(SalesLeadTI.ACTION_CONVERT_TO_OPPORTUNITY));
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
	
	/*
	 * Products tab
	 */

	private ProductFacet navigateAndGetProductsFacet() throws Exception {
		System.out.println("navigateAndGetGetProductsFacet Called");
		Thread.sleep(5000);
		this.changeTabToProducts();
		System.out.println("changeTabToProducts Called");

		this.clickButton("button_slB7JLWMzaMdM2AsqPzimW", "AddInvolvedParty_"
				+ tiName);
		Thread.sleep(5000);
		return new ProductFacet(driver, tiName, testCaseName);
	}

	public void newProductsandAdd(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		this.navigateAndGetProductsFacet().addAndSave(data);
	}

	public void newProductsandAddNew(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		this.navigateAndGetProductsFacet().addAndNew(data);
	}

	/*
	 * Involved Party tab
	 */

	private InvolvedPartiesFacet navigateAndGetInoveledPartiesFacet() throws Exception {
		System.out.println("navigateAndGetInoveledPartiesQC Called");
		Thread.sleep(5000);
		this.changeTabToInvolvedParties();
		System.out.println("changeTabToInvolvedParties Called");

		this.clickButton("buttonqB0fznsvd4Ic16gcuwk8EW", "AddInvolvedParty_"
				+ tiName);
		Thread.sleep(5000);
		return new InvolvedPartiesFacet(driver, tiName, testCaseName);
	}

	public void newInvolvedPartyandAdd(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		this.navigateAndGetInoveledPartiesFacet().addAndSave(data);
	}

	public void newInvolvedPartyandAddNew(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		this.navigateAndGetInoveledPartiesFacet().addAndNew(data);
	}

	/*
	 * Contact Facet
	 */

	private ContactFacet navigateAndGetContactFacet() throws Exception {
		System.out.println("navigateAndGetContactFacet Called");
		Thread.sleep(5000);
		this.changeTabToContacts();
		System.out.println("changeTabToContactFacet Called");

		this.clickButton("buttonGNt3C7cSBaUHwsb9WbM4zG", "AddContact)_"
				+ tiName);
		Thread.sleep(5000);
		return new ContactFacet(driver, tiName, testCaseName);
	}

	public void addContactAddandNew(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		this.navigateAndGetContactFacet().addAndNew(data);
	}

	public void addContactAddAndSave(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		this.navigateAndGetContactFacet().addAndSave(data);
	}

	/*
	 * Sales And Marketing Team Facet
	 */

	private SalesAndMarketingTeamFacet navigateAndGetSalesAndMarketingTeamFacet() throws Exception {
		System.out.println("navigateAndGetSalesAndMarketingTeamFacet Called");
		Thread.sleep(5000);
		this.changeTabToSalesAndMarketingTeam();
		System.out.println("changeTabToSalesAndMarketingTeamFacet Called");

		this.clickButton("buttonRcKHDxdhHK_i9Zce8OQNqW", "AddInvolvedParty_"
				+ tiName);
		Thread.sleep(5000);
		return new SalesAndMarketingTeamFacet(driver, tiName, testCaseName);
	}

	public void newSalesAndMarketingTeamandAdd(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		this.navigateAndGetSalesAndMarketingTeamFacet().addAndSave(data);
	}

	public void newSalesAndMarketingTeamandAddNew(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		this.navigateAndGetSalesAndMarketingTeamFacet().addAndNew(data);
	}

	/*
	 * Attachment facet
	 */
	private void navigateAndGetAttachementFacet() throws Exception {
		this.changeTabToAttachements();
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
		this.jsClick(this.getAction(ConstantAttachment.Attachement_FromLibrary));
		Thread.sleep(5000);
		new AttachmentFacet(driver, this.testName).AddAttachment_FromLibrary(data);
		
		Thread.sleep(5000);
	}
	
	
	protected void clickButton1(String xPath,String measurementName) throws InterruptedException {
		WebElement elem = this.elementToFindExplicit(By2.Xpath(xPath),1);

		PerformanceRunner.startMeasurement(measurementName);
		elem.click();
		PerformanceRunner.stopMeasurement();

		Thread.sleep(3000);
	}

	public void ModifySalesLeadSummary(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		
		String value;
		WebElement elem;

		for (String key : data.keySet()) {
			value = data.get(key);

			// wait for 2sec after each data entry
			Thread.sleep(2000);

			switch (key) {

			case SalesLeadTI.NAME:

				this.elementToFindExplicit(By2.partialId(SalesLeadTI.NAME), 1)
						.sendKeys(value);
				break;

			case SalesLeadTI.ACCOUNT:

				// if ((elem = this.getElementIfExisting(By2
				// .startsWithAndPartialId("objectvalueselector",
				// "ButtonValueHelp"), 1)) != null) {
				this.valueHelpDialog(SalesLeadTI.ACCOUNT, value, "Account",
						SalesLeadTI.HITLIST_ITEM_PARTIAL_ID);
				// }
				break;

			case SalesLeadTI.PRIMARYCONTACT:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadTI.PRIMARYCONTACT, value,
							"Account", SalesLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadTI.STATUS_REASON:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadTI.STATUS_REASON, "-input"),
						1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadTI.QUALIFICATIONLEVEL:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadTI.QUALIFICATIONLEVEL,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			

			case SalesLeadTI.CATEGORY:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(SalesLeadTI.CATEGORY,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadTI.CAMPAIGN:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadTI.CAMPAIGN,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadTI.CAMPAIGN, value,
							"Campaign", SalesLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadTI.MARKETINGUNIT:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(

						"objectvalueselector", "ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadTI.MARKETINGUNIT, value,
							"Marketing Unit",
							SalesLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadTI.SALESUNIT:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(

						"objectvalueselector", "ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadTI.SALESUNIT, value,
							"Marketing Unit",
							SalesLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadTI.OWNER_MARKETING:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadTI.OWNER_MARKETING, value,
							"Owner", SalesLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadTI.OWNER_SALES:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadTI.OWNER_SALES, value,
							"Owner", SalesLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadTI.NOTE:

				this.elementToFindExplicit(By2.partialId(SalesLeadTI.NOTE), 1)
						.sendKeys(value);
				break;

			case SalesLeadTI.TERRITORY_ID:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadTI.TERRITORY_ID, value,
							"Sales Territory ID",
							SalesLeadTI.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadTI.PRIORITY:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(SalesLeadTI.PRIORITY,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadTI.STARTDATE:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(SalesLeadTI.STARTDATE,
								"-input"), 1)) != null) {
					// this.fill_datetime(SalesLeadTI.STARTDATE, value);

					this.DatePickerbyID(SalesLeadTI.STARTDATE, value);

				}
				break;

			case SalesLeadTI.ENDDATE:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadTI.ENDDATE, "-input"),
						1)) != null) {
					this.fill_datetimebyID(SalesLeadTI.ENDDATE, value);

					// this.DatePicker(SalesLeadTI.STARTDATE_ELEMENT_NAME,
					// value);

				}
				break;

			
			
			default:
				// Fill the remaining simple fields

				if ((elem = this.getElementIfExisting(By2.partialId(key), 1)) != null) {
					elem.sendKeys(value);
				} else {
					if ((elem = this.getElementIfExisting(By2.label(key), 1)) != null) {
						elem.sendKeys(value);
					}
				}
			}
		}

		Thread.sleep(5000);
		
	}
	
}
