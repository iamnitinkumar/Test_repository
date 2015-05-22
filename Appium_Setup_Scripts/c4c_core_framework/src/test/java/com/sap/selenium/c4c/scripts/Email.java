package com.sap.selenium.c4c.scripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.EmailOWL;
import com.sap.selenium.c4c.components.EmailTI;
import com.sap.selenium.c4c.components.PerformanceRunner;

public class Email {

	private WebDriver driver;
	private EmailTI emailTI = null;
	private EmailOWL emailOWL = null;
	
	public Email(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
    /*
     * New TI, OWL classes
     */
    public EmailTI getEmailTI()
    {
    	if (emailTI == null)
    	{
    		emailTI = new EmailTI(driver);
    	}
    	return emailTI;
    }

    
    public EmailOWL getEmailOWL()
    {
    	if (emailOWL == null)
    	{
    		emailOWL = new EmailOWL(driver);
    	}
    	return emailOWL;
    }

    
    public Object getEmailQC()
    {
    	return null;
    }
    
	
   public Boolean editEmail()
   {
	   return true;
   }
   
   public Boolean navigateToEmail() throws Exception{
	   try {
		this.getEmailOWL().navigate();
	} catch (Exception e) {
		Assert.fail("Failed to naviagte to Email with error: "+ e.getLocalizedMessage()); 
	}
	   Assert.assertTrue("Navigation to Email successful", true);
	   return true;
	  
   }
   
   public Boolean openFirstEmail()
   {
		try {
			this.navigateToEmail();
			Thread.sleep(5000);
			this.getEmailOWL().openFirstEmailByFilter(EmailOWL.SIMPLE_SEARCH_FILTER_ALL);
		} catch (Exception e) {
			Assert.fail("Opening email failed: "+ e.getLocalizedMessage());
		}
	   Assert.assertTrue("Email opened successful", true);
	   return true;
   } 
   
   public void changeToFacetFeed() throws InterruptedException{
	   this.getEmailTI().changeTabToFeed();
   }
   
   public void changeToFacetOverview() throws InterruptedException{
	   this.getEmailTI().changeTabToOverview();
   }
   
   public void changeToFacetRelatedItems() throws InterruptedException{
	   this.getEmailTI().changeTabToRelatedItems();
   }
   
   public void changeToFacetChanges() throws InterruptedException{
	   this.getEmailTI().changeTabToChanges(); 
   }
   
   public void changeToFacetAttachments() throws InterruptedException{
	   this.getEmailTI().changeTabToAttachments();
   }
   
   public Boolean closeEmail() throws Exception
   {
		this.getEmailTI().close();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
   }
    
}
