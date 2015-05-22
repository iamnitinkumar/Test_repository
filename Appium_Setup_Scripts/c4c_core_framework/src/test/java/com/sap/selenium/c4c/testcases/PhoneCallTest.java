package com.sap.selenium.c4c.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.components.PhoneCallQC;
import com.sap.selenium.c4c.scripts.PhoneCall;

public class PhoneCallTest extends PerformanceTest{

	@Before
	public void setUp() throws Exception {
		AccessHelper.login("English");
	}

	@After
	public void tearDown() throws Exception {
		AccessHelper.logout("English");
	}

	@Test
	public void phoneCall() throws Exception {
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //MM/dd/yyyy
	    Date date = new Date(); 
	    date=AccessHelper.addDays(date,7);
	    String dateStr = dateFormat.format(date).toString();
		String objectname = "Test PhoneCall" + date.getTime();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put(PhoneCallQC.SUBJECT, objectname); 
		data.put(PhoneCallQC.ACCOUNT, "walmart");
		data.put(PhoneCallQC.PRIMARY_CONTACT, "");
		data.put(PhoneCallQC.OWNER, "");
		data.put(PhoneCallQC.TERRITORY, "");
		data.put(PhoneCallQC.DATE, dateStr);
		data.put(PhoneCallQC.DIRECTION,"Outbound");        
		data.put(PhoneCallQC.CATEGORY,"Telephone call"); 
		data.put(PhoneCallQC.PRIORITY,"Normal");
		data.put(PhoneCallQC.CAMPAIGN,""); 
		data.put(PhoneCallQC.NOTES,"PhoneCall created from Selenium");
		
		PhoneCall phoneCall = new PhoneCall(driver,"phonecall");
		//QC of PhoneCall
		phoneCall.quickCreatePhoneCall(data);
				
		Thread.sleep(5000);

		//Generate Summary
		phoneCall.generateSummary();
		
		Thread.sleep(5000);
		
		
		//Add attachments
		phoneCall.addAttachments("www.sap.com","Link Title");
		Thread.sleep(5000);
		//Add participants
		phoneCall.addParticipants();
		Thread.sleep(5000);
		
		//save
		phoneCall.savePhoneCall();
		Thread.sleep(5000);
		//Change to feed
		phoneCall.changeToFacetFeed();
		Thread.sleep(5000);
		//check if edit is not enabled.
		phoneCall.checkNotEditable();
		Thread.sleep(5000);
		//Change to related items
		phoneCall.changeToFacetRelatedItems();
		Thread.sleep(5000);		
		//Add related items 
		phoneCall.addRelatedItemsPhoneCalls();
		Thread.sleep(5000);
		//Add follow up items
		phoneCall.addFollowupItemsPhoneCalls();
		Thread.sleep(5000);
		
		//TODO: Delete from followup and related items
		phoneCall.deleteFromFollowup();
		Thread.sleep(5000);
		
		phoneCall.deleteFromRelatedItems();
		Thread.sleep(5000);
		
		//status change to inprocess
		phoneCall.setToInProcess();
		Thread.sleep(5000);
		
		//et actions “Convert to New ticket” and “Assign to Exisiting ticket
		phoneCall.convertToNewTicket();
		Thread.sleep(5000);
		
		phoneCall.assignNewTicket();
		Thread.sleep(5000);
		
		phoneCall.editPhoneCall();
		Thread.sleep(5000);
		
		//Edit fields on header
		phoneCall.editHeaderPhoneCalls();
		Thread.sleep(5000);				
		//change status to completed
		phoneCall.completePhoneCall(); 
		Thread.sleep(5000);		
		//save
		phoneCall.savePhoneCall();
		Thread.sleep(5000);		
		//Change to changes
		phoneCall.changeToFacetChanges();
		Thread.sleep(5000);		
		//edit
		phoneCall.editPhoneCall();
		Thread.sleep(5000);		
		//check for entries for logged in user
		phoneCall.checkChangesPhoneCalls();
		Thread.sleep(5000);		
		//save
		phoneCall.savePhoneCall();
		Thread.sleep(5000);		
		//change status to cancelled.
		phoneCall.cancelPhoneCall(); 
		Thread.sleep(5000);		 
		//save
		phoneCall.savePhoneCall();
		Thread.sleep(5000);	
		//close phoneCall
		phoneCall.closePhoneCall();
		Thread.sleep(5000);
		
	}

}
