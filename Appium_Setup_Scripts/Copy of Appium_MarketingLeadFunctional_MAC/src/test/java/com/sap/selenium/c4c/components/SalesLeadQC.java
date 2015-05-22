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

public class SalesLeadQC extends BaseQC {

	// ID's
	public static final String NAME = "inputfield6R85ajPOOaUGdB5MsaRf40_";
	public static final String ACCOUNT = "objectvalueselectorheX3_u2b0acv8ViHJ1y_";
	public static final String PRIMARYCONTACT = "objectvalueselectordoS_sNjWFvKA6N_s05h749KG";

	public static final String STATUS = "dropdownlistboxSLUwwlLXXa_zAfMdEK1mZm";
	public static final String SOURCE = "dropdownlistbox2WDyNvQLP4A6yKNtaQtSfG";
	public static final String QUALIFICATIONLEVEL = "dropdownlistboxAuNdqxT_sgaE0ipNAyThobW";
	public static final String CATEGORY = "dropdownlistbox0aCjIfSb4aMvOCfQnVCxW0";
	public static final String PRIORITY = "dropdownlistbox1CB9MyomOqc7bDBMgIXJx0";
	public static final String STARTDATE = "inputfieldiFw8_0y9wKE40Af5Mq1ccW";
	public static final String ENDDATE = "inputfieldd7ezapbux4cK1kSH0RGx40";

	public static final String CAMPAIGN = "objectvalueselectorS9W8QTRay4AelHA9AJDlaW";
	public static final String OWNER_SALES = "objectvalueselectordhSO97fgaK68vpfPzT00e0";
	public static final String OWNER_MARKETING = "objectvalueselectorXSWD2_ssnYak3adoqf";

	public static final String MARKETINGUNIT = "objectvalueselectortVYJ9LaE_q6aIpDFB2gIlm";
	public static final String NOTE = "__area";
	public static final String SALESUNIT = "objectvalueselectorVrS22rRpwKwCxOezq";

	public static final String TERRITORY_ID = "objectvalueselectorRg4LeeUS2Kgj7H1_ttdIq0";

	public static final String MACHINES = "inputfield1e97ac5e53b742a995247372de57738f";
	public static final String MONTHLYCAPSULES = "inputfield3cd2894566b240879ad2f599b734b978";
	public static final String FIRSTCOFFEEORDER = "inputfielddc7a06e13eb345ac967b79ec24447e8d";
	private static final String MACHINES_drop = "dropdownlistbox2e4d75839ec741f79a4d90023bce2393";
	public static final String MONTHLYCAPSULES_drop = "dropdownlistbox62ff6a1ff9144508be2fdc22b9bacff4";
	public static final String FIRSTCOFFEEORDER_drop = "dropdownlistbox1d9bd2c1cf2042c189b4e6fb2483f265";

	protected final static String HITLIST_ITEM_PARTIAL_ID = "statictext";

	public SalesLeadQC(WebDriver webDriver, String testCaseName) {
		super(webDriver);

		this.qcName = "SalesLead";
		this.saveMenuPartialId = "buttonqP6eQsaNG4c24QGKy02B00";
		this.saveAndNewPartialId = "childnavigationitemoWZ8ujpRi4M5nnhQ9FftvW_";
		this.saveAndOpenPartialId = "childnavigationitemoWZ8ujpRi4M5nnhQ9FftvW_";
		this.savePartialId = "childnavigationitemJI8Lz2M_zKMPCQQAxshUx0_";

		this.testName = testCaseName;

	}

	// protected void fillDropDown(WebElement elem, String value)
	// throws InterruptedException {
	// System.out.println(elem.getAttribute("id"));
	// elem.click();
	//
	// Thread.sleep(3000);
	// elem.sendKeys(value);
	// Thread.sleep(2000);
	// elem.sendKeys(Keys.ENTER);
	// }

