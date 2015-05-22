package com.sap.selenium.c4c.components;

/*import org.openqa.selenium.By;*/
/*import org.openqa.selenium.Keys;*/
import java.util.Set;

import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
	protected String filterEnd = "icon";
	
	
	
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
		Thread.sleep(10000);
		boolean woCAvailable=false;
		int checks=0;
		
		if(this.doesElementExist(By2.className(woCSroll))){
			do{
				try{
					//Changes Made for Appium----------------------
					this.elementToFindExplicit(By.id(woCScrollMobile), 60);//Added
					this.elementToClick(By.id(woCScrollMobile), 60);//Added
					System.out.println("Wocscroll for Mobile opened");
					if(this.doesElementExist(By2.text("Marketing")) || this.doesElementExist(By2.linkText(owlName))){//this.doesElementExist(By2.text("Marketing")) || 
						System.out.println("If Marketing");
						woCAvailable=true;
						//this.elementToClick(By2.linkText(owlName), 60);		
						this.elementToClick(By2.text("Marketing"), 60);//Added
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
				Thread.sleep(10000);
				System.out.println("Else Marketing");
				//Changes made for Appium
				Thread.sleep(25000);
				//this.jsClick(this.elementToFindExplicit(By2.partialId(woCScrollMobile), 60));
				this.jsClick(this.elementToFindExplicit(By2.CssPath("#sapOberonMobileWorkcenter-wocbutton-img"), 60));
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				//js.executeScript("document.querySelector('#sapOberonMobileWorkcenter-wocbutton-img').click();");
				System.out.println("Clicked Menu");
				//driver.findElement(By2.partialId(woCScrollMobile)).click();
				//this.elementToFindExplicit(By.id(woCScrollMobile), 60);
				//this.elementToClick(By.id(woCScrollMobile), 60);
				this.elementToClick(By2.text(owlName), 60);
				//this.elementToClick(By2.linkText(owlName), 60);				
			}
			catch(Exception e){
				Assert.fail("OWL " + owlName + " not found in WebPage" + e.getLocalizedMessage());
			}
		}
		
		try{
			System.out.println("Leads opened");
			PerformanceRunner.startMeasurement(metricName);
			//this.navigateToTab(tabName); //change in ie
			this.elementToClick(By2.text(tabName), 60);
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
		System.out.println("in simple search text");
		Thread.sleep(5000);
		 this.navigate();
		 PerformanceRunner.startMeasurement("SimpleSearch_"+this.owlName);
		 this.elementToFindExplicit(simpleSearch, 10).sendKeys(simpleSearchText);
		 PerformanceRunner.stopMeasurement();
		 Thread.sleep(5000);
		 
		 PerformanceRunner.startMeasurement("Open_TI_"+this.owlName);
		 this.elementToFindExplicit(firstRow, 10).click();
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
		
		System.out.println("In simple search");
		PerformanceRunner.startMeasurement("Search_"+this.tabName);
		this.elementToSendKey(By2.startsWithAndPartialId(simpleSearchStart, simpleSearchEnd), 60, searchTerm);
		PerformanceRunner.stopMeasurement();
		
		Thread.sleep(20000);
		
	}
	
	public void openTI(String linkText)throws Exception{
		System.out.println("In open ti");
		Thread.sleep(10000);                  
		PerformanceRunner.startMeasurement("Open_TI_"+this.tabName);
		this.elementToClick(By2.partialLinkText(linkText), 70);
		PerformanceRunner.stopMeasurement();
		Thread.sleep(20000);
		System.out.println("Out open Ti");
	}
	public void openTI1()throws Exception{
		System.out.println("In open ti");
		Thread.sleep(10000);                  
		PerformanceRunner.startMeasurement("Open_TI_"+this.tabName);
		this.elementToClick(By2.Xpath("//*[contains(./@id,'-col0-row0')]"), 70);
		//driver.findElement(By.xpath("//*[contains(./@id,'-col0-row0')]")).click();
		//System.out.println(By2.Xpath("//table[contains(./@id, '" + table_PartialId + "') ]//tbody//tr[1]//td[1]//div//div//a[contains(./@id,'-col0-row1')]"));
		PerformanceRunner.stopMeasurement();
		Thread.sleep(20000);
		System.out.println("Out open Ti");
	}
	
	
}
