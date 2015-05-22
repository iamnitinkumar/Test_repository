package com.sap.selenium.c4c.components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.Keys;//
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sap.selenium.c4c.components.PerformanceRunner;


public class AccessHelper {
	private static WebDriver driver;
	protected static By userID=By.id("__screen0-user");
	protected static By password=By.id("__screen0-pass");
	protected static By loginButton=By.id("__screen0-logonBtn");
	protected static By loginLanguage=By.id("__screen0-langdd-input");
	protected static By logOut=By.id("main-logout");
	protected static By logOutConfirm=By.id("__button");
	protected static String loginLanguageMobile="#__screen0-langdd-select";
	
	
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void ClickNoSaveTI(){
		if(elementtofind(By.id("WP_NO"))==true){
			 driver.findElement(By.id("WP_NO")).click();
			}
			else{
				return;
						
			}
		
	}

	public static void ClickinPopUp(String label){
		if(elementtofind(By2.text(label))==true){
			 driver.findElement(By2.text(label)).click();
			}
			else{
				return;
						
			}
		
	}
	
	public AccessHelper(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
	public static WebElement getSimpleSearchField()
	{
		//"BasicFind1-cb-input" - partial Id does not work with full name, leave out last character
		return driver.findElement(By2.startsWithAndPartialId("BasicFind", "-cb-inpu"));
	}
	
	public static WebElement getFilterMenuButton()
	{
	    return driver.findElement(By2.startsWithAndPartialId("DefaultSetDropDown", "-ico"));
	}
	
	public static WebElement getLinkInListByRowCol(int row, int col)
	{
		return driver.findElement(By2.startsWithAndPartialId("link", "-col"+col+"-row"+row));
	}
	
    public void jsClick(WebElement element)
    {
    	JavascriptExecutor js;
		js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
    }
    
    public static void simplesearch(String valuetosearch, boolean tomeasure, String measurementName ) throws InterruptedException{
	    
    	WebElement SimpleSearchElement;
    	
    	  	
    	if(elementtofind(By2.startsWithAndPartialId("BasicFind", "-cb-inpu"))==true){
    		SimpleSearchElement = driver.findElement(By2.startsWithAndPartialId("BasicFind", "-cb-inpu"));
    		if (tomeasure==true){
    			NavigationBar.ToMeasureSendKey(SimpleSearchElement,measurementName,valuetosearch); 
    		}
    		else{
    			SimpleSearchElement.sendKeys(valuetosearch);
    		}
    		
			
		}
		else{
			return;
					
		}
    	
    	
        
        Thread.sleep(3000);
               
    
    }
public static void DisplayAll(String Measurement, Boolean ToMeasure) throws InterruptedException{
    
	WebElement DisplayAll;
	
	if(AccessHelper.elementtofind(By2.startsWithAndPartialId("DefaultSetDropDown", "-icon"))==true){
		DisplayAll = driver.findElement(By2.startsWithAndPartialId("DefaultSetDropDown", "-icon"));
		DisplayAll.click();
		
		
	}
	else{
		
		return;
	}
    //DisplayAll= AccessHelper.getFilterMenuButton();
    
    if(AccessHelper.elementtofind(By2.text("All"))==true){
		DisplayAll = driver.findElement(By2.text("All"));
		 if(ToMeasure==true){
		    	
		    	NavigationBar.ToMeasure(DisplayAll, Measurement);
		    	
		    }
		    else{
		    	DisplayAll.click();                                              
		    }
	}
	else{
		
		return;
	}  
                            
    Thread.sleep(10000); 
}

public static Boolean doeselementexist(By by){
	WebElement element;
	
	element=driver.findElement(by);
	if(element.isDisplayed()==true){	
		return true;
	}
	else{		
		return false;
	}
}

//Open WOC//
public static void OpenWoC(String WoC) throws InterruptedException{
	WebElement WoCElement;
	WebElement scrollOpenWoC;
	boolean WoCAvailable=false;
	int i=0;	
	
	if(AccessHelper.doeselementexist(By.className("sapUiUx3NavBarForward"))==true){
		scrollOpenWoC = driver.findElement(By.className("sapUiUx3NavBarForward"));
		
		do{
			try
			{
				
				WoCElement = driver.findElement(By.linkText(WoC));
                if(WoCElement.isDisplayed()==true){   
                       WoCAvailable=true;                       
                       WoCElement.click();                      
				
				}    			    			      
			}
			catch (WebDriverException e)
			{				
				i++;
				scrollOpenWoC.click();
				if(i>4){
					break;
				}    			
			}
		}
		while(WoCAvailable==false); 	
	}
	else{
		
		if(AccessHelper.elementtofind(By.linkText(WoC))==true){
			WoCElement = driver.findElement(By.linkText(WoC));
			WoCElement.click();
		}
		else{
				return;
			} 
			
	}
}
	              

		//Close TI//
		public static void CloseTI() throws InterruptedException{
	    	WebElement CloseTIElement;
	    	if(AccessHelper.elementtofind(By.className("sapUiUx3OverlayCloseButton"))==true){
	    		CloseTIElement = driver.findElement(By.className("sapUiUx3OverlayCloseButton"));
		        CloseTIElement.click();
	    	}
	    	else{
				return;
			} 
	        
	        Thread.sleep(3000);                       
	    }
		//OPen Facet//
		public static void openfacet(String Facet, Boolean ToMeasure,String Measurement) throws InterruptedException{
	    	WebElement ElementFacet;
	        WebElement selectfacetmenu;
	        
	        
	    selectfacetmenu = driver.findElement(By.className("sapUiUx3NavBarForward"));
	    ElementFacet = driver.findElement(By2.text(Facet));
	    while(ElementFacet.isDisplayed()==false){
	    	selectfacetmenu.click();
	        Thread.sleep(2000);
	        ElementFacet = driver.findElement(By2.text(Facet));
	    }
	    if(ToMeasure==true){
	    	NavigationBar.ToMeasure(ElementFacet, Measurement);
	    }
	    Thread.sleep(3000);
	}
		//Quick Create//
		public static void quickcreate(Boolean tomeasure, String measurementName)throws InterruptedException{
	    	
	    	String xpath;
	    	xpath = "//button[contains(text(),'New')]";
	    	
	    	Thread.sleep(2000);
	    	
	    	WebElement TabName;
	    	
	    	if(AccessHelper.elementtofind(By.xpath(xpath))==true){
	    		TabName = driver.findElement(By.xpath(xpath));
    		
		    	if (tomeasure==true){
		        	NavigationBar.ToMeasure(TabName,measurementName);                      
		        }
		        else{ 
		        	TabName.click();              
		        }
	    	}
	    	else{
	    		return;
	    				
	    	}	
	    }
		
		//OPENTI//
		public static void openTIfromName(Boolean tomeasure, String Measurement, String linkText) throws InterruptedException{
	    	
	    	WebElement FirstItemInList;
	        FirstItemInList = driver.findElement(By.partialLinkText(linkText));
	        if(tomeasure==true){
	        	NavigationBar.ToMeasure(FirstItemInList, Measurement);
	        }
	        else{
	        	FirstItemInList.click();
	        }
	        Thread.sleep(10000);
	    
	    }
		
		 public static Date addDays(Date d, int days)
		    {
		    	
		    	
		    	Calendar calendar = Calendar.getInstance(); 
		    	calendar.setTime(d);
		    	calendar.add(Calendar.DATE, days);
		    	return calendar.getTime();
		    	
		    }
		 
		 
		 public static void logout(String language) throws InterruptedException{
			 Thread.sleep(5000);
			 	 elementToFindExplicit(logOut, 5).click();
			 	 ///elementToFindExplicit(logOutConfirm,5).click();
			 	
			 	 switch(language){
			 	 case "English":
			 		elementToFindExplicit(By2.text("Yes"), 5).click();
			 		break;
			 	 case"German":
			 		elementToFindExplicit(By2.text("Ja"), 5).click();
			 		break;
			 	 case"Spanish":
			 		elementToFindExplicit(By2.text("S�"), 5).click();
			 		break;
			 	 case"French":
			 		elementToFindExplicit(By2.text("Oui"), 5).click();
			 		break;
			 	 default:
			 		elementToFindExplicit(By2.partialId("__button"),5).click();
			 		break;
			 	 }
			 	 Thread.sleep(7000);
				 System.out.println("Logged out");
		 }
		 //----------------Appium-------------------------------------------------
		 public static void login(String language) throws Exception{
			 driver.get(PerformanceRunner.getProperty("aut"));
			 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(40000);
			System.out.println("Done Login");
			 elementToFindExplicit(userID, 10).sendKeys(PerformanceRunner.getProperty("PerformanceAlias"));
			 elementToFindExplicit(password, 10).sendKeys(PerformanceRunner.getProperty("PerformancePassword"));
			 elementToClickMobile(By.cssSelector("#__screen0-langdd-select"), 60);
             Thread.sleep(5000);
             elementToClickMobile(By2.Xpath("//*[contains(text(),'Spanish')]"), 60);
             elementToClickMobile(By2.Xpath("//*[contains(text(),'"+language+"')]"), 60);
			 elementToFindExplicit(loginButton, 15).click();
	            // driver.findElement(By.cssSelector("#__screen0-langdd-select")).click();
		       //driver.findElement(By.xpath("//*[contains(text(),'Spanish')]")).click();
		       // driver.findElement(By.xpath("//*[contains(text(),'English')]")).click();
			 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		    }
		 //-------------------------------------------------------------------
		 
		 //Login for IE
/*		 public static void login(String language) throws InterruptedException{
			 driver.get(PerformanceRunner.getProperty("aut"));
			 elementToFindExplicit(userID, 5).sendKeys(PerformanceRunner.getProperty("PerformanceAlias"));
			 elementToFindExplicit(password, 5).sendKeys(PerformanceRunner.getProperty("PerformancePassword"));
			 //To add change of language
			 elementToFindExplicit(loginLanguage, 5).click();
			 elementToFindExplicit(loginLanguage, 5).clear();
			 elementToFindExplicit(loginLanguage, 5).sendKeys(language);
			 elementToFindExplicit(loginLanguage, 5).sendKeys(Keys.ENTER);
			 
			 
			 
			 elementToFindExplicit(loginButton, 5).click();
		    }
		 */
		 
		 
		 
		 public static String getname(Integer nametype){
			
		 		String name;
		    	String dateStr = Integer.toString(randInt(1000,100000));
		    	
		    	switch(nametype){
		    	case 4: name="Appointment "+dateStr;
		    				 break;
		    	case 5: name="New Task from Selenium "+dateStr;
		    				break;
		    	case 6: name="New Campaign from Selenium "+dateStr;
		    				break;
		    	case 2: name="New Lead from Selenium "+dateStr;
							break;
		    	case 3: name="New Opportunity from Selenium "+dateStr;
							break;
		    	case 1: name="CustomerSelenium"+dateStr;
							break;
		    	default: name="Created from Selenium "+dateStr;
		    					break;
		    	}
		 		
		 		//System.out.print(name);
		    	
		 		return name;
		 	}
		 
		  public static void TIEdit(Boolean tomeasure, String measurementName) throws InterruptedException{
		    	
			  		    	
		    	if(AccessHelper.elementtofind(By.xpath("//button[contains(text(),'Edit')]"))==true){
		    		WebElement TabName = driver.findElement(By.xpath("//button[contains(text(),'Edit')]"));
			    	
			       	
			    	if (tomeasure==true){
			        	NavigationBar.ToMeasure(TabName,measurementName);                      
			        }
			    	
			        else{ 
			        	TabName.click();              
			        }
		    	}
		    	else{
		    		return;
		    				
		    	}
		    	
		    	
		    	Thread.sleep(1000);
		    	
		    }
		  
		  public static boolean elementtofind(By by)
		    {
		        final int MAXIMUM_WAIT_TIME = 10;
		        final int MAX_STALE_ELEMENT_RETRIES = 6;		       
		        
		        WebDriverWait wait = new WebDriverWait(driver, MAXIMUM_WAIT_TIME);
		        int retries = 0;
		        while (true)
		        {
		            try
		            {
		                wait.until(ExpectedConditions.elementToBeClickable(by));

		                return true;
		            }
		            catch (StaleElementReferenceException e)
		            {
		                if (retries < MAX_STALE_ELEMENT_RETRIES)
		                {
		                    retries++;
		                    continue;
		                }
		                else
		                {
		                    return false;
		                }
		            }
		        }
		    }
		  
		  public static WebElement elementToFind(By by, int waitTime)
		    {
			    driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
			   try{
				   return driver.findElement(by);
			    }
		        catch (Exception e)
		        	{
		        		throw e;
		        	}	    
		    			        
		    }
		  
		  public static WebElement handleMultiple(By by) {
              //WebElement element;
              List<WebElement> ele = driver.findElements(by); 
              for ( WebElement elem : ele){
                     System.out.println(elem.getAttribute("id")); //remove
                     System.out.println(elem.getTagName()); //remove
                     System.out.println(elem.isDisplayed()); //remove
                     if (elem.isDisplayed() == true) {
                           return elem;
                     }
              }
              return null;
       }

		  	public static WebElement elementToFindExplicit(By by, int waitTime)
		    {
		  		
		        WebDriverWait wait = new WebDriverWait(driver, waitTime);
		        
		        try
		            {
		                wait.until(ExpectedConditions.elementToBeClickable(by));
		                return driver.findElement(by);
		            }
		            catch (Exception e)
		            {
		                throw e;
		                    
		            }
		    }
		  	//-------Added method for Appium--------------------
			public static boolean elementToClickMobile(By by, int waitTime) {

				boolean isClicked = false;
				if (driver.findElements(by).size() != 0) {
					System.out.println("In element to click");
					driver.findElement(by).click();
					isClicked = true;
				} else {
					System.out.println("Element Button does not Exist");
					isClicked = false;
				}
				return isClicked;

			}
			//------------------------------------------------------
}





