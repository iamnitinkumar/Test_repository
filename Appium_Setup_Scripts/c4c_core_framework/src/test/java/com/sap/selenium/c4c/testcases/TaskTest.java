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
import com.sap.selenium.c4c.components.TaskQC;
import com.sap.selenium.c4c.scripts.Task;

public class TaskTest extends PerformanceTest{

	@Before
	public void setUp() throws Exception {
		AccessHelper.login("English");
	}

	@After
	public void tearDown() throws Exception {
		AccessHelper.logout("English");
	}

	@Test
	public void test() throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //new SimpleDateFormat("MM/dd/yyyy"); DD.MM.YYYY
	    Date date = new Date(); 
	    date=AccessHelper.addDays(date,7);
	    String dateStr = dateFormat.format(date).toString();
		String objectname = AccessHelper.getname(5);
		
		Map<String, String> data = new HashMap<String, String>();
		data.put(TaskQC.SUBJECT, objectname); 
		data.put(TaskQC.ACCOUNT, "walmart" );  //PerformanceRunner.getProperty("Account_Task")
		data.put(TaskQC.PRIMARY_CONTACT, "");
		data.put(TaskQC.PROCESSOR, "");
		data.put(TaskQC.TO_DATE, dateStr); 
		data.put(TaskQC.CATEGORY, "Customer visit"); 
		data.put(TaskQC.PRIORITY, "Normal"); 
		data.put(TaskQC.OWNER, "");
		data.put(TaskQC.SALES_TERRITORY, "");
		data.put(TaskQC.NOTES, "Task created from selenium");
		//data.put(TaskQC.COMPLETION, "50");
		
		Task Task = new Task(driver,"tasktestcase");
		
		//QC of Task
		Task.quickCreateTask(data);
		
		Thread.sleep(5000);
		
		//Add attachments
		Task.addAttachments("www.sap.com","Link Title");
		
		Thread.sleep(5000);
		
		//Add involved parties
		Task.addInvolvedParties();
		
		Thread.sleep(5000);
		
		//status change to inprocess
		Task.setToInProcess();
		
		Thread.sleep(5000);
		
		//save
		Task.saveTask();
		
		Thread.sleep(5000);
		
		//Change to feed
		Task.changeToFacetFeed();
		
		Thread.sleep(5000);
		
		//check if edit is not enabled.
		Task.checkNotEditable();
		
		Thread.sleep(5000);
		
		//Change to related items
		Task.changeToFacetRelatedItems();
		
		Thread.sleep(5000);
		
		//Add related items and follow up items
		Task.addRelatedItemsTasks();
		
		Thread.sleep(5000);
		
		//Add follow up items
		Task.addFollowupItemsTasks();
		
		Thread.sleep(5000);
		
		//delete follow up and related items
		Task.deleteFromFollowup();
		
		Thread.sleep(5000);
		
		Task.deleteFromRelatedItems();
		
		Thread.sleep(5000);
		
		//Edit fields on header
		Task.editHeaderTasks();
		
		Thread.sleep(5000);
		
		//change status to completed
		Task.completeTask();
		
		Thread.sleep(5000);
		
		Task.saveTask();
		
		Thread.sleep(5000);
		
		//Change to changes
		Task.changeToFacetChanges();
		
		Thread.sleep(5000);
		
		//edit
		Task.editTask();
		
		Thread.sleep(5000);
		
		//check for entries for logged in user
		Task.checkChangesTasks();
		
		Thread.sleep(5000);
		
		//Save
		Task.saveTask();
		
		Thread.sleep(5000);
		
		//close Task
		Task.closeTask();
	}

}
