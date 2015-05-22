package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sap.selenium.c4c.components.BaseOWL;


public class OpportunityOWL extends BaseOWL {
	
	
	
	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_ACCOUNTS = "My Accounts";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_ACCOUNTS = "My Team's Accounts";
	
	public static final String NEW_BUTTON = "buttonfOxfHI0dKqIrzqzsawgdpm";
	
	
	public OpportunityOWL(WebDriver webDriver)
	{
		super(webDriver);
		
		this.owlName = "CUSTOMERS";
		this.tabName = "ACCOUNTS";
		this.metricName = "Open_WoC_Customers";
		
		
	}
	
	public void openFilter(String filter)throws InterruptedException{
		
		try{
			
			this.fillDropDownFilter(By2.startsWithAndPartialId(filterStart,filterEnd), filter, this.tabName);
			System.out.println("adding filter done");
			/*this.elementToClick(By2.startsWithAndPartialId(filterStart,filterEnd), 60);
			
			switch(filter){
			case "ALL":
				PerformanceRunner.startMeasurement("DISPLAY_ALL_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_ALL), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "MY":
				PerformanceRunner.startMeasurement("DISPLAY_MY_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_ACCOUNTS), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "TEAM":
				PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_TEAMS_ACCOUNTS), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			}*/
			
		}
		catch(Exception e){
			
			
		}	
	
	}
	
	
	public void executeActionCreateTargetGroup()
	{
		
	}
	
	public void clickButton(String partialId, String measurementName) throws InterruptedException
	{
		 WebElement elem = this.elementToFindExplicit(By2.partialId(partialId),1);
			
	     PerformanceRunner.startMeasurement(measurementName);
         elem.click();
         PerformanceRunner.stopMeasurement();
         
         Thread.sleep(3000);
	}

}
