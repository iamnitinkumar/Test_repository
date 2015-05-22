package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sap.selenium.c4c.components.BaseOWL;

public class SalesLeadOWL extends BaseOWL {

	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_ACCOUNTS = "My Accounts";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_ACCOUNTS = "My Team's Accounts";

	public final String NEW_BUTTON = "button8MeAsc7BZagNnlqeJqQUqW";

	public SalesLeadOWL(WebDriver webDriver) {
		super(webDriver);

		this.tabName = "CUSTOMERS";
		// this.subTab = "ACCOUNTS";
		this.owlName = "Open_WoC_Customers";
		this.subName = "Open_Tab_Accounts";

	}

	public void openFilter(String filter) throws InterruptedException {

		try {

			this.elementToClick(By2.startsWithAndPartialId("", ""), 60);
			switch (filter) {
			case "ALL":
				PerformanceRunner.startMeasurement("DISPLAY_ALL_ACCOUNTS");
				this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_ALL), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "MY":
				PerformanceRunner.startMeasurement("DISPLAY_MY_ACCOUNTS");
				this.elementToClick(
						By2.text(this.SIMPLE_SEARCH_FILTER_MY_ACCOUNTS), 60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			case "TEAM":
				PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_ACCOUNTS");
				this.elementToClick(
						By2.text(this.SIMPLE_SEARCH_FILTER_MY_TEAMS_ACCOUNTS),
						60);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(5000);
				break;
			}

		} catch (Exception e) {

		}

	}

	public void executeActionCreateTargetGroup() {

	}

	public boolean clickButton(String partialId, String measurementName)  {

		boolean isClicked;
		PerformanceRunner.startMeasurement(measurementName);
		isClicked=elementToClick(By2.partialId(partialId), 2);
		PerformanceRunner.stopMeasurement();
		return isClicked;

	}
	

}
