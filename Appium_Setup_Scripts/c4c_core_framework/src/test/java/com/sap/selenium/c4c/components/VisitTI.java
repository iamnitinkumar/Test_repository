package com.sap.selenium.c4c.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.Keys;*/
import org.openqa.selenium.WebElement;

public class VisitTI extends BaseTI {
	
	
	//public static final String Notes =  
	protected static final String ACTION_REFRESHVISIT ="childnavigationitemyXZzn8iVda6PrAoL_RAx2m_";
	protected static final String ACTION_SETASINPROCESS="childnavigationitemzE1LlQc30Ksa2PTK5A4u30_";
	protected static final String ACTION_GENERATE_SUMMARY= "childnavigationiteme8XFtQ6Sv4_n6Hbjj_y9G0_";
	protected static final String CONTACTSELECT = "objectvalueselectorVBot1bN_s9qEqtc5T_jpK5m_";
	
	protected static final String CONTACTCHOOSE ="statictextV3_sQnBpntKo325fGWr0zpW_";
	
	protected static final String ELEMENT_ID_POSTFIX = "col0-row5";
	protected static final String CHOOSETASK= "checkboxD6Ffc5EnsaEoGbLY_s_zLBW_";	
	
	protected static final String TASKCHKBOX_ELEMENT_ID= "col0-row1";
	protected static final String TASKOK = "buttonBvD6wJ4QQ4AiW9NqFQxWs0";
	
	protected static final String CHOOSESURVEY= "checkboxKxq3I9c02qkEWiv7CHv44m_";	
	protected static final String SURVEY_ELEMENT_ID= "col0-row1";
	protected static final String SURVEYOK = "buttonU6_sjQAo7yaABhQQiq4YU8m_";
	
	protected static final String CONTACT_CHOOSE_ELEMENT_ID= "col1-row0";
	protected final static String HITLIST2_ITEM_PARTIAL_ID ="statictext";
	public static final String CHECKIN = "buttonKmYeUanMe42FlLzPniTnD0_";
	protected static final String CHOOSEATTENDEES= "statictextvca5ZCXEAaEGc51SnF65s0";	
	protected static final String ATTENDEES_ELEMENT_ID= "col0-row0";
	protected static final String ATTENDEESELECT= "objectvalueselectorqri2Uvc5oa2OmRFrAmSPqm_";
	//VisitTI
	public VisitTI(WebDriver webDriver)
	{
		
		super(webDriver);
	
		//ToDo  change all the IDs !!!!!
		actionButton = "buttonSz9wzE2oraAhTwXaqNy9xW";
		editButton   = "_inspector0-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle";
		saveButton   = "-actionBar-buttonOO2ogCGg_s4s6f0qJS6tpOW_";
		cancelButton = "-actionBar-buttonnY1FVCP3Fq2hLDqbbWb8BG_";
		addTask = "buttonGtz78KroEKMQquoStSjszG";
		addSurvey = "buttonBvD6wJ4QQ4AiW9NqFQxWs0";
		
		addAttachment = "buttonNpRCE_shlAagwzT_s5ACEYYW";
		weblinkAttachLink = "inputfieldNt4_v1yZ24gVM_sN3j6pqfW";
		weblinkAttachTitle = "inputfieldqxmA9DynDaoj8VCGC4au3W";
		addWebLink = "buttontdiGV_dgy4YZluDYDy4Wam";
		libraryAttachSelect = "buttonUOJ_QK1xzq6kZ1UptkCTwW";		
		
		tiName = "Visit";
	}
	
	public void changeToSubTab() throws Exception
	{
		this.changeTab("navigationitemJMjxSy6D1qswnkAwOp9nNm_", "NavigateToContatcs");
	}

	
	public void changeTabToOverview() throws Exception
	{
		this.changeTab("navigationitem2xfiSW1VZqo2UecrB1qgM0_", "NavigateToOverview");
	}
	
	public void changeTabToContacts() throws Exception
	{
		this.changeTab("navigationitemJMjxSy6D1qswnkAwOp9nNm_", "NavigateToContacts");
	}
	
