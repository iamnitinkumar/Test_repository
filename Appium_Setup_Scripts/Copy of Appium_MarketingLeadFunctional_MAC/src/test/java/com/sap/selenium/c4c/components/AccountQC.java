package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceRunner;
import com.sap.selenium.c4c.components.ShellToolPaletteArea;

public class AccountQC extends BaseQC {
	
	
	public static final String NAME           			 = "inputfieldRbF2e_sPm6aQi3LUCEQiVrG";
	public static final String PROSPECT				     = "checkboxrENXE2p7Hqcum_rGOsSK9G_";
	public static final String PARENT					 = "objectvalueselectorrMlXQ1DWv4wPIhuAt7Px10_";
	public static final String WEBSITE         			  = "inputfieldlviwnGL8jqcTAaGPxd2xJ0_";
	public static final String CLASSIFICATION		     = "dropdownlistboxO3sbj03_shKIT93piWBgok0";
	public static final String COUNTRY		 	         = "dropdownlistboxPP_sHWfbNyq6vDxnrzCXh3G_";
	public static final String CITY            			  = "inputfield07eJDpEoIqMmFr1qUC_DLm_";
	public static final String STATE			         = "dropdownlistboxLMMP46VpqKEz_scknAvPtuW_";
	public static final String OWNER			         = "objectvalueselectorENn6YkrYgKQ1PX8j_sa4MQG_";

	
	
	//QC dialogs like appointment have a list at the bottom which cause duplicate entries --> need own constant
	protected final static String HITLIST_ITEM_PARTIAL_ID = "listdefintion";
	
	
	public static final String NAME_LABEL_ID               = "labelfslAh0Z82aoPaoyszKJwnm_";
	public static final String PROSPECT_LABEL_ID           = "labelkIE81WkjB4UYBVZwKlDnW0_";
	public static final String PARENT_ACCOUNT_LABEL_ID     = "labelihKmVPvRq4oQqSa_s7WjtFG_";
	public static final String WEBSITE_LABEL_ID            = "labelOmu4oB7pAK6b32HmkUbJoW_2";
	public static final String CLASSIFICATION_LABEL_ID     = "labelhJNWpfJvYq_VYtFfXf7IO0_";
	public static final String COUNTRY_LABEL_ID            = "label6I2qyU2Qja_aYcbRPr4Do0_";
	public static final String CITY_LABEL_ID               = "labelkBr0UBXTzaQAstDhsBn6Q0_";
	public static final String STATE_LABEL_ID              = "labelTnQ7h3XC7qw1bUZOV1kil0_";
	public static final String TERRITORY_LABEL_ID          = "labelXPegqvY0sqoYojNdJHTbAG_";
	public static final String OWNER_LABEL_ID              = "labelUg3uSBZDcagenneL_sKrNim_";
	
	
	static final String CHECK_DUPLICATES_BUTTON_ID = "button_qtcvLSit4wMEviQz60PgG_";
	static final String NEW_BUTTON_ID = "button_qtcvLSit4wMEviQz60PgG_";
	

	public AccountQC(WebDriver webDriver)
	{
		super(webDriver);
		
		this.qcName = "Account";
		this.saveMenuPartialId    = "buttonKf8stUeG34wu3jw3Um6c7G_";
		this.saveAndNewPartialId  = "childnavigationitemR9QhSMT1YKkIah0pcdGE6m_";
		this.saveAndOpenPartialId = "childnavigationitemrSHRNsrnQ4Q4BNXz_opJUm_";
		this.savePartialId        = "childnavigationitemQyjQlHkjnqQ9Qi7KxzK7OG_";
		
	}

	
	protected Map<String, String> getTexts()
	{
		WebElement elem;
		Map<String, String>texts = new LinkedHashMap<String, String>();
		
		texts.put(AccountQC.NAME_LABEL_ID, this.stripOfColon(this.elementToFindExplicit(By2.partialId(AccountQC.NAME_LABEL_ID), 1).getText()));
		
		if ((elem = this.getElementIfExisting(By2.partialId(AccountQC.CLASSIFICATION_LABEL_ID), 1))!= null)
		{
			texts.put(AccountQC.CLASSIFICATION_LABEL_ID, this.stripOfColon(elem.getText()));
		}
		
		if ((elem = this.getElementIfExisting(By2.partialId(AccountQC.COUNTRY_LABEL_ID), 1))!= null)
		{
			texts.put(AccountQC.COUNTRY_LABEL_ID, this.stripOfColon(elem.getText()));
		}
		
		if ((elem = this.getElementIfExisting(By2.partialId(AccountQC.CITY_LABEL_ID), 1))!= null)
		{
			texts.put(AccountQC.CITY_LABEL_ID, this.stripOfColon(elem.getText()));
		}

		if ((elem = this.getElementIfExisting(By2.partialId(AccountQC.PROSPECT_LABEL_ID), 1))!= null)
		{
			texts.put(AccountQC.PROSPECT_LABEL_ID, this.stripOfColon(elem.getText()));
		}

		if ((elem = this.getElementIfExisting(By2.partialId(AccountQC.WEBSITE_LABEL_ID), 1))!= null)
		{
			texts.put(AccountQC.WEBSITE_LABEL_ID, this.stripOfColon(elem.getText()));
		}
		
		return texts;
	}
	
	
	public void qcFromToolBar() throws Exception{

		ShellToolPaletteArea AccQC = new ShellToolPaletteArea(driver);
		AccQC.openAccountQC();
	}
	
	public void createFromNew(String objectName) throws Exception{
		PerformanceRunner.startMeasurement("Open_QC_"+objectName);
		this.elementToClick(By2.text("New"), 60);
		PerformanceRunner.stopMeasurement();
	}
	
	protected void create(Map<String, String> data) throws Exception{
		String value;		
		
		for (String key : data.keySet())
		{
			value = data.get(key);
			switch(key)
			{

			case AccountQC.NAME:
			
				this.elementToSendKey(By2.partialId(AccountQC.NAME), 1, value);
				break;
			
			case AccountQC.WEBSITE:
			
				
				this.elementToSendKey(By2.partialId(AccountQC.WEBSITE), 1, value);
				break;	

			case AccountQC.CITY:
							
				this.elementToSendKey(By2.partialId(AccountQC.CITY), 1, value);
				break;	
				
			
				
			case AccountQC.CLASSIFICATION:
				
				if ((this.getElementIfExisting(By2.label(AccountQC.CLASSIFICATION), 1))!= null)
				{
					this.fillDropDown2(By2.label(AccountQC.CLASSIFICATION), value);
				}
				break;
			
			
			case AccountQC.COUNTRY:
				
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(AccountQC.COUNTRY, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(AccountQC.COUNTRY, "-inpu"), value);
				}				
				break;
				
				
			case AccountQC.STATE:
				
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(AccountQC.STATE, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(AccountQC.STATE, "-inpu"), value);
				}				
				break;

			case AccountQC.PARENT:
			
				
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(AccountQC.PARENT, "ButtonValueHelp"), 60))!= null)
				{
					this.valueHelpDialog(AccountQC.PARENT, value, "ParentAccount", AccountQC.HITLIST_ITEM_PARTIAL_ID);
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
		
		this.checkDuplicates();
		Thread.sleep(5000);
		
	}
	
	public void checkDuplicates() throws Exception
	{
		PerformanceRunner.startMeasurement("Check_Duplicate_Account");
		this.elementToClick(By2.partialId(AccountQC.CHECK_DUPLICATES_BUTTON_ID), 60);
		PerformanceRunner.stopMeasurement();
		
	}
	
	
	
	
	
	
}

