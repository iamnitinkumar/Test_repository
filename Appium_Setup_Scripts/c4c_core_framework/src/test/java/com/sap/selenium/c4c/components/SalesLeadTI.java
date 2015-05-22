package com.sap.selenium.c4c.components;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class SalesLeadTI extends BaseTI {

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

	/*
	 * 
	 */

	public SalesLeadTI(WebDriver webDriver, String testCaseName) {

		super(webDriver);
		// ToDo change all the IDs !!!!!

		actionButton = "buttonFoosqTxKz4ku2WgTMOVtBG_";

		editButton = "-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle_";
		saveButton = "-actionBar-buttonfZKh0hBYQKEb08_sdsV6WYm_";
		cancelButton = "-actionBar-button9WJx1Kntpq_iYxpe67uram_";
		this.testCaseName = testCaseName;
		tiName = "Saleslead";
	}

	/*
	 * Inner navigations
	 */

	public void changeTabToActivities() throws Exception {
		this.changeTab("navigationitemdQRIJUGOaKAjBaQj71_sak0_",
				"NavigateToActivities");
	}

	public void changeTabToContacts() throws Exception {

		System.out.println("changeTabToContacts() Called");
		this.changeTab("navigationitemTeZe5HZ6yqAMVHMpqeaRiG_",
				"NavigateToContatcs");
	}

	public void changeTabToOverview() throws Exception {
		this.changeTab("navigationitemFqGbbNCnY4YTmF2lmwdsnW_",
				"NavigateToOverview");
	}

	public void changeTabToProducts() throws Exception {
		this.changeTab("navigationitemc5xq2QXW4qU6wPMbZebTP0_",
				"NavigateToFeed");
	}

	public void changeTabToFeed() throws Exception {
		this.changeTab("navigationitemGM7IWPdD_sawX8lY4K6Dfhm_",
				"NavigateToFeed");
	}

	public void changeTabToSalesAndMarketingTeam() throws Exception {
		this.changeTab("navigationitemrLccD69qwaUY1MIKHLwRDG_",
				"NavigateToAccountTeam");
	}

	public void changeTabToInvolvedParties() throws Exception {
		this.changeTab("navigationitemwWu_sKaq80K2u7_sr1LD8fZm_",
				"NavigateToAccountAddresses");
	}

	public void changeTabToOpportunities() throws Exception {
		this.changeTab("navigationitemSbMkxR4djKMaQt9p822nmm_",
				"NavigateToOpportunities");
	}

	public void changeTabToAttachements() throws Exception {
		this.changeTab("navigationitemUmQVyYc5zKw_s8fpxxC8yx0_",
				"NavigateToAttachments");
	}

	public void changeTabToSavo() throws Exception {
		this.changeTab("navigationitemgqLP_sWjaJakQ7gdQ9yzpF0_",
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

	/*
	 * Actions
	 */

	public void executeActionSetAsAccept(String Reason) throws Exception
	{
		this.jsClick(this.getAction(this.actionButton,
				SalesLeadTI.ACTION_SET_AS_ACCEPTED));
		// to do

		if (Reason != null) // select the reason for won id reason is passed
		{
			WebElement elem = driver.findElement(By2.startsWithAndPartialId(
					SalesLeadTI.REASON_INPUT, "-input"));
			this.fillDropDown(elem, Reason);
		}

		// click on ok
		this.clickButton(SalesLeadTI.REASON_OK_BUTTON, "Reason_OK_Button_Click");

	}

	public void executeActionSetAsDecline(String Reason) throws Exception {
		this.jsClick(this.getAction(this.actionButton,
				SalesLeadTI.ACTION_SET_AS_DECLINE));
		// to do

		if (Reason != null) // select the reason for won id reason is passed
		{
			WebElement elem = driver.findElement(By2.startsWithAndPartialId(
					SalesLeadTI.REASON_INPUT, "-input"));
			this.fillDropDown(elem, Reason);
		}

		// click on ok
		this.clickButton(SalesLeadTI.REASON_OK_BUTTON, "Reason_OK_Button_Click");

	}

	public void executeActionCopy() throws Exception {
		this.jsClick(this.getAction(this.actionButton, SalesLeadTI.ACTION_COPY));
	}

	public void executeActionConvertToOpportunity() throws Exception {
		this.jsClick(this.getAction(this.actionButton,
				SalesLeadTI.ACTION_CONVERT_TO_OPPORTUNITY));
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
