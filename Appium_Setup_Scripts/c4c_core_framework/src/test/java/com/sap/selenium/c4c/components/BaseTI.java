package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTI extends Base{

	public BaseTI(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	protected String actionButton;
	protected String actionMenuButton;
	protected String editButton = "DisplayEditToggle";
	protected String cancelButton;
	protected String copyAction;
	protected String saveButton;
	protected String newButton;
	protected String summaryButton;
	protected String TIname;
	protected String addTask;//this is for add task in Visit
	protected String addSurvey;//this is for add Survey in Visit;
	protected String addtaskchoose;
	protected String close = "sapUiUx3OverlayCloseButton";
	protected String ELEMENT_ID_POSTFIX;  	
	/* we can also build concatenate to auto add object name e.g.  "Edit_" + "Account"*/
	protected String measureEdit = "Edit";
	protected String measureSave = "Save";
	protected String measureCancel = "Cancel";

	protected String tiName;
	protected String subName;

	//For Attachments
	public static final String ATTACH_LOCAL_FILE_ID = "childnavigationitemF322lygitaESiGivtXT8f0";
	public static final String ATTACH_WEB_LINK_ID = "childnavigationitem_49v2790fqQSQhKR360Vym";
	public static final String ATTACH_LIBRARY_ID = "childnavigationitem3HEBKvP2xa6g4_sk6WqutO0";
	
	//For Attachments  
	protected String addAttachment;
	protected String weblinkAttachLink;
	protected String weblinkAttachTitle;
	protected String addWebLink;
	protected String libraryAttachSelect;
	
	
	/*
	//Values are same over all TIs.
	protected String ADD_ATTACHMENT = "buttonNpRCE_shlAagwzT_s5ACEYYW";
	protected String WEBLINK_ATTACH_LINK = "inputfieldNt4_v1yZ24gVM_sN3j6pqfW";
	protected String WEBLINK_ATTACH_TITLE = "inputfieldqxmA9DynDaoj8VCGC4au3W";
	protected String ADD_WEBLINK = "buttontdiGV_dgy4YZluDYDy4Wam";
	protected String LIBRARY_ATTACH_SELECT = "buttonUOJ_QK1xzq6kZ1UptkCTwW";
	*/
	
	//followup items
	protected String newFollowup;
	protected String appointmentFollowup;
	protected String taskFollowup;
	protected String phonecallFollowup;
	protected String leadFollowup;
	protected String salesleadFollowup;
	protected String opportunityFollowup;
	protected String ticketFollowup;
	protected String quoteFollowup;
	
	//related items
	protected String addRelatedItem;
	protected String referenceType;
	protected String referenceName;
	protected String addReference;
	protected String cancelReference;
	protected String addReferenceClass;
	protected String cancelReferenceClass;
	
	
	protected final String HITLIST_ITEM_PARTIAL_ID_REF ="inputfield"; 
	
	//changes
	protected String changesUser;
	protected String changesGo;
	protected String changesFirstRow;
		
	public void clickButton(String button) throws Exception{
		
		switch(button){
		case"SAVE":
			PerformanceRunner.startMeasurement("Save_TI_"+tiName);
	        this.elementToClick(By2.partialId(this.saveButton), 60);
	        PerformanceRunner.stopMeasurement();
	        break;
		case"EDIT":
			PerformanceRunner.startMeasurement("Edit_TI_"+tiName);
	        this.elementToClick(By2.partialId(this.editButton), 60);
	        PerformanceRunner.stopMeasurement();
	        break;
		case"SUMMARY":
			PerformanceRunner.startMeasurement("Open_Summary_TI_"+tiName);
	        this.elementToClick(By2.partialId(this.summaryButton), 60);
	        PerformanceRunner.stopMeasurement();
	        break;
		case"CANCEL":
			PerformanceRunner.startMeasurement("Cancel_TI_"+tiName);
	        this.elementToClick(By2.partialId(this.cancelButton), 60);
	        PerformanceRunner.stopMeasurement();
	        break;
		}
	}

	public void close() throws Exception
	{
		this.elementToClick(By2.className(close), 60);	
	}
	
	//TODO: replica with changes
	public void close2()
	{
		this.elementToClick2(By2.className(close), 60);	
	}

	public void edit() throws Exception
	{		 		
	     PerformanceRunner.startMeasurement("Edit_TI_"+tiName);
         this.elementToClick2(By2.partialId(editButton), 60);
         PerformanceRunner.stopMeasurement();
	}
	
	
	public void save() throws Exception
	{
		 PerformanceRunner.startMeasurement("Save_TI_"+tiName);
		 this.elementToClick(By2.partialId(saveButton), 60);
         PerformanceRunner.stopMeasurement();
	}
	
	//TODO: replica method with changes
	public void save2()
	{
		 PerformanceRunner.startMeasurement("Save_TI_"+tiName);
		 this.elementToClick2(By2.partialId(saveButton), 60);
         PerformanceRunner.stopMeasurement();
	}
	
	public void cancel()
	{
		 WebElement elem = this.getCancelButton();
		
	     PerformanceRunner.startMeasurement(measureCancel+tiName);
         elem.click();
         PerformanceRunner.stopMeasurement();
	}
	
	
	/*
	 * next two methods could probably also be merged
	 */
	protected void clickButton(String partialId, String measurementName)
			throws InterruptedException {
		System.out.println("Clicking button");
		WebElement elem = this.elementToFindExplicit(By2.partialId(partialId),15);
		System.out.println(elem);
			PerformanceRunner.startMeasurement(measurementName);
			elem.click();
			System.out.println(elem);
			PerformanceRunner.stopMeasurement();


		Thread.sleep(3000);
	}
	
	
	protected boolean changeTab(String partialId, String measurementName)
			throws Exception {
		boolean isTabChange = false;
		PerformanceRunner.startMeasurement("Open_" + tiName + "_Facet_"
				+ measurementName);
		if (this.elementToClick(By2.partialId(partialId), 60)) {
			isTabChange = true;
		}
		PerformanceRunner.stopMeasurement();

		Thread.sleep(3000);
		return isTabChange;
	}
	
	//TODO: replica with changes
	protected void changeTabIfExisting(String partialId, String measurementName) throws InterruptedException
	{
		 PerformanceRunner.startMeasurement("Open_" + tiName + "_Facet_" + measurementName);
         this.elementToClickIfExisting(By2.partialId(partialId), 60);
         PerformanceRunner.stopMeasurement();
        
        Thread.sleep(3000);
	}
	











	//Naviagte to Tab in the thing Inspector
	protected void NaviagteToFacet(String FacetName, String measurementName)
			throws InterruptedException {
		WebElement elem = this.elementToFindExplicit(
				By2.startsWithAndLabelText("navigationitem", FacetName), 15);

		if (elem != null) {
			PerformanceRunner.startMeasurement(measurementName);
			elem.click();
			PerformanceRunner.stopMeasurement();

			Thread.sleep(3000);
		}
	}





	public void clickFollowUnfollow()
	{
		
	}
	
	public void clickFlagUnFlag()
	{
		
	}

	public void clickAddRemoveFavorites()
	{
		
	}
	
	
	/* do we even still need those? */
	protected WebElement getEditButton()
	{
	   return driver.findElement(By2.partialId(editButton));
	}
	
	protected WebElement getSaveButton()
	{
	   return driver.findElement(By2.partialId(saveButton));
	}
	
	protected WebElement getCancelButton()
	{
	   return driver.findElement(By2.partialId(cancelButton));
	}
	
	protected WebElement getActionMenuButton()

	{
		return driver.findElement(By2.partialId(actionMenuButton));
	}

		protected WebElement getAction(String actionButtonPartialId,
			String actionPartialId) throws Exception {

		WebElement action = null;
		try {

			elementToClick2(By2.partialId(actionButtonPartialId), 2);

			Thread.sleep(5000);

			// Assert.assertTrue("Action not enabled",
			// isActionEnabled(actionPartialId));

			if (isActionExist(actionPartialId)) {
				action = driver.findElement(By2
						.linkByPartialId(actionPartialId));

			} else {
				System.out.println("Called Action not exists");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return action;
	}

	protected WebElement getAction(String actionPartialId) throws Exception {

		WebElement action = null;

		try {
			Thread.sleep(5000);

			action = driver.findElement(By2.linkByPartialId(actionPartialId));

		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}

		return action;
	}

	// check if the execute action is enabled/disabled
	
		/**
		 * isActionEnabled () : checks the Action enable or not
		 * 
		 * Method takes 1 parameters 
		 * @param partialID  : Action ID partial id
		 * @return boolean value : true: action exist
		 * 						 : false: action not exist
		 */
		public boolean isActionEnabled(String partialID) {
			
			boolean isenabled = false;
			
			if (isAttribtuePresent(driver.findElement(By2.partialId(partialID)),"aria-disabled")) 
			
				{
						if (driver.findElement(By2.partialId(partialID)).getAttribute("aria-disabled").equals("false"))
						
								{
										isenabled = true;

								} 
						else 
						
								{
										System.out.print("Attribute exists but not action is not enabled");
								}
				} 
				
			else 
			
				{
						System.out.print("Attribute does not exists");
				}
			
			return isenabled;
		}
		
		/**
		 * isActionEnabled () : checks the Action enable or not
		 * 
		 * Method takes 2 parameter.
		 * @param startsWith : Action ID Starts with
		 * @param partialID  : Action ID partial id
		 * @return boolean value : true: action exist
		 * 						 : false: action not exist
		 */
		public boolean isActionEnabled(String startsWith,String partialID) {
			boolean isenabled = false;
			if (isAttribtuePresent(driver.findElement(By2.startsWithAndPartialId(startsWith, partialID)),"aria-disabled"))
			
				{
						if (driver.findElement(By2.startsWithAndPartialId(startsWith, partialID)).getAttribute("aria-disabled").equals("false")) 
							{
								isenabled = true;
							} 
						else 
							{
								System.out.print("Attribute exists but not action is not enabled");
							}
				} 
			
			else 
			
				{
						System.out.print("Attribute does not exists");
				}
			
			return isenabled;
		}

		// check if the execute action is exist or not
		
		/**
		 * isActionExist () : checks the Action exist or not
		 * 
		 * Method takes 1 parameter.
		 * @param partialID : Action ID partial id
		 * @return boolean value : true: action exist
		 * 						 : false: action not exist
		 */
		public boolean isActionExist(String partialID) {
			
			boolean isExist = false;
			
			if (driver.findElements(By2.partialId(partialID)).size() != 0) 
			
				{
					isExist = true;

				}
			return isExist;
		}
		
		/**
		 * isActionExist () : checks the Action exist or not
		 * 
		 * Method takes 2 parameters 
		 * @param startsWith : Action ID Starts with
		 * @param partialID  : Action ID partial id
		 * @return boolean value : true: action exist
		 * 						 : false: action not exist
		 */
		public boolean isActionExist(String startsWith,String partialID) {
			
			boolean isExist = false;
			if (driver.findElements(By2.startsWithAndPartialId(startsWith, partialID)).size() != 0) 
			
				{
					isExist = true;

				}
			return isExist;
		}

	
	
	/*********Methods for Activities*****************/

	public void AddAttachmentsInActivity(String type) throws Exception {  // can add webdav. but only present in QXL.

		String childnav = null;
		//,text = null;

		switch (type) {

		case "localfile":
			childnav = ATTACH_LOCAL_FILE_ID;
			//text = "Local File";
			break;
		case "weblink":
			childnav = ATTACH_WEB_LINK_ID;
			//text = "Web Link";
			break;
		case "library":
			childnav = ATTACH_LIBRARY_ID;
			//text = "From Library";
			break;
		default:
			System.out.println("choose the correct child element");
			break;

		}

		Thread.sleep(5000);
		//Add button
		elementToClick(By2.partialId("buttonNpRCE_shlAagwzT_s5ACEYYW"), 5);

		Thread.sleep(1000);

		// childnavigationitem 
		jsClick(driver.findElement(By2.linkByPartialId(childnav)));
	}

	public void editActivityToAddAttachements() throws Exception
	{  
		/* Code for adding file from the windows window should be done. May
		 * be using AutoIt will be useful.
		 */

		// add button and child nav
		AddAttachmentsInActivity("weblink");

		// Link value
		elementToSendKey(By2.partialId("inputfieldNt4_v1yZ24gVM_sN3j6pqfW"), 5, "www.sap.com");

		// Title
		elementToSendKey(By2.partialId("inputfieldqxmA9DynDaoj8VCGC4au3W"), 5, "Link Title");

		// add link button
		elementToClick(By2.partialId("buttontdiGV_dgy4YZluDYDy4Wam"), 5);

		// add button and childnav
		AddAttachmentsInActivity("library");

		// Value from the pop up. 
		elementToClick(By2.startsWithAndPartialId("statictextzy_X4wqywKgJS63Cgl8MZ0", "col0-row0"), 5);

		// click on select button
		elementToClick(By2.partialId("buttonUOJ_QK1xzq6kZ1UptkCTwW"), 5);


		Thread.sleep(3000);

	}

	public void generateSummaryActivity(String actionId) throws Exception{

		jsClick(getAction(actionButton, actionId));
		Thread.sleep(10000);
	}
	
	public void AddAttachments(String type) throws Exception {  // can add webdav. but only present in QXL.

		String childnav = null;

		switch (type) {

		case "localfile":
			childnav = ATTACH_LOCAL_FILE_ID;
			break;
		case "weblink":
			childnav = ATTACH_WEB_LINK_ID;
			break;
		case "library":
			childnav = ATTACH_LIBRARY_ID;
			break;
		default:
			System.out.println("choose the correct child element");
			break;

		}
		
		Thread.sleep(5000);
		//Add button
		elementToClick(By2.partialId(addAttachment), 60);  
		Thread.sleep(1000);

		// childnavigationitem 
		jsClick(driver.findElement(By2.linkByPartialId(childnav)));
		Thread.sleep(3000);
   }
		
	public void editToAddAttachements(String link, String title) throws Exception
   {  
	    /* Code for adding file from the windows window should be done. May
		 * be using AutoIt will be useful.
		 */
	   
		// add button and child nav
	    AddAttachments("weblink");
		
		// Link value
		elementToSendKeyWithoutClear(By2.partialId(weblinkAttachLink), 60, link); 

		// Title
		elementToSendKey(By2.partialId(weblinkAttachTitle), 60, title);

		// add link button
		elementToClick(By2.partialId(addWebLink), 60);

		// add button and childnav
		AddAttachments("library");

		// Value from the pop up. 
		elementToClick(By2.startsWithAndPartialId("statictextzy_X4wqywKgJS63Cgl8MZ0_", "col0-row0"), 60);

		// click on select button
		elementToClick(By2.partialId(libraryAttachSelect), 60); 

		Thread.sleep(3000);
		
	}
	
	public void performActionActivity(String actionId) throws Exception{
		
		jsClick(getAction(actionButton, actionId));
		Thread.sleep(10000);
	}
	
	public void newFollowupItems(String type) throws InterruptedException {  

		String childnav = null;
		//,text = null;

		switch (type) {

		case "appointment":
			childnav = appointmentFollowup;
			break;
		case "task":
			childnav = taskFollowup;
			break;
		case "phonecall":
			childnav = phonecallFollowup;
			break;
		case "saleslead":
			childnav = salesleadFollowup;
			break;
		case "opportunity":
			childnav = opportunityFollowup;
			break;
		case "ticket":
			childnav = ticketFollowup;
			break;
		case "quote":
			childnav = quoteFollowup;
			break;
		default:
			System.out.println("choose the correct child element");
			break;

		}
		
		Thread.sleep(5000);
		//New button
		elementToClick2(By2.partialId(newFollowup), 60);
		
		Thread.sleep(1000);

		// childnavigationitem 
		jsClick(driver.findElement(By2.linkByPartialId(childnav)));
		Thread.sleep(3000);
   }
	
public void editToAddFollowupItems() throws InterruptedException {
		
		WebElement elem;
	
		// new in related items follow up buttonnIowqMzpQaMSpxZvMRAWZG
		newFollowupItems("appointment");
		Thread.sleep(1000);
		// Quick create of Appointment
		AppointmentQC appointment = new AppointmentQC(driver);
		appointment.selectSaveAction2(appointment.savePartialId, "Appointment_QC_Save");
		
		// new in related items follow up buttonnIowqMzpQaMSpxZvMRAWZG
		newFollowupItems("task");
		Thread.sleep(1000);
		// Quick Create of Task
		TaskQC task = new TaskQC(driver,"taskQC_followup");
		task.selectSaveAction2(task.savePartialId, "Task_QC_Save");
		
		// new in related items follow up buttonnIowqMzpQaMSpxZvMRAWZG
		newFollowupItems("phonecall");
		Thread.sleep(1000);
		// Quick create of Phonecall	
		PhoneCallQC phonecall = new PhoneCallQC(driver,"phonecallQC_followup");
		phonecall.selectSaveAction2(phonecall.savePartialId, "PhoneCall_QC_Save");
	
		// new in related items follow up buttonnIowqMzpQaMSpxZvMRAWZG
		newFollowupItems("saleslead");
		Thread.sleep(1000);
		//QC of Sales lead
		SalesLeadQC saleslead = new SalesLeadQC(driver,"salesleadQC_followup");
		//TODO: check. fill drop down for category. dropdownlistbox0aCjIfSb4aMvOCfQnVCxW0_1487-input  Prospect for consulting
		if ((elem = saleslead.getElementIfExisting(By2.startsWithAndPartialId("dropdownlistbox0aCjIfSb4aMvOCfQnVCxW0_", "-inpu"), 60))!= null)
		{
			saleslead.fillDropDown(elem, "Prospect for consulting");
		}	
		saleslead.selectSaveAction2(saleslead.savePartialId, "SalesLead_QC_Save");
	
		// new in related items follow up buttonnIowqMzpQaMSpxZvMRAWZG
		newFollowupItems("opportunity");
		Thread.sleep(1000);
		//QC of opportunity to do
		OpportunityQC opportunity = new OpportunityQC(driver,"opportunityQC_followup");
		//TODO: check. value help for owner. Mandatory. objectvalueselector6_snmI0JWagDHwH831hlM0_2070InputField-input objectvalueselector6_snmI0JWagDHwH831hlM0_2749ButtonValueHelp
		if ((elem = opportunity.getElementIfExisting(By2.startsWithAndPartialId("objectvalueselector6_snmI0JWagDHwH831hlM0_", "ButtonValueHelp"), 60))!= null)
		{
			opportunity.valueHelpDialog("objectvalueselector6_snmI0JWagDHwH831hlM0_", "", "Opportunity", "statictext");
		}		
		opportunity.selectSaveAction2(opportunity.savePartialId, "Opportunity_QC_Save");
		
		// new in related items follow up buttonnIowqMzpQaMSpxZvMRAWZG
		newFollowupItems("ticket");
		Thread.sleep(5000);
		//QC of service ticket to do
		ServiceTicketQC ticket = new ServiceTicketQC(driver);
		ticket.selectSaveAction2(ticket.savePartialId, "ServiceTicket_QC_Save");  
		
		// new in related items follow up buttonnIowqMzpQaMSpxZvMRAWZG  //TODO:
		newFollowupItems("quote");
		Thread.sleep(1000);
		//code for QC of sales quote to do
		SalesQuoteQC salesquote = new SalesQuoteQC(driver);
		salesquote.selectSaveAction2(salesquote.savePartialId, "SalesQuote_QC_Save");  
			
	}
	
	public void addRelatedItems() throws InterruptedException {
		String[] types = {"Appointment","Lead","Opportunity","Ticket", "Activity Task","Phone Call","Sales Quote"};
			
			for(String type : types){
			// click on Add
			elementToClick2(By2.partialId(addRelatedItem), 60);  
			Thread.sleep(5000);
			// Choosing type from drop down
			if ((this.elementToFindExplicit2(By2.startsWithAndPartialId(referenceType, "-inpu"),60)) != null) {
				try {
					this.fillDropDown2(By2.startsWithAndPartialId(referenceType, "-inpu"), type);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// OVS
			if ((this.elementToFindExplicit2(By2.startsWithAndPartialId(referenceName, "ButtonValueHelp"), 60))!= null){
				if(type.equals(tiName)){ //TODO: make it reusable for PhoneCalls
			    	elementToFindExplicit(By2.startsWithAndPartialId(referenceName, "ButtonValueHelp"), 60).click();
			    	 
					//wait for search to return throw-away results
					Thread.sleep(4000);
					WebElement elem;
					elem = this.elementToFindExplicit(By2.startsWithAndPartialId("BasicFind", "-cb-input"), 60);
					
					if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId(HITLIST_ITEM_PARTIAL_ID_REF, "-col0-row1"), 60)) != null) 
				    {
				    	elem.click();
				    }
				    else{
				    	this.elementToFindExplicit(By2.startsWithAndPartialId("embeddedcomponent_", "-close"), 60).click();
				    	this.elementToFindExplicit2(By2.buttonByClassAndPartialId(cancelReferenceClass, cancelReference), 60);
				    }	
					Thread.sleep(2000);
				}
				else{
					this.valueHelpDialog(referenceName, "", "InvolvedParty", HITLIST_ITEM_PARTIAL_ID_REF);
				}	
			}
		
			// click on Add in add reference dialog
			elementToClick2(By2.buttonByClassAndPartialId(addReferenceClass,addReference), 60);
			Thread.sleep(2000);
		}
	}
	
	public void getChanges() throws Exception{
		//objectvalueselector33oJNZ3soqsV1XOMpGN_slG_469InputField-input
		this.valueHelpDialog(changesUser, PerformanceRunner.getProperty("PerformanceAlias"), "Changes", "statictextL7wXSii6iKYNzI9TGBgW90_");
		elementToClick(By2.partialId(changesGo), 60);
	}
	
	public void deleteItemInTI(String line_id, String icon_id) throws InterruptedException{  

		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By2.startsWithAndPartialId(line_id, "rows-row0"));
		actions.moveToElement(menuHoverLink);

		WebElement subLink = driver.findElement(By2.partialId(icon_id));
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
		
	
	}
}
