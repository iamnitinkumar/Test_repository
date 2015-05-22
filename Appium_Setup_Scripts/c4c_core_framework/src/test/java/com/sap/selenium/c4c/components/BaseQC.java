package com.sap.selenium.c4c.components;


/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceRunner;

public abstract class BaseQC extends Base {
	
	public BaseQC(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}



	protected String qcName;
	
	protected String saveMenuPartialId;
	protected String saveAndOpenPartialId;
	protected String saveAndNewPartialId;
	protected String savePartialId;
	protected String cancelPartialId;
	
	private String saveAndOpenMeasurement = "Save_and_Open_QC_";
	private String saveAndNewMeasurement  = "Save_and_New_QC_";
	private String saveMeasurement        = "Save_QC_";
	

	
	abstract protected Map<String, String> getTexts();
	
	/**
	 * Adds all texts of the UI component in the current login language to an Excel spreadsheet
	 * In case the file is empty, first line will contain the IDs, second line the texts. 
	 * In case there are already entries in the file, only the new texts will be added 
	 * @param fullFileName
	 * @param language
	 * @throws IOException
	 * 
	 */
	
	protected void create(Map<String, String> data) throws Exception{
		//to be re-defined with thing specific create code
	}
	
	
	protected void selectSaveAction(String partialActionId, String measurementName) throws Exception
	{
	    //Open save menu
	    //Save button and menu trigger start with matching pattern - need to use "MEN" to find right one
		System.out.println("In Select and Save");
		Thread.sleep(7000);
		System.out.println("Goin in click1");
		this.elementToClick(By2.startsWithAndPartialId(this.saveMenuPartialId, "MEN"), 60);
		Thread.sleep(2000);
		System.out.println("Click 1 done");
		PerformanceRunner.startMeasurement(measurementName+this.qcName);
		this.jsClick(this.elementToFindExplicit(By2.partialId(partialActionId), 60));
		System.out.println("Click 2 done");
		PerformanceRunner.stopMeasurement();
		Thread.sleep(5000);
	}
	
	
	/*
	public void createFromFile(String fileName)
	{
		
	}
	*/
	
	
	public void createAndSave(Map<String, String> data)
			throws Exception {
		System.out.println("In createAndSave");
		this.create(data);
		this.selectSaveAction(this.savePartialId, this.saveMeasurement);
		if(isNotificationMessageAreaExist())
		{
//			Assert.fail(getNotificationMessage());
		}
		System.out.println("Out of create and Save");
	}
	
	
	public void createAndOpen(Map<String, String> data)
			throws Exception {
		this.create(data);
		this.selectSaveAction(this.saveAndOpenPartialId,
				this.saveAndOpenMeasurement);
		if(isNotificationMessageAreaExist())
		{
//			Assert.fail(getNotificationMessage());
//			getNotificationMessage();
//			TakeScreenShot();
		}
	}
	
	public void createAndNew(Map<String, String> data)
			throws Exception {
		this.create(data);
		this.selectSaveAction(this.saveAndNewPartialId,
				this.saveAndNewMeasurement);
		if(isNotificationMessageAreaExist())
		{
//			Assert.fail(getNotificationMessage());
		}
	}
	
/*	
	public void createAndSaveFromFile(String fullFileName) throws InterruptedException
	{
		TestDataLoader tdl = new TestDataLoader();
		
		this.createAndSave(tdl.readSingleExcelSheet(fullFileName));
	}
*/	
	
	
	/**
	 * Check last character, in case it's a ':', strip it off
	 * @param label label 
	 * @return label with last character (in case it's a ':') removed
	 */
	protected String stripOfColon(String label)
	{
		int len = label.length()-1;
		if (label.charAt(len) == ':'    )
			label = label.substring(0, len);
		
		return label;
	}
	
	protected void selectSaveAction2(String partialActionId, String measurementName) throws InterruptedException
	{
		Thread.sleep(7000);
		System.out.println("Goin in click1");
	    //Open save menu
	    //Save button and menu trigger start with matching pattern - need to use "MEN" to find right one
		this.elementToClick2(By2.startsWithAndPartialId(this.saveMenuPartialId, "MEN"), 60);
		Thread.sleep(2000);
		PerformanceRunner.startMeasurement(measurementName+this.qcName);
		this.jsClick(this.elementToFindExplicit2(By2.partialId(partialActionId), 60));
		PerformanceRunner.stopMeasurement();
		Thread.sleep(5000);
	}
	
}

