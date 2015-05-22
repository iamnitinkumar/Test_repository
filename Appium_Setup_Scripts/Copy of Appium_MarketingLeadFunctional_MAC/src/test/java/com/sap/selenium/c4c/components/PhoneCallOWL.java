package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.BaseOWL;

public class PhoneCallOWL extends BaseOWL {
	
	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_PHONECALLS = "My Phone Calls";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_EMAILS = "My Team Phone Calls";
	
	
	public PhoneCallOWL(WebDriver webDriver)
	{
		super(webDriver);
		this.owlName = "ACTIVITIES";
		this.tabName = "PHONE CALLS";		
		this.metricName = "Open_WoC_Ativities";
		this.subName = "Open_WoC_PhoneCalls";

	}

}