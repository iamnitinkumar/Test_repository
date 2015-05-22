package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskQC extends BaseQC {
	
	public static final String SUBJECT                    = "inputfieldUlenqiJg5q_Xq71MKJNFfm_";
	public static final String ACCOUNT         = "objectvalueselectoron3tkT7JzKkHBjRbJtzvd0_"; //ButtonValueHelp
	public static final String PRIMARY_CONTACT = "objectvalueselectorlBd4KrY_s646BJL63YMSv4W_";
	public static final String PROCESSOR       = "objectvalueselectorg8a99MAeh4ghBGAsxg9EyW_";
	public static final String OWNER           = "objectvalueselectorIfWOXhB_SKgae48a6ovBYW_";
	public static final String SALES_TERRITORY = "objectvalueselectorCRHdjckJiKAN_73FH716XW_";
	
	public static final String COMPLETION                = "inputfielddnjJDEGGEaIB0f7U4aiGdW_";
	
	public static final String NOTES                      = "__area";
	
	//QC dialogs like appointment have a list at the bottom which cause duplicate entries --> need own constant
	protected final static String HITLIST_ITEM_PARTIAL_ID = "statictext"; //"listdefintionui";
	
	
	/*
	 * Date/Time need to use dummy IDs since the prefix is the same for both
	 */
	public static final String FROM_DATE                  = "inputfield01xMayNZDqgQu8yNu0VHN0_CALENDAR-input";
	public static final String FROM_TIME_ELEMENT_ID                  = "inputfield01xMayNZDqgQu8yNu0VHN0_TIMELIST-input";
	public static final String TO_DATE                    = "inputfieldv85Ncci50akkkyzpP6MzxG_CALENDAR-input";
	public static final String TO_TIME_ELEMENT_ID                    = "inputfieldv85Ncci50akkkyzpP6MzxG_TIMELIST-input";
	
	protected static final String FROM_DATE_TIME_ELEMENT_ID          = "inputfield01xMayNZDqgQu8yNu0VHN0_";                 //85
	protected static final String TO_DATE_TIME_ELEMENT_ID            = "inputfieldv85Ncci50akkkyzpP6MzxG_";               
	
	protected static final String TIME_ELEMENT_ID_POSTFIX            = "TIMELIST-input";   //- need dummy IDs to diff the two fields
	protected static final String DATE_ELEMENT_ID_POSTFIX            = "CALENDAR-input";
	
	public static final String CATEGORY                   = "dropdownlistboxz24LfCVmkaEetzkcEhPZGm_";
	public static final String PRIORITY                   = "dropdownlistboxbuumPHWjiaAv9CbYC0A250_";
	
	
	public static final String SUBJECT_ELEMENT_NAME                    = "Subject";
	public static final String ACCOUNT_VALUE_HELP_ELEMENT_NAME         = "Account";
	public static final String PRIMARY_CONTACT_VALUE_HELP_ELEMENT_NAME = "Primary Contact";
	public static final String OWNER_VALUE_HELP_ELEMENT_NAME           = "Owner";
	public static final String SALES_TERRITORY_VALUE_HELP_ELEMENT_NAME = "Sales Territory";
	public static final String FROM_DATE_ELEMENT_NAME                  = "Start Date";
	public static final String FROM_TIME_ELEMENT_NAME                  = "Start Time";
	public static final String TO_DATE_ELEMENT_NAME                    = "End Date";
	public static final String TO_TIME_ELEMENT_NAME                    = "End Time";
	public static final String COMPLETION_ELEMENT_NAME                 = "Completion";
	public static final String NOTES_ELEMENT_NAME                      = "Notes";
	public static final String CATEGORY_ELEMENT_NAME                   = "Category";
	public static final String PRIORITY_ELEMENT_NAME                   = "Priority";
	
	protected String saveAndCompletePartialId =  "childnavigationitems_Bf3IL8R4QPVhjuEnny30_";
	private String saveAndCompleteMeasurement  = "Save_and_Complete_";
	
	public TaskQC(WebDriver webDriver, String testCaseName)
	{
		super(webDriver);
		
		this.qcName = "Task";
		this.saveMenuPartialId    = "button_syNGfrxjmacxmWfqm2ljlm_"; //button_syNGfrxjmacxmWfqm2ljlm_1159MENU
		this.saveAndNewPartialId  = "childnavigationitem4Vq9Han_L4o0XCHQuFdtZ0_";
		this.saveAndOpenPartialId = "childnavigationitemjlE_1CjLuK_1df6w8m_s1YW_";
		this.savePartialId        = "childnavigationitem1QAAlxWBlKc7F2kbHkWmfG_";
		this.cancelPartialId      = "button9CSNAhVf7KIjtg3yTPLxQm_";
		
		//   save and complete
		this.testName = testCaseName;
	}
	
	protected void create(Map<String, String> data) throws InterruptedException{
		String value;
		WebElement elem;
		
		for (String key : data.keySet())
		{
			
			value = data.get(key);
			switch(key)
			{
				case TaskQC.SUBJECT:
					
					if ((elem = this.getElementIfExisting(By2.partialId(TaskQC.SUBJECT), 5)) != null)
					{
						elem.sendKeys(value);
					}
			
					break;
					
				case TaskQC.ACCOUNT:
				case TaskQC.ACCOUNT_VALUE_HELP_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.ACCOUNT, "ButtonValueHelp"), 1))!= null)
					{
						this.valueHelpDialog(TaskQC.ACCOUNT, value, "Account", TaskQC.HITLIST_ITEM_PARTIAL_ID);
					}				
					break;					
					
				case TaskQC.PRIMARY_CONTACT:
				case TaskQC.PRIMARY_CONTACT_VALUE_HELP_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.PRIMARY_CONTACT, "ButtonValueHelp"), 1))!= null)
					{
						this.valueHelpDialog(TaskQC.PRIMARY_CONTACT, value, "PrimaryContact", TaskQC.HITLIST_ITEM_PARTIAL_ID);
					}				
					break;					
					
				case TaskQC.PROCESSOR:					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.PROCESSOR, "ButtonValueHelp"), 1))!= null)
					{
						this.valueHelpDialog(TaskQC.PROCESSOR, value, "Processor", TaskQC.HITLIST_ITEM_PARTIAL_ID);
					}				
					break;
				
				case TaskQC.COMPLETION:
				case TaskQC.COMPLETION_ELEMENT_NAME:
					if ((elem = this.getElementIfExisting(By2.partialId(TaskQC.COMPLETION), 5)) != null)
					{
						elem.clear();
						elem.sendKeys(value);
						elem.sendKeys(Keys.ENTER);
					}
			
					break;
					
				case TaskQC.OWNER:
				case TaskQC.OWNER_VALUE_HELP_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.OWNER, "ButtonValueHelp"), 1))!= null)
					{
						this.valueHelpDialog(TaskQC.OWNER, value, "Owner", TaskQC.HITLIST_ITEM_PARTIAL_ID);
					}				
					break;					

				case TaskQC.SALES_TERRITORY:
				case TaskQC.SALES_TERRITORY_VALUE_HELP_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.SALES_TERRITORY, "ButtonValueHelp"), 1))!= null)
					{
						this.valueHelpDialog(TaskQC.SALES_TERRITORY, value, "Territory", TaskQC.HITLIST_ITEM_PARTIAL_ID);
					}				
					break;					

				case TaskQC.FROM_DATE_ELEMENT_NAME:
				case TaskQC.FROM_DATE:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.FROM_DATE_TIME_ELEMENT_ID, TaskQC.DATE_ELEMENT_ID_POSTFIX), 1))!= null)
					{
						elem.sendKeys(value);
					}				
					break;					

				case TaskQC.FROM_TIME_ELEMENT_NAME:
				case TaskQC.FROM_TIME_ELEMENT_ID:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.FROM_DATE_TIME_ELEMENT_ID, TaskQC.TIME_ELEMENT_ID_POSTFIX), 1))!= null)
					{
						elem.sendKeys(value);
					}				
					break;						
					
				case TaskQC.TO_DATE_ELEMENT_NAME:
				case TaskQC.TO_DATE:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.TO_DATE_TIME_ELEMENT_ID, TaskQC.DATE_ELEMENT_ID_POSTFIX), 1))!= null)
					{	
						Thread.sleep(2000);
						elem.clear();
						elem.sendKeys(value);
					}				
					break;						
				
					
				case TaskQC.TO_TIME_ELEMENT_NAME:
				case TaskQC.TO_TIME_ELEMENT_ID:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.TO_DATE_TIME_ELEMENT_ID, TaskQC.TIME_ELEMENT_ID_POSTFIX), 1))!= null)
					{
						elem.sendKeys(value);
					}				
					break;							
					
				case TaskQC.CATEGORY:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.CATEGORY, "-inpu"), 1))!= null)
					{
						this.fillDropDown(elem, value);
					}
					break;					
					
				case TaskQC.CATEGORY_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.label(TaskQC.CATEGORY_ELEMENT_NAME), 1))!= null)
					{
						this.fillDropDown(elem, value);
					}
					break;
										
			case TaskQC.PRIORITY:
					
					if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(TaskQC.PRIORITY, "-inpu"), 1))!= null)
					{
						this.fillDropDown(elem, value);
					}
					break;					
					
				case TaskQC.PRIORITY_ELEMENT_NAME:
					
					if ((elem = this.getElementIfExisting(By2.label(TaskQC.PRIORITY_ELEMENT_NAME), 1))!= null)
					{
						this.fillDropDown(elem, value);
					}
					break;					
					
				default:
					//Fill the remaining simple fields

					if ((elem = this.getElementIfExisting(By2.partialId(key), 1))!= null)
					{
						elem.sendKeys(value);
					}
					else
					{
						if ((elem = this.getElementIfExisting(By2.label(key), 1))!= null)
						{
							elem.sendKeys(value); 
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

