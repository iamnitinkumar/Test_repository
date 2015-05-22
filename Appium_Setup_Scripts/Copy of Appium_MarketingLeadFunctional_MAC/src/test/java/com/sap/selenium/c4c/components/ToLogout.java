package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebDriver;

public class ToLogout extends BaseLoginLogout{
	
	
	public ToLogout(WebDriver webDriver)
	{
		super(webDriver);
		this.logoutlabel = "Logout_C4C";
		

	}
}
