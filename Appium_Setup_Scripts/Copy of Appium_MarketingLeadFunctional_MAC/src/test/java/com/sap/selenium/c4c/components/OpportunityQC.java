
package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceRunner;

public class OpportunityQC extends BaseQC {

	public static final String NAME_ELEMENT_ID = "inputfieldAY4LWcdT54cmwn_s9eBwRD0_";

	
	// partial id's for Oppurtunity quick create fields
	
	public static final String NAME         					= "inputfieldAY4LWcdT54cmwn_s9eBwRD0";
	public static final String ACCOUNT 							= "objectvalueselectorHppqevK8aaYFSgcH3xeA1G";
	public static final String PRIMARY_CONTACT         			= "objectvalueselectorDJFL3kMLhK_OJoDgE62YbW";
	public static final String SOURCE       					= "dropdownlistboxmyokgu9MOqQ2YL10sdWYN0";	
	public static final String EXPECTED_VALUE          			= "inputfieldkoPIB8RYbqMlB6h_sZRHJF0";
	public static final String CURRENCY_CODE         			= "dropdownlistboxTCHEKCKg1Ko2oU_s4QbOBmW";
	public static final String START_DATE                 		= "inputfieldGMLflBtaJKUOhaPXiJdxTG";
	public static final String CLOSE_DATE                   	= "inputfielddChc_il3R4UdyB7xxmOs90";
	public static final String SALES_CYCLE                   	= "dropdownlistboxiN_ZP4lbUqw2j_sFrsupjoG";
	public static final String SALES_PHASE                  	= "dropdownlistboxwCsUCIwXEacgaIz93_W2_s0";
	public static final String PROBABILITY              	    = "inputfieldlLqbu10q8awgI8pOMKWOwW";
	public static final String PUBLISH_TO_FORECAST      	    = "checkboxfCnTkcWzJaYTKoZdWmpwEm";
	public static final String FORECAST_CATEGORY            	= "dropdownlistboxOmFj0Y68H4gVRVSmZqGQD0";
	public static final String CATEGORY                 		= "dropdownlistboxO8ktYb_4b4wnnqvrxH6Fo0";
	public static final String CAMPAIGN        	       	        = "objectvalueselectorbGnEQYb1oq6Nmyv1oucfz0";
	public static final String OWNER            	            = "objectvalueselector6_snmI0JWagDHwH831hlM0";
	public static final String NOTE          		            = "__area";
	public static final String INSTANCE_TYPE         	        = "dropdownlistbox726825dc56d1f5bdeab584a2e7d91feb";

	protected final static String HITLIST_ITEM_PARTIAL_ID = "statictext";

	public OpportunityQC(WebDriver webDriver, String testCaseName)
	{
		super(webDriver);

		this.qcName = "Opportunity";
		this.saveMenuPartialId    = "buttonlC1_3DMGaacBVkV16ZJc9W_";
		this.saveAndNewPartialId  = "childnavigationitemDnUUtl7eO4YK8Nvsvo3gUG_";
		this.saveAndOpenPartialId = "childnavigationitempP3ng4oFTqwRwiI6i6Tpa0_";
		this.savePartialId        = "childnavigationitemJuoBuibnS4ETualQPbRJkG_";
		this.testName = testCaseName;

	}


