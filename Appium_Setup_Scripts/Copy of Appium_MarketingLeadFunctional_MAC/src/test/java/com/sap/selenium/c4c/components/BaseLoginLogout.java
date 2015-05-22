package com.sap.selenium.c4c.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class BaseLoginLogout extends Base {
	
	
	public BaseLoginLogout(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	protected static By userID=By.id("__screen0-user");
	protected static By password=By.id("__screen0-pass");
	protected static By loginButton=By.id("__screen0-logonBtn");
	protected static By logOut=By.id("main-logout");
	protected static By logOutConfirm=By2.text("Yes");
	protected String loginlabel;
	protected String logoutlabel;
	

	 public void logout() throws InterruptedException{
		 
		 this.elementToFindExplicit(logOut, 5).click();
		 this.elementToFindExplicit(logOutConfirm, 5).click();
		 
	 }
 
 
	 public void login() throws InterruptedException{
		  
		 this.elementToFindExplicit(userID, 5).sendKeys(PerformanceRunner.getProperty("PerformanceAlias"));
		 this.elementToFindExplicit(password, 5).sendKeys(PerformanceRunner.getProperty("PerformancePassword"));
		 this.elementToFindExplicit(loginButton, 5).click(); 
    }
 
 

}

