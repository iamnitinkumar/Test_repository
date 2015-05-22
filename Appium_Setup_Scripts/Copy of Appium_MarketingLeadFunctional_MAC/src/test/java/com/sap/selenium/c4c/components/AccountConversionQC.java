package com.sap.selenium.c4c.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceRunner;

public class AccountConversionQC extends BaseQC {

	public static final String FIRST_NAME = "inputfieldzfDuLqxXFKALN2ZFKwLGlG";
	public static final String LAST_NAME = "inputfieldWswFy1hgMqk9sOeBYtIOPm";
	public static final String ACCOUNT = "inputfieldbVifWApAfagTyzTX0rKfPm";
	public static final String TITLE = "dropdownlistboxZC0Z0SPnRa6VV_s8C2eXS";
	public static final String ACADEMIC_TITLE = "dropdownlistbox2Ge9zilYMKcU1M4whxc7CG";
	public static final String FUNCTION = "dropdownlistboxC1H9y5MB3Ks3rPKDBCK20G";
	public static final String DEPARTMENT = "dropdownlistboxYRzi9Q3bAa27qZVCNleptG";
	public static final String MOBILE = "inputfieldUr6TYNAsvKULYJE404Vm9W";
	public static final String PHONE = "inputfieldxu51mqhp54UBHuqeWo7dpW";
	public static final String FAX = "inputfieldSFVU7Gz_WqAa3ofwyF28rW";

	// QC dialogs like appointment have a list at the bottom which cause
	// duplicate entries --> need own constant
	protected final static String HITLIST_ITEM_PARTIAL_ID = "statictext";

	static final String CHECK_DUPLICATES_BUTTON_ID = "button_qtcvLSit4wMEviQz60PgG_";
	static final String NEW_BUTTON_ID = "button_qtcvLSit4wMEviQz60PgG_";

	public AccountConversionQC(WebDriver webDriver) {
		super(webDriver);

		this.qcName = "Account";
		this.saveMenuPartialId = "buttonFFBtQrj_vKQdJgjn891Qbm";
				
		this.saveAndOpenPartialId = "childnavigationitem9fK2fPSvtqQelqOUZmXkEG";
		this.savePartialId = "childnavigationitemwJ4oICXgGqYQJ6_Ahpktlm";

	}

	

	protected void create(Map<String, String> data) throws Exception {
		String value;

		for (String key : data.keySet()) {
			value = data.get(key);
			switch (key) {

			case AccountConversionQC.FIRST_NAME:

				this.elementToSendKey(By2.partialId(AccountConversionQC.FIRST_NAME), 1,
						value);
				break;

			case AccountConversionQC.LAST_NAME:

				this.elementToSendKey(By2.partialId(AccountConversionQC.LAST_NAME),
						1, value);
				break;

			case AccountConversionQC.ACCOUNT:

				this.elementToSendKey(By2.partialId(AccountConversionQC.ACCOUNT), 1,
						value);
				break;

			case AccountConversionQC.TITLE:

				if ((this.getElementIfExisting(
						By2.label(AccountConversionQC.TITLE), 1)) != null) {
					this.fillDropDown2(
							By2.label(AccountConversionQC.TITLE), value);
				}
				break;

			case AccountConversionQC.ACADEMIC_TITLE:

				if ((this.getElementIfExisting(By2.startsWithAndPartialId(
						AccountConversionQC.ACADEMIC_TITLE, "input"), 1)) != null) {
					this.fillDropDown2(By2.startsWithAndPartialId(
							AccountConversionQC.ACADEMIC_TITLE, "input"), value);
				}
				break;

			case AccountConversionQC.FUNCTION:

				if ((this.getElementIfExisting(By2.startsWithAndPartialId(
						AccountConversionQC.FUNCTION, "input"), 1)) != null) {
					this.fillDropDown2(By2.startsWithAndPartialId(
							AccountConversionQC.FUNCTION, "input"), value);
				}
				break;

			case AccountConversionQC.DEPARTMENT:

				if ((this.getElementIfExisting(By2.startsWithAndPartialId(
						AccountConversionQC.DEPARTMENT, "ButtonValueHelp"), 60)) != null) {
					this.valueHelpDialog(AccountConversionQC.DEPARTMENT, value,
							"ParentAccount",
							AccountConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;
				
			case AccountConversionQC.MOBILE:

				this.elementToSendKey(By2.partialId(AccountConversionQC.MOBILE), 1,
						value);
				break;

			case AccountConversionQC.PHONE:

				this.elementToSendKey(By2.partialId(AccountConversionQC.PHONE),
						1, value);
				break;

			case AccountConversionQC.FAX:

				this.elementToSendKey(By2.partialId(AccountConversionQC.FAX), 1,
						value);
				break;


			default:
				// Fill the remaining simple fields
				try {
					this.elementToSendKey(By2.partialId(key), 60, value);
				} catch (Exception nopartialID) {
					try {
						this.elementToSendKey(By2.label(key), 60, value);
					} catch (Exception nolabel) {

						Assert.fail("Field with name " + value
								+ " was not found in web page");

					}
				}
			}
		}

		//this.checkDuplicates();
		Thread.sleep(5000);

	}

	public void checkDuplicates() throws Exception {
		PerformanceRunner.startMeasurement("CHECK_DUPLICATES_ACCOUNT");
		this.elementToClick(
				By2.partialId(AccountConversionQC.CHECK_DUPLICATES_BUTTON_ID), 60);
		PerformanceRunner.stopMeasurement();

	}

	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}

}
