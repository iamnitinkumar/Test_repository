package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceRunner;

public class AppointmentQC extends BaseQC {
	
	public static final String SUBJECT_ELEMENT_ID                    = "inputfieldGm6cjKHsBKE4ByHjdlAPm0_";
	public static final String ACCOUNT_VALUE_HELP_ELEMENT_ID         = "objectvalueselectoryDPoGUdplKAXHDhhJR_hcm_"; //ButtonValueHelp
	public static final String PRIMARY_CONTACT_VALUE_HELP_ELEMENT_ID = "objectvalueselectorq6E01rOSS4Aef5tLj0POzW_";
	public static final String OWNER_VALUE_HELP_ELEMENT_ID           = "objectvalueselectorbZyzqVuKUKs_fET1bQhGG0_";
	public static final String TERRITORY_VALUE_HELP_ELEMENT_ID       = "objectvalueselectorDmBpgujSGKwAzF_sFgE_Z0W_";
	
	//QC dialogs like appointment have a list at the bottom which cause duplicate entries --> need own constant
	protected final static String HITLIST_ITEM_PARTIAL_ID ="statictext";  //listdefintionui not working for appointments
	
	/*
	 * Date/Time need to use dummy IDs since the prefix is the same for both
	 */
	public static final String FROM_DATE_ELEMENT_ID                  = "inputfieldQD0ovca3_sKEshopmcS_4om_CALENDAR-input";
	public static final String FROM_TIME_ELEMENT_ID                  = "inputfieldQD0ovca3_sKEshopmcS_4om_TIMELIST-input";
	public static final String TO_DATE_ELEMENT_ID                    = "inputfieldhkPlTZtPNKgx8Q3KbCdFN0_CALENDAR-input";
	public static final String TO_TIME_ELEMENT_ID                    = "inputfieldhkPlTZtPNKgx8Q3KbCdFN0_TIMELIST-input";
	
	protected static final String FROM_DATE_TIME_ELEMENT_ID          = "inputfieldQD0ovca3_sKEshopmcS_4om_";                 //85
	protected static final String TO_DATE_TIME_ELEMENT_ID            = "inputfieldhkPlTZtPNKgx8Q3KbCdFN0_";               
	
	protected static final String TIME_ELEMENT_ID_POSTFIX            = "TIMELIST-input";   //- need dummy IDs to diff the two fields
	protected static final String DATE_ELEMENT_ID_POSTFIX            = "CALENDAR-input";
	
	public static final String CATEGORY_ELEMENT_ID                   = "dropdownlistboxw7BhEl4ZgKUgsP7MZ2SMdG_";
	public static final String PRIORITY_ELEMENT_ID                   = "dropdownlistbox0iqtJGdqt4gHnamez2LdGW_";  //dropdownlistbox0iqtJGdqt4gHnamez2LdGW_236-input
	
	public static final String ADD_ATTENDEE_ELEMENT_ID               = "buttonp80i_adj5aUU3IsUyKgtkG_";
	public static final String ATTENDEE_NAME_VALUE_HELP_ELEMENT_ID	 = "objectvalueselector5Gw1fUXrfaIKNsw8fkU790_";
	public static final String LOCATION	 =  "inputfieldlDJ2MxWzRKQ9U530db5BK0_";
	
	public static final String NOTES_CLASS = "sapUiTf sapUiTfBack sapUiTfBrd sapUiTfStd sapUiTxtA saplsui-nomargin";
	public static final String NOTES = "__area";
	
	public static final String ACCOUNT_VALUE_HELP_ELEMENT_NAME         = "Account";
	public static final String PRIMARY_CONTACT_VALUE_HELP_ELEMENT_NAME = "Primary Contact";
	public static final String OWNER_VALUE_HELP_ELEMENT_NAME           = "Owner";
	public static final String TERRITORY_VALUE_HELP_ELEMENT_NAME       = "Territory";
	public static final String FROM_DATE_ELEMENT_NAME                  = "Start Date";
	public static final String FROM_TIME_ELEMENT_NAME                  = "Start Time";
	public static final String TO_DATE_ELEMENT_NAME                    = "End Date";
	public static final String TO_TIME_ELEMENT_NAME                    = "End Time";
	public static final String CATEGORY_ELEMENT_NAME                   = "Category";
	public static final String PRIORITY_ELEMENT_NAME                   = "Priority";
	public static final String NOTES_ELEMENT_NAME                      = "Notes";
	
