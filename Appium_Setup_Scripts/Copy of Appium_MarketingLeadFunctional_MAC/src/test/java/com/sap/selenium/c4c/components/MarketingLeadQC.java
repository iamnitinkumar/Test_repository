package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;

public class MarketingLeadQC extends BaseQC {

	Boolean is_USE_EXISTING_ACCOUNT = false;

	// ID's

	public static final String USE_EXISTING_ACCOUNT = "checkboxe8b3FTvT6Kgfi9Mth";

	/**
	 * COMMON FIELDS FOR EXISTING AND NON EXISTING ACCOUNTS
	 */
	public static final String NAME = "inputfieldav2Clb0RHq_TkSRdy2j80m";
	public static final String STATUS = "dropdownlistboxwQCrVcgPYac0FlASY1bS0m";
	public static final String QUALIFICATION_LEVEL = "dropdownlistboxhHQsWVqpqa2E6QNvV7oumW";
	public static final String SOURCE = "dropdownlistboxHAMY3gCKTqQMJosV5la0b0";
	public static final String CATEGORY = "dropdownlistboxt1cZp65cfKoGEXn6ZkDIj0";
	public static final String PRIORITY = "dropdownlistboxb0f3JmtTV4Qc02A5jNtHBW";
	public static final String STARTDATE = "inputfieldrpDlO_sE6E4cnvNrVCLz_Pm";
	public static final String ENDDATE = "inputfieldnKspRpMxJqQcSe8j0h3feG";
	public static final String OWNER = "objectvalueselectorlOws41O3mqEtAPbeUAX9QW";
	public static final String MARKETINGUNIT = "objectvalueselectorGFDNEhV5AaIduiximYj1oW";
	public static final String NOTE = "__area";
	public final static String HITLIST_ITEM_PARTIAL_ID = "statictext";

	/**
	 * ONLY FOR EXISTING ACCOUNTS
	 */
	public static final String ACCOUNT = "objectvalueselectorPjx8_shXiKaws352ZCvsOyG";
	public static final String CONTACT = "objectvalueselectorbqMgQm9LvaIx9kfrxBbTb0";
	public static final String CAMPAIGN = "objectvalueselectorwZ_saEbEqLKkfNCEX3A1rp0";

	/**
	 * ONLY FOR NON EXISTING ACCOUNTS
	 */

	public static final String COMPANY = "inputfield4ltELp2BkqYCgaajtbw6uW";
	public static final String CONTACT_FIRST_NAME = "inputfieldGmfFSQitIKQdPUqqL6Yjn0";
	public static final String CONTACT_LAST_NAME = "inputfielde8lKGQZhYa_w9CXbztYvsm";
	public static final String CITY = "inputfieldnblSRyyVuqsTOirK_HaFem";
	public static final String COUNTRY = "dropdownlistbox8dlfmwGm3KE6tHvH8bLiZ0";
	public static final String STATE = "dropdownlistboxKe_No9yHEaE_GKvDinVpSm";
	public static final String PHONE = "inputfieldYbrjQa9WHKoRsAQ17NDg8G";
	public static final String MOBILE = "inputfield2nstqsd8nqgWEB0uXLm";
	public static final String EMAIL = "inputfieldDocimVy_swKMYCU9LA7zx4G";

	public MarketingLeadQC(WebDriver webDriver) {
		super(webDriver);

		this.qcName = "Marketing";
		this.saveMenuPartialId = "buttonbRALgj7NAKMeAP4RpO_stEG"; 
		this.saveAndNewPartialId = "childnavigationitemjTusrH7ex4cPPvP7ujK5SW";
		this.saveAndOpenPartialId = "childnavigationitemxvwiwx_scnKkQO8NnlSA870";
		this.savePartialId = "childnavigationitemmOkKoBs0n4s1yhkO7bAkr0";

	}

