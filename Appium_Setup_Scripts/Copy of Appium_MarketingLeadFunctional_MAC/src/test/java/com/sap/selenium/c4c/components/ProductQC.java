package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.sap.selenium.c4c.components.By2;

public class ProductQC extends BaseQC {


	public static final String NAME = "inputfieldnqOCSERew4_BXjGH5IZUs0";
	public static final String ID = "inputfieldCqUTnWFzZqUTzMdd_phM3G";
	public static final String CATEGORY = "objectvalueselectork0y2YfBVCaAL3cvYU";
	public static final String UNIT_OF_MEASURE = "dropdownlistboxaiQJ2EY364okExjXsu91sm";
	public static final String NOTES = "_area";
	
	
	protected final static String HITLIST_ITEM_PARTIAL_ID = "listdefintion";


	public ProductQC(WebDriver webDriver) {
		super(webDriver);
		

		this.qcName = "Product";
		this.savePartialId = "button35C8zCpbdaI5K7r8i_0xi0";
		this.saveAndNewPartialId = "childnavigationitem_HPTqxwcdK_B9MfoPHQU0m";
		this.saveAndOpenPartialId = "childnavigationitemkmxFC4NNTKAtSdR2P38QTm";
		this.saveMenuPartialId = "childnavigationitemmOkKoBs0n4s1yhkO7bAkr0_";

	}

	
	protected void create(Map<String, String> data) throws InterruptedException {
		String value;
		WebElement elem;

		for (String key : data.keySet()) {
			value = data.get(key);
			
			// wait for 2sec after each data entry
						Thread.sleep(2000);
						
			switch (key) {


			case ProductQC.NAME:

				this.elementToClear(By2.partialId(ProductQC.NAME),2);
				this.elementToSendKey(By2.partialId(ProductQC.NAME), 1, value);
				break;

			case ProductQC.ID:

				this.elementToClear(By2.partialId(ProductQC.ID),2);
				this.elementToSendKey(By2.partialId(ProductQC.ID), 1, value);
				break;


			case ProductQC.CATEGORY:

				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(ProductQC.CATEGORY, "ButtonValueHelp"), 1))!= null)
				{
				this.valueHelpDialog(ProductQC.CATEGORY, value, "Catrgory", ProductQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case ProductQC.UNIT_OF_MEASURE:

				if ((elem = this.getElementIfExisting(By2.label(ProductQC.UNIT_OF_MEASURE), 1))!= null)
				{
					this.fillDropDown(elem, value);
				}
				break;
				
			case ProductQC.NOTES:

				this.elementToClear(By2.partialId(ProductQC.NOTES),2);
				this.elementToSendKey(By2.partialId(ProductQC.NOTES), 1, value);
				break;
				
			
			default:
				// Fill the remaining simple fields

				try
				{
					this.elementToSendKey(By2.partialId(key), 60, value);
				}
				catch(Exception nopartialID)
				{
					try
					{
						this.elementToSendKey(By2.label(key), 60, value);					
					}
					catch(Exception nolabel)
					{
						
						Assert.fail("Field with name " + value + " was not found in web page");
						
						
					}
				}
			}
		}

		
	}


	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
