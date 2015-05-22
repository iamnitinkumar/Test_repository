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

public class ContactQC extends BaseQC {
	
	public static final String FIRSTNAME		 	         = "inputfieldM05IfVLXPaUeKCCFxgjsLm";
	public static final String LASTNAME	 	         = "inputfieldCU01C4Z_sN4EWvuSj8o79lG";
	public static final String JOBTITLE		 	         = "inputfieldrciUr0cz6aEeo8y00Td0";
	public static final String FUNCTION            			 = "dropdownlistboxcMzmUGecCagf8J7rYBb7ym";
	public static final String DEPARTMENT			         = "dropdownlistboxnf978mbGEaQ5ldoaQMFE9W";
	public static final String PHONE		         = "inputfieldZm1uOLS1mK_f8nJFGrn9sW";
	public static final String FAX		             = "inputfieldxCdTXeL4xaIS8w7ttbJmAG";
	public static final String MOBILE		                 = "inputfieldOdBTmqXAR4gzkGcxDs0lI0";
	public static final String EMAIL					="inputfieldqy94744Fs4IAdgDVamUT3W";
	

	static final String CHECK_DUPLICATES_BUTTON				="buttonvhk6SkWd1K_Jc1H2EZBkmW";
	

	public ContactQC(WebDriver webDriver)
	{
		super(webDriver);
		
		this.qcName = "Contact";
		this.saveMenuPartialId    = "buttontp5oQUEloak99vRSlJ94nG_";
		this.saveAndNewPartialId  = "childnavigationitemU70JcoIrBa2HV5VtdxmbA0_";
		this.saveAndOpenPartialId = "childnavigationitemmRWeNd2OKqAIBIXg9KUdAG_";
		this.savePartialId        = "childnavigationitemvHEhTuRB9K22V365KK91j0_";
		
	}
	
	
	protected void create(Map<String, String> data) throws Exception{
		String value;
		
		for (String key : data.keySet())
		{
			value = data.get(key);
			switch(key)
			{
			case AccountTI.FIRSTNAME:
				this.elementToClear(By2.partialId(FIRSTNAME), 60);
				this.elementToSendKey(By2.partialId(FIRSTNAME), 60, value);
				break;
			case AccountTI.LASTNAME:
				this.elementToClear(By2.partialId(LASTNAME), 60);
				this.elementToSendKey(By2.partialId(LASTNAME), 60, value);
				break;
			case AccountTI.JOBTITLE:
				this.elementToClear(By2.partialId(JOBTITLE), 60);
				this.elementToSendKey(By2.partialId(JOBTITLE), 60, value);
				break;			
			case AccountTI.FUNCTION:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(FUNCTION, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(FUNCTION, "-inpu"), value);
				}				
				break;
			case AccountTI.DEPARTMENT:
				if ((this.getElementIfExisting(By2.startsWithAndPartialId(DEPARTMENT, "-inpu"), 1))!= null)
				{
					this.fillDropDown2(By2.startsWithAndPartialId(DEPARTMENT, "-inpu"), value);
				}				
				break;
			case AccountTI.PHONE:
				this.elementToClear(By2.partialId(PHONE), 60);
				this.elementToSendKey(By2.partialId(PHONE), 60, value);
				break;
			case AccountTI.FAX:
				this.elementToClear(By2.partialId(FAX), 60);
				this.elementToSendKey(By2.partialId(FAX), 60, value);
				break;
			case AccountTI.MOBILE:
				this.elementToClear(By2.partialId(MOBILE), 60);
				this.elementToSendKey(By2.partialId(MOBILE), 60, value);
				break;
			case AccountTI.EMAIL:
				this.elementToClear(By2.partialId(EMAIL), 60);
				this.elementToSendKey(By2.partialId(EMAIL), 60, value);
				break;
			}
		}
		
		Thread.sleep(2000);
		this.checkDuplicates();
		Thread.sleep(5000);
		
	}
	
	public void checkDuplicates()
	{
		WebElement elem = driver.findElement(By2.partialId(ContactQC.CHECK_DUPLICATES_BUTTON));
		elem.click();
	}


	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