	public static final String ADD_ATTENDEE_ELEMENT_NAME               = "Add";
	
	protected String saveAndCompletePartialId =  "childnavigationitemjGxAnq44GKIgttnjOvI9um_";
	private String saveAndCompleteMeasurement  = "Save_and_Complete_";
	
	public AppointmentQC(WebDriver webDriver)
	{
		super(webDriver);
		
		this.qcName = "Appointment";
		this.saveMenuPartialId    = "buttongYITm_sARk4ATxSPuScdU_sW_";
		this.saveAndNewPartialId  = "childnavigationitem5bi_saAb6RaQ1BwEVRsmA0G_";
		this.saveAndOpenPartialId = "childnavigationitemaO1PXhYVMqsmLKmSN3vwiW_";
		this.savePartialId        = "childnavigationitemO_WCDXKvM4ciFIktVy0_sNm_";
		
			
		//   save and complete
		
	}
	public AppointmentQC(WebDriver webDriver, String testCaseName)
	{
		super(webDriver);
		
		this.qcName = "Appointment";
		this.saveMenuPartialId    = "buttongYITm_sARk4ATxSPuScdU_sW_";
		this.saveAndNewPartialId  = "childnavigationitem5bi_saAb6RaQ1BwEVRsmA0G_";
		this.saveAndOpenPartialId = "childnavigationitemaO1PXhYVMqsmLKmSN3vwiW_";
		this.savePartialId        = "childnavigationitemO_WCDXKvM4ciFIktVy0_sNm_";
		
		this.testName = testCaseName;
		
		//   save and complete
		
	}
	
	protected void create(Map<String, String> data) throws Exception{
		String value;
		WebElement elem;
		Thread.sleep(3000);
		System.out.println("In Create");
		for (String key : data.keySet())
		{
			
			value = data.get(key);
			switch(key)
			{
				case AppointmentQC.SUBJECT_ELEMENT_ID:
						System.out.println("In SUBJECT_ELEMENT_ID");		
					if ((elem = this.getElementIfExisting(By2.partialId(AppointmentQC.SUBJECT_ELEMENT_ID), 60)) != null)
					{
						elem.clear();
						elem.sendKeys(value);
						System.out.println("out SUBJECT_ELEMENT_ID");
						Thread.sleep(3000);
					}
			
					break;
					
				case AppointmentQC.ACCOUNT_VALUE_HELP_ELEMENT_ID:
				case AppointmentQC.ACCOUNT_VALUE_HELP_ELEMENT_NAME:
					System.out.println("in ACCOUNT_VALUE_HELP_ELEMENT_ID");
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.PRIMARY_CONTACT_VALUE_HELP_ELEMENT_ID, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(AppointmentQC.ACCOUNT_VALUE_HELP_ELEMENT_ID, value, "Account", AppointmentQC.HITLIST_ITEM_PARTIAL_ID);
						System.out.println("out ACCOUNT_VALUE_HELP_ELEMENT_ID");
						Thread.sleep(5000);
					}				
					break;					
					
			case AppointmentQC.PRIMARY_CONTACT_VALUE_HELP_ELEMENT_ID:
				case AppointmentQC.PRIMARY_CONTACT_VALUE_HELP_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.PRIMARY_CONTACT_VALUE_HELP_ELEMENT_ID, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(AppointmentQC.PRIMARY_CONTACT_VALUE_HELP_ELEMENT_ID, value, "PrimaryContact", AppointmentQC.HITLIST_ITEM_PARTIAL_ID);
					}				
					break;					

				case AppointmentQC.OWNER_VALUE_HELP_ELEMENT_ID:
				case AppointmentQC.OWNER_VALUE_HELP_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.OWNER_VALUE_HELP_ELEMENT_ID, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(AppointmentQC.OWNER_VALUE_HELP_ELEMENT_ID, value, "Owner", AppointmentQC.HITLIST_ITEM_PARTIAL_ID);
					}				
					break;					

