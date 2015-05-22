package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.BaseOWL;

public class AppointmentOWL extends BaseOWL {
	
	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_APPOINTMENTS = "My Appointments";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_APPOINTMENTS = "My Team's Appointments";
	
	
	public AppointmentOWL(WebDriver webDriver)
	{
		super(webDriver);
		
		this.owlName = "ACTIVITIES";
		this.tabName = "APPOINTMENTS";		
		this.metricName = "Open_WoC_Activities";
		this.subName = "Open_WoC_Appointments";

	}

}