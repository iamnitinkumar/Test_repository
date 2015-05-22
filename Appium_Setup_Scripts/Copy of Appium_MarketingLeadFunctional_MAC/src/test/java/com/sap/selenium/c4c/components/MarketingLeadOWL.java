package com.sap.selenium.c4c.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sap.selenium.c4c.components.BaseOWL;

public class MarketingLeadOWL extends BaseOWL {

	public static final String SIMPLE_SEARCH_FILTER_ALL = "All";
	public static final String SIMPLE_SEARCH_FILTER_MY_ACCOUNTS = "My Accounts";
	public static final String SIMPLE_SEARCH_FILTER_MY_TEAMS_ACCOUNTS = "My Team's Accounts";

	public static final String NEW_BUTTON = "buttonn7vzZ64G6K2skiiLLncdx0";

	public MarketingLeadOWL(WebDriver webDriver) {
		super(webDriver);

		this.owlName = "CUSTOMERS";
		this.tabName = "ACCOUNTS";
		this.metricName = "Open_WoC_Customers";

	}

	public void openFilter(String filter) throws InterruptedException {

		try {
			System.out.println("In Open filter");
			this.fillDropDownFilter(
					By2.startsWithAndPartialId(filterStart, filterEnd), filter,
					this.tabName);
			System.out.println("Done open Filter");
			/*
			 * this.elementToClick(By2.startsWithAndPartialId(filterStart,filterEnd
			 * ), 60);
			 * 
			 * switch(filter){ case "ALL":
			 * PerformanceRunner.startMeasurement("DISPLAY_ALL_ACCOUNTS");
			 * this.elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_ALL), 60);
			 * PerformanceRunner.stopMeasurement(); Thread.sleep(5000); break;
			 * case "MY":
			 * PerformanceRunner.startMeasurement("DISPLAY_MY_ACCOUNTS");
			 * this.elementToClick
			 * (By2.text(this.SIMPLE_SEARCH_FILTER_MY_ACCOUNTS), 60);
			 * PerformanceRunner.stopMeasurement(); Thread.sleep(5000); break;
			 * case "TEAM":
			 * PerformanceRunner.startMeasurement("DISPLAY_MY_TEAM_ACCOUNTS");
			 * this
			 * .elementToClick(By2.text(this.SIMPLE_SEARCH_FILTER_MY_TEAMS_ACCOUNTS
			 * ), 60); PerformanceRunner.stopMeasurement(); Thread.sleep(5000);
			 * break; }
			 */

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
