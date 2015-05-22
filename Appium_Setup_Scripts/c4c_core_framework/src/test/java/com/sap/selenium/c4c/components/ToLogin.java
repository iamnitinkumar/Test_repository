package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebDriver;

public class ToLogin extends BaseLoginLogout {
	
	public ToLogin(WebDriver webDriver)
	{
		super(webDriver);
		this.loginlabel = "Login_C4C";
		

	}

}
