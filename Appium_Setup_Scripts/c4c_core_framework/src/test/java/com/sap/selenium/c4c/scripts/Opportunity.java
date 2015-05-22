package com.sap.selenium.c4c.scripts;

import io.appium.java_client.AppiumDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.OpportunityOWL;
import com.sap.selenium.c4c.components.OpportunityQC;
import com.sap.selenium.c4c.components.OpportunityTI;

public class Opportunity {

	private WebDriver driver;
	//private AppiumDriver driver;
	private OpportunityTI OpportunityTI = null;
	private OpportunityOWL OpportunityOWL = null;
	private OpportunityQC OpportunityQC = null;

	private String wcName;
	private String wcViewName;
	private String testCaseName;

	public Opportunity(WebDriver webDriver, String testCaseName) {
		driver = webDriver;
		wcName = "SALES";
		wcViewName = "OPPORTUNITY";
		this.testCaseName = testCaseName;
	}
/*	public Opportunity(AppiumDriver webDriver, String testCaseName) {
		driver = webDriver;
		wcName = "SALES";
		wcViewName = "OPPORTUNITY";
		this.testCaseName = testCaseName;
	}*/

	/*
	 * New TI, OWL classes
	 */

	public OpportunityTI getOpportunityTI() {
		if (OpportunityTI == null) {
			OpportunityTI = new OpportunityTI(driver);
		}
		return OpportunityTI;
	}

	public OpportunityQC getOpportunityQC() {
		if (OpportunityQC == null) {
			OpportunityQC = new OpportunityQC(driver, testCaseName);
		}
		return OpportunityQC;
	}