	protected void create(Map<String, String> data) throws Exception {

		String value;
		WebElement elem;

		for (String key : data.keySet()) {
			value = data.get(key);

			// wait for 2sec after each data entry
			Thread.sleep(7000);

			switch (key) {

			case MarketingLeadQC.USE_EXISTING_ACCOUNT:
				Thread.sleep(10000);
				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(MarketingLeadQC.USE_EXISTING_ACCOUNT,
								"checkbox"), 10)) != null) {
					is_USE_EXISTING_ACCOUNT = this.checkBox(elem, value);
					Thread.sleep(3000);
					System.out.println(is_USE_EXISTING_ACCOUNT);

				}
				break;

			case MarketingLeadQC.NAME:

				elementToSendKey(By2.partialId(MarketingLeadQC.NAME), 10, value);

				break;

			case MarketingLeadQC.ACCOUNT:
				if (is_USE_EXISTING_ACCOUNT) {
					if ((elem = this.getElementIfExisting(By2
							.startsWithAndPartialId("objectvalueselector",
									"ButtonValueHelp"), 15)) != null) {
						Thread.sleep(10000);
						this.valueHelpDialog(MarketingLeadQC.ACCOUNT, value,
								"Account",
								MarketingLeadQC.HITLIST_ITEM_PARTIAL_ID);
					}
					Thread.sleep(3000);
				}
				break;

			case MarketingLeadQC.COMPANY:

				if (is_USE_EXISTING_ACCOUNT == false) {

					elementToSendKey(By2.partialId(MarketingLeadQC.COMPANY), 1,
							value);
				}

				break;

			case MarketingLeadQC.CONTACT:

				if (is_USE_EXISTING_ACCOUNT) {

					if ((elem = this.getElementIfExisting(By2
							.startsWithAndPartialId("objectvalueselector",
									"ButtonValueHelp"), 1)) != null) {
						this.valueHelpDialog(MarketingLeadQC.CONTACT, value,
								"Contact",
								MarketingLeadQC.HITLIST_ITEM_PARTIAL_ID);
					}
				}
				break;

			case MarketingLeadQC.CONTACT_FIRST_NAME:

				if (is_USE_EXISTING_ACCOUNT == false) {

					elementToSendKey(
							By2.partialId(MarketingLeadQC.CONTACT_FIRST_NAME),
							10, value);
				}

				break;

			case MarketingLeadQC.CONTACT_LAST_NAME:

				if (is_USE_EXISTING_ACCOUNT == false) {
					Thread.sleep(3000);
					elementToSendKey(
							By2.partialId(MarketingLeadQC.CONTACT_LAST_NAME),
							10, value);
				}

				break;

