package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Set;

import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;
import com.sap.selenium.c4c.components.PerformanceRunner;



public class BaseOWL extends Base{
	
	public BaseOWL(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	protected String owlName;
	protected String tabName;
	protected String metricName;
	protected String subName;
	
	protected String woCSroll = "sapUiUx3NavBarForward";
	protected String woCScrollMobile="sapOberonMobileWorkcenter-wocbutton-img";
	protected String simpleSearchStart = "BasicFind";
	protected String simpleSearchEnd = "cb-inpu";
	
	
	protected By simpleSearch = By2.startsWithAndPartialId("BasicFind", "-cb-inpu");
	protected By firstRow = By2.startsWithAndPartialId("link", "-col"+0+"-row"+0);
	protected By displayAll = By2.startsWithAndPartialId("DefaultSetDropDown", "ico");
	
	
	protected String filterStart = "DefaultSetDropDown";
	protected String filterEnd = "ico";
	
	
	
	public void navigateFromUser2(String owlName, String tabName) throws Exception
	{
		boolean woCAvailable=false;
		int checks=0;
		
		if(this.doesElementExist(By2.className(woCSroll)))
		{
			do{
				if(this.doesElementExist(By2.linkText(owlName)))
				{
					this.elementToClick(By2.linkText(owlName), 60);	
					Thread.sleep(2000);
					PerformanceRunner.startMeasurement(metricName);
					this.navigateToTab(tabName);
					PerformanceRunner.stopMeasurement();
					Thread.sleep(2000);
					woCAvailable=true;
				}
				else{
					checks++;
					this.elementToClick(By2.className(woCSroll), 60);
					if(checks>4){
						throw new Exception("Work Center not Available for this user, please review assigned work centers");						
					}
					
				}
				
			}
			while(woCAvailable==false);
		}
		else{
			if(this.doesElementExist(By2.linkText(owlName)) == false ){
				throw new Exception("Work Center not Available for this user, please review assigned work centers");
			}
			else{
				this.elementToClick(By2.linkText(owlName), 60);	
				Thread.sleep(2000);
				PerformanceRunner.startMeasurement(metricName);
				this.navigateToTab(tabName);
				PerformanceRunner.stopMeasurement();
				Thread.sleep(2000);
			}
		
			
		}
		
	}
	
	public void navigateFromUser3(String owlName, String tabName) throws InterruptedException
	{
		WebElement elem;
		    elem = driver.findElement(By2.linkText(owlName));
		    elem.click();
		    
		    
		    /*
		    
			elem = getElementProperties(By2.linkText(owlName));
			this.elementToClick(By2.linkText(owlName), 60);	
			Thread.sleep(2000);
			PerformanceRunner.startMeasurement(metricName);
			this.navigateToTab(tabName);
			PerformanceRunner.stopMeasurement();
			Thread.sleep(2000);*/
			
		
		
	}
	
	
	/**
	 * 	
	 * @throws InterruptedException
	 */
	
	public void navigateFromUser(String owlName, String tabName) throws Exception
	{	
		
		//this.elementToClick(By2.linkText(owlName), 60);	
		//this.navigateToTab(tabName);
		
		boolean woCAvailable=false;
		int checks=0;
		
		if(this.doesElementExist(By2.className(woCSroll))){
			do{
				try{
					//Changes Made for Appium----------------------
					this.elementToFindExplicit(By.id(woCScrollMobile), 60);
					this.elementToClick(By.id(woCScrollMobile), 60);
					System.out.println("wocscroll opened");
					if(this.doesElementExist(By2.text("Sales")) || this.doesElementExist(By2.linkText(owlName))){
						System.out.println("Sales Loop");
						woCAvailable=true;
						this.elementToClick(By2.linkText(owlName), 60);		
						//this.elementToClick(By2.text("Sales"), 60);
					}//Changes Made for Appium-------------------
				}
				catch(Exception e){
					checks++;
					this.elementToClick(By2.className(woCSroll), 60);
					if(checks>4){
						break;
					}  
				}
				
			}
			while(woCAvailable==false);
		}
		else{
			try{
				//Changes made for Appium

				this.elementToFindExplicit(By.id(woCScrollMobile), 60);
				this.elementToClick(By.id(woCScrollMobile), 60);
				this.elementToClick(By2.text("Sales"), 60);
				//this.elementToClick(By.id(owlName), 60);
			}
			catch(Exception e){
				Assert.fail("OWL " + owlName + " not found in WebPage" + e.getLocalizedMessage());
			}
		}
		
		try{
			//Changes made for Appium
			System.out.println("Oppurtunity opened");
			PerformanceRunner.startMeasurement(metricName);
			//this.navigateToTab(tabName); //change in ie
			this.elementToClick(By2.text("Opportunities"), 60);
			PerformanceRunner.stopMeasurement();
		}
		catch(Exception e){
			Assert.fail("Tab " + tabName + " not found in WebPage" + e.getLocalizedMessage());
		}
	}
	
	public void navigate() throws Exception
	{	
		
		//this.elementToClick(By2.linkText(owlName), 60);	
		//this.navigateToTab(tabName);
		
		boolean woCAvailable=false;
		int checks=0;
		
		if(this.doesElementExist(By2.className(woCSroll))){
			do{
				try{
					if(this.doesElementExist(By2.linkText(owlName))){
						woCAvailable=true;
						this.elementToClick(By2.linkText(owlName), 60);						
					}
				}
				catch(Exception e){
					checks++;
					this.elementToClick(By2.className(woCSroll), 60);
					if(checks>4){
						break;
					}  
				}
				
			}
			while(woCAvailable==false);
		}
		else{
			try{
				this.elementToClick(By2.linkText(owlName), 60);				
			}
			catch(Exception e){
				Assert.fail("OWL " + owlName + " not found in WebPage" + e.getLocalizedMessage());
			}
		}
		try{
			PerformanceRunner.startMeasurement(metricName);
			this.navigateToTab(tabName);
			PerformanceRunner.stopMeasurement();
		}
		catch(Exception e){
			Assert.fail("Tab " + tabName + " not found in WebPage" + e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * Navigate to sub tab inside the OWL
	 * @param subTabName
	 * @param measurementName
	 * @throws InterruptedException
	 */
	public void navigate(String subTabName, String measurementName) throws InterruptedException
	{
		By tab = By.linkText(this.tabName);
		By subTab = By.linkText(subTabName);
		
		WebElement elem;
		
		elem = this.elementToFindExplicit(tab, 5);
		
		PerformanceRunner.startMeasurement("Open_WoC_"+this.owlName);
		elem.click();
		PerformanceRunner.stopMeasurement();
		
		if ((elem = this.getElementIfExisting(subTab, 5)) != null)
		{
			PerformanceRunner.startMeasurement(measurementName);
			elem.click();
			PerformanceRunner.stopMeasurement();
		}
		
		Thread.sleep(5000);
		
	}
	
	
	
	public void openTIFromSimpleSearch(String simpleSearchText) throws Exception
	{
		 this.navigate();
		 PerformanceRunner.startMeasurement("SimpleSearch_"+this.owlName);
		 this.elementToFindExplicit(simpleSearch, 5).sendKeys(simpleSearchText);
		 PerformanceRunner.stopMeasurement();
		 Thread.sleep(5000);
		 
		 PerformanceRunner.startMeasurement("Open_TI_"+this.owlName);
		 this.elementToFindExplicit(firstRow, 5).click();
		 PerformanceRunner.stopMeasurement();
         Thread.sleep(5000);
	}
	
	
	public void openTIFromSimpleSearchWithFilter(String simpleSearchText, String filter) throws Exception
	{
		this.navigate();
		
		this.elementToFindExplicit(displayAll, 5).click();
		By dropDown = By2.text(filter);
		PerformanceRunner.startMeasurement(filter+"_"+this.owlName);
		this.elementToFindExplicit(dropDown, 5).click();
		PerformanceRunner.stopMeasurement();
		
		this.openTIFromSimpleSearch(simpleSearchText);
	}
	
	public void simpleSearch(String searchTerm)throws InterruptedException{
		
		PerformanceRunner.startMeasurement("Search_"+this.tabName);
		this.elementToSendKey(By2.startsWithAndPartialId(simpleSearchStart, simpleSearchEnd), 60, searchTerm);
		PerformanceRunner.stopMeasurement();
		System.out.println("Simple search done");
		Thread.sleep(3000);
		
	}
	
	public void openTI(String linkText)throws Exception{
		PerformanceRunner.startMeasurement("Open_TI_"+this.tabName);
		this.elementToClickLast(By2.partialLinkText(linkText), 60);
		System.out.println("open ti done");
		PerformanceRunner.stopMeasurement();
		Thread.sleep(10000);
	}
	
	
}
