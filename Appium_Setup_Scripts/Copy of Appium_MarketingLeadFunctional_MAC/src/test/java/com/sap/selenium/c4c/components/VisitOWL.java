package com.sap.selenium.c4c.components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.Keys;*/
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;//

public class VisitOWL extends BaseOWL 
{
	
	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_VISITS = "My Visits Today";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_VISITS = "My Team's Visits";
	
	public VisitOWL(WebDriver webDriver)
	{
		
		super(webDriver);	
		this.tabName = "VISITS";
		this.owlName = "Open_WoC_VISITS";
		this.subName = "TASKS";
		this.subName = "SURVEYS";
}	
	

public void openFilter(String filter)throws InterruptedException{
	
	try{
		
		this.elementToClick(By2.startsWithAndPartialId(filterStart,filterEnd), 60);
		switch(filter){
		case "ALL":
			PerformanceRunner.startMeasurement("DISPLAY_ALL_Visits");
			this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_ALL), 60);
			PerformanceRunner.stopMeasurement();
			Thread.sleep(5000);
			break;
		case "MY":
			PerformanceRunner.startMeasurement("DISPLAY_MY_Visits");
			this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_VISITS), 60);
			PerformanceRunner.stopMeasurement();
			Thread.sleep(5000);
			break;
		case "TEAM":
			PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_Visits");
			this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_TEAMS_VISITS), 60);
			PerformanceRunner.stopMeasurement();
			Thread.sleep(5000);
			break;
		}
		
	}
	catch(Exception e){
		
		
	}	

}
}
	
	