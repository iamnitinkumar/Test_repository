package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhoneCallTI extends BaseTI {
	
	public static final String GENERATE_SUMMARY = "childnavigationitem9dIAUza8Bq_NblL6uxkP_";
	public static final String PARTICIPANT_VALUE_HELP = "objectvalueselector6_sj_gHm1qqsSEjWd_s8AB_sW";
	public static final String SET_IN_PROCESS = "childnavigationitemKNqBcb9_sLKgQv8y2MIMhWW_";
	public static final String SET_COMPLETE = "childnavigationitemCEgMaNGnqqcVayMtGlPSyG_";
	public static final String SET_CANCELLED = "childnavigationitemwcQ1jpbvr4sELurq7BFsK0_";
	public static final String CONVERT_NEW_TICKET = "childnavigationitemL0zzfP41rKkwaF9IGOT7dm_";
	public static final String ASSIGN_NEW_TICKET = "childnavigationitem0PjQdNv3UK6w2L_PeNyBKG_";
	
	public static final String DELETE_ROW_FOLLOWUP = "listdefintion074okf1iJaYKt_sJZHufAm0";
	public static final String DELETE_ICON_FOLLOWUP = "iconpKN78fD5W4kGLrXtCtiAUm_";
	public static final String DELETE_ROW_RELATEDITEM = "listdefintionoA5Yp10buasixGg2qsn6bG_";
	public static final String DELETE_ICON_RELATEDITEM = "icongMLr2ErnDqEU_iHI80dG9m_";
	
	/*protected final String CHANGES_USER = "objectvalueselector33oJNZ3soqsV1XOMpGN_slG_";
	protected final String CHANGES_GO = "button1o7it5TAQqYUgGTPSIe0T0_";
	protected final String CHANGES_FIRST_ROW = "listdefintionQZbGZIjQYqUKkmm0_KDMhW_";*/
	
	public PhoneCallTI(WebDriver webDriver)
	{
		
		super(webDriver);
		
		actionButton = "buttonhyVv_sSNkaqAvFH4vftnDfG_";	
		editButton   = "-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle_";
		saveButton   = "-actionBar-buttonfK7cw9OFzKQCQAvFXH_SDm_";
		cancelButton = "-actionBar-buttonfwgUPwS7BaEdZJb5WAvncG_";
			
		tiName = "Phone Call";
		
		addAttachment = "buttonNpRCE_shlAagwzT_s5ACEYYW";
		weblinkAttachLink = "inputfieldNt4_v1yZ24gVM_sN3j6pqfW";
		weblinkAttachTitle = "inputfieldqxmA9DynDaoj8VCGC4au3W";
		addWebLink = "buttontdiGV_dgy4YZluDYDy4Wam";
		libraryAttachSelect = "buttonUOJ_QK1xzq6kZ1UptkCTwW";		
		
		newFollowup = "buttonnIowqMzpQaMSpxZvMRAWZG_";
		appointmentFollowup = "childnavigationitem_V8qMFgMlKEyxRUzsUVozm_";
		taskFollowup = "childnavigationitemvD4Jwb6Tp4_YtxXEO68GD0_";
		phonecallFollowup = "childnavigationitemv8NmsZ7wOaIGvRr4u50E6W_";
		salesleadFollowup = "childnavigationitemxRQmXfoM3Kwsre2PqCsM50_";
		opportunityFollowup = "childnavigationitem1Cxq5gXUJaUGck_sJr_VIEm_";
		ticketFollowup = "childnavigationitemH_WB3GxzG4wZhSJC1Gy8AW_";
		quoteFollowup = "childnavigationitemPsy5m7so3q2SIUxITFU8sW_";
		
		addRelatedItem = "button_spvQH3tNKKMgopbMjK4ndG_";  
		referenceType = "dropdownlistboxR7X0AyOHCKEb8FcBDTtjZW_";
		referenceName = "objectvalueselectorUnHX69RO2KIr_sdHxRDrg00_";
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
		this.changeTabIfExisting("navigationitemQ7bJ1QrilaoCzEZXbzHys0_", "NavigateToOverview");
	}
	
	public void changeTabToFeed() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemV26i4nDfo4chrpi7DxeNym_", "NavigateToFeed"); 
	}
	
	public void changeTabToRelatedItems() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemfYngO7o0iqcqR_GeNxZa6G_", "NavigateToCharts");
	}
	
	public void changeTabToChanges() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemGiIWKpvlFa6sSg_s2IRdKzG_", "NavigateToActivities");
	}
	
	public void editPhoneCallToAddParticipants() throws Exception
	   {
		   //Add button
			elementToClick(By2.partialId("buttonRtU8oCRxTqYVjqq72WVWUW"), 5);
			
			// OVS
			if ((this.getElementIfExisting(By2.startsWithAndPartialId(PARTICIPANT_VALUE_HELP, "ButtonValueHelp"), 1))!= null){
				this.valueHelpDialog(PARTICIPANT_VALUE_HELP,"", "Participant", AppointmentQC.HITLIST_ITEM_PARTIAL_ID);
			}	

			// add on participant pop up
			elementToClick(By2.buttonByClassAndPartialId("sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd","__button"), 5);
			//	AccessHelper.waitUntil(by);
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
	 
	 public void editHeader() throws InterruptedException{  
			
		WebElement elem ;
		//category
		if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId("inputfieldZEMrgYaKjKs5IMb0c9VEhm_", "-inpu"), 1))!= null)  
		{
			this.fillDropDown(elem, "Customer complaint");
		}
		//Priority
		if ((elem = this.getElementIfExisting2(By2.startsWithAndPartialId("inputfieldc0I2agLzFq6AaHAc5M5j1G_", "-inpu"), 1))!= null)  
		{
			this.fillDropDown(elem, "Urgent");
		}  
	Thread.sleep(5000);  
	} 
	
	 public void checkChanges() throws Exception{
		getChanges(); 
		elementToClick(By2.startsWithAndPartialId(changesFirstRow, "-row0-col0"), 60);
		WebElement elem = getElementIfExisting(By2.startsWithAndPartialId("statictextzQYWhcMR1aEk8m7iAJSraW_", "col0-row1"), 60);
		if(elem != null && elem.getText().equals("Status")){
			//statictextzQYWhcMR1aEk8m7iAJSraW_720-col0-row0
			assert getElementProperties(By2.startsWithAndPartialId("statictextycnj9yr9UKgh6B4sSCXctW_", "col1-row1")).getAttribute("title") == "2-In Process";
			assert getElementProperties(By2.startsWithAndPartialId("statictextdaRxevhhCacFjnuxtJyfB0_", "col2-row1")).getAttribute("title") == "3-Completed";
		}
	}
	 
	public void convertNewTicketAction() throws Exception{
	    performActionActivity(PhoneCallTI.CONVERT_NEW_TICKET);
	    ServiceTicketQC ticket = new ServiceTicketQC(driver);
		ticket.selectSaveAction2(ticket.savePartialId, "ServiceTicket_QC_Save");  
	}
	
	public void assignExtistingTicketAction() throws Exception{
		WebElement elem;
	    performActionActivity(PhoneCallTI.ASSIGN_NEW_TICKET);
	   
	    PerformanceRunner.startMeasurement("Open_"+"assign_ticket"+"_ValueHelp");
    	elementToFindExplicit(By2.startsWithAndPartialId("objectvalueselectorWVPFK9x_smaU9hEo2CfZq0m_", "ButtonValueHelp"), 60).click();
    	PerformanceRunner.stopMeasurement();
    	
	    if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId("statictextFHHFSgYCjaYn9FDBidYc8W_", "-col1-row3"), 5)) != null)
	    {
	    	PerformanceRunner.startMeasurement("Select_"+"assign_ticket"+"_ValueHelp");
	    	elem.click();
	    	PerformanceRunner.stopMeasurement();
	    }
	    else
	    	this.elementToFindExplicit(By2.startsWithAndPartialId("embeddedcomponent", "-close"), 5).click();
		  
	    Thread.sleep(2000);
	    elementToClick2(By2.partialId("buttonoik5RFdKL4QcmhVxD_Voj0_"), 60);  
	}
	
}