	public void changeTabToSurveys() throws Exception
	{
		this.changeTab("navigationitemeZLXBurQb4Agi35oBZtugG_", "NavigateToSurveys");
	}
	
	public void changeTabToTasks() throws Exception
	{
		this.changeTab("navigationitemO3JIkY6ud4M5WfwugX0EYm_", "NavigateToTasks");
	}
	
	public void changeTabToCampaign() throws Exception
	{
		this.changeTab("navigationitemxP_FmexqX4MFp5ELUUc4V0_", "NavigateToCampaign");
	}
	public void changeTabToFollowUp() throws Exception
	{
		this.changeTab("navigationitemcKlmrOEK8Ks6QoQIDw4k2W", "NavigateToFollow-up");
		
	}
	public void changeTabToAttendees() throws Exception
	{
		this.changeTab("navigationitem6_sdxmCwNRKQYUwqGBM8OnG_", "NavigateToAttendees");
		
	}
	public void changeTabToAttachments() throws Exception
	{
	this.changeTab("navigationitemlCAzyhxhy4ICEHKTxmgmCW_", "NavigateToAttachments");
	}
	public void changeTabToChanges() throws Exception
	{
	this.changeTab("navigationitemAwSamgJNqKgnJ99dNt_", "NavigateToAttachments");
	}
public void visitnote()throws InterruptedException{
    	  	   	
	 
    	WebElement Field = null;
       
    	if ((Field = this.getElementIfExisting(By2.label("Notes"), 1))!= null)

    	{
    	Field.clear();	
    	Field.sendKeys("Visit created from Selenium"); 
    
    	Thread.sleep(1000);
    	
    }	
  
}
public void AddContact() throws InterruptedException
{
 
 WebElement addcontact;
 By by = By2.partialId("button_s2TrPijMyKYO9e2HCyInlG_");
 WebElement  addcontact1= AccessHelper.handleMultiple(by);
 addcontact1.click();
 Thread.sleep(5000);
 
	 if (( addcontact = this.getElementIfExisting(By2.startsWithAndPartialId(VisitTI.CONTACTSELECT, "ButtonValueHelp"), 1))!= null)
		{
		 
	  		addcontact.click();
	  		
		}
	 if ((addcontact = this.getElementIfExisting2(By2.startsWithAndPartialId(VisitTI.CONTACTCHOOSE, "ButtonValueHelp"), 1))!=null)
	 {
		 this.valueHelpDialog(VisitTI.CONTACT_CHOOSE_ELEMENT_ID,"", "PrimaryContact", VisitTI.HITLIST2_ITEM_PARTIAL_ID);
		
	 }
	
	 By by1= By2.text("Add");
	 WebElement add = AccessHelper.handleMultiple(by1);
	 add.click();
	 
}
	
public void AddAttendees() throws InterruptedException
{
	WebElement addattendees;
	By by = By2.partialId("button2tXX4YKnWaAc8Zsm0tTyBG");
    WebElement phcallfield = AccessHelper.handleMultiple(by);
    phcallfield.click();
    
    if (( addattendees = this.getElementIfExisting(By2.startsWithAndPartialId(VisitTI.ATTENDEESELECT, "ButtonValueHelp"), 1))!= null)
	{
	 
    	addattendees.click();
  		
	}
 if ((addattendees = this.getElementIfExisting2(By2.startsWithAndPartialId(VisitTI.CHOOSEATTENDEES, "ButtonValueHelp"), 1))!=null)
 {
	 this.valueHelpDialog(VisitTI.CHOOSEATTENDEES,"", "ATTENDEES", VisitTI.HITLIST2_ITEM_PARTIAL_ID);
	
 }

 By by1= By2.text("Add");
 WebElement add = AccessHelper.handleMultiple(by1);
 add.click();
 
	
	}
	


public void  AddTask() throws InterruptedException {
	
     WebElement taskname;
   
	By by = By2.partialId("buttonGtz78KroEKMQquoStSjszG");
    WebElement phcallfield = AccessHelper.handleMultiple(by);
    phcallfield.click();
    
    /*if ( !driver.findElement(By.id("idOfTheElement")).isSelected() )
	{
	     driver.findElement(By.id("idOfTheElement")).click();
	}*/
	if((taskname = this.getElementIfExisting2(By2.startsWithAndPartialId(CHOOSETASK,TASKCHKBOX_ELEMENT_ID),1))!=null)
			
	{
		System.out.print(taskname);
		taskname.click();
	
		By by1 = By2.partialId("buttonBvD6wJ4QQ4AiW9NqFQxWs0");
	WebElement taskok =AccessHelper.handleMultiple(by1);
	taskok.click();
	
	}
}
	
public void  AddSurvey() throws InterruptedException {
	
    WebElement addsurvey;
  
	By by2 = By2.partialId("buttonV4KFGotOdK6KQf4_3n6ZGW_");
   WebElement survey = AccessHelper.handleMultiple(by2);
   survey.click();
   
  
	if((addsurvey = this.getElementIfExisting2(By2.startsWithAndPartialId(CHOOSESURVEY,SURVEY_ELEMENT_ID),1))!=null)
			
	{
		System.out.print(addsurvey);
		addsurvey.click();
	
		By by1 = By2.partialId(SURVEYOK);
	WebElement surveyok =AccessHelper.handleMultiple(by1);
	surveyok.click();
	
	}

}
public void editSurvey() throws Exception{
	WebElement editsurvey;
	WebElement editsurvey1;
	WebElement elem;
	WebElement elem1;
	
	/*if((editsurvey = this.getElementIfExisting2(By2.startsWithAndPartialId("linkicWXMcWtUqwN1U5kPVf5Zm","col0-row0"),1))!=null)
	{
		editsurvey.click();
		
	}*/
		
		if((editsurvey1 = this.getAction("actionbuttonmenuS_aTRSHNnakm3fOw27kQ2W_","")) != null);
		{
		
		
		if ((editsurvey1 = this.getElementIfExisting2(By2.startsWithAndPartialId("childnavigationitemtNTA31aEd4AfJzLDuWbbFm_",""), 1))!=null);
		{
			editsurvey1.click();
		}
		}
		if (( elem = this.getElementIfExisting2(By2.startsWithAndPartialId("inputfield779qrBPWCqYmO_GI_sLgoXG_",""),1))!=null);
		{
		
		
		 elem.sendKeys("60");
		 }
	if ((elem1= this.getElementIfExisting2(By2.buttonByPartialIdAndText("buttongbOtBrghT42dwQ_sIHau9Tm_", "Submit"),1))!=null);
	{
		elem1.click();
	}
	
}

public void checkin(String actionId) throws Exception{
	performActionActivity(actionId);
	Thread.sleep(2000);
	//check if in status. (works only for english)
	String title = getElementProperties(By2.text("Check In")).getAttribute("title");
	assert "Check In" == title;
	
}

public void AddFollowupOpp()throws InterruptedException{
	
	
By by1 = By2.partialId("childnavigationitemkAwruuM5SqcDRrmgA4c7OG");
WebElement followup =AccessHelper.handleMultiple(by1);
followup.click();

By by2 = By2.partialId("childnavigationitemJuoBuibnS4ETualQPbRJkG");
WebElement save = AccessHelper.handleMultiple(by2);
save.click();
}

public void AddFollowupSalesQuote()throws InterruptedException{
	
	
By by3 = By2.text(" Sales Quote");
WebElement followup = AccessHelper.handleMultiple(by3);
followup.click();

By by4 = By2.text("Save");
WebElement save = AccessHelper.handleMultiple(by4);
save.click();

}
public void AddFollowupServiceTicket()throws InterruptedException{
	
	WebElement adddescription;
By by3 = By2.text(" Service Ticket");
WebElement followup = AccessHelper.handleMultiple(by3);
followup.click();

By by5 = By2.text("Description");
adddescription = AccessHelper.handleMultiple(by5);
adddescription.sendKeys(" Test from Seleiumn");

By by4 = By2.text("Save");
WebElement save = AccessHelper.handleMultiple(by4);
save.click();

}

}
		

	

	
   
			








