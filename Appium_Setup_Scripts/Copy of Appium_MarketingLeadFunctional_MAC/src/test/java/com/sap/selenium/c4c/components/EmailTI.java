package com.sap.selenium.c4c.components;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class EmailTI extends BaseTI {

	public EmailTI(WebDriver webDriver)
	{
		
		super(webDriver);
		
		
		actionButton = "buttonMPtWm17dxq6npK3iXzaA2m_";
		
		editButton   = "-actionBar-buttonCLIENT_GENERATED_ThingAction_DisplayEditToggle_";
		saveButton   = "-actionBar-buttonWiqgMCb7gKwO4Wq2guqiNm_";
		cancelButton = "-actionBar-buttonfCM6BM3ylasa3oK2oksXvm_";  
		
		tiName = "E-Mail";
		
	}
	
	public void changeTabToOverview() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitembyGgkezTAKAbhEf49Du4sG_", "NavigateToOverview");
	}
	
	public void changeTabToFeed() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemBbXKBRhMYawWIXpGY3cZV0_", "NavigateToFeed"); 
	}
	
	public void changeTabToRelatedItems() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemmhdiYONzMq_nINMTu9DvVm_", "NavigateToRelatedItems");
	}
	
	public void changeTabToChanges() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemOJg3c_vSY4w9iTWuLY_sMim_", "NavigateToChanges");
	}
    
	public void changeTabToAttachments() throws InterruptedException
	{
		this.changeTabIfExisting("navigationitemGeT6ikp6daIdZ4G5XAZgM0_", "NavigateToAttchments");
	}
    
}


