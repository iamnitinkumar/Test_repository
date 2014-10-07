package utils;

import io.appium.java_client.AppiumDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import logger.LoggerStatus;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.Reporter;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class GetData {
	
	Map<String, String> parameters 		= new HashMap<String, String>();
	private static GetData instance 	= null;
	public static String pass 			= "=\"green\">TEST PASSED<";
	public static String fail 			= "=\"red\">TEST FAILED<";
	public static int successCounter 	= 0;
	public static int  failureCounter 	= 0;
	public static int  sFailureCounter 	= 0;
	public int scenarioCount			= 0;
	public int sCount 					= 0;
	public int fCount 					= 0;
	private String stCount				= "";
	
	public static Logger logger=Logger.getLogger(GetData.class.getName());
	
    public static GetData getInstance() throws ClassNotFoundException {
        if(instance == null) {
           instance = new GetData();
        }
        return instance;
      }

	   public String readInternalHash(String param)
	   {
	 	  if(parameters.containsKey(param.toLowerCase()))
	 	  {
	 		  return parameters.get(param);
	 	  }
	 	  else
	 	  {
	 		  return "";
	 	  }
	   }
	   
	   public void reportStatusDisplayedText( RemoteWebDriver driver, int count,String msg,String path,String selection) throws ClassNotFoundException
	   {  
		   By by = null;
		   try
		   {
			   if(selection.toLowerCase().equals("xpath"))
			   {
				  by = By.xpath(path);
			   }
			   else if(selection.toLowerCase().equals("id"))
			   {
				  by = By.id(path);
			   }
			   else if(selection.toLowerCase().equals("name"))
			   {
				   by = By.name(path);
			   }
			   if(!driver.findElement(by).isDisplayed())
			   {
				   GetData.failureCounter++;
				   LoggerStatus.getInstance().report_results(GetData.getInstance().readInternalHash("filename"),count, msg, fail);
				   scenarioCount++;
				   Assert.assertTrue(driver.findElement(by).isDisplayed(),"ERROR: " + msg);
				   ATUReports.add(msg, "arg1", "arg2", "arg3", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			   }
			   else
			   {
				   GetData.successCounter++;
				   LoggerStatus.getInstance().report_results(GetData.getInstance().readInternalHash("filename"),count, msg, pass);
				   ATUReports.add(msg, "arg1", "arg2", "arg3", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			   }
		   }
		   catch(Throwable e)
		   {
			   GetData.failureCounter++;
			   LoggerStatus.getInstance().report_results(GetData.getInstance().readInternalHash("filename"),count, msg, fail);
			   scenarioCount++;
			   logger.error("ERROR: Test Case ID: " + stCount +"\n" + e.getMessage() + "\nExpected: "+ msg + "\nActual: " +msg + " - failed");
			   Assert.assertTrue(driver.findElement(by).isDisplayed(),"ERROR: " + msg);
			   
		   }
	   }

	   public void setLogging(int testScenarioCount, String filename,String msg) throws ClassNotFoundException, IOException
	   {
		   String testScenarioId=new String("TC");
			
			if(testScenarioCount>=0 && testScenarioCount<=9)
			{
				testScenarioId=testScenarioId+"00"+testScenarioCount;
			}else if(testScenarioCount>=10 && testScenarioCount<=99)
			{
				testScenarioId=testScenarioId+"0"+testScenarioCount;
			}else if(testScenarioCount>=100 && testScenarioCount<=999)
			{
				testScenarioId=testScenarioId+testScenarioCount;
			}else if(testScenarioCount>=1000 && testScenarioCount<=9999)
			{
				testScenarioId=testScenarioId+testScenarioCount;
			}
		   Reporter.log("*************************************************", true);
		   stCount = testScenarioId;
		   GetData.getInstance().readEntirePropertyFile(filename);
		   LoggerStatus.getInstance().report_testcasedescription(GetData.getInstance().readInternalHash("filename"),testScenarioId,msg);
		   LoggerStatus.getInstance().report_header(GetData.getInstance().readInternalHash("filename"));
		   Reporter.log(msg, true);
	   }
	   
	   public void readEntirePropertyFile(String filename) throws IOException
	   {
		   	File file = new File(filename);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			Enumeration<?> e = properties.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = properties.getProperty(key);
				
				parameters.put(key.toLowerCase(), value);
			}
	   }
	   
	   
	   public void writeMultiplePropertiesToFile(String[] paramStrings,String[] valueStrings,String filename) throws IOException
	   {
		   FileInputStream in = new FileInputStream(filename);
	        Properties props = new Properties();
	        props.load(in);
	        in.close();

	        FileOutputStream out = new FileOutputStream(filename);
	        for(int i=0; i < paramStrings.length; i++) 
	        	props.setProperty(paramStrings[i], valueStrings[i]);
	        
	        props.store(out, null);         
	        out.close();
	        
	        
	        //To remove the comments written due to store()
	        BufferedReader br = new BufferedReader(new FileReader(filename));
	        String line;
	        String data = "";
	        
	        while ((line = br.readLine()) != null) {
	           if(line.charAt(0) != '#') {
	        	   line = line.replace('=', ':');
	        	   data += line + "\n";
	           }
	        }
	        br.close();
	        
	        PrintWriter pw = new PrintWriter(filename);
	        pw.write(data);
	        pw.close();
	    }
	   
	  	public void atuMethod(String TestCaseRequirement){
			ATUReports.setAuthorInfo("Jyothi", Utils.getCurrentTime(), "1.0");
		     ATUReports.setTestCaseReqCoverage(TestCaseRequirement);
	  		
	  	}
	  	
	  	public void scrollTo(String text,AppiumDriver driver)
		{
			try
			{
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				RemoteWebElement element = (RemoteWebElement) driver.findElement(By.tagName("tableview"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String widId = ((RemoteWebElement) element).getId();
				scrollObject.put("element", widId);
				js.executeScript("mobile: scroll", scrollObject);
			}
			catch(NoSuchElementException E)
			{
				E.printStackTrace();
			}
		}
}
