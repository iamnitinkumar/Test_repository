package com.sap.selenium.c4c.scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.OpportunityQC;
import com.sap.selenium.c4c.components.SalesLeadQC;
import com.sap.selenium.c4c.components.SalesLeadOWL;
import com.sap.selenium.c4c.components.SalesLeadTI;

import org.junit.Assert;

/**
 * @author C5184725
 *
 */
public class SalesLead {

	private SalesLeadQC SalesLeadQC = null;
	private WebDriver driver;
	private SalesLeadTI SalesLeadTI = null;
	private SalesLeadOWL SalesLeadOWL = null;
	private OpportunityQC OpportunityQC = null;
	private String testCaseName;

	public SalesLead(WebDriver webDriver, String testCaseName) {
		driver = webDriver;
		this.testCaseName = testCaseName;
	}

	/*
	 * New TI, OWL classes
	 */
	public SalesLeadTI getSalesLeadTI() {
		if (SalesLeadTI == null) {
			SalesLeadTI = new SalesLeadTI(driver, testCaseName);
		}
		return SalesLeadTI;
	}

	public SalesLeadOWL getSalesLeadOWL() {
		if (SalesLeadOWL == null) {
			SalesLeadOWL = new SalesLeadOWL(driver);
		}
		return SalesLeadOWL;
	}

	public SalesLeadQC getSalesLeadQC() {
		if (SalesLeadQC == null) {
			SalesLeadQC = new SalesLeadQC(driver, testCaseName);
		}
		return SalesLeadQC;
	}

	public OpportunityQC getOpportunityQC() {
		if (OpportunityQC == null) {
			OpportunityQC = new OpportunityQC(driver, this.testCaseName);
		}
		return OpportunityQC;
	}

