package com.sap.selenium.c4c.components;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(PerformanceRunner.class)
public abstract class PerformanceTest {
	//protected static AppiumDriver driver;
	protected static WebDriver driver;
	protected static NavigationBar navigationBar;
	protected static ShellToolPaletteArea toolArea;
	protected static AccessHelper accessHelper;

	@BeforeClass
	public static void openBrowser() throws MalformedURLException {
		String PROXY;
		if (Integer.parseInt(PerformanceRunner.getProperty("supaIterations")) > 0) { 
			PROXY = "localhost:9090"; 
			System.out.println("localhost:9090");
		} else {
			PROXY = "proxy:8080"; 
			System.out.println("proxy:8080");
		}
		
		if (PerformanceRunner.getProperty("supaBrowser").equals("chrome")) {
			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			proxy.setProxyType(ProxyType.MANUAL);
			proxy.setHttpProxy(PROXY).setSslProxy(PROXY);
			proxy.setNoProxy("localhost");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.PROXY, proxy);
			cap.setCapability("nativeEvents", false);
			cap.setCapability("chrome.switches", Arrays.asList("--disable-translate"));
			
			//driver = new ChromeDriver(cap);
		} else if (PerformanceRunner.getProperty("supaBrowser").equals("iexplore")) {
			
			System.setProperty("webdriver.ie.driver","C:\\IEDriverServer_x64_2.42.0\\IEDriverServer.exe");
			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			proxy.setHttpProxy(PROXY).setSslProxy(PROXY);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.PROXY, proxy);
			cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			System.out.println("in ie setup");
			driver = new InternetExplorerDriver(cap);//Changes Required
		} 
		
		//--------------Appium Intialisation------------------
		else if(PerformanceRunner.getProperty("supaBrowser").equals("appium")){
				System.out.println("Appium setup");
				org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
				proxy.setHttpProxy(PROXY).setSslProxy(PROXY);
			  DesiredCapabilities capabilities = new DesiredCapabilities();
		      capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		      capabilities.setCapability("platformName", "Android");
		      capabilities.setCapability("deviceName", "NexusOne");
		      capabilities.setCapability("version", "4.0.4");
		      capabilities.setCapability("newCommandTimeout", 1200);
		      capabilities.setCapability(CapabilityType.PROXY, proxy);
		      driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
/*			      JavascriptExecutor js=(JavascriptExecutor) driver;
			      HashMap<String,Double>wait1 =new HashMap<String, Double>();
			      wait1.put("timeout", (double) 250);
			      js.executeScript("mobile: setCommandTimeout", wait1);*/
				//driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			
		}
		//----------------------------------------------------
		
		else {
			System.out.println(PerformanceRunner.getProperty("supaBrowser").equals("appium"));
			System.out.println("in firefox");
			FirefoxProfile profile = new FirefoxProfile();
			
			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			proxy.setProxyType(ProxyType.MANUAL);
			proxy.setHttpProxy(PROXY).setSslProxy(PROXY);
			proxy.setNoProxy("localhost");
			//profile.setProxyPreferences(proxy);
			
			System.out.println("AreNativeEventsEnabled: " + profile.areNativeEventsEnabled());
			profile.setEnableNativeEvents(false);
			System.out.println("NativeEvents explicitly disabled");
		
			//driver = new FirefoxDriver(profile);
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);		
		//driver.manage().window().maximize();
		
		navigationBar = new NavigationBar(driver);
		toolArea      = new ShellToolPaletteArea(driver);
		accessHelper  = new AccessHelper(driver); //Changes Required
		
	}
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}		
}
