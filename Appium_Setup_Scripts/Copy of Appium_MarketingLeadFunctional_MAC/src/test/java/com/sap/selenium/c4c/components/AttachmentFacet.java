package com.sap.selenium.c4c.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;

public class AttachmentFacet extends BaseFacet {

	WebDriver webdriver;
	
	public static final String LINK = "Link";
	public static final String TITLE = "Title";

	public AttachmentFacet(WebDriver webDriver, String testCaseName) {
		super(webDriver);

		this.facetName = "Attachment";
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

	}

	public void AddAttachment_LocalFile(String pathOfFile)
			throws AWTException, InterruptedException {
		Thread.sleep(5000);
		StringSelection ss = new StringSelection(pathOfFile);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(8000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(10000);

	}

	public void AddAttachment_WebLink(Map<String, String> data) {

		String value;
		WebElement elem;

		for (String key : data.keySet()) {

			value = data.get(key);
			switch (key) {

			case "Link":

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId("inputfieldNt4_v1yZ24gVM_sN3j6pqfW", "input"), 1)) != null) {
					elem.sendKeys(value);
				}
				break;

			case "Title":

				if ((elem = this.getElementIfExisting(
						By2.startsWithAndPartialId("inputfieldqxmA9DynDaoj8VCGC4au3W", "input"), 1)) != null) {
					elem.sendKeys(value);
				}
				break;

			}
		}
	}

	public void AddAttachment_FromLibrary(String value) throws Exception 
	
	{

		this.FromLibrary(value, "Account",ConstantAttachment.Attachement_Table_PartialId);

	}

	/**
	 * Open value help, search for entry, select first hit list entry or cancel
	 * in case of no hits
	 * 
	 * @param hitListItemId
	 * @param searchString
	 * @param valueHelpName
	 * @throws Exception 
	 */
	protected void FromLibrary(String searchString, String valueHelpName,String table_PartialId) throws Exception {

		System.out.println("FromLibrary method called");

		// wait for search to return throw-away results
		Thread.sleep(8000);

		WebElement elem = null;
		
		elementToSendKey(By2.startsWithAndPartialId("BasicFind", "-cb-input"),5,searchString);
		elementToSendEnter(By2.startsWithAndPartialId("BasicFind", "-cb-input"),5);
		

		// wait for search to return results
		Thread.sleep(15000);

		if ((elem = this.getElementIfExisting(By2.startsWithAndPartialId(table_PartialId, "-table"), 10)) != null) {
			int tablerows = driver.findElements(By.xpath("//table[contains(./@id," + table_PartialId  + ")]//tbody//tr")).size();
			
			System.out.println("No Of Rows:" + tablerows);
			
			if (tablerows > 0 && tablerows == 2) 
				
				{
				
				if (existsElement("//table[contains(./@id, '" + table_PartialId + "') ]//tbody//tr[1]//td[1]//div//span") == true)
				
						{
								elementToClick(By2.Xpath("//table[contains(./@id, '" + table_PartialId + "') ]//tbody//tr[1]//td[1]//div//span"),5);
								elementToClick(By2.partialId("buttonUOJ_QK1xzq6kZ1UptkCTwW"), 2);
								System.out.println("Element is Present");
						} 
				else 
						{
								elementToClick(By2.startsWithAndPartialId("embeddedcomponent",	"-close"), 10);
								System.out.println("Element is Absent");
						}

				} 
			
			else 
			
						{	
								System.out.println("rows are 30");
								Thread.sleep(10000);
								elementToClick(By2.Xpath("//table[contains(./@id, '" + table_PartialId + "') ]//tbody//tr[1]//td[1]//div//span"),10);
								Thread.sleep(5000);
								System.out.println("button click");
								elementToClick(By2.partialId("buttonUOJ_QK1xzq6kZ1UptkCTwW"), 10);
				
						}
			
		} else {
			
			elementToClick(By2.startsWithAndPartialId("embeddedcomponent", "-close"),10);
			System.out.println("Element is Absent");
			System.out.println("Table not exist");

		}

		Thread.sleep(2000);
		System.out.println("FromLibrary method Finish");
	}
}