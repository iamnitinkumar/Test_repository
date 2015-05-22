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

public class SalesQuoteQC extends BaseQC {

	

	public SalesQuoteQC(WebDriver webDriver)
	{
		super(webDriver);
		
		this.qcName = "SalesQuote";
		this.saveMenuPartialId    = "buttonOcSFOWiCna21fPpM7KhpoW_"; 
	//	this.saveAndNewPartialId  = "childnavigationitemU70JcoIrBa2HV5VtdxmbA0_";
		this.saveAndOpenPartialId = "childnavigationitemo0NC7BOX7aIsjTGQuYXnaG_";
		this.savePartialId        = "childnavigationitemyRh7Lpj5_42991ihaXyPbm_";
		
	}
	



	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

