package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskTI extends BaseTI{
	
	public static final String ADD_INVOLVED_PARTIES_ID = "button548At84mDqIYtsJS_s1yEZm_";
	public static final String ROLE_INVOLVED_PARTIES_ID = "dropdownlistbox9mBm3pUD44MoFTZ9UFkz2G_";	
	public static final String INVOLVED_PARTY_ID = "objectvalueselectorodoVTsYLBq2jAuGu4belam_";	
	
	//public static final String GENERATE_SUMMARY = "childnavigationitemBDZz6VXaEKwNYXHW6Tg72W_";
	public static final String SET_IN_PROCESS = "childnavigationitemgp7xjiK0XakSlE3s0iRcAG_";
	public static final String SET_COMPLETE = "childnavigationitemelQnIN5LWKgs0OlrylL4O0_";
	//public static final String SET_CANCELLED = "childnavigationitemXYxSnWcFCqEQm0Qvlmc8aG_";
	
	public static final String DELETE_ROW_FOLLOWUP = "listdefintion_saWalrqx_sqQ1y9bm5q54_sG_";
	public static final String DELETE_ICON_FOLLOWUP = "iconI51m94K_sbqwt3Si3JlHOGG_";
	public static final String DELETE_ROW_RELATEDITEM = "listdefintionahC5_SK964cUsM0zwGlMHW_";
	public static final String DELETE_ICON_RELATEDITEM = "iconK1a59mbR5qs_r2uqvTl2UG_";
	
	protected final static String HITLIST_ADD_INV_PARTY_PARTIAL_ID = "statictextwwqSMX4hh4khmULsIF7IWW_"; //"listdefintionui";
	
	public TaskTI(WebDriver webDriver)
	{
		super(webDriver);
		this.TIname = "TI_TASK";
		
		actionButton = "button1xUdiloz9K61D6OOt3_sLp0_";
		editButton   = "-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle_";
		saveButton   = "-actionBar-buttonAIDF4oKcgaM0Q2ji00ZvlW_";
		cancelButton = "-actionBar-buttonOHjVw_s5s6aYZmIDFV1QSzW_";
		
		tiName = "Activity Task";
		
		addAttachment = "buttonNpRCE_shlAagwzT_s5ACEYYW_";
		weblinkAttachLink = "inputfieldNt4_v1yZ24gVM_sN3j6pqfW_";
		weblinkAttachTitle = "inputfieldqxmA9DynDaoj8VCGC4au3W_";
		addWebLink = "buttontdiGV_dgy4YZluDYDy4Wam";
		libraryAttachSelect = "buttonUOJ_QK1xzq6kZ1UptkCTwW";		
		
		newFollowup = "buttonZvUweRj_sK4kFgYyGVnwVHW_";
		appointmentFollowup = "childnavigationitemBlyrIYpGjaY_sZwCv24HwXm_";
		taskFollowup = "childnavigationitema0e76SDOaaYlk_CHKYG8sm_";
		phonecallFollowup = "childnavigationitemSm_ucQKxe4UBBAgNEL1Rf0_";
		leadFollowup = "childnavigationitemW9z3YSVz6K_EWOwydh27GG_";
		salesleadFollowup = "childnavigationitem4lg3B6Plx4E2C8_sIzpBVVG_";
		opportunityFollowup = "childnavigationitemyDWcUKDPba63Fapmy_57_m_";
		ticketFollowup = "childnavigationitemvmavqBWqG4AasqmvPGj8PW_";
		quoteFollowup = "childnavigationitemwsFRuAEF_4sQ_10sICF_tW_";
		
		addRelatedItem = "buttonJMcPKzXuvKgzJqhlCN_sUG0_";
		referenceType = "inputfield6iqTsJ_ex4o2b9AX31nJ_s0_"; //TODO: check if this works. It was dropdown list before.
		referenceName = "objectvalueselector_xQ_s1_sEVe4Q6znMXpqLtiG_";
		addReference = "__button";
		cancelReference = "__button";
		addReferenceClass = "sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd";
		cancelReferenceClass = "sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd sapUiUx3TPBtn";
		 
		changesUser = "objectvalueselector33oJNZ3soqsV1XOMpGN_slG_";
		changesGo = "button1o7it5TAQqYUgGTPSIe0T0_";
		changesFirstRow = "listdefintionQZbGZIjQYqUKkmm0_KDMhW_";
			
	}
	
	/*
	 * Inner navigations  
	 */
	public void changeTabToOverview() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemv9hN7Ofj2qAYM53jF0cuvm_", "NavigateToOverview");
	}
	
	public void changeTabToFeed() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemf_s11Bl196aIjx_siX_se2W8W_", "NavigateToFeed");
	}
	
	public void changeTabToRelatedItems() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemXqCgny8ZSa2YYoMiH6qxMG_", "NavigateToRelatedItems");
	}
	
	public void changeTabToChanges() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemAWvyXUZ314IIdwzfLobIj0_", "NavigateToChanges");
	}

	 public void editTaskToAddInvolvedParties() throws InterruptedException{
		 WebElement elem;
		String[] roles = {"Activity Contact"}; //,"Contact","Activity Contact"};
		
		for(String role : roles){
			// click on Add in involved parties
			elementToClick2(By2.partialId(ADD_INVOLVED_PARTIES_ID), 5);
	
			// Choosing role from drop down
			if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId(ROLE_INVOLVED_PARTIES_ID, "-inpu"),1)) != null) {
				this.fillDropDown(elem, role);
			}
			// OVS
			if ((this.getElementIfExisting2(By2.startsWithAndPartialId(INVOLVED_PARTY_ID, "ButtonValueHelp"), 1))!= null){   
				this.valueHelpDialog(INVOLVED_PARTY_ID, "", "InvolvedParty", HITLIST_ADD_INV_PARTY_PARTIAL_ID);
				//this.waitUntil(By2.startsWithAndPartialId("embeddedcomponent_", "-close"));
			}				
			// click on Add in involved parties dialog
			elementToClick2(By2.buttonByClassAndPartialId("sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd","__button"), 60);
			//jsClick(this.elementToFindExplicit2(By2.buttonByClassAndPartialId("sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd","__button"), 60));
		}
		
	   }
	 
	public void editHeader() throws InterruptedException{  
		
		WebElement elem ;
		//category
		if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId("dropdownlistboxUYrUhl03UaU0fRUeGPOuLm_", "-inpu"), 1))!= null)   //inputfield214tLFuFDKkMNJV0yhZjrW_709-input
		{
			this.fillDropDown(elem, "Meeting");
		}
		//Priority
		if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId("dropdownlistbox2lcju2OqRKoo4OhCFmu7v0_", "-inpu"), 1))!= null)  //inputfieldHBg2ITlWNqE2wrKPYCTn1m_714-input
		{
			this.fillDropDown(elem, "Low");
		}  
	Thread.sleep(5000);  
	}
	
	public void setInProcess(String actionId) throws Exception{
		performActionActivity(actionId);
		Thread.sleep(2000);
		//check if in status. (works only for english)
		String title = getElementProperties(By2.text("In Process")).getAttribute("title");
		assert "In Process" == title;
	}
	
	public void checkForNotEditable() {
		if(getEditButton() == null){
			assert false;
		}
		else{
			assert true;
		}
	}
		
	public void checkChanges() throws Exception{
		getChanges();
		WebElement elem = getElementIfExisting(By2.startsWithAndPartialId("statictextzQYWhcMR1aEk8m7iAJSraW_", "col0-row1"), 60);
		if(elem != null && elem.getText().equals("Status")){
			//statictextzQYWhcMR1aEk8m7iAJSraW_720-col0-row0
			assert getElementProperties(By2.startsWithAndPartialId("statictextycnj9yr9UKgh6B4sSCXctW_", "col1-row1")).getAttribute("title") == "2-In Process";
			assert getElementProperties(By2.startsWithAndPartialId("statictextdaRxevhhCacFjnuxtJyfB0_", "col2-row1")).getAttribute("title") == "3-Completed";
		}
	}


}

