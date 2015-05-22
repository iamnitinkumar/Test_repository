package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceRunner;

public class ServiceTicketQC extends BaseQC {

	

	public ServiceTicketQC(WebDriver webDriver)
	{
		super(webDriver);
		
		this.qcName = "ServiceTicket";
		
		this.saveMenuPartialId    = "button_snY12kJvA4s8c_F34SJKW0_"; 
		this.saveAndNewPartialId  = "childnavigationitemw9axqz_sjKKcyl41ubQClGG_";
		this.saveAndOpenPartialId = "childnavigationitemmwZucqoBraUkBLvrid0usm_";
		this.savePartialId        = "childnavigationitemGdB20AZgvaQwpaLEjuRYHG_";
		
	}
	



	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

