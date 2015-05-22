package com.sap.selenium.c4c.scripts;


import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.TaskOWL;
import com.sap.selenium.c4c.components.TaskQC;
import com.sap.selenium.c4c.components.TaskTI;


public class Task {
	
	private WebDriver driver;
	private TaskTI taskTI = null;
	private TaskOWL taskOWL = null;
	private TaskQC taskQC = null;
	private String testCaseName;
	
	public Task(WebDriver webDriver, String testCaseName)
	{
		driver = webDriver;
		this.testCaseName = testCaseName;
	}
	
    /*
     * New TI, OWL classes
     */
    public TaskTI getTaskTI()
    {
    	if (taskTI == null)
    	{
    		taskTI = new TaskTI(driver);
    	}
    	return taskTI;
    }

    
    public TaskOWL getTaskOWL()
    {
    	if (taskOWL == null)
    	{
    		taskOWL = new TaskOWL(driver);
    	}
    	return taskOWL;
    }

    
    public TaskQC getTaskQC()
    {
    	if (taskQC == null)
    	{
    		taskQC = new TaskQC(driver,this.testCaseName);
    	}
    	return taskQC;
    }
    
    
    public void navigateToTasks(){
    	
 	   try{
 		   this.getTaskOWL().navigate();
 	   }
 	   catch (Exception e){
 		   Assert.fail("Failed to open Account WoC:  "+ e.getLocalizedMessage()); 
 	   }
 	   
 	   
 	   
    }
	
    public Boolean simpleSearchTask(String searchTerm, String filterType){
 	   
 	   try{
 		   displayTasks(filterType);
 		   this.getTaskOWL().simpleSearch(searchTerm);
 		   
 	   }
 	   catch(Exception e){
 		   Assert.fail("Failed to seach term: "+ searchTerm);
 	   }
 	   
 	   return true;
    }
    
	public void displayTasks(String filterType){
		   try{
			   navigateToTasks();
			   this.getTaskOWL().openFilter(filterType);

		   }
		   catch(Exception e){
			   
		   }
	   }
	
	public Boolean editTask() throws Exception
	   {
		   this.getTaskTI().edit();
			
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
	   }
	   
	   public Boolean saveTask()
	   {
		   this.getTaskTI().save2();
			
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
	   }
	   
	   public Boolean closeTask() throws Exception
	   {
			this.getTaskTI().close2();
			
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
	   }
	   
	   public void quickCreateTask(Map<String,String> data) throws 
	Exception
	   {
		   	this.getTaskOWL().navigate();
			AccessHelper.quickcreate(true, "New_TaskQC");
			this.createTask(data);
	   } 
	   
	   public Boolean createTask(Map<String, String> data) throws Exception
	   {
		   
		     try {
				this.getTaskQC().createAndOpen(data);
			} catch (InterruptedException e) {
				Assert.fail("Task creation failed: "+ e.getLocalizedMessage()); 
			}
		   
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   Assert.assertTrue("Task create successful", true);
		   return true;
	   }
	  
	   public void completeTask () {
		   try {
			this.getTaskTI().performActionActivity(TaskTI.SET_COMPLETE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	      
	   public void addAttachments(String link, String title) throws Exception{
		   this.getTaskTI().editToAddAttachements(link, title);
	   }
	   
	   public void addInvolvedParties() throws InterruptedException{
		   this.getTaskTI().editTaskToAddInvolvedParties();
	   }
	   
	   public void setToInProcess() {
		   try {
			this.getTaskTI().setInProcess(TaskTI.SET_IN_PROCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   public void changeToFacetFeed() throws InterruptedException{
		   this.getTaskTI().changeTabToFeed();
	   }
	   
	   public void changeToFacetOverview() throws InterruptedException{
		   this.getTaskTI().changeTabToOverview();;
	   }
	   
	   public void changeToFacetRelatedItems() throws InterruptedException{
		   this.getTaskTI().changeTabToRelatedItems();;
	   }
	   
	   public void changeToFacetChanges() throws InterruptedException{
		   this.getTaskTI().changeTabToChanges();;
	   }
	   
	   public void checkNotEditable(){
		   this.getTaskTI().checkForNotEditable();
	   }
	   
	   public void addFollowupItemsTasks() throws InterruptedException{
		   this.getTaskTI().editToAddFollowupItems();
	   }
	   
	   public void addRelatedItemsTasks() throws Exception{
		   this.getTaskTI().addRelatedItems();
	   }
	   
	   public void editHeaderTasks() throws InterruptedException{
		   this.getTaskTI().editHeader();
	   }
	   
	   public void checkChangesTasks() throws Exception{
		   this.getTaskTI().checkChanges();
	   }
	   	   
	   public void deleteFromFollowup() throws InterruptedException{
		   this.getTaskTI().deleteItemInTI(TaskTI.DELETE_ROW_FOLLOWUP, TaskTI.DELETE_ICON_FOLLOWUP);
	   }
	   
	   public void deleteFromRelatedItems() throws InterruptedException{
		   this.getTaskTI().deleteItemInTI(TaskTI.DELETE_ROW_RELATEDITEM, TaskTI.DELETE_ICON_RELATEDITEM);
	   }
}