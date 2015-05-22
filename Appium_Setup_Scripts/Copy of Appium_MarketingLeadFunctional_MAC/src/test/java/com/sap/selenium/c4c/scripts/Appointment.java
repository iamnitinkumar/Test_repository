package com.sap.selenium.c4c.scripts;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AppointmentOWL;
import com.sap.selenium.c4c.components.AppointmentQC;
import com.sap.selenium.c4c.components.AppointmentTI;

public class Appointment {

	private WebDriver driver;
	private AppointmentTI appointmentTI = null;
	private AppointmentOWL appointmentOWL = null;
	private AppointmentQC appointmentQC = null;
	private String testCaseName;

	public Appointment(WebDriver webDriver, String testCaseName)
	{
		driver = webDriver;
		this.testCaseName = testCaseName;
	}
	
	public Appointment(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
    /*
     * New TI, OWL classes
     */
	
	public AppointmentOWL getAppointmentOWL()
    {
    	if (appointmentOWL == null)
    	{
    		appointmentOWL = new AppointmentOWL(driver);
    	}
    	return appointmentOWL;
    }
	
    public AppointmentTI getAppointmentTI()
    {
    	if (appointmentTI == null)
    	{
    		appointmentTI = new AppointmentTI(driver);
    	}
    	return appointmentTI;
    }
	
	
    public AppointmentQC getAppointmentQC()
    {
    	if (appointmentQC == null)
    	{
    		appointmentQC = new AppointmentQC(driver,this.testCaseName);
    	}
    	return appointmentQC;
    }
    
    public Boolean editAppointment()
    {

    	try {
    		this.getAppointmentTI().edit();
    		Thread.sleep(10000);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return true;
    }
    
    public Boolean saveAppointment()
    {
 	   this.getAppointmentTI().save2();
 		
 		
 		try {
 			Thread.sleep(10000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return true;
    }
    public Boolean closeAppointment()
    {	try {
 	   		Thread.sleep(3000);
 	   		this.getAppointmentTI().close2();
 			Thread.sleep(10000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return true;
    }
   
   
   
   public Boolean createAppointment(Map<String, String> data)
   {

	   try {
		   this.getAppointmentQC().createAndOpen(data);
	   } catch (Exception e) {
		   Assert.fail("Account creation failed: "+ e.getLocalizedMessage()); 
	   }

	   try {
		   Thread.sleep(10000);
	   } catch (InterruptedException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }

	   Assert.assertTrue("Account create successful", true);
	   return true;
   }

   
   public void quickCreateAppointment(Map<String,String> data) throws Exception   //quickCreatAppointment(Map<String, String> data1)
   {
	   	this.getAppointmentOWL().navigate();
		AccessHelper.quickcreate(true, "New_AppointmentQC");
		this.createAppointment(data);
   }
   
   
  /* public Boolean createAppointmentFromFile(String fullFileName)
   {
	   TestDataLoader tdl = new TestDataLoader();
	   if (tdl.doesFileExist(fullFileName))
	   {
		   Map<String, Map<String, String>>testDataMaps = tdl.readExcelDataRows(fullFileName, 0);

		   for (String key : testDataMaps.keySet())
		   {
			   Map<String, String> data = testDataMaps.get(key);
			   try {
				   this.quickCreateAppointment(data);

			   } catch (InterruptedException e) {
				   Assert.fail("Appointment creation failed for set <"+key+">: "+ e.getLocalizedMessage()); 
			   }
			   try {
				   Thread.sleep(10000);
			   } catch (InterruptedException e) {
				   e.printStackTrace();
			   }
		   }
	   } 
	   else
	   {
		   Assert.fail("Appointment creation failed - file <"+ fullFileName + "> does not exist");
	   }

	   Assert.assertTrue("Appointment create successful", true);

	   return true;
	   
   }*/
   
   public void generateSummary () throws Exception{
	   this.getAppointmentTI().performActionActivity(AppointmentTI.GENERATE_SUMMARY);
   }
   
   public void cancelAppointment () throws Exception{
	   this.getAppointmentTI().performActionActivity(AppointmentTI.SET_CANCELLED);
   }
   
   public void completeAppointment () throws Exception{
	   this.getAppointmentTI().performActionActivity(AppointmentTI.SET_COMPLETE);
   }
      
   public void addAttachments(String link, String title) throws Exception{
	   this.getAppointmentTI().editToAddAttachements(link, title);
   }
   
   public void addInvolvedParties() throws InterruptedException{
	   this.getAppointmentTI().editAppointmentToAddInvolvedParties();
   }
   
   public void setToInProcess() throws Exception{
	   this.getAppointmentTI().setInProcess(AppointmentTI.SET_IN_PROCESS);
   }
   
   public void changeToFacetFeed() throws InterruptedException{
	   this.getAppointmentTI().changeTabToFeed();
   }
   
   public void changeToFacetOverview() throws InterruptedException{
	   this.getAppointmentTI().changeTabToOverview();;
   }
   
   public void changeToFacetRelatedItems() throws InterruptedException{
	   this.getAppointmentTI().changeTabToRelatedItems();;
   }
   
   public void changeToFacetChanges() throws InterruptedException{
	   this.getAppointmentTI().changeTabToChanges();;
   }
   
   public void checkNotEditable(){
	   this.getAppointmentTI().checkForNotEditable();
   }
   
   public void addFollowupItemsAppointments() throws InterruptedException{
	   this.getAppointmentTI().editToAddFollowupItems();
   }
   
   public void addRelatedItemsAppointments() throws Exception{
	   this.getAppointmentTI().addRelatedItems();
   }
   
   public void editHeaderAppointments() throws InterruptedException{
	   this.getAppointmentTI().editHeader();
   }
   
   public void checkChangesAppointments() throws Exception{
	   this.getAppointmentTI().checkChanges();
   }
  
   public void deleteFromFollowup() throws InterruptedException{
	   this.getAppointmentTI().deleteItemInTI(AppointmentTI.DELETE_ROW_FOLLOWUP, AppointmentTI.DELETE_ICON_FOLLOWUP);
   }
   
   public void deleteFromRelatedItems() throws InterruptedException{
	   this.getAppointmentTI().deleteItemInTI(AppointmentTI.DELETE_ROW_RELATEDITEM, AppointmentTI.DELETE_ICON_RELATEDITEM);
   }
}
