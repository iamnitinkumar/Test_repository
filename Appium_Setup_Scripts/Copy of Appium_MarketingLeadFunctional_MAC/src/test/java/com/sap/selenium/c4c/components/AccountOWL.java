package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sap.selenium.c4c.components.BaseOWL;


public class AccountOWL extends BaseOWL {
	
	
	
	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_ACCOUNTS = "My Accounts";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_ACCOUNTS = "My Team's Accounts";
	
	
	public AccountOWL(WebDriver webDriver)
	{
		super(webDriver);
		
		this.owlName = "CUSTOMERS";
		this.tabName = "ACCOUNTS";
		this.metricName = "Open_WoC_Accounts";
		
		
	}
	
	public void openFilter(String filter)throws InterruptedException{
		
		try{
			
			//this.fillDropDownMobile(By2.startsWithAndPartialId(filterStart, filterEnd), filter);
			//----------------Appium Changes-----------------------------------------------------------
			Thread.sleep(25000);
			WebElement element=driver.findElement(By2.startsWithAndPartialId("DefaultSetDropDown", "select"));
			Select sel1=new Select(element);
			Thread.sleep(20000);
			List <WebElement> alloptions=sel1.getOptions();
			for(WebElement kk:alloptions){
				if("All".equals(kk.getText())){
				kk.click();
				}
				System.out.println(kk.getText());
			}
			Thread.sleep(10000);
			System.out.println("Out of openfilter");
			//-------------------------------------------------------------------------------------------
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
			
			System.out.println("Exception found");
		}	
	
	}			public static boolean elementToClickMobile(By by, int waitTime) {

		boolean isClicked = false;
		if (driver.findElements(by).size() != 0) {
			System.out.println("In element to click");
			driver.findElement(by).click();
			isClicked = true;
		} else {
			System.out.println("Element Button does not Exist");
			isClicked = false;
		}
		return isClicked;

	}
	
	
	public void executeActionCreateTargetGroup()
	{
		
	}
	

}
