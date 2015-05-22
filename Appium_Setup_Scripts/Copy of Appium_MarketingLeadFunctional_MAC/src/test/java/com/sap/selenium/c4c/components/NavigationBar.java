package com.sap.selenium.c4c.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
	private static WebDriver driver;


	public NavigationBar(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
	public void navigateToActivitiesAndMeasure(String measurementName)
	{
		navigateAndMeasure("ACTIVITIES", measurementName, null);
	}
	
	public void navigateToCustomersAndMeasure(String measurementName)
	{
		navigateAndMeasure("CUSTOMERS", measurementName, null);
	}
	
	public void navigateToSalesAndMeasure(String measurementName)
	{
		navigateAndMeasure("SALES", measurementName, null);
	}
	
	public void navigateToMarketingAndMeasure(String measurementName)
	{
		navigateAndMeasure("MARKETING", measurementName, null);
	}
	
	public void navigateToCompetitorsAndMeasure(String measurementName)
	{
		navigateAndMeasure("COMPETITORS", measurementName, null);
	}
	
	public static void ToMeasure(WebElement Object,String Measurement)
    {
 	     PerformanceRunner.startMeasurement(Measurement);
         Object.click();
         PerformanceRunner.stopMeasurement();
     }
	
	public static void ToMeasureSendKey(WebElement Object,String Measurement, String valuesarch)
    {
 	     PerformanceRunner.startMeasurement(Measurement);
         Object.sendKeys(valuesarch);
         PerformanceRunner.stopMeasurement();
     }
	
	public static void navigateAndMeasure(String tabName, String measurementName, Boolean tomeasure){
    	
    	WebElement TabName = driver.findElement(By.linkText(tabName));
        if (tomeasure==true){
        	ToMeasure(TabName,measurementName);                      
        }
        else{ 
        	TabName.click();              
        }
     
	/*public void navigateAndMeasure(String tabName, String measurementName)
	{
		WebElement elem = driver.findElement(By.linkText(tabName));
		
		if (measurementName != null)
		{
			PerformanceRunner.startMeasurement(measurementName);
			elem.click();
			PerformanceRunner.stopMeasurement();
		}
		else
			elem.click();
	}*/
	
	}
	

	/* check if those make sense as well
	public static WebElement getElementCustomers()
	{
		return driver.findElement(By.linkText("CUSTOMERS"));
	}
	
	public static WebElement getElementSales()
	{
		return driver.findElement(By.linkText("SALES"));		
	}
	*/
}
