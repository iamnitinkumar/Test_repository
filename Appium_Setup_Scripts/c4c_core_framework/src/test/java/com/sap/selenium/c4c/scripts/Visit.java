package com.sap.selenium.c4c.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.lang.reflect.Constructor;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.Keys;*/






import org.openqa.selenium.WebElement;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.AppointmentTI;
import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.VisitOWL;
import com.sap.selenium.c4c.components.VisitQC;
import com.sap.selenium.c4c.components.VisitTI;

public class Visit {

	private WebDriver driver;
	private VisitTI visitTI = null;
	private VisitOWL visitOWL = null;
	private VisitQC visitQC = null;  
	String  visitname= null;
	
	public Visit(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
    /*
     * New TI, OWL classes
     */
    public VisitTI getvisitTI()
    {
    	if (visitTI == null)
    	{
    		visitTI = new VisitTI(driver);
    	}
    	return visitTI;
    }

    
    public VisitOWL getvisitOWL()
    {
    	if (visitOWL == null)
    	{
    		visitOWL = new VisitOWL(driver);
    	}
    	return visitOWL;
    }

    
    public VisitQC getvisitQC()
    {
    	if (visitQC == null)
    	{
    		visitQC = new VisitQC(driver);
    	}
    	return visitQC;
    	
    }
 	

	    	
    public void editVisit(){
 	   try{
 		 String EditVisit = null;
		//AccessHelper.TIEdit(true, EditVisit);	  
 		this.getvisitTI().edit();
 		   
 		 visitTI.visitnote();
 	   }
 	   catch(Exception e){
 		   
 	   }
    }
    public void savevisit(){
 	   try{
 		   this.getvisitTI().save();
 	   }
 	   catch(Exception e){
 		   
 	   }
    }
    
    public Boolean openvisit(String visitName, String filterName)
    {
 		try {
 			simpleSearchvisitWithoutNav(visitName, filterName);
 			this.getvisitOWL().openTI(visitName);
 		} catch (Exception e) {
 			Assert.fail("Opening visit failed: "+ e.getLocalizedMessage());
 		}
 	   Assert.assertTrue("Visit display successful", true);
 	   return true;
    } 
    
    
    public Boolean simpleSearchvisitWithoutNav(String searchTerm, String filterType){
 	   
 	   try{
 		   this.getvisitOWL().openFilter(filterType);
 		   this.getvisitOWL().simpleSearch(searchTerm);
 		   
 	   }
 	   catch(Exception e){
 		   Assert.fail("Failed to seach term: "+ searchTerm);
 	   }
 	   
 	   return true;
    }
    
    public void displayvisit(String filterType){
 	   try{
 		   navigateToVisit();
 		   this.getvisitOWL().openFilter(filterType);

 	   }
 	   catch(Exception e)
 	   {
 		   
 	   }
    }

 	  public void navigateToVisit() throws Exception{
 			
 		  
		   this.getvisitOWL().navigate();
		   
		        }
		      

	 
  
  
 	 
 	   public Boolean closevisit() throws Exception
 	   {
 			this.getvisitTI().close();
 			
 			
 			try {
 				Thread.sleep(10000);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			
 			
 			
 		   return true;
 	   }	   
 	   
 	  /*public void quickCreateVisit(Map<String,String> data) throws InterruptedException   //quickCreatAppointment(Map<String, String> data1)
 	   {
 		   	//this.getvisitOWL().navigate();
 			AccessHelper.quickcreate(true, "New_VisitQC");
 			this.createVisitFromNew(data,"NEW");
 	   }*/
 	 
 	   
 	   public void quickCreateVisit(Map<String,String> data) throws InterruptedException   //quickCreatAppointment(Map<String, String> data1)
 	   {
 		   	//this.getvisitOWL().navigate();
 			AccessHelper.quickcreate(true, "New_Visit");
 			this.createVisit(data);
 	   }
 	/* public Boolean createVisit(Map<String, String> data)
 	   {
 		   
 		     try {
 				this.getvisitQC().createFromNew(data);
 			} catch (InterruptedException e) {
 				Assert.fail("Account creation failed: "+ e.getLocalizedMessage()); 
 			}
 		   
 				try {
 					Thread.sleep(10000);
 				} catch (InterruptedException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 			   
 			   Assert.assertTrue("Visit create successful", true);
 		   return true;
 	   }
*/
 	  public Boolean createVisit(Map<String, String> data)
 	   {

 		   try {
 			   this.getvisitQC().createAndOpen(data);
 		   } catch (Exception e) {
 			   Assert.fail("Visit creation failed: "+ e.getLocalizedMessage()); 
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

 	   public Boolean createVisitFromNew(Map<String, String> data, String afterAction) throws Exception
 	   {
 		   
 		     try {
 		    	this.getvisitOWL().navigate();
 		    	this.getvisitQC().createFromNew("Visit");
 		    	switch(afterAction)
 		    	{
 		    	case "SAVE":
 		    		this.getvisitQC().createAndSave(data);
 		    		break;
 		    	case "OPEN":
 		    		this.getvisitQC().createAndOpen(data);
 		    		break;
 		    	case "NEW":
 		    		this.getvisitQC().createAndNew(data);
 		    		break;
 		    	}
 				
 			} catch (InterruptedException e) {
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
 	  public void checkin() {
 		   try {
			this.visitTI.checkin(visitTI.CHECKIN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	   }  
 	 public void navigate(String owlName, String tabName) throws Exception{
 		   try {
 			  
 			  this.getvisitOWL().navigateFromUser(owlName, tabName);
 			
 			 

 		   } catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} 
 	 


}



}


