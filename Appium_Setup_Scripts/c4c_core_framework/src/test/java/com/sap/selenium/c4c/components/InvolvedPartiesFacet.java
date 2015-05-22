package com.sap.selenium.c4c.components;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;

public class InvolvedPartiesFacet extends BaseFacet {

	protected static String INVOLVEDPARTY_ROLE = "INVOLVEDPARTY_ROLE";
	protected static String INVOLVEDPARTY_NAME = "INVOLVEDPARTY_NAME";
	protected static String INVOLVEDPARTY_PRIMARY = "INVOLVEDPARTY_PRIMARY";
	protected static String INVOLVEDPARTY_PRIMARY_CONTACT = "INVOLVEDPARTY_PRIMARY_CONTACT";
	

	public InvolvedPartiesFacet(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	public InvolvedPartiesFacet(WebDriver webDriver, String tiName, String testCaseName) {
		super(webDriver);
		new InvolvedPartiesFacetHelper(webDriver).Check(tiName);

		this.facetName = "InvolvedParties";
		this.testName = testCaseName;

	}

	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void add(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub

		String value;
		WebElement elem;

		for (String key : data.keySet()) {

			value = data.get(key);
			switch (key) {
			case "INVOLVEDPARTY_ROLE":

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(InvolvedPartiesFacet.INVOLVEDPARTY_ROLE,
								"-input"), 5)) != null) {
					//Appium changes for Dropdown
					//elem.clear();//IE
					elem.click();
					driver.findElement(By.xpath("//*[contains(text(), '" + value + "')]")).click();
					//elem.sendKeys(value);//IE
					//elem.sendKeys(Keys.ENTER);//IE
				}

				break;

			case "INVOLVEDPARTY_NAME":

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(InvolvedPartiesFacet.INVOLVEDPARTY_NAME,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog_New(InvolvedPartiesFacet.INVOLVEDPARTY_NAME, value, "Name",
							Constants.NAME_VALUEHELP_TABLE_ID);
				}
				break;

			case "INVOLVEDPARTY_PRIMARY":

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(InvolvedPartiesFacet.INVOLVEDPARTY_PRIMARY,
								"checkbox"), 1)) != null) {
					this.checkBox(elem, value);
				}
				break;
				
			case "INVOLVEDPARTY_PRIMARY_CONTACT":

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								InvolvedPartiesFacet.INVOLVEDPARTY_PRIMARY_CONTACT,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog_New(InvolvedPartiesFacet.INVOLVEDPARTY_PRIMARY_CONTACT,
							value, "PrimaryContact",
							Constants.PRIMARY_CONTACT_VALUEHELP_TABLE_ID);
				}
				break;
			
			
			default:
				// Fill the remaining simple fields

				if ((elem = this.getElementIfExisting(By2.partialId(key), 1)) != null) {
					elem.sendKeys(value);
				} else {
					if ((elem = this.getElementIfExisting(By2.label(key), 1)) != null) {
						elem.sendKeys(value);
					}
				}

			}

		}

	}

	public void demo(Map<String, String> map) {
		String value;

		for (String key : map.keySet()) {
			value = map.get(key);
			switch (key) {

			case "Role":
				if (value != null) {
					INVOLVEDPARTY_ROLE = value;
					System.out.println("INVOLVEDPARTY_ROLE : " + INVOLVEDPARTY_ROLE);

				}

				break;

			case "Name":
				if (value != null) {
					INVOLVEDPARTY_NAME = value;
					System.out.println("INVOLVEDPARTY_NAME : " + INVOLVEDPARTY_NAME);

				}

				break;

			case "Primary":
				if (value != null) {
					INVOLVEDPARTY_PRIMARY = value;
					System.out.println("INVOLVEDPARTY_PRIMARY :" + INVOLVEDPARTY_PRIMARY);

				}

				break;

			case "Primary_Contact":
				if (value != null) {
					INVOLVEDPARTY_PRIMARY_CONTACT = value;
					System.out.println("INVOLVEDPARTY_PRIMARY_CONTACT :" + INVOLVEDPARTY_PRIMARY_CONTACT);
				}

				break;
			

			}

		}

	}
	
	public static String getINVOLVEDPARTY_ROLE() {
		return INVOLVEDPARTY_ROLE;
	}

	public static String getINVOLVEDPARTY_NAME() {
		return INVOLVEDPARTY_NAME;
	}

	public static String getINVOLVEDPARTY_PRIMARY() {
		return INVOLVEDPARTY_PRIMARY;
	}

	public static String getINVOLVEDPARTY_PRIMARY_CONTACT() {
		return INVOLVEDPARTY_PRIMARY_CONTACT;
	}

}
