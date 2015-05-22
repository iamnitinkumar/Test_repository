package Test;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TestAppium {
    public void createAndroidWebClientDriver() throws MalformedURLException{
/*
		 Thread t = new Thread(new Runnable() {
			 String x;
				public void run() {

				    DesiredCapabilities capabilities = new DesiredCapabilities();  
				    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");        
				    capabilities.setCapability("platformName", "Android");        
				    capabilities.setCapability("deviceName", "Nexus One");        
				  //  capabilities.setCapability("platformVersion", "4.1.2");   
				    capabilities.setCapability("newCommandTimeout", 240);
				    //capabilities.setCapability("setCommandTimeout", "240");
				    AppiumDriver driver;
				    System.out.println("Creating Driver...");
				    try {
						driver = new AppiumDriver(new URL(x), capabilities);
					
				    System.out.println("Driver is created");
				        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
					driver.get(Thread.currentThread().getName());
				    driver.get("https://www.google.co.in/");
				    }catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		 t.start();*/
    DesiredCapabilities capabilities = new DesiredCapabilities();  
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");        
    capabilities.setCapability("platformName", "Android");        
    capabilities.setCapability("deviceName", "Nexus One");        
  //  capabilities.setCapability("platformVersion", "4.1.2");   
    capabilities.setCapability("newCommandTimeout", 240);
    //capabilities.setCapability("setCommandTimeout", "240");
    AppiumDriver driver;
    System.out.println("Creating Driver...");
    driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    System.out.println("Driver is created");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
  /*  JavascriptExecutor js=(JavascriptExecutor) driver;
    HashMap<String,Double>wait1 =new HashMap<String, Double>();
    wait1.put("timeout", (double) 250);
    js.executeScript("mobile: newCommandTimeout", wait1);*/
/*     JavascriptExecutor js=(JavascriptExecutor) driver;
     HashMap<String,Double>wait1 =new HashMap<String, Double>();
     wait1.put("timeout", (double) 250);
     js.executeScript("mobile: setCommandTimeout", wait1);*/
    //System.out.println(driver.getContextHandles());
    //driver.context("WEBVIEW_com.google.android.apps.magazines");
   
    driver.get("https://www.google.co.in/");
    }  
    public static void main(String args[]) throws MalformedURLException{
    	TestAppium test=new TestAppium();
    	test.createAndroidWebClientDriver();
    }
}


