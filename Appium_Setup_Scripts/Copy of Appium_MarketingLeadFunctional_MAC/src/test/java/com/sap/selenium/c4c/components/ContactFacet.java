package com.sap.selenium.c4c.components;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;

public class ContactFacet extends BaseFacet {

	WebDriver webdriver;

	protected static String ContactFacet_Name = "ContactFacet_Name";
	protected static String ContactFacet_PrimaryContact = "ContactFacet_PrimaryConatct";
	protected static String ContactFacet_Role = "ContactFacet_Role";

	public static String getContactFacet_Role() {
		return ContactFacet_Role;
	}

	public static String getContactFacet_Name() {
		return ContactFacet_Name;
	}

	public static String getContactFacet_PrimaryConatct() {
		return ContactFacet_PrimaryContact;
	}

	public ContactFacet(WebDriver webdriver) {
		super(webdriver);
		this.webdriver = webdriver;
	}

	public ContactFacet(WebDriver webDriver, String tiName, String testCaseName) {
		super(webDriver);
		new ContactFacetHelper(webDriver).Check(tiName);

		this.facetName = "Contacts";
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
			
			Thread.sleep(2000);

			value = data.get(key);
			switch (key) {

			case "ContactFacet_Name":

				System.out.println(ContactFacet.ContactFacet_Name);
				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								ContactFacet.ContactFacet_Name,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog_New(ContactFacet.ContactFacet_Name,
							value, "Name",
							Constants.PRIMARY_CONTACT_VALUEHELP_TABLE_ID);
				}
				break;

			case "ContactFacet_PrimaryConatct":
				System.out.println(ContactFacet.ContactFacet_PrimaryContact);

				if ((elem = this
						.getElementIfExisting(
								By2.startsWithAndPartialId(
										ContactFacet.ContactFacet_PrimaryContact,
										"checkbox"), 1)) != null) {
					this.checkBox(elem, value);
				}
				break;
				
			case "ContactFacet_Role":
				System.out.println(ContactFacet.ContactFacet_Role);
				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								ContactFacet.ContactFacet_Role, "-input"), 5)) != null) {
					elem.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					elem.sendKeys(value);
					elem.sendKeys(Keys.ENTER);
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

			case "contact_Name":
				if (value != null) {
					ContactFacet_Name = value;
					System.out.println("ContactFacet_Name : "
							+ ContactFacet_Name);

				}

				break;

			case "contact_PrimaryContact":
				if (value != null) {
					ContactFacet_PrimaryContact = value;
					System.out.println("ContactFacet_PrimaryContact :"
							+ ContactFacet_PrimaryContact);

				}

				break;
				
			case "contact_Role":
				if (value != null) {
					ContactFacet_Role = value;
					System.out.println("ContactFacet_Role :"
							+ ContactFacet_Role);

				}

				break;

			}

		}

	}

}
