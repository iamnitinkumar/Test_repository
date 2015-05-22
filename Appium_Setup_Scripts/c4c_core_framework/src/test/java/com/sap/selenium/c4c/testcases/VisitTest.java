
package com.sap.selenium.c4c.testcases;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.components.VisitQC;
import com.sap.selenium.c4c.components.VisitTI;
import com.sap.selenium.c4c.scripts.Visit;








//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.By;
/*import org.openqa.selenium.Keys;*/
//import org.openqa.selenium.WebDriver;//
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class VisitTest extends PerformanceTest {
	
	
	@Before
	public void setUp() throws Exception {

		AccessHelper.login("English"); 

		}

             
    @After
    public void tearDown() throws Exception {

    	AccessHelper.logout("English");

    	}

   
 	@Test
public void Visit() throws Exception
{
 			
 		Visit visit = new Visit(driver);
 				
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		date=AccessHelper.addDays(date,7);
		String dateStr = dateFormat.format(date).toString();
		String objectname = AccessHelper.getname(7);
		//Create visit 
			visit.navigate("VISITS", "VISITS");
			Map<String, String>visitdataQC = new HashMap<String, String>();
			visitdataQC.put(VisitQC.VISITNAME, objectname);
			visitdataQC.put(VisitQC.ACCOUNTSELECT_ID, "Walmart");
			visitdataQC.put(VisitQC.OWNER_ID ,"Performance");
			visitdataQC.put(VisitQC.FROM_DATE_ELEMENT_ID,dateStr);
			visitdataQC.put(VisitQC.TO_DATE_ELEMENT_ID,dateStr);
			visit.quickCreateVisit(visitdataQC);
			visit.savevisit();
			visit.closevisit();
		
 	//Open Visit & Edit Visit & Add Task 
			VisitTI visitTI = visit.getvisitTI();
			visit.openvisit("svetha_automation", "ALL");
			visit.editVisit();
			visit.savevisit();
			
			
//Add Task to Visit
		visitTI.changeTabToTasks();
		visitTI.AddTask();
			
	//Survey
			visitTI.changeTabToSurveys();
			visitTI.AddSurvey();
			//visitTI.editSurvey();
			
	//Campaign
			//visitTI.changeTabToCampaign();
			
	//Contacts
			visitTI.changeTabToContacts();
			visitTI.AddContact();
	//Attachments
			//visitTI.changeTabToAttachments();	
			//visitTI.AddAttachments("Library");
			//visitTI.AddAttachments("weblink");
			
		
	//Followup
			Thread.sleep(2000);
			//visitTI.changeTabToFollowUp();
			//visitTI.AddFollowupOpp();
			//visitTI.AddFollowupSalesQuote();
			
			visit.closevisit();
			
	//
			
}
}
