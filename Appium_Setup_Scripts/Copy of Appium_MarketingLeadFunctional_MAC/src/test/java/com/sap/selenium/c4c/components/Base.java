package com.sap.selenium.c4c.components;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	protected static WebDriver driver;
	protected String tabName;
	protected String owlName;
	protected String testName;

	public Base(WebDriver webDriver) {
		if (driver == null)
			driver = webDriver;

	}

	/**
	 * Execute a JavaScript based click on the passed WebElement
	 * 
	 * @param element
	 *            to be clicked
	 */

	protected boolean jsClick(WebElement element) {

		if (element != null)

		{
			JavascriptExecutor js;
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			return true;

		}

		else

		{
			System.out.println("Element not Exist");
			return false;
		}
		

	}

	/**
	 * Find element determined via locator and return it if found
	 * 
	 * @param by
	 *            element locator
	 * @param waitTime
	 *            time to wait till element has to be clickable
	 * @return element if found
	 * @throws exception
	 *             if element is not found
	 */
	protected boolean elementToClick(By by, int waitTime) {

		boolean isClicked = false;
		if (driver.findElements(by).size() != 0) {
			
			this.elementToFindExplicit(by, waitTime).click();
			isClicked = true;
		} else {
			System.out.println("Element Button does not Exist");
			isClicked = false;
		}
		return isClicked;

	}

	protected void elementToClear(By by, int waitTime) {
		this.elementToFindExplicit(by, waitTime).clear();
	}

	protected void elementToSendKey(By by, int waitTime, String text) {
		WebElement we = null;
		if ((we = this.elementToFindExplicit(by, waitTime)).getText().equals(
				null)) {
			we.sendKeys(text);
			we.sendKeys(Keys.ENTER);
		} else {

			we.clear();
			we.sendKeys(text);
			we.sendKeys(Keys.ENTER);
		}

	}

	protected void elementToSendKeyWithoutClear(By by, int waitTime, String text) {
		WebElement we = this.elementToFindExplicit(by, waitTime);
		we.sendKeys(text);
		we.sendKeys(Keys.ENTER);
	}

	protected void elementToSendEnter(By by, int waitTime) {

		this.elementToFindExplicit(by, waitTime).sendKeys(Keys.ENTER);
	}

	protected WebElement elementToFindExplicit(By by, int waitTime)
			throws NoSuchElementException {

		WebDriverWait wait = new WebDriverWait(this.driver, waitTime);
		return wait.until(ExpectedConditions.elementToBeClickable(by));

	}

	/**
	 * Find element determined via locator and return it if found
	 * 
	 * @param by
	 *            element locator
	 * @param waitTime
	 *            time to wait before the element is searched
	 * @return element if it exists or null
	 */
	protected WebElement getElementIfExisting(By by, int waitTime) 	throws NoSuchElementException {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);

		WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(by));
		return elem;

	}

	/**
	 * Find element determined via locator
	 * 
	 * @param by
	 *            element locator
	 * @return true if found and displayed or not found/not displayed
	 */
	protected boolean doesElementExist(By by) {
		try {

			List<WebElement> elems = driver.findElements(by);
			for (WebElement elem : elems) {
				if (elem.isDisplayed() == true) {
					return true;
				}
			}
		} catch (Exception e) {

			return false;
		}

		return false;
	}

	/**
	 * Open value help, search for entry, select first hit list entry or cancel
	 * in case of no hits
	 * 
	 * @param valueHelpId
	 * @param hitListItemId
	 * @param searchString
	 * @param valueHelpName
	 * @throws InterruptedException
	 */
	protected void valueHelpDialog(String valueHelpId, String searchString,
			String valueHelpName, String hitListEntryIDBegin)
			throws InterruptedException {
		// Select account via value help, entering it directly doesn't always
		// work
		PerformanceRunner.startMeasurement("Open_" + valueHelpName
				+ "_ValueHelp");
		elementToFindExplicit(
				By2.startsWithAndPartialId(valueHelpId, "ButtonValueHelp"), 60)
				.click();
		PerformanceRunner.stopMeasurement();

		// wait for search to return throw-away results
		Thread.sleep(15000);
		WebElement elem;
		elem = this.elementToFindExplicit(
				By2.startsWithAndPartialId("BasicFind", "-cb-input"), 5);

		PerformanceRunner.startMeasurement("Type_" + valueHelpName
				+ "_ValueHelp");
		elem.sendKeys(searchString);
		elem.sendKeys(Keys.ENTER);
		PerformanceRunner.stopMeasurement();

		// wait for search to return results
		Thread.sleep(5000);

		if ((elem = this.getElementIfExisting(
				By2.startsWithAndPartialId(hitListEntryIDBegin, "-col0-row0"),
				5)) != null) {
			PerformanceRunner.startMeasurement("Select_" + valueHelpName
					+ "_ValueHelp");
			elem.click();
			PerformanceRunner.stopMeasurement();
		} else
			this.elementToFindExplicit(
					By2.startsWithAndPartialId("embeddedcomponent", "-close"),
					5).click();

		Thread.sleep(2000);
	}

	/**
	 * Enter passed value into dropdown menu Menu is first selected, then
	 * cleared and finally, the value is put in followed by ENTER
	 * 
	 * @param elem
	 *            dropdown menu input field
	 * @param value
	 *            value to be set
	 * @throws InterruptedException
	 */
	protected void fillDropDown2(By by, String value) throws Exception {
		elementToClick(by, 60);
		Thread.sleep(1000);
		elementToClear(by, 60);
		Thread.sleep(1000);
		elementToSendKey(by, 60, value);
		Thread.sleep(2000);
		elementToSendEnter(by, 60);
	}

	protected void fillDropDownFilter(By by, String value, String object)
			throws Exception {
		this.elementToClick(by, 60);
		PerformanceRunner.startMeasurement("Display_" + value + "_" + object);
		this.elementToClick(By2.text(value), 60);
		PerformanceRunner.stopMeasurement();
		Thread.sleep(5000);
	}

	protected void fillDropDown(WebElement elem, String value)
			throws InterruptedException {
		elem.click();
		Thread.sleep(1000);
		elem.clear();
		Thread.sleep(1000);
		elem.sendKeys(value);
		Thread.sleep(2000);
		elem.sendKeys(Keys.ENTER);
	}
	//-------New Appium Method for Dropdown----------
	protected void fillDropDownMobile(By by, String value) throws Exception
	{
		Thread.sleep(10000);
		System.out.println("Click on element");
		//this.jsClick(this.elementToFindExplicit(by, 60));
		elementToClick(by, 60);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[contains(text(), '" + value + "')]")).click();
		Thread.sleep(2000);
	}
	//-----------------------------------------------

	protected void navigateToTab(String tabnme) throws Exception {

		elementToClick(By2.linkText(tabnme), 60);

	}

	// TODO: replica with changes
	protected void elementToClick2(By by, int waitTime) {
		try {
			this.elementToFindExplicit2(by, waitTime).click();
		} catch (WebDriverException e) {
			throw e;
		}

	}

	// TODO: replica with changes
	protected WebElement elementToFindExplicit2(By by, int waitTime) {
		// WebDriverWait wait = new WebDriverWait(driver, waitTime);

		WebDriverWait wait = new WebDriverWait(this.driver, waitTime);
		return AccessHelper.handleMultiple(by);
	}

	// TODO:
	protected WebElement getElementIfExisting2(By by, int waitTime) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);

		try {
			WebElement elem = AccessHelper.handleMultiple(by); // wait.until(ExpectedConditions.elementToBeClickable(by))
			return elem;
		} catch (Exception e) {
			return null;
		}
	}

	protected void valueHelpDialog2(String valueHelpId, String searchString,
			String valueHelpName) throws InterruptedException {
		elementToClear(By2.startsWithAndPartialId(valueHelpId, "-input"), 60);
		PerformanceRunner.startMeasurement("Type_" + valueHelpName
				+ "_ValueHelp");
		elementToSendKey(By2.startsWithAndPartialId(valueHelpId, "-input"), 60,
				searchString);
		elementToSendEnter(By2.startsWithAndPartialId(valueHelpId, "-input"),
				60);
		PerformanceRunner.stopMeasurement();

	}

	protected WebElement getElementProperties(By by) {
		WebElement elem;
		elem = elementToFindExplicit(by, 60);
		return elem;
	}

	protected void elementToClickIfExisting(By by, int waitTime) {
		WebElement elem;
		try {
			if ((elem = this.getElementIfExisting2(by, waitTime)) != null)
				elem.click();
		} catch (WebDriverException e) {
			throw e;
		}

	}

