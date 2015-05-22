package com.sap.selenium.c4c.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLogout extends Base {
	
	public LoginLogout(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	private static WebDriver driver;
	protected static By userID=By.id("__screen0-user");
	protected static By password=By.id("__screen0-pass");
	protected static By loginButton=By.id("__screen0-logonBtn");
	protected static By logOut=By.id("main-logout");
	protected static By logOutConfirm=By2.text("Yes");
	
	 public void logout() throws InterruptedException{
		 
		 elementToFindExplicit(logOut, 5).click();
		 elementToFindExplicit(logOutConfirm, 5).click();
	 }
 
 
	 public void login() throws InterruptedException{
		 driver.get(PerformanceRunner.getProperty("aut"));
		 elementToFindExplicit(userID, 5).sendKeys(PerformanceRunner.getProperty("PerformanceAlias"));
		 elementToFindExplicit(password, 5).sendKeys(PerformanceRunner.getProperty("PerformancePassword"));
		 elementToFindExplicit(loginButton, 5).click();
    }
 
 

}
