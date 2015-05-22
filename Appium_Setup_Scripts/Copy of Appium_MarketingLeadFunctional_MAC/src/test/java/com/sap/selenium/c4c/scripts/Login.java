package com.sap.selenium.c4c.scripts;

import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.ToLogin;;

public class Login {
	
	private WebDriver driver;
	
	private ToLogin toLogin = null;
	
	public Login(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
	 public ToLogin getTtoLogin()
	    {
	    	if (toLogin == null)
	    	{
	    		toLogin = new ToLogin(driver);
	    	}
	    	return toLogin;
	    }

}