				case AppointmentQC.TERRITORY_VALUE_HELP_ELEMENT_ID:
				case AppointmentQC.TERRITORY_VALUE_HELP_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.TERRITORY_VALUE_HELP_ELEMENT_ID, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(AppointmentQC.TERRITORY_VALUE_HELP_ELEMENT_ID, value, "Territory", AppointmentQC.HITLIST_ITEM_PARTIAL_ID);
					}				
					break;					

				case AppointmentQC.FROM_DATE_ELEMENT_NAME:
				case AppointmentQC.FROM_DATE_ELEMENT_ID:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.FROM_DATE_TIME_ELEMENT_ID, AppointmentQC.DATE_ELEMENT_ID_POSTFIX), 60))!= null)
					{
						elem.clear();
						elem.sendKeys(value);
					}				
					break;					

				case AppointmentQC.FROM_TIME_ELEMENT_NAME:
				case AppointmentQC.FROM_TIME_ELEMENT_ID:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.FROM_DATE_TIME_ELEMENT_ID, AppointmentQC.TIME_ELEMENT_ID_POSTFIX), 60))!= null)
					{
						elem.sendKeys(value);
					}				
					break;						
					
				case AppointmentQC.TO_DATE_ELEMENT_NAME:
				case AppointmentQC.TO_DATE_ELEMENT_ID:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.TO_DATE_TIME_ELEMENT_ID, AppointmentQC.DATE_ELEMENT_ID_POSTFIX), 60))!= null)
					{
						elem.clear();
						elem.sendKeys(value);
					}				
					break;						
				
					
				case AppointmentQC.TO_TIME_ELEMENT_NAME:
				case AppointmentQC.TO_TIME_ELEMENT_ID:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.TO_DATE_TIME_ELEMENT_ID, AppointmentQC.TIME_ELEMENT_ID_POSTFIX), 60))!= null)
					{
						elem.sendKeys(value);
					}				
					break;							
					
				case AppointmentQC.CATEGORY_ELEMENT_ID:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.CATEGORY_ELEMENT_ID, "-inpu"), 60))!= null)
					{
						this.fillDropDown(elem, value);
					}
					break;					
					
				case AppointmentQC.CATEGORY_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.label(AppointmentQC.CATEGORY_ELEMENT_NAME),60))!= null)
					{
						this.fillDropDown(elem, value);
					}
					break;		
					
				case AppointmentQC.PRIORITY_ELEMENT_ID:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.PRIORITY_ELEMENT_ID, "-inpu"), 60))!= null)
					{
						//this.fillDropDown(elem, value);//IE
						//Appium changes for Dropdown
						this.fillDropDownMobile(By2.startsWithAndPartialId(AppointmentQC.PRIORITY_ELEMENT_ID, "-inpu"), value);
						System.out.println("Out PRIORITY_ELEMENT_ID");
					}
					break;					
					
				case AppointmentQC.PRIORITY_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.label(AppointmentQC.PRIORITY_ELEMENT_NAME), 60))!= null)
					{
						this.fillDropDown(elem, value);
					}
					break;
				
				case AppointmentQC.NOTES:
					
					if ((elem = this.getElementIfExisting2(By2.partialId(AppointmentQC.NOTES), 60))!= null) //By2.buttonByClassAndPartialId(NOTES_CLASS, NOTES)
					{
						elem.clear();
						elem.sendKeys(value);
					}				
					break;
					
				default:
					//Fill the remaining simple fields

					if ((elem = this.getElementIfExisting(By2.partialId(key), 60))!= null)
					{
						elem.clear();
						elem.sendKeys(value);
					}
					else
					{
						if ((elem = this.getElementIfExisting(By2.label(key), 60))!= null)
						{
							elem.clear();
							elem.sendKeys(value); 
						}
					}
			
			}
			
		}
		
		//Add attendees in the quick create.
		if ((elem = this.getElementIfExisting(By2.partialId(AppointmentQC.ADD_ATTENDEE_ELEMENT_ID), 60))!= null)
		{
			elem.click();
			if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(AppointmentQC.TERRITORY_VALUE_HELP_ELEMENT_ID, "ButtonValueHelp"), 60))!= null)
			{
				this.valueHelpDialog(AppointmentQC.ATTENDEE_NAME_VALUE_HELP_ELEMENT_ID, "","Attendee", AppointmentQC.HITLIST_ITEM_PARTIAL_ID);
			}					
			
		}				
		
		
	}

	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void createAndComplete(Map<String, String> data) throws Exception
	{
        this.create(data);
        this.selectSaveAction(this.saveAndCompletePartialId, this.saveAndCompleteMeasurement);
	}
	
	
}