			case MarketingLeadQC.STATUS:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(MarketingLeadQC.STATUS,"input"), 10)) != null) {
					//this.fillDropDown(elem, value);
					this.fillDropDownMobile((By2.startsWithAndPartialId(MarketingLeadQC.STATUS,"input")), value);
				}
				break;

			case MarketingLeadQC.QUALIFICATION_LEVEL:

				if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(
								MarketingLeadQC.QUALIFICATION_LEVEL, "input"),
						10)) != null) {
					//this.fillDropDown(elem, value);
					this.fillDropDownMobile(By2.startsWithAndPartialId(MarketingLeadQC.QUALIFICATION_LEVEL, "input"), value);
				}
				break;

			case MarketingLeadQC.SOURCE:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(MarketingLeadQC.SOURCE,
								"input"), 1)) != null) {
					//this.fillDropDown(elem, value);
					this.fillDropDownMobile(By2.startsWithAndPartialId(MarketingLeadQC.SOURCE,"input"), value);
				}
				break;

			case MarketingLeadQC.CATEGORY:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(MarketingLeadQC.CATEGORY,
								"input"), 1)) != null) {
					this.fillDropDownMobile(By2.startsWithAndPartialId(MarketingLeadQC.CATEGORY,"input"), value);
					//this.fillDropDown(elem, value);
				}
				break;

			case MarketingLeadQC.PRIORITY:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(MarketingLeadQC.PRIORITY,
								"input"), 1)) != null) {
					//this.fillDropDown(elem, value);
					this.fillDropDownMobile(By2.startsWithAndPartialId(MarketingLeadQC.PRIORITY,"input"), value);
				}
				break;

			case MarketingLeadQC.STARTDATE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(MarketingLeadQC.STARTDATE), 1)) != null) {
					// this.fill_datetime(MarketingLeadQC_Model.STARTDATE,
					// value);

					this.DatePickerbyID(MarketingLeadQC.STARTDATE, value);

				}
				break;

			case MarketingLeadQC.ENDDATE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(MarketingLeadQC.ENDDATE), 1)) != null) {
					this.fill_datetimebyID(MarketingLeadQC.ENDDATE, value);

					// this.DatePicker(MarketingLeadQC_Model.STARTDATE_ELEMENT_NAME,
					// value);

				}
				break;

			case MarketingLeadQC.CAMPAIGN:
				if (is_USE_EXISTING_ACCOUNT) {

					if ((elem = this.getElementIfExisting(By2
							.startsWithAndPartialId(MarketingLeadQC.CAMPAIGN,
									"ButtonValueHelp"), 1)) != null) {
						this.valueHelpDialog(MarketingLeadQC.CAMPAIGN, value,
								"Campaign",
								MarketingLeadQC.HITLIST_ITEM_PARTIAL_ID);
					}
				}
				break;

			case MarketingLeadQC.OWNER:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId("objectvalueselector",
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(MarketingLeadQC.OWNER, value, "Owner",
							MarketingLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case MarketingLeadQC.MARKETINGUNIT:

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId(

						"objectvalueselector", "ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(MarketingLeadQC.MARKETINGUNIT, value,
							"Marketing Unit",
							MarketingLeadQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case MarketingLeadQC.NOTE:

				elementToSendKey(By2.partialId(MarketingLeadQC.NOTE), 1, value);

				break;

			case MarketingLeadQC.CITY:
				if (is_USE_EXISTING_ACCOUNT == false) {
					elementToSendKey(By2.partialId(MarketingLeadQC.CITY), 1,
							value);
				}

				break;

			// done
			case MarketingLeadQC.COUNTRY:

				if (is_USE_EXISTING_ACCOUNT == false) {

					if ((elem = this.getElementIfExisting(
							By2.startsWithAndPartialId(MarketingLeadQC.COUNTRY, "input"), 1)) != null) {
						//this.fillDropDown(elem, value);
						this.fillDropDownMobile((By2.startsWithAndPartialId(MarketingLeadQC.COUNTRY, "input")), value);
					}
				}
				break;

			// done
			case MarketingLeadQC.STATE:
				if (is_USE_EXISTING_ACCOUNT == false) {

					if ((elem = this.getElementIfExisting(
							By2.startsWithAndPartialId(MarketingLeadQC.STATE,"input"), 1)) != null) {
						//this.fillDropDown(elem, value);
						this.fillDropDownMobile((By2.startsWithAndPartialId(MarketingLeadQC.STATE,"input")), value);
					}
				}
				break;

			case MarketingLeadQC.PHONE:
				if (is_USE_EXISTING_ACCOUNT == false) {

					elementToSendKey(By2.partialId(MarketingLeadQC.PHONE), 1,
							value);
				}
				break;

			case MarketingLeadQC.MOBILE:
				if (is_USE_EXISTING_ACCOUNT == false) {

					elementToSendKey(By2.partialId(MarketingLeadQC.MOBILE), 1,
							value);
				}
				break;

			case MarketingLeadQC.EMAIL:
				if (is_USE_EXISTING_ACCOUNT == false) {

					elementToSendKey(By2.partialId(MarketingLeadQC.EMAIL), 1,
							value);
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

		Thread.sleep(5000);

	}

	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}

}
