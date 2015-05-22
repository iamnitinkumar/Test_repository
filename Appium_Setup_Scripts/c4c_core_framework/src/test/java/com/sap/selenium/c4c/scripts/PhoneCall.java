package com.sap.selenium.c4c.scripts;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.PhoneCallOWL;
import com.sap.selenium.c4c.components.PhoneCallQC;
import com.sap.selenium.c4c.components.PhoneCallTI;

public class PhoneCall {

	private WebDriver driver;
	private PhoneCallTI phoneCallTI = null;
	private PhoneCallOWL phoneCallOWL = null;
	private PhoneCallQC phoneCallQC = null;
	private String testCaseName;

	
	public PhoneCall(WebDriver webDriver, String testCaseName)
	{
		driver = webDriver;
		this.testCaseName = testCaseName;
	}
	
    /*
     * New TI, OWL classes
     */
    public PhoneCallTI getPhoneCallTI()
    {
    	if (phoneCallTI == null)
    	{
    		phoneCallTI = new PhoneCallTI(driver);
    	}
    	return phoneCallTI;
    }

    
    public PhoneCallOWL getPhoneCallOWL()
    {
    	if (phoneCallOWL == null)
    	{
    		phoneCallOWL = new PhoneCallOWL(driver);
    	}
    	return phoneCallOWL;
    }

    
    public PhoneCallQC getPhoneCallQC()
    {
    	if (phoneCallQC == null)
    	{
    		phoneCallQC = new PhoneCallQC(driver,this.testCaseName);
    	}
    	return phoneCallQC;
    }
    
	
   public Boolean editPhoneCall() 
   {
	   
		
		
		try {
			this.getPhoneCallTI().edit();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
   }
   
   public Boolean savePhoneCall()
   {
	   this.getPhoneCallTI().save2();
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
   }
   
   public Boolean closePhoneCall()  
   {
		
		
		
		try {
			this.getPhoneCallTI().close();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
   }
   
   public void quickCreatePhoneCall(Map<String,String> data) 
   
   {
	   	try {
			this.getPhoneCallOWL().navigate();
			AccessHelper.quickcreate(true, "New_PhoneCallQC");
			this.createPhoneCall(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   } 
   
   public Boolean createPhoneCall(Map<String, String> data) 
   {
	   
	     try {
			this.getPhoneCallQC().createAndOpen(data);
		} catch (Exception e) {
			Assert.fail("PhoneCall creation failed: "+ e.getLocalizedMessage()); 
		}
	   
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   Assert.assertTrue("PhoneCall create successful", true);
	   return true;
   }
  
   public void generateSummary ()  {
	   try {
		this.getPhoneCallTI().performActionActivity(PhoneCallTI.GENERATE_SUMMARY);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void cancelPhoneCall ()  {
	   try {
		this.getPhoneCallTI().performActionActivity(PhoneCallTI.SET_CANCELLED);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void completePhoneCall ()  {
	   try {
		this.getPhoneCallTI().performActionActivity(PhoneCallTI.SET_COMPLETE);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
      
   public void addAttachments(String link, String title)  {
	   try {
		this.getPhoneCallTI().editToAddAttachements(link, title);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void addParticipants()  {
	   try {
		this.getPhoneCallTI().editPhoneCallToAddParticipants();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void setToInProcess()  {
	   try {
		this.getPhoneCallTI().setInProcess(PhoneCallTI.SET_IN_PROCESS);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void changeToFacetFeed() {
	   try {
		this.getPhoneCallTI().changeTabToFeed();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void changeToFacetOverview() {
	   try {
		this.getPhoneCallTI().changeTabToOverview();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
   }
   
   public void changeToFacetRelatedItems() {
	   try {
		this.getPhoneCallTI().changeTabToRelatedItems();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
   }
   
   public void changeToFacetChanges() {
	   try {
		this.getPhoneCallTI().changeTabToChanges();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
   }
   
   public void checkNotEditable(){
	   this.getPhoneCallTI().checkForNotEditable();
   }
   
   public void addFollowupItemsPhoneCalls() {
	   try {
		this.getPhoneCallTI().editToAddFollowupItems();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void addRelatedItemsPhoneCalls()  {
	   try {
		this.getPhoneCallTI().addRelatedItems();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void editHeaderPhoneCalls() {
	   try {
		this.getPhoneCallTI().editHeader();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void checkChangesPhoneCalls()  {
	   try {
		this.getPhoneCallTI().checkChanges();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void convertToNewTicket()  {
	   try {
		this.getPhoneCallTI().convertNewTicketAction();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void assignNewTicket()  {
	   try {
		this.getPhoneCallTI().assignExtistingTicketAction();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void deleteFromFollowup() {
	   try {
		this.getPhoneCallTI().deleteItemInTI(PhoneCallTI.DELETE_ROW_FOLLOWUP, PhoneCallTI.DELETE_ICON_FOLLOWUP);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void deleteFromRelatedItems() {
	   try {
		this.getPhoneCallTI().deleteItemInTI(PhoneCallTI.DELETE_ROW_RELATEDITEM, PhoneCallTI.DELETE_ICON_RELATEDITEM);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
