package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceRunner;

public class VisitQC extends BaseQC {

	public static final String VISITNAME     = "inputfieldGb3SbNvplK_75Oxze_sR4lm_";
	public static final String ACCOUNTSELECT_ID     = "objectvalueselector1mq3Km8_uqoyZZQKpzxkCW";
	public static final String OWNER_ID     = "objectvalueselector1mq3Km8";
	public static final String SELECTACCOUNT        = "statictext_sosJUITt3aEjAmHhSRt3pG";
	public static final String FROM_DATE_ELEMENT_ID   = "inputfield0ljUnj7JW4InHVjrdKuINW_381CALENDAR-input";
	public static final String TO_DATE_ELEMENT_ID = "inputfieldM4e25fWlNK6qE3geqfRrf0_384CALENDAR-input";
	public static final String ACCOUNTSELECT_ELEMENT_NAME         = "Account";
	//owner
	public static final String OWNER_ELEMENT_NAME           = "Owner";
	
	protected static final String FROM_DATE_TIME_ELEMENT_ID = "inputfield0ljUnj7JW4InHVjrdKuINW";
	protected static final String TO_DATE_TIME_ELEMENT_ID    = "inputfieldM4e25fWlNK6qE3geqfRrf"; 
	
	protected static final String TIME_ELEMENT_ID_POSTFIX            = "TIMELIST-input";   		
	protected static final String DATE_ELEMENT_ID_POSTFIX            = "CALENDAR-input";
	protected final static String HITLIST_ITEM_PARTIAL_ID ="statictext";
	protected String saveAndCompletePartialId =  "childnavigationitemJPoOLnjOg4_5CPSuY5_k9G_";
	private String saveAndCompleteMeasurement  = "Save_and_Complete_";
	public static final String FROM_DATE_ELEMENT_NAME                  = "Start Date";
	public static final String FROM_TIME_ELEMENT_NAME                  = "Start Time";
	public static final String TO_DATE_ELEMENT_NAME                    = "End Date";
	public static final String TO_TIME_ELEMENT_NAME                    = "End Time";
	
	public VisitQC(WebDriver webDriver)
	{
		
		super(webDriver);
		
		this.qcName = "Account";
		this.saveMenuPartialId    = "button9zy4f3bXHqczacSdQ5wgUW";
		this.saveAndNewPartialId  = "childnavigationitemJPoOLnjOg4_5CPSuY5_k9G_";
		this.saveAndOpenPartialId = "childnavigationitem8CU4wTsfk4A6Yqj5Zyh8RG_";
		this.savePartialId        = "childnavigationitemJHteSaI2pKMv4gWfzenGIm_";
		
	}

	public void createFromNew(String objectName) throws Exception{
		PerformanceRunner.startMeasurement("Open_QC_"+objectName);
		this.elementToClick(By2.text("New"), 60);
		PerformanceRunner.stopMeasurement();
	}
	
	   	
	protected void create(Map<String, String> data) throws InterruptedException{
		String value;		
		WebElement visitField = null;
		WebElement elem;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		date=AccessHelper.addDays(date,7);
		String dateStr = dateFormat.format(date).toString();
		for (String key : data.keySet())
		{
			value = data.get(key);
			switch(key)
			{

			case VisitQC.VISITNAME:
			
				if ((elem = this.getElementIfExisting(By2.partialId(VisitQC.VISITNAME), 60)) != null);
				{
					elem.sendKeys(value);
				}
				break;
				
			case VisitQC.ACCOUNTSELECT_ID:
			case VisitQC.ACCOUNTSELECT_ELEMENT_NAME:
				
				
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(VisitQC.ACCOUNTSELECT_ID, "ButtonValueHelp"), 1))!= null)
				{
					this.valueHelpDialog(VisitQC.ACCOUNTSELECT_ID, value, "Account", VisitQC.HITLIST_ITEM_PARTIAL_ID);
				}	
				
				break;
				
			case VisitQC.OWNER_ID:
			case VisitQC.OWNER_ELEMENT_NAME:
				
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(VisitQC.OWNER_ID, "ButtonValueHelp"), 1))!= null)
				{
					this.valueHelpDialog(VisitQC.OWNER_ID, value, "Owner", AppointmentQC.HITLIST_ITEM_PARTIAL_ID);
				}				
				break;					

			case VisitQC.FROM_DATE_ELEMENT_ID:
			
				if((visitField=this.getElementIfExisting(By2.startsWithAndPartialId(FROM_DATE_TIME_ELEMENT_ID,DATE_ELEMENT_ID_POSTFIX), 0)) != null)
				{
					
					visitField.sendKeys(dateStr);
				}
				
				break;
			case VisitQC.FROM_TIME_ELEMENT_NAME:
			case VisitQC.FROM_DATE_TIME_ELEMENT_ID:
				
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(VisitQC.FROM_DATE_TIME_ELEMENT_ID, VisitQC.TIME_ELEMENT_ID_POSTFIX), 60))!= null)
				{
					elem.sendKeys(value);
				}				
				break;	
			case VisitQC.TO_DATE_ELEMENT_ID:
				
				if((visitField=this.getElementIfExisting(By2.startsWithAndPartialId(TO_DATE_TIME_ELEMENT_ID,DATE_ELEMENT_ID_POSTFIX), 0)) != null)
				{
					
						visitField.sendKeys(dateStr);
				}
				break;
			case VisitQC.TO_TIME_ELEMENT_NAME:
			case VisitQC.TO_DATE_TIME_ELEMENT_ID:
				
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(VisitQC.TO_DATE_TIME_ELEMENT_ID, VisitQC.TIME_ELEMENT_ID_POSTFIX), 60))!= null)
				{
					elem.sendKeys(value);
				}				
				break;							
					
						
					}
				}
			}

	
	
	

   
 			

	/*public void create( String visitname) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		date=AccessHelper.addDays(date,7);
		String dateStr = dateFormat.format(date).toString();
	 	WebElement visitField;
	 	String CustID = null;
	 //Give Visit Name	
	 	if((visitField=this.getElementIfExisting(By2.partialId(VISITNAME),1)) != null)
	 	{
	 		
		 	visitField.sendKeys(visitname);
    	}
    	  				
    	 	if((visitField=this.getElementIfExisting(By2.partialId(CUSTID),1))!= null) 
    	 	{
			
			visitField.sendKeys(CustID);
		}
						
	
	//Open Account 	
		if((visitField=this.getElementIfExisting(By2.partialId(ACCOUNTSELECT),1))!= null)
		{
			visitField.click(); 
		}
		
					
		
		
		if((visitField=this.getElementIfExisting(By2.partialId(SELECTACCOUNT),1))!= null)
		{		

			visitField.click(); 
		}
			
	
		
	//Startdate	
		if((visitField=this.getElementIfExisting(By2.startsWithAndPartialId(FROM_DATE_TIME_ELEMENT_ID,DATE_ELEMENT_ID_POSTFIX), 0)) != null)
		{
			
			visitField.clear();
			visitField.sendKeys(dateStr);
		}
		
					
		
//endDate		
		if((visitField=this.getElementIfExisting(By2.startsWithAndPartialId(TO_DATE_TIME_ELEMENT_ID,DATE_ELEMENT_ID_POSTFIX), 0)) != null)
		{
			
			visitField.clear();
			visitField.sendKeys(dateStr);
		}
		
		//Save
		if(this.saveAndOpenPartialId != null){
				
			visitField.click();             
			}*/
		
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
	


	
	