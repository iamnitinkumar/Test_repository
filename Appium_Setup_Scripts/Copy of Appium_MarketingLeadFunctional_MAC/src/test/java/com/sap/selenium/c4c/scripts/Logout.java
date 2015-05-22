package com.sap.selenium.c4c.scripts;

import org.openqa.selenium.WebDriver;
import com.sap.selenium.c4c.components.ToLogout;

public class Logout {
	
private WebDriver driver;
	
	private ToLogout toLogout = null;
	
	public Logout(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
	 public ToLogout getTtoLogout()
	    {
	    	if (toLogout == null)
	    	{
	    		toLogout = new ToLogout(driver);
	    	}
	    	return toLogout;
	    }

}