//	public void fill_CompundField(String inputField_PartialID,
//			String dropdown_PartialID, String value) {
//		String values[];
//
//		// split the Value to inputfieldvalue(values[0]) and
//		// dropdownfieldvalue(values[1])
//		if (value.contains("-")) {
//			values = value.split("-");
//
//			try {
//
//				this.elementToFindExplicit(By2.partialId(inputField_PartialID),
//						1).clear();
//
//				// fill the inputfield value
//				this.elementToFindExplicit(By2.partialId(inputField_PartialID),
//						1).sendKeys(values[0]);
//
//				String xpath_dropdownValue = "//*[child::text()='" + values[1]
//						+ "']";
//
//				Thread.sleep(2000);
//				// click on the dropdown icon
//				driver.findElement(
//						By2.startsWithAndPartialId(dropdown_PartialID, "-icon"))
//						.click();
//				Thread.sleep(3000);
//
//				if (Compare(
//						StringReplace(
//								driver.findElement(
//										By2.startsWithAndPartialId(
//												dropdown_PartialID, "-icon"))
//										.getAttribute("id"), "-icon",
//								"-lb-list"), values[1])) {
//
//					driver.findElement(By.xpath(xpath_dropdownValue)).click();
//
//					Thread.sleep(2000);
//
//				} else {
//					System.out.println("Fail");
//					Assert.assertFalse("Given Dropdown Option not found", false);
//				}
//
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} else {
//			throw new IllegalArgumentException("String " + value
//					+ " does not contain -");
//		}
//
//	}
	
	public void fill_CompundField(String inputField_PartialID,String dropdown_PartialID, String value) 
	{
		String values[];

		// split the Value to inputfieldvalue(values[0]) and
		// dropdownfieldvalue(values[1])
		if (value.contains("-")) 

		{
			values = value.split("-");

			try {

				this.elementToFindExplicit(By2.partialId(inputField_PartialID),       1).clear();

				// fill the inputfield value
				this.elementToFindExplicit(By2.partialId(inputField_PartialID),1).sendKeys(values[0]);

				Thread.sleep(2000);
				
				// send keys for currency code
				fillDropDownMobile(By2.startsWithAndPartialId(dropdown_PartialID, "-input"), values[1]);
//				elementToSendKey(By2.startsWithAndPartialId(dropdown_PartialID, "-input"), 2, values[1]);

//				Thread.sleep(2000);

				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			throw new IllegalArgumentException("String " + value
					+ " does not contain -");
		}

	}

	public String StringReplace(String id, String target, String rev) {

		String strOutput = id;
		strOutput = strOutput.replace(target, rev);
		System.out.println(strOutput);
		return strOutput;

	}

	public boolean Compare(String Id, String option) {
		boolean isPresent = false;

		int count = driver.findElements(By.xpath("//*[@id='" + Id + "']/li"))
				.size();
		// System.out.println(count);

		for (int i = 1; i <= count; i++) {
			String Option_Name = driver.findElement(
					By.xpath("//*[@id='" + Id + "']/li[" + i + "]/span[1]"))
					.getText();
			System.out.println(Option_Name);
			if (option.equals(Option_Name)) {
				isPresent = true;
				break;
			}
		}
		return isPresent;

	}

	public void fill_datetime(String labelName, String value) {
		String partialID = null;
		WebElement ele;

		String[] values;
		if (value.contains(" ")) {
			values = value.split(" ");

			try {
				if (values[0] != null) {
					partialID = "CALENDAR-input";
					// xpath = "//*[preceding-sibling::label[1][. = '" +
					// labelName + ":']]//*[self::input[contains(./@id, '" +
					// partialID + "')] or self::textarea]";

					ele = this.elementToFindExplicit(By2
							.elementbylabelwithElementTypeandPartialID(
									labelName, "input", partialID), 1);
					if (ele.isEnabled() && ele != null) {

						ele.clear();
						ele.sendKeys(values[0]);
					}
				}
				if (values[1] != null) {
					partialID = "TIMELIST-input";
					ele = this.elementToFindExplicit(By2
							.elementbylabelwithElementTypeandPartialID(
									labelName, "input", partialID), 1);
					if (ele.isEnabled() && ele != null) {

						ele.clear();
						ele.sendKeys(values[0]);
					}
				}

				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			partialID = "CALENDAR-input";
			ele = this.elementToFindExplicit(By2
					.elementbylabelwithElementTypeandPartialID(labelName,
							"input", partialID), 1);
			if (ele.isEnabled() && ele != null) {

				ele.clear();
				ele.sendKeys(value);
			}
			// throw new IllegalArgumentException("String " + value
			// + " does not contain -");

		}
	}

	public void DatePicker(String labelName, String date) {

		try {

			String dates[] = date.split("-");

			driver.findElement(
					By2.elementbylabelwithElementTypeandPartialID(labelName,
							"div", "CALENDAR-icon")).click();
			Thread.sleep(1000);

			Select drop_month = new Select(driver.findElement(By
					.className("ui-datepicker-month")));
			drop_month.selectByVisibleText(dates[1]);

			Thread.sleep(2000);

			Select drop_year = new Select(driver.findElement(By
					.className("ui-datepicker-year")));
			drop_year.selectByVisibleText(dates[2]);

			Thread.sleep(2000);

			if (dates[0].startsWith("0"))

			{
				dates[0] = dates[0].substring(1);
				System.out.println(dates[0]);
			}

			String monthValue = driver.findElement(
					By.xpath("//option[@selected='selected']")).getAttribute(
					"value");
			driver.findElement(
					By.xpath("//a[text()='" + dates[0] + "'][../@data-month='"
							+ monthValue + "']")).click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void DatePickerbyID(String partialID, String date) {

		try {

			String dates[] = date.split("-");

			// driver.findElement(By2.elementbylabelwithElementTypeandPartialID(labelName,
			// "div", "CALENDAR-icon")).click();
			driver.findElement(
					By2.startsWithAndPartialId(partialID, "CALENDAR-icon"))
					.click();
			Thread.sleep(1000);

			Select drop_month = new Select(driver.findElement(By
					.className("ui-datepicker-month")));
			drop_month.selectByVisibleText(dates[1]);

			Thread.sleep(2000);

			Select drop_year = new Select(driver.findElement(By
					.className("ui-datepicker-year")));
			drop_year.selectByVisibleText(dates[2]);

			Thread.sleep(2000);

			if (dates[0].startsWith("0"))

			{
				dates[0] = dates[0].substring(1);
				System.out.println(dates[0]);
			}

			String monthValue = driver.findElement(
					By.xpath("//option[@selected='selected']")).getAttribute(
					"value");
			driver.findElement(
					By.xpath("//a[text()='" + dates[0] + "'][../@data-month='"
							+ monthValue + "']")).click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fill_datetimebyID(String partialID, String value) {

		WebElement ele;

		String[] values;
		if (value.contains(" ")) {
			values = value.split(" ");

			try {
				if (values[0] != null) {

					ele = this.elementToFindExplicit(
							By2.startsWithAndPartialId(partialID,
									"CALENDAR-input"), 1);
					if (ele.isEnabled() && ele != null) {

						ele.clear();
						ele.sendKeys(values[0]);
					}
				}
				if (values[1] != null) {
					// partialID = "TIMELIST-input";
					ele = this.elementToFindExplicit(
							By2.startsWithAndPartialId(partialID,
									"TIMELIST-input"), 1);
					if (ele.isEnabled() && ele != null) {

						ele.clear();
						ele.sendKeys(values[0]);
					}
				}

				Thread.sleep(2000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			// partialID = "CALENDAR-input";
			ele = this.elementToFindExplicit(
					By2.startsWithAndPartialId(partialID, "CALENDAR-input"), 1);
			if (ele.isEnabled() && ele != null) {

				ele.clear();
				ele.sendKeys(value);
			}
			// throw new IllegalArgumentException("String " + value
			// + " does not contain -");

		}
	}

	/**
	 * @author C5184725
	 * @return
	 */
	public boolean isExceptionDialogExist() {
		try {

			Boolean ispresent = false;

			WebElement ExceptionElement = driver.findElement(By2
					.classNameByPartialId("sapUiDlgModal"));

			if (ExceptionElement.isEnabled() || ExceptionElement.isDisplayed()) {
				System.out.println(ExceptionElement.isEnabled()
						|| ExceptionElement.isDisplayed());
				ispresent = true;
				// driver.close();
			}
			return ispresent;
		} // try
		catch (NoAlertPresentException Ex) {
			Ex.printStackTrace();
			System.exit(1);
			return true;
		} // catch
	}

	/**
	 * @author C5184725
	 * @return
	 */
	public boolean isNotificationMessageAreaExist() {
		try {
			WebElement notificationelement = driver.findElement(By2
					.classNameByPartialId("sapUiNotificationBar"));
			if (notificationelement != null)
				return true;
			else
				return false;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	/**
	 * @author C5184725
	 * @return
	 * @throws Exception
	 */
	public String getNotificationMessage() throws Exception {
		String notificationText = null;
		WebElement notificationelement = driver.findElement(By2
				.classNameByPartialId("sapUiNotificationBar"));

		if (notificationelement != null) {
			System.out
					.println("isNotifierContainerPresent() : notificationelement not null");

			notificationelement.getAttribute("id");
			// TODO : to add a element click step once we are able to get all
			// the messages in the area. For loop is placeholder for the same

			List<WebElement> elements = driver.findElements(By2
					.classNameByPartialId("sapUiNotifierMessageText"));
			System.out.println(elements.size());
			if (elements.size() > 0) {
				for (WebElement ele : elements) {
					System.out.println(ele.getText());
					notificationText = ele.getText();

				}
			}

		} else {
			System.out
					.println("isNotifierContainerPresent() : notificationelement  null");

		}

		TakeScreenShot();
		return notificationText;

	}

	/**
	 * @author C5184725
	 * @throws IOException
	 */
	public void TakeScreenShot() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		// File file = new File(System.getProperty("user.dir")
		File file = new File("C:\\Selenium_ScreenShot"); // write to my
															// directory
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
				FileUtils.copyFile(scrFile, new File(file + "\\screenshot_"
						+ this.testName + dateFormat.format(date) + ".png"));
			} else {
				System.out.println("Failed to create directory!");
			}
		} else {

			FileUtils.copyFile(scrFile, new File(file + "\\screenshot_"
					+ this.testName + System.currentTimeMillis() + ".png"));

		}

		System.out.println(System.getProperty("user.dir"));

	}

	protected void waitUntil(By by) {
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.invisibilityOfElementLocated(by));
	}

	/**
	 * CheckBox checked if pass true and unchecked if passed false First it will
	 * check the state of check box then compare it with passed value cleared
	 * and finally, the value is put in followed by ENTER
	 * 
	 * @author C5184725
	 * @param elem
	 *            CheckBox Element
	 * @param toCheck
	 *            True for Checkbox checked and False for Checkbox unchecked
	 */
	protected boolean checkBox(WebElement elem, String toCheck)
			throws InterruptedException {
		System.out.println("checkBox method called");

		Boolean boolean1 = Boolean.valueOf(toCheck);

		Boolean status = isAttribtuePresent(elem, "aria-checked");// Checks
																	// present
																	// status of
																	// check
																	// box: true
																	// if
																	// checked
																	// false if
																	// unchecked
		if (status != boolean1)

		{
			elem.click();
			System.out.println("checkBox method finish   : " + !status);
			return !status;

		} else {
			System.out.println("checkBox method finish   :  " + status);
			return status;

		}

	}

	/**
	 * This method will check if the attribute is present for the Element.
	 * 
	 * @author rahul.agarwal01@sap.com
	 * @param element
	 * @param attribute
	 * @return boolean value : true if present and false if not.
	 */
	boolean isAttribtuePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String attri = element.getAttribute(attribute);
			if (attri != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	/**
	 * Open value help, search for entry, select first hit list entry or cancel
	 * in case of no hits
	 * 
	 * @param valueHelpId
	 * @param tableParialID
	 * @param searchString
	 * @param valueHelpName
	 * @throws InterruptedException
	 */
	protected void valueHelpDialog_New(String valueHelpId, String searchString,
			String valueHelpName, String tableParialID)
			throws InterruptedException {

		System.out.println("valueHelpDialog method called");
		// Select account via value help, entering it directly doesn't always
		// work
		WebElement elem = this.elementToFindExplicit(
				By2.startsWithAndPartialId(valueHelpId, "ButtonValueHelp"), 5);
		PerformanceRunner.startMeasurement("Open_" + valueHelpName
				+ "_ValueHelp");
		elem.click();
		PerformanceRunner.stopMeasurement();

		// wait for search to return throw-away results
		Thread.sleep(4000);

		elem = this.elementToFindExplicit(
				By2.startsWithAndPartialId("BasicFind", "-cb-input"), 5);
		PerformanceRunner.startMeasurement("Type_" + valueHelpName
				+ "_ValueHelp");
		elem.sendKeys(searchString);
		elem.sendKeys(Keys.ENTER);
		PerformanceRunner.stopMeasurement();

		// wait for search to return results
		Thread.sleep(5000);

		if ((elem = this.getElementIfExisting(
				By2.startsWithAndPartialId(tableParialID, "-table"), 2)) != null) {
			int tablerows = driver.findElements(
					By.xpath("//table[contains(./@id, '" + tableParialID
							+ "')]//tbody//tr")).size();
			System.out.println("No Of Rows:" + tablerows);
			if (tablerows > 0 && tablerows == 2) {

				String elemPath = "//table[contains(./@id, '" + tableParialID
						+ "') ]//tbody//tr[1]//td[1]//div//span";

				if (existsElement(elemPath) == true) {

					this.elementToFindExplicit(By2.Xpath(elemPath), 5).click();

					System.out.println("Element is Present");
				} else {
					this.elementToFindExplicit(
							By2.startsWithAndPartialId("embeddedcomponent",
									"-close"), 5).click();
					System.out.println("Element is Absent");
				}

			} else {
				this.elementToFindExplicit(
						By2.Xpath("//table[contains(./@id, '" + tableParialID
								+ "') ]//tbody//tr[1]"), 5).click();

			}
		} else {
			this.elementToFindExplicit(
					By2.startsWithAndPartialId("embeddedcomponent", "-close"),
					5).click();
			System.out.println("Element is Absent");
			System.out.println("Table not exist");

		}

		Thread.sleep(2000);
		System.out.println("valueHelpDialog method Finish");
	}

	/**
	 * @author rahul.agarwal01@sap.com Method Name: existsElement
	 * @param xpathExpression
	 * @return
	 */
	protected boolean existsElement(String xpathExpression) {
		try {
			driver.findElement(By.xpath(xpathExpression));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	/**
	 * @author rahul.agarwal01@sap.com Method Name: WebElementList
	 * @param by
	 * @return List of WebElements
	 */
	protected List<WebElement> WebElementList(By by) {

		List<WebElement> elements = driver.findElements(by);

		return elements;
	}

	/**
	 * @author rahul.agarwal01@sap.com Method Name: WebElementListSize
	 * @param by
	 * @return Size of WebElementList
	 */
	protected int WebElementListSize(By by) {

		List<WebElement> elements = driver.findElements(by);

		return elements.size();
	}

}