	protected void create(Map<String, String> data) throws Exception{
		String value;
		WebElement elem;
				

		for (String key : data.keySet())
		{

			value = data.get(key);
			
			// wait for 2sec after each data entry
			Thread.sleep(3000);
			
			switch(key)
			{
			case OpportunityQC.NAME:   				//Mandatory field
				
//				elem = this.elementToFindExplicit(By2.partialId(OpportunityQC.NAME), 5);
//				elem.clear();
//				elem.sendKeys(value);
				this.elementToClear(By2.partialId(OpportunityQC.NAME),2);
				this.elementToSendKey(By2.partialId(OpportunityQC.NAME), 1, value);
				break;

										
			case OpportunityQC.ACCOUNT:
				// enter the account name without value help 
				//this.elementToFindExplicit(By2.label(OpportunityQC.ACCOUNT_ELEMENT_NAME), 1).sendKeys(value);
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(OpportunityQC.ACCOUNT,"ButtonValueHelp"), 1))!= null)
				{
				this.valueHelpDialog(OpportunityQC.ACCOUNT, value, "Account", OpportunityQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

							
			case OpportunityQC.PRIMARY_CONTACT:

				//this.elementToFindExplicit(By2.label(OpportunityQC.PRIMARY_CONTACT_ELEMENT_NAME), 1).sendKeys(value);
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(OpportunityQC.PRIMARY_CONTACT, "ButtonValueHelp"), 1))!= null)
				{
				this.valueHelpDialog(OpportunityQC.PRIMARY_CONTACT, value, "Contact", OpportunityQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

							
			case OpportunityQC.SOURCE:

				//					this.elementToFindExplicit(By2.label(OpportunityQC.SOURCE_ELEMENT_NAME), 1).sendKeys(value);
				//					break;

				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.SOURCE), 1))!= null)
				{
					this.fillDropDown(elem, value);
				}
				break;

							
			case OpportunityQC.EXPECTED_VALUE:

				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.EXPECTED_VALUE), 1))!= null)
				{
					this.fill_CompundField(OpportunityQC.EXPECTED_VALUE, OpportunityQC.CURRENCY_CODE, value);
				}
				break;
				
			
				
			case OpportunityQC.START_DATE:
				
				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.START_DATE), 1))!= null)
				{
//					this.fill_datetimebyID(OpportunityQC.START_DATE, value);
					
					this.DatePickerbyID(OpportunityQC.START_DATE, value);
					
				}
				break;
				
			
				
			case OpportunityQC.CLOSE_DATE:
				
				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.CLOSE_DATE), 1))!= null)
				{
//					this.fill_datetimebyID(OpportunityQC.CLOSE_DATE, value);
					
					this.DatePickerbyID(OpportunityQC.CLOSE_DATE, value);
					
				}
				break;

			
				
			case OpportunityQC.SALES_CYCLE:

				//					this.elementToFindExplicit(By2.label(OpportunityQC.SOURCE_ELEMENT_NAME), 1).sendKeys(value);
				//					break;

				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.SALES_CYCLE), 1))!= null)
				{
					this.fillDropDown(elem, value);
				}
				break;
				
			
				
			case OpportunityQC.SALES_PHASE:

				//					this.elementToFindExplicit(By2.label(OpportunityQC.SOURCE_ELEMENT_NAME), 1).sendKeys(value);
				//					break;

				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.SALES_PHASE), 1))!= null)
				{
					this.fillDropDown(elem, value);
				}
				break;
				
							
				
			case OpportunityQC.PROBABILITY:
				
				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.PROBABILITY), 1))!= null)
				{
//					elem.clear();
//					elem.sendKeys(value);
					
					this.elementToClear(By2.partialId(OpportunityQC.PROBABILITY),2);
					this.elementToSendKey(By2.partialId(OpportunityQC.PROBABILITY), 1, value);
				}
//				this.elementToFindExplicit(By2.label(OpportunityQC.PROBABILITY_ELEMENT_NAME), 1).sendKeys(value);
				break;
							
				
			case OpportunityQC.FORECAST_CATEGORY:

				//					this.elementToFindExplicit(By2.label(OpportunityQC.SOURCE_ELEMENT_NAME), 1).sendKeys(value);
				//					break;

				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.FORECAST_CATEGORY), 1))!= null)
				{
					this.fillDropDown(elem, value);
				}
				break;
				
			
				
			case OpportunityQC.CATEGORY:

				//					this.elementToFindExplicit(By2.label(OpportunityQC.SOURCE_ELEMENT_NAME), 1).sendKeys(value);
				//					break;

				if ((elem = this.getElementIfExisting(By2.partialId(OpportunityQC.CATEGORY), 1))!= null)
				{
					this.fillDropDown(elem, value);
				}
				break;
				
			
				
			case OpportunityQC.CAMPAIGN:
				// enter the account name without value help 
				//this.elementToFindExplicit(By2.label(OpportunityQC.CAMPAIGN_ELEMENT_NAME), 1).sendKeys(value);
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(OpportunityQC.CAMPAIGN, "ButtonValueHelp"), 1))!= null)
				{
				this.valueHelpDialog(OpportunityQC.CAMPAIGN, value, "Campaign", OpportunityQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;
				
			
				
			case OpportunityQC.OWNER:

//				this.elementToFindExplicit(By2.label(OpportunityQC.OWNER_ELEMENT_NAME), 1).sendKeys(value);
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(OpportunityQC.OWNER, "ButtonValueHelp"), 1))!= null)
				{
				this.valueHelpDialog(OpportunityQC.OWNER, value, "Owner", OpportunityQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;
				
			

			default:
				//Fill the remaining simple fields
				try
				{
					this.elementToSendKey(By2.partialId(key), 60, value);
				}
				catch(Exception nopartialID)
				{
					try
					{
						this.elementToSendKey(By2.label(key), 60, value);					
					}
					catch(Exception nolabel)
					{
						
						Assert.fail("Field with name " + value + " was not found in web page");
						
						
					}
				}

			}

		}
	}


	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}

}