	protected void create(Map<String, String> data) throws InterruptedException {
		String value;
		WebElement elem;

		for (String key : data.keySet()) {
			value = data.get(key);

			// wait for 2sec after each data entry
			Thread.sleep(2000);

			switch (key) {

			case SalesLeadQC.NAME:

				this.elementToFindExplicit(By2.partialId(SalesLeadQC.NAME), 1)
						.sendKeys(value);
				break;

			case SalesLeadQC.ACCOUNT:

				// if ((elem = this.getElementIfExisting(By2
				// .startsWithAndPartialId("objectvalueselector",
				// "ButtonValueHelp"), 1)) != null) {
				this.valueHelpDialog(SalesLeadQC.ACCOUNT, value, "Account",
						SalesLeadQC.HITLIST_ITEM_PARTIAL_ID);
				// }
				break;

			case SalesLeadQC.PRIMARYCONTACT:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadQC.PRIMARYCONTACT, value,
							"Account", SalesLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadQC.SOURCE:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadQC.SOURCE, "-input"),
						1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadQC.QUALIFICATIONLEVEL:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadQC.QUALIFICATIONLEVEL,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadQC.STATUS:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadQC.STATUS, "-input"),
						1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadQC.CATEGORY:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(SalesLeadQC.CATEGORY,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadQC.CAMPAIGN:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadQC.CAMPAIGN,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadQC.CAMPAIGN, value,
							"Campaign", SalesLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadQC.MARKETINGUNIT:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(

						"objectvalueselector", "ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadQC.MARKETINGUNIT, value,
							"Marketing Unit",
							SalesLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadQC.SALESUNIT:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(

						"objectvalueselector", "ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadQC.SALESUNIT, value,
							"Marketing Unit",
							SalesLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadQC.OWNER_MARKETING:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadQC.OWNER_MARKETING, value,
							"Owner", SalesLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadQC.OWNER_SALES:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadQC.OWNER_SALES, value,
							"Owner", SalesLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadQC.NOTE:

				this.elementToFindExplicit(By2.partialId(SalesLeadQC.NOTE), 1)
						.sendKeys(value);
				break;

			case SalesLeadQC.TERRITORY_ID:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(SalesLeadQC.TERRITORY_ID, value,
							"Sales Territory ID",
							SalesLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case SalesLeadQC.PRIORITY:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(SalesLeadQC.PRIORITY,
								"-input"), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case SalesLeadQC.STARTDATE:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(SalesLeadQC.STARTDATE,
								"-input"), 1)) != null) {
					// this.fill_datetime(SalesLeadQC.STARTDATE, value);

					this.DatePickerbyID(SalesLeadQC.STARTDATE, value);

				}
				break;

			case SalesLeadQC.ENDDATE:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadQC.ENDDATE, "-input"),
						1)) != null) {
					this.fill_datetimebyID(SalesLeadQC.ENDDATE, value);

					// this.DatePicker(SalesLeadQC.STARTDATE_ELEMENT_NAME,
					// value);

				}
				break;

			case SalesLeadQC.FIRSTCOFFEEORDER:
				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(SalesLeadQC.FIRSTCOFFEEORDER,
								"-input"), 1)) != null) {
					this.fill_CompundField(SalesLeadQC.FIRSTCOFFEEORDER,
							SalesLeadQC.FIRSTCOFFEEORDER_drop, value);
				}
				break;

			case SalesLeadQC.MACHINES:
				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(SalesLeadQC.MACHINES,
								"-input"), 1)) != null) {
					this.fill_CompundField(SalesLeadQC.MACHINES,
							SalesLeadQC.MACHINES_drop, value);
				}
				break;

			// case SalesLeadQC.MONTHLYCAPSULES:
			// if ((elem = this.getElementIfExisting(
			// By2.label(SalesLeadQC.MONTHLYCAPSULES), 1)) != null) {
			// this.fill_CompundField(SalesLeadQC.MONTHLYCAPSULES,
			// SalesLeadQC.MONTHLYCAPSULES_drop, value);
			// }
			// break;

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
