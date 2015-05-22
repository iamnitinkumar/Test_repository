package com.sap.selenium.c4c.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.BaseOWL;

public class EmailOWL extends BaseOWL {
	
	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_EMAILS = "My E-Mails";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_EMAILS = "My Team E-Mails";
	
	
	public EmailOWL(WebDriver webDriver)
	{
		super(webDriver);
		this.owlName = "ACTIVITIES";
		this.tabName = "E-MAILS";		
		this.metricName = "Open_WoC_Activities";
		this.subName = "Open_WoC_E-Mails";

	}
	
	public void openFirstEmailByFilter(String filter) throws InterruptedException
	{
		this.elementToFindExplicit(displayAll, 5).click();
		By dropDown = By2.text(filter);
		PerformanceRunner.startMeasurement(filter+"_"+this.owlName);
		this.elementToFindExplicit(dropDown, 5).click();
		PerformanceRunner.stopMeasurement();
		Thread.sleep(5000);
		getLinkInListByRowCol(0, 0).click();
	}
	
	public WebElement getLinkInListByRowCol(int row, int col)
	{
		return driver.findElement(By2.startsWithAndPartialId("link", "-col"+col+"-row"+row));
	}
	
}