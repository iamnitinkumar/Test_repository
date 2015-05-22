

package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebDriver;


import com.sap.selenium.c4c.components.PerformanceTest;


public class PerformanceTestAccess extends PerformanceTest{

	
	public static WebDriver getDriver()
	{
		return driver;
	}
	

}