	/**
	 * <mark>Description: This method shall be used to create an Opportunity
	 * using the Qucik create .
	 * 
	 * @param data
	 * 
	 *            dataset to create ( key - value pair )
	 * 
	 * @param action
	 * 
	 *            - NEW : Create Opportunity and open a new Quick Create
	 *            opportunity screen - SAVE: Create opportunity and save only -
	 *            OPEN: Create Opportunity and Open the created opportunity in
	 *            Thing Inspector
	 */
	public void createSalesLead(Map<String, String> data, String action) {
		switch (action) {
		case "OPEN":

			try {
				this.getSalesLeadOWL().clickButton(SalesLeadOWL.NEW_BUTTON,"NEW_SalesLead_CLICK");
				this.getSalesLeadQC().createAndOpen(data);
			} catch (Exception e) {
				Assert.fail("salesLead creation failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("SalesLead create successful", true);
			break;

		case "NEW":

			try {
				this.getSalesLeadOWL().clickButton(SalesLeadOWL.NEW_BUTTON,"NEW_SalesLead_CLICK");
				this.getSalesLeadQC().createAndNew(data);
			} catch (Exception e) {
				Assert.fail("SalesLead creation failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("SalesLead create successful", true);
			break;

		case "SAVE":

			try {
				this.getSalesLeadOWL().clickButton(SalesLeadOWL.NEW_BUTTON,"NEW_SalesLead_CLICK");
				this.getSalesLeadQC().createAndSave(data);
			} catch (Exception e) {
				Assert.fail("salesLead creation failed: "
						+ e.getLocalizedMessage());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue("salesLead create successful", true);
			break;

		}

	}

	/**
	 * This method will Create a new sales Lead
	 * 
	 * @param data
	 * @return
	 */
	public Boolean createSalesLead(Map<String, String> data) {

		try {
			this.getSalesLeadQC().createAndOpen(data);
			Thread.sleep(10000);
		} catch (Exception e) {
			Assert.fail("SalesLead creation failed: " + e.getLocalizedMessage());
			e.printStackTrace();
		}

		Assert.assertTrue("SalesLead create successful", true);
		return true;
	}

	/**
	 * This method is used to click on New button in OWL to create sales lead
	 * 
	 * @param data
	 * @return
	 */
	public Boolean createNewSalesLead(Map<String, String> data) {

		try {
			this.getSalesLeadOWL().clickButton(SalesLeadOWL.NEW_BUTTON,
					"NEWSALESLEAD_CLICK");
			this.getSalesLeadQC().createAndOpen(data);
			Thread.sleep(10000);
		} catch (Exception e) {
			Assert.fail("SalesLead creation failed: " + e.getLocalizedMessage());
			e.printStackTrace();
		}

		Assert.assertTrue("SalesLead create successful", true);
		return true;
	}

	public Boolean AddAppointmentActivitytoSalesLead(Map<String, String> data) {

		// try {
		// this.getAccountOWL().openTIFromSimpleSearchWithFilter(accountName,
		// AccountOWL.SIMPLE_SEARCH_FILTER_ALL);
		// } catch (Exception e) {
		// Assert.fail("Opening account failed: "+ e.getLocalizedMessage());
		// //e1.printStackTrace();
		// }

		try {
			this.getSalesLeadTI().newAppointment(data);
		} catch (Exception e) {
			Assert.fail("appointment creation failed: "
					+ e.getLocalizedMessage());
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
	 * this method will Accept the sales Lead with Reason.
	 * 
	 * @param Reason
	 */
	public void acceptSalesLeadWithReason(String Reason) {

		System.out.println("acceptSalesLeadWithReason() Called");
		try {
			this.getSalesLeadTI().executeActionSetAsAccept(Reason);
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue("SalesLead Action set to Accept", true);

	}

	/**
	 * this method will decline the sales Lead with Reason.
	 * 
	 * @param Reason
	 */
	public void declineSalesLeadWithReason(String Reason) {

		System.out.println("declineSalesLeadWithReason() Called");

		try {
			this.getSalesLeadTI().executeActionSetAsDecline(Reason);
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue("SalesLead Action set to Decline", true);

	}

	/**
	 * This method will copy the existing sales Lead and save it as New.
	 * 
	 * @param data
	 * @return
	 */
	public Boolean copySalesLead(Map<String, String> data) {

		System.out.println("copySalesLead() Called");

		try {
			this.getSalesLeadTI().executeActionCopy();
			this.getSalesLeadQC().createAndSave(data);
			Thread.sleep(10000);
		} catch (Exception e) {
			Assert.fail("Copy SalesLead failed: " + e.getLocalizedMessage());
			e.printStackTrace();
		}

		Assert.assertTrue("SalesLead copied successful", true);
		return true;
	}

	/**
	 * This method click on involved party facet in the TI and add involed party
	 * to the the SalesLead
	 * 
	 * @param salesLeadName
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public Boolean AddProductToSalesLead(Map<String, String> data) {

		// try {
		// this.getAccountOWL().openTIFromSimpleSearchWithFilter(accountName,
		// AccountOWL.SIMPLE_SEARCH_FILTER_ALL);
		// } catch (Exception e) {
		// Assert.fail("Opening account failed: "+ e.getLocalizedMessage());
		// //e1.printStackTrace();
		// }

		// if (salesLeadName != null) {
		// WebElement elem = driver.findElement(By2.startsWithAndPartialId(
		// "BasicFind", "-cb-input"));
		// elem.sendKeys(salesLeadName);
		//
		// // wait for search to return results
		// Thread.sleep(4000);
		// // "listdefintionuiH58Wl_saqMwy7TR7hsNaW_", "-rows-row"
		// if ((elem = driver.findElement(By2.startsWithAndPartialId("link",
		// "col0-row0"))) != null) {
		//
		// elem.click();
		//
		// } else {
		// driver.findElement(
		// By2.startsWithAndPartialId("embeddedcomponent_",
		// "-close")).click();
		// }
		// }

		try {
			this.getSalesLeadTI().newProductsandAddNew(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Product Facet addition Failed failed: "
					+ e.getLocalizedMessage());
		}

		// Adding a contact does not switch account into change mode, no need to
		// save!

		return true;
	}

	/**
	 * This method click on involved party facet in the TI and add involed party
	 * to the the SalesLead
	 * 
	 * @param salesLeadName
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public Boolean AddInvolvedPartytoSalesLead(Map<String, String> data) {

		try {
			Thread.sleep(2000);
			this.getSalesLeadTI().newInvolvedPartyandAdd(data);
		} catch (Exception e) {
			Assert.fail("InvolvedParty creation failed: "
					+ e.getLocalizedMessage());
		}

		// Adding a contact does not switch account into change mode, no need to
		// save!

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * This method click on Sales And Marketing Team facet in the TI and add
	 * Sales And Marketing Team to the the SalesLead
	 * 
	 * @param salesLeadName
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public Boolean AddSalesAndMarketingTeamtoSalesLead(Map<String, String> data)
			throws Exception {

		try {
			this.getSalesLeadTI().newSalesAndMarketingTeamandAdd(data);
		} catch (Exception e) {
			Assert.fail("Sales And Marketing Team creation failed: "
					+ e.getLocalizedMessage());
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
	 * This method click on Contact facet in the TI and add Contact to the the
	 * SalesLead
	 * 
	 * @param salesLeadName
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public Boolean AddContacttoSalesLead(Map<String, String> data)
			throws Exception {

		Thread.sleep(2000);

		try {
			this.getSalesLeadTI().addContactAddAndSave(data);
		} catch (Exception e) {
			Assert.fail("Contact Addition failed: " + e.getLocalizedMessage());
		}

		Thread.sleep(3000);

		return true;
	}

	/**
	 * 
	 * @param wcName
	 *            Name of the Workcenter ( Language Specific )
	 * @param wcViewName
	 *            Name of the Workcenter View (Language Specific )
	 * 
	 *            This Method is used to Navigates to the Workcenter and the
	 *            Work Center View. When tested for a particular language, the
	 *            Parameters need to be defined in the respective Language.
	 */
	public void navigate(String wcName, String wcViewName) {
		try {
			this.getSalesLeadOWL().navigateFromUser(wcName, wcViewName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean searchandOpenSalesLead(String SalesLeadName,
			String filterName) {
		try {
			simpleSearchSalesLead(SalesLeadName, filterName);
			this.getSalesLeadOWL().openTI(SalesLeadName);
		} catch (Exception e) {
			Assert.fail("Opening SalesLead failed: " + e.getLocalizedMessage());
		}
		Assert.assertTrue("SalesLead display successful", true);
		return true;
	}

	private Boolean simpleSearchSalesLead(String SalesLeadName,
			String filterName) {

		try {
			this.getSalesLeadOWL().openFilter(filterName);
			this.getSalesLeadOWL().simpleSearch(SalesLeadName);

		} catch (Exception e) {
			Assert.fail("Failed to seach term: " + SalesLeadName);
		}

		return true;
	}

	/**
	 * This method will converts the sales Lead to opportunity
	 * 
	 * @param data
	 * @return
	 */
	public Boolean salesLead_ConvertToOpportunity(Map<String, String> data) {

		System.out.println("salesLead_ConvertToOpportunity() Called");

		try {
			this.getSalesLeadTI().executeActionConvertToOpportunity();
			this.getOpportunityQC().createAndSave(data);
			Thread.sleep(10000);
		} catch (Exception e) {
			Assert.fail("Convert SalesLead to Opportunity failed: "
					+ e.getLocalizedMessage());
			e.printStackTrace();
		}

		Assert.assertTrue("SalesLead conversion to opportunity successful",
				true);
		return true;
	}

	public Boolean closeSalesLead() {

		try {
			this.getSalesLeadTI().close();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Prerequisites: Sales Lead TI should be open and not in edit mode
	 * 
	 * Description: This method can be used to edit the Sales Lead opened in the
	 * Thing Inspector.
	 */
	public void editSalesLead() {
		try {
			this.getSalesLeadTI().clickButton("EDIT");
		} catch (Exception e) {

		}
	}

	/**
	 * Prerequisites: Sales Lead TI open and in EDIT mode
	 * 
	 * Description: This method can be used to click on the SAVE button in the
	 * Thing Inspector.
	 */
	public void saveSalesLeadTI() {
		try {
			this.getSalesLeadTI().clickButton("SAVE");
		} catch (Exception e) {

		}
	}

	public Boolean AddAttachementToSalesLead_LocalFile(String pathOfFile) {

		try {
			this.getSalesLeadTI().addAttachement_LocalFile(pathOfFile);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Contact creation failed: " + e.getLocalizedMessage());
		}

		return true;
	}

	public Boolean AddAttachementToSalesLead_WebLink(Map<String, String> data) {

		try {
			this.getSalesLeadTI().addAttachement_Weblink(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Contact creation failed: " + e.getLocalizedMessage());
		}

		return true;
	}

	public Boolean AddAttachementToSalesLead_FromLibrary(String data) {

		try {
			this.getSalesLeadTI().addAttachement_FromLibrary(data);
			Thread.sleep(3000);
		}

		catch (Exception e)

		{
			Assert.fail("Contact creation failed: " + e.getLocalizedMessage());
		}

		return true;
	}

}
