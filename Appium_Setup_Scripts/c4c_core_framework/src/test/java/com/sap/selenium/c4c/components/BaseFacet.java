package com.sap.selenium.c4c.components;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class BaseFacet extends Base {

	public BaseFacet(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private int waittime = 5;

	protected String facetName;

	protected String addMenuPartialId;
	protected String addPartialId;
	protected String addAndNewPartialId;

	private String addMeasurement = "Add_";

	private String addAndOpenMeasurement = "AddandOpen_";

	abstract protected Map<String, String> getTexts();

	protected abstract void add(Map<String, String> data) throws Exception;

	protected void selectAddAction(String partialActionId,
			String measurementName) throws InterruptedException {
		// Open Add menu
//		AddMenuButton();
		// elementToClick(By2.classNameByPartialId(this.addMenuPartialId),
		// waittime);
		Thread.sleep(2000);
		// PerformanceRunner.startMeasurement(measurementName + this.facetName);
		// this.jsClick(By2.partialId(partialActionId), waittime);
		// PerformanceRunner.stopMeasurement();
		Thread.sleep(5000);
	}

	public void addAndSave(Map<String, String> data) throws Exception {
		System.out.println("In Add and Save");
		this.add(data);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//this.selectAddAction(this.addPartialId, this.addMeasurement);
		Thread.sleep(2000);
		this.AddButton();
	}

	public void addAndNew(Map<String, String> data) throws Exception {
		this.add(data);
	//	this.selectAddAction(this.addAndNewPartialId,this.addAndOpenMeasurement);

//		this.AddandNewButton();
		this.AddButton();
		if (isNotificationMessageAreaExist()) {
			try {
				System.out.println("Notification Present : : True");
				TakeScreenShot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Notification Present : : False");
		}
	}

	protected void AddMenuOptionButton() {
		WebElement we = driver.findElement(By2.startsWithAndPartialId(
				"__popup", "buttons"));

		if (we != null) {

			WebElement qwe = driver
					.findElement(By
							.xpath("//div[contains(./@id, '__popup') and contains(./@id, 'buttons')]//*[contains(./@class, 'sapUiMenuButton') and contains(./@id, 'button')]"));

			if (qwe != null) {
				qwe.click();
				System.out.println("AddMenuButton Clicked");
			} else {
				System.out.println("AddMenuButton Null");
			}

			// div[contains(./@id, '__popup') and contains(./@id,
			// 'buttons')]//*[contains(./@class, 'sapUiMenuButton') and
			// contains(./@id, 'button')]
			// elementToClick(
			// By2.ByclassNameandPartialId("sapUiMenuButton", "button"),
			// waittime);

		} else {
			System.out.println(" Condition false for AddMenuButton");
		}
	}
	
	
	protected void AddButton() {
		System.out.println("In Add Button");
		WebElement we = driver.findElement(By2.startsWithAndPartialId(
				"__popup", "buttons"));

		if (we != null) {
			
			try {
			//	elementToClick(By2.Xpath("//div[contains(@id, '__popup') and contains(@id, 'buttons')]//button[@class='sapUiBtn sapUiBtnNorm sapUiBtnS sapUiBtnStd']"), 5);
				jsClick(driver.findElement(By2.CssPath("div.sapUiUx3TPBtnRow > div:first-child > div:first-child > button")));	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("AddButton Clicked");
			
			} 
		
			else 
			
			{
				System.out.println("AddButton Null");
			}

			
	

	}

	protected void AddandSaveButton() {
		WebElement we = driver
				.findElement(By2
						.classNameByPartialId("sapUiMnuLst sapUiMnuNoIco sapUiMnuNoSbMnu"));

		if (we != null) {

			WebElement qwe = driver
					.findElement(By
							.xpath("//ul[contains(./@class, 'sapUiMnuLst sapUiMnuNoIco sapUiMnuNoSbMnu')]//*[contains(./@aria-posinset, '1')]"));
			if (qwe != null) {
				qwe.click();
				System.out.println("AddButton Clicked");
			} else {
				System.out.println("AddButton Null");
			}
			

		} else {
			System.out.println(" Condition false for AddButton");
		}
	}

	protected void AddandNewButton() {
		WebElement we = driver
				.findElement(By2
						.classNameByPartialId("sapUiMnuLst sapUiMnuNoIco sapUiMnuNoSbMnu"));

		if (we != null) {

			WebElement qwe = driver
					.findElement(By
							.xpath("//ul[contains(./@class, 'sapUiMnuLst sapUiMnuNoIco sapUiMnuNoSbMnu')]//*[contains(./@aria-posinset, '2')]"));
			if (qwe != null) {
				qwe.click();
				System.out.println("AddandNewButton Clicked");
			} else {
				System.out.println("AddandNewButton Null");
			}
			// div[contains(./@id, '__popup') and contains(./@id,
			// 'buttons')]//*[contains(./@class, 'sapUiMenuButton') and
			// contains(./@id, 'button')]
			// elementToClick(
			// By2.ByclassNameandPartialId("sapUiMenuButton", "button"),
			// waittime);

		} else {
			System.out.println(" Condition false for AddandNewButton");
		}
	}
}
