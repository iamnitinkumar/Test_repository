package com.sap.selenium.c4c.components;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;

public class SalesAndMarketingTeamFacet extends BaseFacet {

	WebDriver webdriver;

	protected static String SalesAndMarketingLead_Role = "SalesAndMarketingLead_Role";
	protected static String SalesAndMarketingLead_Name = "SalesAndMarketingLead_Name";
	protected static String SalesAndMarketingLead_Primary = "SalesAndMarketingLead_Primary";

	public static String getSalesAndMarketingLead_Role() {
		return SalesAndMarketingLead_Role;
	}

	public static String getSalesAndMarketingLead_Name() {
		return SalesAndMarketingLead_Name;
	}

	public static String getSalesAndMarketingLead_Primary() {
		return SalesAndMarketingLead_Primary;
	}

	public SalesAndMarketingTeamFacet(WebDriver webdriver) {
		super(webdriver);
		this.webdriver = webdriver;
	}

	public SalesAndMarketingTeamFacet(WebDriver webDriver, String tiName, String testCaseName) {
		super(webDriver);
		 new SalesAndMarketingTeamFacetHelper(webDriver).Check(tiName);

		this.facetName = "SalesAndMarketingLead";
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
			case "SalesAndMarketingLead_Role":
				System.out.println("SalesAndMarketingLead_Role");
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(SalesAndMarketingTeamFacet.SalesAndMarketingLead_Role, "-input"), 5)) != null) {
					//Appium changes for Dropdown
					//elem.sendKeys(value);//IE
					elem.click();
					driver.findElement(By.xpath("//*[contains(text(), '" + value + "')]")).click();
					// elem.sendKeys(Keys.ENTER);//IE
				}

				break;

			case "SalesAndMarketingLead_Name":
				System.out.println("SalesAndMarketingLead_Name");
				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								SalesAndMarketingTeamFacet.SalesAndMarketingLead_Name,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog_New(SalesAndMarketingTeamFacet.SalesAndMarketingLead_Name,
							value, "Name",
							Constants.NAME_VALUEHELP_TABLE_ID);
				}
				break;

			case "SalesAndMarketingLead_Primary":

				if ((elem = this
						.getElementIfExisting(
								By2.startsWithAndPartialId(
										SalesAndMarketingTeamFacet.SalesAndMarketingLead_Primary,
										"checkbox"), 1)) != null) {
					this.checkBox(elem, value);
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

			case "salesAndMarketingLead_Role":
				if (value != null) {
					SalesAndMarketingLead_Role = value;
					System.out.println("SalesAndMarketingLead_Role : "
							+ SalesAndMarketingLead_Role);

				}

				break;

			case "salesAndMarketingLead_Name":
				if (value != null) {
					SalesAndMarketingLead_Name = value;
					System.out.println("SalesAndMarketingLead_Name : "
							+SalesAndMarketingLead_Name);

				}

				break;

			case "salesAndMarketingLead_Primary":
				if (value != null) {
					SalesAndMarketingLead_Primary = value;
					System.out.println("SalesAndMarketingLead_Primary :"
							+ SalesAndMarketingLead_Primary);

				}

				break;

			}

		}

	}

}
