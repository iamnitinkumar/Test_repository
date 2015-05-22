package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.BaseOWL;

public class TaskOWL extends BaseOWL {
	
	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_TASK = "My Tasks";
	public static final String SIMPLE_SEARCH_FILTER_MY_COMPLETED_TASK = "My Completed Tasks";
	public static final String SIMPLE_SEARCH_FILTER_MY_OPEN_TASK = "My Open Tasks";
	public static final String SIMPLE_SEARCH_FILTER_MY_TASK_THIS_WEEK = "My Tasks This Week";
	public static final String SIMPLE_SEARCH_FILTER_MY_TASK_THIS_MONTH = "My Tasks This Month";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_TASK = "My Team's Tasks";
	
	
	public TaskOWL(WebDriver webDriver)
	{
		super(webDriver);
		this.owlName = "ACTIVITIES";
		this.tabName = "TASKS";		
		this.metricName = "Open_WoC_Ativities";
		this.subName = "Open_WoC_Tasks";

	}
	
	public void openFilter(String filter)throws InterruptedException{
		
		try{
			
			this.elementToClick(By2.startsWithAndPartialId(filterStart,filterEnd), 60);
			switch(filter){
			case "ALL":
				PerformanceRunner.startMeasurement("DISPLAY_ALL_TASK");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_ALL), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "MY":
				PerformanceRunner.startMeasurement("DISPLAY_MY_TASK");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_TASK), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "COMPLETED":
				PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_COMPLETED_TASK), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "OPEN":
				PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_OPEN_TASK), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "WEEK":
				PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_TASK_THIS_WEEK), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "MONTH":
				PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_TASK_THIS_MONTH), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "TEAM":
				PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_TEAMS_TASK), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			}
			
		}
		catch(Exception e){
			
			
		}	

	}
}

	
	