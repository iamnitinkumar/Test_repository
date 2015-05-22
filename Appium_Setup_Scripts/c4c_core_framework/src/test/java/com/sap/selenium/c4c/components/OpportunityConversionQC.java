package com.sap.selenium.c4c.components;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sap.selenium.c4c.components.By2;

public class OpportunityConversionQC extends BaseQC {

	// partial id's for Opportunity Conversion fields

	public static final String NAME = "inputfieldv3VCALpuTKUWFn2BDe1e60";
	public static final String ACCOUNT = "objectvalueselector0HgaZ7u0UKorxBUVGTh0aW";
	public static final String PRIMARY_CONTACT = "objectvalueselectorhhVuadMWeaog31_se3O7suG";
	public static final String SOURCE = "dropdownlistbox6SuL5lCjR4widD2Il";
	public static final String EXPECTED_VALUE = "inputfieldOxgQWiGbc4Aa1ZNkjyzsnG";
	public static final String CURRENCY_CODE = "dropdownlistbox6qDcuB2_jKQd5JxX9hp7nm";
	public static final String START_DATE = "inputfieldGwvnZiSAe4g0Iwx1SKGJzG";
	public static final String CLOSE_DATE = "inputfieldNy_sig71u0aARDlQLOnJwxW";
	public static final String SALES_CYCLE = "dropdownlistboxj1WgTE50Na2F1vohsrCAZW";
	public static final String SALES_PHASE = "dropdownlistboxYugzAIlIMKMRwTGnvJizTG";
	public static final String PROBABILITY = "inputfieldSmXdLwmyLK20EcdwUGrHgW";
	public static final String PUBLISH_TO_FORECAST = "checkboxYKoU4ol6F4_Y_IgZJ5PlHW";
	public static final String FORECAST_CATEGORY = "dropdownlistboxB1VxpFyWEKMGyMmoD9f3";
	public static final String CATEGORY = "dropdownlistboxO8ktYb_4b4wnnqvrxH6Fo0";
	public static final String CAMPAIGN = "objectvalueselector4xtvSKudr4MAYc1voYGoyW";
	public static final String OWNER = "objectvalueselectorEbvjvhyioaQwVb6zuzqjlm";
	public static final String NOTE = "__area";
	public static final String INSTANCE_TYPE = "dropdownlistbox726825dc56d1f5bdeab584a2e7d91feb";

	protected final static String HITLIST_ITEM_PARTIAL_ID = "statictext";

	public OpportunityConversionQC(WebDriver webDriver, String testCaseName) {
		super(webDriver);

		this.qcName = "Opportunity";
		this.saveMenuPartialId = "buttonmDN1yDdTJqwPwsStC";
		this.saveAndNewPartialId = "childnavigationitem54MAhVE2XaYLtOchb8CUg0_";
		this.savePartialId = "childnavigationitemInqA6CEeUK6tNGe79acaQG";
		this.testName = testCaseName;

	}

	protected void create(Map<String, String> data) throws Exception {
		String value;
		WebElement elem;

		for (String key : data.keySet()) {

			value = data.get(key);

			// wait for 2sec after each data entry
			Thread.sleep(3000);

			switch (key) {
			case OpportunityConversionQC.NAME: // Mandatory field

				this.elementToClear(By2.partialId(OpportunityConversionQC.NAME),
						2);
				this.elementToSendKey(
						By2.partialId(OpportunityConversionQC.NAME), 1, value);
				break;

			case OpportunityConversionQC.ACCOUNT:
				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(OpportunityConversionQC.ACCOUNT,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(OpportunityConversionQC.ACCOUNT, value,
							"Account",
							OpportunityConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case OpportunityConversionQC.PRIMARY_CONTACT:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(
								OpportunityConversionQC.PRIMARY_CONTACT,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(OpportunityConversionQC.PRIMARY_CONTACT,
							value, "Contact",
							OpportunityConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case OpportunityConversionQC.SOURCE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.SOURCE), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case OpportunityConversionQC.EXPECTED_VALUE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.EXPECTED_VALUE), 1)) != null) {
					this.fill_CompundField(
							OpportunityConversionQC.EXPECTED_VALUE,
							OpportunityConversionQC.CURRENCY_CODE, value);
				}
				break;

			case OpportunityConversionQC.START_DATE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.START_DATE), 1)) != null) {
					// this.fill_datetimebyID(OpportunityConversion.START_DATE,
					// value);

					this.DatePickerbyID(OpportunityConversionQC.START_DATE, value);

				}
				break;

			case OpportunityConversionQC.CLOSE_DATE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.CLOSE_DATE), 1)) != null) {
					// this.fill_datetimebyID(OpportunityConversion.CLOSE_DATE,
					// value);

					this.DatePickerbyID(OpportunityConversionQC.CLOSE_DATE, value);

				}
				break;

			case OpportunityConversionQC.SALES_CYCLE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.SALES_CYCLE), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case OpportunityConversionQC.SALES_PHASE:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.SALES_PHASE), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case OpportunityConversionQC.PROBABILITY:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.PROBABILITY), 1)) != null) {

					this.elementToClear(
							By2.partialId(OpportunityConversionQC.PROBABILITY), 2);
					this.elementToSendKey(
							By2.partialId(OpportunityConversionQC.PROBABILITY),
							1, value);
				}
				break;

			case OpportunityConversionQC.FORECAST_CATEGORY:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.FORECAST_CATEGORY),
						1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case OpportunityConversionQC.CATEGORY:

				if ((elem = this.getElementIfExisting(
						By2.partialId(OpportunityConversionQC.CATEGORY), 1)) != null) {
					this.fillDropDown(elem, value);
				}
				break;

			case OpportunityConversionQC.CAMPAIGN:
				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(OpportunityConversionQC.CAMPAIGN,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(OpportunityConversionQC.CAMPAIGN, value,
							"Campaign",
							OpportunityConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			case OpportunityConversionQC.OWNER:

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(OpportunityConversionQC.OWNER,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog(OpportunityConversionQC.OWNER, value,
							"Owner",
							OpportunityConversionQC.HITLIST_ITEM_PARTIAL_ID);
				}
				break;

			default:
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
	}

	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}

}
