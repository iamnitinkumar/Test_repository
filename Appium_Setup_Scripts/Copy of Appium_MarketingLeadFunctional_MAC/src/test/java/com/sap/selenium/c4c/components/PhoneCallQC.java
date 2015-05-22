package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhoneCallQC extends BaseQC {
	
	public static final String SUBJECT                  = "inputfieldQXVuh0plCqwfYBYrBzvmnG_";
	public static final String PRIMARY_CONTACT         = "objectvalueselectorCqzWzIl67q6zJgJoFvfPk0_"; //ButtonValueHelp
	public static final String ACCOUNT 					="objectvalueselectoreP0nftbl_s4ccsXg54IBXEW_";
	public static final String OWNER          = "objectvalueselectorGSVIGmDBfqoiTIYW4z1K6W_";
	public static final String TERRITORY       = "objectvalueselectoryQnZjw1S6aMA1as26CuW7m_";
	
	//QC dialogs like appointment have a list at the bottom which cause duplicate entries --> need own constant
	protected final static String HITLIST_ITEM_PARTIAL_ID = "statictext";
	
	
	/*
	 * Date/Time need to use dummy IDs since the prefix is the same for both
	 */
	public static final String DATE                  = "inputfieldIsipRNPXZKYKWIrkndo_jW_"; //inputfieldIsipRNPXZKYKWIrkndo_jW_1937CALENDAR-input
	public static final String TIME                  = "inputfieldIsipRNPXZKYKWIrkndo_jW_";
      
	
	protected static final String TIME_ELEMENT_ID_POSTFIX            = "TIMELIST-input";   //- need dummy IDs to diff the two fields
	protected static final String DATE_ELEMENT_ID_POSTFIX            = "CALENDAR-input";
	
	public static final String DIRECTION               = "inputfieldD7hfom42Z4odVXwZhtkr9m_";
	public static final String CATEGORY                   = "dropdownlistboxsWdG0dsCcKYA0IG7hw1Npm_";
	public static final String PRIORITY                   = "dropdownlistboxMYB4NDidOK6A9cHx9kyCYW";
	public static final String CAMPAIGN                   = "objectvalueselectorZva3LpwVPqIZ7iY_A9GsMm_";
	public static final String NOTES                   = "__area";
	
	//change ids
	protected String saveAndCompletePartialId =  "childnavigationitemjGxAnq44GKIgttnjOvI9um_";
	private String saveAndCompleteMeasurement  = "Save_and_Complete_";
	
	public PhoneCallQC(WebDriver webDriver, String testCaseName)
	{
		super(webDriver);
		
		this.qcName = "PhoneCall";
		this.saveMenuPartialId    = "buttonn6U6Uxk_sIKczsiHoiQHKvm_";
		this.saveAndNewPartialId  = "childnavigationitemQPQFjCnoc4gszUdfftrQrG_";
		this.saveAndOpenPartialId = "childnavigationitemF5k8ybbf94w_EX5dqgDCPm_";
		this.savePartialId        = "childnavigationitem3wDIVnnarqoLqQ5_jKLnkW_";
		
		//   save and complete
		this.testName = testCaseName;
		
	}
	
	protected void create(Map<String, String> data) throws InterruptedException{
		String value;
		WebElement elem;
		Thread.sleep(3000);
		for (String key : data.keySet())
		{
			
			value = data.get(key);
			switch(key)
			{
				case PhoneCallQC.SUBJECT:
					//Mandatory field
					
					if ((elem = this.getElementIfExisting(By2.partialId(PhoneCallQC.SUBJECT), 60)) != null)
					{
						elem.sendKeys(value);
					}
					Thread.sleep(1000);
					break; 
					
				case PhoneCallQC.ACCOUNT:
					
					if ((this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.ACCOUNT, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(PhoneCallQC.ACCOUNT, value, "Account", PhoneCallQC.HITLIST_ITEM_PARTIAL_ID);
					}
					Thread.sleep(1000);
					break;					
					
				case PhoneCallQC.PRIMARY_CONTACT:
					if ((this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.PRIMARY_CONTACT, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(PhoneCallQC.PRIMARY_CONTACT, value, "PrimaryContact", PhoneCallQC.HITLIST_ITEM_PARTIAL_ID);
					}
					Thread.sleep(1000);
					break;					

				case PhoneCallQC.OWNER:
					if ((this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.OWNER, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(PhoneCallQC.OWNER, value, "Owner", PhoneCallQC.HITLIST_ITEM_PARTIAL_ID);
					}
					Thread.sleep(1000);
					break;					

				case PhoneCallQC.TERRITORY:
					if ((this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.TERRITORY, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(PhoneCallQC.TERRITORY, value, "Territory", PhoneCallQC.HITLIST_ITEM_PARTIAL_ID);
					}
					Thread.sleep(1000);
					break;					

				case PhoneCallQC.DATE:
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.DATE, PhoneCallQC.DATE_ELEMENT_ID_POSTFIX), 60))!= null)
					{
						elem.sendKeys(value);
					}
					Thread.sleep(1000);
					break;					

				case PhoneCallQC.DIRECTION:
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.DIRECTION, "-inpu"), 60))!= null)
					{
						this.fillDropDown(elem, value);
					}
					Thread.sleep(1000);
					break;						
					
				case PhoneCallQC.CATEGORY:
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.CATEGORY, "-inpu"), 60))!= null)
					{
						this.fillDropDown(elem, value);
					}
					Thread.sleep(1000);
					break;					
				
					
				case PhoneCallQC.PRIORITY:
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.PRIORITY, "-inpu"), 60))!= null)
					{
						this.fillDropDown(elem, value);
					}
					Thread.sleep(1000);
					break;
					
				case PhoneCallQC.CAMPAIGN:
					if ((this.getElementIfExisting(By2.startsWithAndPartialId(PhoneCallQC.CAMPAIGN, "ButtonValueHelp"), 60))!= null)
					{
						this.valueHelpDialog(PhoneCallQC.CAMPAIGN, value, "Campaign", PhoneCallQC.HITLIST_ITEM_PARTIAL_ID);
					}
					Thread.sleep(1000);
					break;						
				
				case PhoneCallQC.NOTES:
					if ((elem = this.getElementIfExisting(By2.partialId(PhoneCallQC.NOTES), 60))!= null)
					{
						elem.sendKeys(value);
					}
					Thread.sleep(1000);
					break;
					
				default:
					//Fill the remaining simple fields
					if ((elem = this.getElementIfExisting(By2.partialId(key), 60))!= null)
					{
						elem.sendKeys(value);
						Thread.sleep(1000);
					}
					else
					{
						if ((elem = this.getElementIfExisting(By2.label(key), 60))!= null)
						{
							elem.sendKeys(value); 
							Thread.sleep(1000);
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
	
	public void createAndComplete(Map<String, String> data) throws Exception
	{
        this.create(data);
        this.selectSaveAction(this.saveAndCompletePartialId, this.saveAndCompleteMeasurement);
	}
	
	
}

