package com.sap.selenium.c4c.components;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;

public class SalesLeadConversionQC extends BaseQC {

	// ID's

	public static final String NAME = "inputfieldLz4hC4iDGK_sSQEof_";
	public static final String ACCOUNT = "objectvalueselectorCYrbkaY27KQwWgI3sPN9L0";
	public static final String PRIMARYCONTACT = "objectvalueselectorBxWmdV5MHK2s9x2Ai";

	public static final String STATUS = "dropdownlistboxSLUwwlLXXa_zAfMdEK1mZm";
	public static final String SOURCE = "dropdownlistboxBZFR7ar8LaIPIE2Op8zrFG";
	public static final String QUALIFICATIONLEVEL = "dropdownlistbox0msO5wClZ4YIHZyuZF1YZW";
	public static final String CATEGORY = "dropdownlistbox38W2lu8CSq6g5P83HwggYW";

	public static final String CAMPAIGN = "objectvalueselectorX1FBj4gok4Qcexyclyqws0";
	public static final String OWNER_SALES = "objectvalueselectorJrrCXOwQc42I8OqQCuy3xW";
	public static final String OWNER_MARKETING = "objectvalueselectorgDP3wYt294MhUWO1xwiwx0";

	public static final String MARKETINGUNIT = "objectvalueselectornhdl57YdraoftwaAOg_scCm";
	public static final String NOTE = "__area";
	public static final String SALESUNIT = "objectvalueselectorHEx_DLBZHqcIWXb0mSCiYW";

	protected final static String HITLIST_ITEM_PARTIAL_ID = "statictext";

	public SalesLeadConversionQC(WebDriver webDriver, String testCaseName) {
		super(webDriver);

		this.qcName = "SalesLead";
		this.saveMenuPartialId = "buttonJ2hszcdtuaYOr3KVrouYC0";
		this.saveAndOpenPartialId = "childnavigationitemj7hTSG2PU4cpDKUdzwCxBW";
		this.savePartialId = "childnavigationitemmAbFHnBYJ4YPt4INktIgfG";

		this.testName = testCaseName;

	}

	protected void create(Map<String, String> data) throws InterruptedException {
		String value;
		WebElement elem;

		for (String key : data.keySet()) {
			value = data.get(key);

			// wait for 2sec after each data entry
			Thread.sleep(2000);

			switch (key) {

			case SalesLeadConversionQC.NAME:

				elementToSendKey(By2.partialId(SalesLeadConversionQC.NAME), 1,
						value);

				break;

			case SalesLeadConversionQC.ACCOUNT:
				System.out.println("In Account");
				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadConversionQC.ACCOUNT,
								"ButtonValueHelp"), 10)) != null) {
					this.valueHelpDialog(SalesLeadConversionQC.ACCOUNT, value,
							"Account",
							SalesLeadConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadConversionQC.PRIMARYCONTACT:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								SalesLeadConversionQC.PRIMARYCONTACT,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadConversionQC.PRIMARYCONTACT,
							value, "Account",
							SalesLeadConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadConversionQC.SOURCE:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadConversionQC.SOURCE,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadConversionQC.QUALIFICATIONLEVEL:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								SalesLeadConversionQC.QUALIFICATIONLEVEL,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadConversionQC.STATUS:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadConversionQC.STATUS,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadConversionQC.CATEGORY:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadConversionQC.CATEGORY,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadConversionQC.CAMPAIGN:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadConversionQC.CAMPAIGN,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadConversionQC.CAMPAIGN, value,
							"Campaign",
							SalesLeadConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadConversionQC.MARKETINGUNIT:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(

						SalesLeadConversionQC.MARKETINGUNIT, "ButtonValueHelp"),
						1)) != null) {
					this.valueHelpDialog(SalesLeadConversionQC.MARKETINGUNIT,
							value, "Marketing Unit",
							SalesLeadConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadConversionQC.SALESUNIT:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(

						SalesLeadConversionQC.SALESUNIT, "ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadConversionQC.SALESUNIT, value,
							"Marketing Unit",
							SalesLeadConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadConversionQC.OWNER_MARKETING:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								SalesLeadConversionQC.OWNER_MARKETING,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadConversionQC.OWNER_MARKETING,
							value, "Owner",
							SalesLeadConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadConversionQC.OWNER_SALES:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								SalesLeadConversionQC.OWNER_SALES,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadConversionQC.OWNER_SALES,
							value, "Owner",
							SalesLeadConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadConversionQC.NOTE:

				elementToSendKey(By2.partialId(SalesLeadConversionQC.NOTE), 1,
						value);

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

		Thread.sleep(5000);

	}

	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}

}