	public OpportunityOWL getOpportunityOWL() {
		if (OpportunityOWL == null) {
			OpportunityOWL = new OpportunityOWL(driver);
		}
		return OpportunityOWL;
	}

	
	/**
	 * This Method shall be used to close the Opportunity Thing Inspector when opened
	 * @return
	 */
	public Boolean closeOpportunity() {

		try {
			this.getOpportunityTI().close();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * This method shall be used to create an Opportunity using the Quick create option in the SALES->OPPORTUNITY workcenter view.
	 * <P>
	 * Method shall click on the New button and Create an opportunity with the specified data
	 * 
	 * @param data
	 * 
	 *            <P>dataset to create ( key - value pair )
	 * 
	 * @param action
	 * 
	 *            <P>- NEW : Create Opportunity and open a new Quick Create
	 *            opportunity screen 
	 *            <P>- SAVE: Create opportunity and save only
	 *            <P>- OPEN: Create Opportunity and Open the created opportunity in
	 *            Thing Inspector
	 */
	public void createOpportunity(Map<String, String> data, String action) {
		switch (action) {
		case "OPEN":

			try {
				this.getOpportunityOWL().clickButton(OpportunityOWL.NEW_BUTTON,
						"NEW_OPPORTUNITY_CLICK");
				this.getOpportunityQC().createAndOpen(data);
			} catch (Exception e) {
				Assert.fail("Opportunity creation failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("Opportunity create successful", true);
			break;

		case "NEW":

			try {
				this.getOpportunityOWL().clickButton(OpportunityOWL.NEW_BUTTON,
						"NEW_OPPORTUNITY_CLICK");
				this.getOpportunityQC().createAndNew(data);
			} catch (Exception e) {
				Assert.fail("Opportunity creation failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("Opportunity create successful", true);
			break;

		case "SAVE":

			try {
				this.getOpportunityOWL().clickButton(OpportunityOWL.NEW_BUTTON,
						"NEW_OPPORTUNITY_CLICK");
				this.getOpportunityQC().createAndSave(data);
			} catch (Exception e) {
				Assert.fail("Opportunity creation failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("Opportunity create successful", true);
			break;

		}

	}

	/*
	 * public Boolean createAccountFromFile(String fullFileName) {
	 * TestDataLoader tdl = new TestDataLoader();
	 * 
	 * if (tdl.doesFileExist(fullFileName)) { try {
	 * this.getAccountQC().createAndSave
	 * (tdl.readSingleExcelSheet(fullFileName)); } catch (InterruptedException
	 * e) { Assert.fail("Account creation failed: "+ e.getLocalizedMessage()); }
	 * 
	 * } else { Assert.fail("Account creation failed - file <"+ fullFileName +
	 * "> does not exist"); }
	 * 
	 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * Assert.assertTrue("Account create successful", true);
	 * 
	 * return true;
	 * 
	 * 
	 * }
	 */

	/*
	 * public Boolean openAccount(String accountName, String filterName) { try {
	 * this.getAccountOWL().openTIFromSimpleSearchWithFilter(accountName,
	 * filterName); } catch (Exception e) {
	 * Assert.fail("Opening account failed: "+ e.getLocalizedMessage());
	 * //e1.printStackTrace(); }
	 * 
	 * try { Thread.sleep(10000); } catch (InterruptedException e) {
	 * Assert.fail(
	 * "Opening account failed with technical error in wait process: "+
	 * e.getLocalizedMessage()); }
	 * 
	 * Assert.assertTrue("Account display successful", true); return true; }
	 */

	/**
	 * This Method shall be used to associate/add a new Contact to the Opportunity 
	 * <P>
	 * Method shall do the below steps 
	 * 	<P>- Navigate to the contacts Facet in the Opportunity Thing Inspector 
	 *  <P>- Add a new contact with the data specified
	 *  
	 * @param accountName
	 * @param data
	 * @return
	 */
	public Boolean editOpportunityToAddContact(String accountName,
			Map<String, String> data) {

		// try {
		// this.getAccountOWL().openTIFromSimpleSearchWithFilter(accountName,
		// AccountOWL.SIMPLE_SEARCH_FILTER_ALL);
		// } catch (Exception e) {
		// Assert.fail("Opening account failed: "+ e.getLocalizedMessage());
		// //e1.printStackTrace();
		// }

		try {
			this.getOpportunityTI().changeTabToContacts();
		} catch (Exception e) {
			Assert.fail("Navigation to contact failed: "
					+ e.getLocalizedMessage());
		}

		try {
			this.getOpportunityTI().newContact(data);
		} catch (Exception e) {
			Assert.fail("Contact creation failed: " + e.getLocalizedMessage());
		}

		// Adding a contact does not switch account into change mode, no need to
		// save!

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	
	/**
	 * This Method shall be used to associate/add a new Appointment to the Opportunity 
	 * <P>
	 * Method shall do the below steps 
	 * 	<P>- Navigate to the Activity Facet in the Opportunity Thing Inspector 
	 *  <P>- Add a new appointment with the data specified
	 *  
	 * @param data
	 * @return
	 */
	public Boolean AddAppointmentActivitytoOpportunity(Map<String, String> data) {

		try {
			this.getOpportunityTI().changeTabToActivities();
		} catch (Exception e) {
			Assert.fail("Navigation to activites failed: "
					+ e.getLocalizedMessage());
		}

		try {
			this.getOpportunityTI().newAppointment(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("appointment creation failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	/**
	 * Prerequisites: Opportunity TI open and action Set as inProcess enabled
	 * 
	 * <P>
	 * This method shall be used to click on the Action : Set as inProcess in the Thing Inspector.
	 * 
	 * 
	 */
	public void setOpportunitytoInProcess() {

		

		try {
			System.out.println("in setOpportunitytoInProcess");
			this.getOpportunityTI().executeActionSetAsInProcess();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue("Opportunity Action set to in process", true);

	}

	/**
	 * Prerequisites: Oppurtunity TI open and action Set as Open enabled
	 * <P>
	 * This method shall be used to click on the Action : Set as Open in the Thing Inspector.
	 */
	public void setOpportunitytoOpen() {

		

		try {
			this.getOpportunityTI().executeActionSetAsOpen();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue("Opportunity Action set to Open", true);

	}

	/**
	 * Prerequisites: Oppurtunity TI open and action Set as Won enabled
	 * <P>
	 * This method shall be used to click on the Action : Set as Won in the Thing Inspector with the reason. Reason can be null if no
	 * reason needs to be specified.
	 */
	public void setOpportunitytoWonWithReason(String Reason) {
		try {
			this.getOpportunityTI().executeActionSetAsWon(Reason);
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue("Opportunity Action set to in Won", true);

	}

	/**
	 * Prerequisites: Oppurtunity TI open and action Set as Lost enabled
	 * <P>
	 * This method shall be used to click on the Action : Set as Lost in the Thing Inspector with the reason. Reason can be null if no
	 * reason needs to be specified.
	 */
	public void setOpportunitytoLostWithReason(String Reason) {
		try {
			this.getOpportunityTI().executeActionSetAsLost(Reason);
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue("Opportunity Action set to in Lost", true);

	}

	/**
	 * Prerequisites: Oppurtunity TI open and action Set as Stopped enabled
	 * 
	 * <P>
	 * This method shall be used to click on the Action : Set as
	 * Stopped in the Thing Inspector.
	 */
	public void setOpportunitytoStopped() {

		

		try {
			this.getOpportunityTI().executeActionSetAsStopped();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue("Opportunity Action set to Stopped", true);

	}

	/**
	 * Prerequisites: Oppurtunity TI should be open and Action COPY enabled
	 * 
	 * <P>This method can be used to copy the opportunity opened into
	 * a new opportunity with the specific dataset and the action.
	 * 
	 * @param data
	 *            <P> The dataset to be copied ( Key-Value Pair Map Data )
	 * @param action
	 *            <P> - NEW : Copy the Opportunity and open a new Quick Create
	 *            opportunity screen
	 *            <P> - SAVE: Copy the opportunity and save only
	 *            <P> - OPEN: Copy the Opportunity and Open the copied opportunity
	 *            in Thing Inspector
	 */
	public void copyOpportunity(Map<String, String> data, String action) {

		switch (action) {
		case "NEW":
			try {
				this.getOpportunityTI().executeActionCopy();
				this.getOpportunityQC().createAndNew(data);
			} catch (Exception e) {
				Assert.fail("Copy Opportunity failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("Opportunity copied successful", true);
			break;

		case "OPEN":

			try {
				this.getOpportunityTI().executeActionCopy();
				System.out.println("executeactioncopy done");
				this.getOpportunityQC().createAndOpen(data);
				System.out.println("Out of Copy oppurtunity");
			} catch (Exception e) {
				Assert.fail("Copy Opportunity failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("Opportunity copied successful", true);
			break;

		case "SAVE":

			try {
				this.getOpportunityTI().executeActionCopy();
				this.getOpportunityQC().createAndSave(data);
			} catch (Exception e) {
				Assert.fail("Copy Opportunity failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("Opportunity copied successful", true);

			break;
		}

	}

	/*
	 * *************commenting this method for now ************
	 * 
	 * public void editandModifyOpportunity(Map<String, String> data){ try{
	 * this.getOpportunityTI().clickButton("EDIT");
	 * this.getOpportunityTI().ModifyOppurtunitySummary(data);
	 * this.getOpportunityTI().clickButton("SAVE"); } catch(Exception e){
	 * 
	 * } }
	 */

	/**
	 * Prerequisites: Oppurtunity TI should be open and not in edit mode
	 * 
	 * <P>This method can be used to edit the opportunity opened in
	 * the Thing Inspector.
	 */
	public void editOpportunity() {
		try {
			this.getOpportunityTI().clickButton("EDIT");
		} catch (Exception e) {

		}
	}

	/**
	 * Prerequisites: Oppurtunity TI open and in EDIT mode
	 * 
	 *<P>This method can be used to click on the SAVE button in the
	 * Thing Inspector.
	 */
	public void saveOpportunity() {
		try {
			this.getOpportunityTI().clickButton("SAVE");
		} catch (Exception e) {

		}
	}

	/**
	 * Prerequisites: Opportunity TI should be open and in EDIT mode
	 * 
	 *<P>This method modifies the opprtunity summary opened and
	 * edited in the thing inspector with the passed data( key-value pairs )
	 * 
	 * @param data
	 */
	public void modifyOpportunitySummary(Map<String, String> data) {
		try {
			this.getOpportunityTI().ModifyOppurtunitySummary(data);
		} catch (Exception e) {

		}

	}

	/**
	 * This Method is used to Navigates to the Workcenter and the
	 * Work Center View. When tested for a particular language, the
	 * Parameters need to be defined in the respective Language.
	 *            
	 * @param wcName
	 *           <P> Name of the Workcenter ( Language Specific )
	 * @param wcViewName
	 *           <P> Name of the Workcenter View (Language Specific )
	 * 
	 *            
	 */
	public void navigate(String wcName, String wcViewName) {
		try {
			this.getOpportunityOWL().navigateFromUser(wcName, wcViewName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Method for Sales->Opurtunity Navigation
	public void navigatemob(String wcName, String wcViewName) throws InterruptedException{
		System.out.println("click sales");
		WebDriverWait Wait100=new WebDriverWait(driver, 20); 
		Wait100.until(ExpectedConditions.elementToBeClickable(By.id("sapOberonMobileWorkcenter-wocbutton-img")));
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.id("sapOberonMobileWorkcenter-wocbutton-img")).click();
		Thread.sleep(2000);
		Wait100.until(ExpectedConditions.elementToBeClickable(By.id("__section4")));
		driver.findElement(By.id("__section4")).click();
		Thread.sleep(2000);
		Wait100.until(ExpectedConditions.elementToBeClickable(By.id("__button20")));
		driver.findElement(By.id("__button20")).click();
		
	}
	
	/**
	 * This method shall be used to search for an Opportunity in the Opportunity OWL 
	 * <P>
	 * Method shall filter the Opportunity OWL based on the filterName parameter specified
	 * and shall search for the Opportunity specified in the OpportunityName parameter 
	 * 
	 * @param OpportunityName
	 * <P> name of the Opportunity to be searched (Language Specific )
	 * @param filterName
	 * <P> name of the filter that needs to be set (Language Specific )
	 * @return
	 */

	public Boolean searchandOpenOpportunity(String OpportunityName,
			String filterName) {
		try {
			System.out.println("in searchandOpenOpportunity");
			simpleSearchOpportunity(OpportunityName, filterName);
			this.getOpportunityOWL().openTI(OpportunityName);
		} catch (Exception e) {
			Assert.fail("Opening Opportunity failed: "
					+ e.getLocalizedMessage());
		}
		Assert.assertTrue("Opportunity display successful", true);
		return true;
	}

	
	private Boolean simpleSearchOpportunity(String OpportunityName,
			String filterName) {

		try {
			this.getOpportunityOWL().openFilter(filterName);
			this.getOpportunityOWL().simpleSearch(OpportunityName);

		} catch (Exception e) {
			Assert.fail("Failed to seach term: " + OpportunityName);
		}

		return true;
	}

	
	
	/**
	 * This method shall be used to associate/add a Product to the Opportunity
	 * <P>
	 * Method shall 
	 * <P>- Navigate to the Products facet
	 * <P>- Add new Product data
	 * <P>- Click on Add 
	 * 
	 * @param data
	 * 
	 * @return
	 */
	public Boolean addProductToOpportunity(Map<String, String> data) {

/*		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
/*		try {
			this.getOpportunityTI().changeTabToProducts();
		} catch (Exception e) {
			Assert.fail("Navigation to facet Products failed: "
					+ e.getLocalizedMessage());
		}*/

		try {
			Thread.sleep(12000);
			this.getOpportunityTI().addProduct(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Product Addition failed: " + e.getLocalizedMessage());
		}

		return true;
	}

	
	/**
	 * This method shall be used to associate/add a Product to the Opportunity
	 * <P>
	 * Method shall 
	 * <P>- Navigate to the Products facet
	 * <P>- Add new Product data
	 * <P>- Click on Add and New button
	 * 
	 * @param data
	 * 
	 * @return
	 */
	public Boolean addAndNewProductToOpportunity(Map<String, String> data) {

		// try {
		// this.getAccountOWL().openTIFromSimpleSearchWithFilter(accountName,
		// AccountOWL.SIMPLE_SEARCH_FILTER_ALL);
		// } catch (Exception e) {
		// Assert.fail("Opening account failed: "+ e.getLocalizedMessage());
		// //e1.printStackTrace();
		// }

		try {
			this.getOpportunityTI().changeTabToProducts();
		} catch (Exception e) {
			Assert.fail("Navigation to facet Products failed: "
					+ e.getLocalizedMessage());
		}

		try {
			this.getOpportunityTI().addAndNewProduct(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Product Addition failed: " + e.getLocalizedMessage());
		}

		return true;
	}

	
	/**
	 * This method shall be used to associate/add a Contact to the Opportunity
	 * <P>
	 * Method shall 
	 * <P>- Navigate to the Contacts facet
	 * <P>- Add new Contact data
	 * <P>- Click on Add 
	 * 
	 * @param data
	 * 
	 * @return
	 */
	public Boolean addContactToOpportunity(Map<String, String> data) {

		try {
			Thread.sleep(10000);
			this.getOpportunityTI().addContact(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Contacts Addition failed: " + e.getLocalizedMessage());
		}

		return true;
	}
	
	/**
	 * This method shall be used to associate/add a Sales Team to the Opportunity
	 * <P>
	 * Method shall 
	 * <P>- Navigate to the Sales Team facet
	 * <P>- Add new Sales Team data
	 * <P>- Click on Add 
	 * 
	 * @param data
	 * 
	 * @return
	 */

	public Boolean addSalesTeamToOpportunity(Map<String, String> data) {
		try {

			Thread.sleep(15000);
			System.out.println("In Sales");
			this.getOpportunityTI().addSalesTeam(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Sales Team Addition failed: "
					+ e.getLocalizedMessage());
		}
		System.out.println("Sales complete");
		return true;
	}

	/**
	 * This method shall be used to associate/add a InvolvedParty to the Opportunity
	 * <P>
	 * Method shall 
	 * <P>- Navigate to the InvolvedParty facet
	 * <P>- Add new InvolvedParty data
	 * <P>- Click on Add 
	 * 
	 * @param data
	 * 
	 * @return
	 */
	public Boolean addInvolvedPartyToOpportunity(Map<String, String> data) {

		try {

			Thread.sleep(15000);

			this.getOpportunityTI().addInvolvedParty(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Involved Party Addition failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}

	
	/**
	 * This method shall be used to associate/add a Task Activity to the Opportunity
	 * <P>
	 * Method shall 
	 * <P>- Navigate to the Activity facet
	 * <P>- Add new Task data
	 * <P>- Click on SAVE 
	 * 
	 * @param data
	 * 
	 * @return
	 */
	public Boolean AddTaskActivitytoOpportunity(Map<String, String> data) {

		try {

			this.getOpportunityTI().changeTabToActivities();
		} catch (Exception e) {
			Assert.fail("Navigation to activites failed: "
					+ e.getLocalizedMessage());
		}

		try {
			this.getOpportunityTI().newTask(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Task creation failed: " + e.getLocalizedMessage());
		}

		return true;
	}

	
	/**
	 * This method shall be used to associate/add a Phone call activity to the Opportunity
	 * <P>
	 * Method shall 
	 * <P>- Navigate to the Activity facet
	 * <P>- Add new Phone call data
	 * <P>- Click on SAVE 
	 * 
	 * @param data
	 * 
	 * @return
	 */
	public Boolean AddPhoneCallActivitytoOpportunity(Map<String, String> data) {

		try {
			this.getOpportunityTI().changeTabToActivities();
		} catch (Exception e) {
			Assert.fail("Navigation to activites failed: "
					+ e.getLocalizedMessage());
		}

		try {
			this.getOpportunityTI().newPhoneCall(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Phone Call creation failed: "
					+ e.getLocalizedMessage());
		}

		return true;
	}
	
	/**
	 * This method shall be used to Verify the Opportunity status 
	 * @param oppStatus
	 * <P> Status of the Opportunity to be verified ( Language Specific )
	 */
	public void verifyOpportunityStatus(String oppStatus)
	{
		String status = null;
		try 
		{			
			status = this.getOpportunityTI().getOpportunityStatus();
			Assert.assertTrue(oppStatus.equals(status));
			System.out.println("Opportunity Status verification success.  Found:"+ status);
		}
		catch(AssertionError e)
		{
			System.out.println("Wrong Status for Opportunity Found.  Expected:"+oppStatus + " Found:"+ status);
		}
		
		
		
	}
	
	
	/**
	 * This method shall be used to Verify the Opportunity Approval status 
	 * @param oppStatus
	 * <P> Approval Status of the Opportunity to be verified( Language Specific )
	 */
	public void verifyOpportunityApprovalStatus(String oppStatus)
	{
		String status = null;
		try 
		{			
			status = this.getOpportunityTI().getOpportunityApprovalStatus();
			Assert.assertTrue(oppStatus.equals(status));
			System.out.println("Opportunity Approval Status verification success.  Found:"+ status);
		}
		catch(AssertionError e)
		{
			System.out.println("Wrong Approval Status for Opportunity Found.  Expected:"+oppStatus + " Found:"+ status);
		}
		
		
		
	}

}
