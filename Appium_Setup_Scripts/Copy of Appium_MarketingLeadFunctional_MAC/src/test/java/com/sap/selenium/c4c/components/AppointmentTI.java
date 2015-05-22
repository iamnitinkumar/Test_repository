package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppointmentTI extends BaseTI {

	public static final String ADD_INVOLVED_PARTIES_ID = "buttonCACISowKW4cEohEE8z1aHG_";
	public static final String ROLE_INVOLVED_PARTIES_ID = "dropdownlistboxCbc6OGwRGKkGMhFNR3GNG0_";	
	public static final String INVOLVED_PARTY_ID = "objectvalueselectorxY8QS_2DYaYSrYjTT9cgcG_";	
	
	public static final String GENERATE_SUMMARY = "childnavigationitemBDZz6VXaEKwNYXHW6Tg72W_";
	public static final String SET_IN_PROCESS = "childnavigationitemcpMvlkTyAacCTSqUED9Ai0_";
	public static final String SET_COMPLETE = "childnavigationitematStHXgTPqks3KN5JcgEAG_";
	public static final String SET_CANCELLED = "childnavigationitemXYxSnWcFCqEQm0Qvlmc8aG_";
	
	public static final String DELETE_ROW_FOLLOWUP = "listdefintion0pcIfOCHUKg2buBI7UoQUW_";
	public static final String DELETE_ICON_FOLLOWUP = "iconn92OljYkQqseJdQrd_QdXW_";
	public static final String DELETE_ROW_RELATEDITEM = "listdefintionHEUPE3BCVKwrZJfOLxtXU0_";
	public static final String DELETE_ICON_RELATEDITEM = "iconHxBapY8_sTKsGi5VpEyQMFW_";
	
/*	protected final String CHANGES_USER = "objectvalueselector33oJNZ3soqsV1XOMpGN_slG_";
	protected final String CHANGES_GO = "button1o7it5TAQqYUgGTPSIe0T0_";
	protected final String CHANGES_FIRST_ROW = "listdefintionQZbGZIjQYqUKkmm0_KDMhW_"; */
	
		
	public AppointmentTI(WebDriver webDriver)
	{
		
		super(webDriver);
		
		actionButton = "buttonJ7O2Be5xYaUMMr0UIF_HlW_";
		editButton   = "-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle_";
		saveButton   = "-actionBar-button6sPXGpNAeqchL7vbhXFQs0_";
		cancelButton = "-actionBar-button2L6tw2avL4osUHhuaSoTcW_";
		
		tiName = "Appointment";
		
		addAttachment = "buttonNpRCE_shlAagwzT_s5ACEYYW";
		weblinkAttachLink = "inputfieldNt4_v1yZ24gVM_sN3j6pqfW";
		weblinkAttachTitle = "inputfieldqxmA9DynDaoj8VCGC4au3W";
		addWebLink = "buttontdiGV_dgy4YZluDYDy4Wam";
		libraryAttachSelect = "buttonUOJ_QK1xzq6kZ1UptkCTwW";		
		
		newFollowup = "buttonceOalrZ4EKQVk9drduoaTm_";
		appointmentFollowup = "childnavigationitem0BvcckvEkaA6z_sIMBPv6qG_";
		taskFollowup = "childnavigationitemc3HbeJk0W4cRnoah88Z2t0_";
		phonecallFollowup = "childnavigationitemHUXAuSZYy4c3jmiC1pKjU0_";
		salesleadFollowup = "childnavigationitempJ09DvLRR4QwcgD5X6LVKG_";
		opportunityFollowup = "childnavigationitemqsfruRxa94kK1aDHoXtxqW_";
		ticketFollowup = "childnavigationitemA6YtDzHSkqIUx2pE13_o1W_";
		quoteFollowup = "childnavigationitem7XfL_s5hXoKI9m1pM2CV6VG_";
		
		addRelatedItem = "buttonUfcqNJFJ_sKQg8wvqQ64eBm_";
		referenceType = "dropdownlistbox2gbG5fTag4kM561dmicVlG_";
		referenceName = "objectvalueselectorFvcxCz_ppawtN52j0o8bmm_";
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
		this.changeTabIfExisting("navigationitemcHHQEyhpyaoC_sL7MbmM3P0_", "NavigateToOverview");
	}
	
	public void changeTabToFeed() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemuDHGrFlVJKAfO7_sx_4hclG_", "NavigateToFeed");
	}
	
	public void changeTabToRelatedItems() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemDevYeanswKQfzz4cVZw6Fm_", "NavigateToCharts");
	}
	
	public void changeTabToChanges() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitema6rnOt8kwaEmEGNNB2WiPm_", "NavigateToActivities");
	}

	 public void editAppointmentToAddInvolvedParties() throws InterruptedException{
		 WebElement elem;
		String[] roles = {"Attendee"}; //,"Contact","Activity Contact"};
		
		for(String role : roles){
			// click on Add in involved parties
			elementToClick2(By2.partialId(ADD_INVOLVED_PARTIES_ID), 5);
	
			// Choosing role from drop down
			if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId(ROLE_INVOLVED_PARTIES_ID, "-inpu"),1)) != null) {
				this.fillDropDown(elem, role);
			}
			// OVS
			if ((this.getElementIfExisting2(By2.startsWithAndPartialId(INVOLVED_PARTY_ID, "ButtonValueHelp"), 1))!= null){   //TODO:
				this.valueHelpDialog(INVOLVED_PARTY_ID, "", "InvolvedParty", AppointmentQC.HITLIST_ITEM_PARTIAL_ID);
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
		if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId("inputfield214tLFuFDKkMNJV0yhZjrW_", "-inpu"), 1))!= null)   //inputfield214tLFuFDKkMNJV0yhZjrW_709-input
		{
			this.fillDropDown(elem, "Meeting");
		}
		//Priority
		if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId("inputfieldHBg2ITlWNqE2wrKPYCTn1m_", "-inpu"), 1))!= null)  //inputfieldHBg2ITlWNqE2wrKPYCTn1m_714-input
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
		WebElement elem = getElementIfExisting(By2.startsWithAndPartialId("statictextzQYWhcMR1aEk8m7iAJSraW_", "col0-row0"), 60);
		if(elem != null && elem.getText().equals("Status")){
			//statictextzQYWhcMR1aEk8m7iAJSraW_720-col0-row0
			assert getElementProperties(By2.startsWithAndPartialId("statictextycnj9yr9UKgh6B4sSCXctW_", "col1-row0")).getAttribute("title") == "2-In Process";
			assert getElementProperties(By2.startsWithAndPartialId("statictextdaRxevhhCacFjnuxtJyfB0_", "col2-row0")).getAttribute("title") == "3-Completed";
		}
	}
	
	
	
}