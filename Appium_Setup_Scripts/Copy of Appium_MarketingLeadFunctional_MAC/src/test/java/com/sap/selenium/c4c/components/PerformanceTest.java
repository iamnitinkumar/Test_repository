package com.sap.selenium.c4c.components;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
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

@RunWith(PerformanceRunner.class)
public abstract class PerformanceTest {
	protected static WebDriver driver;
	protected static NavigationBar navigationBar;
	protected static ShellToolPaletteArea toolArea;
	protected static AccessHelper accessHelper;

	@BeforeClass
	public static void openBrowser() throws MalformedURLException {
		System.out.println("HI");
		String PROXY;
	
		if (Integer.parseInt(PerformanceRunner.getProperty("supaIterations")) > 0) { 
			PROXY = "localhost:9090"; 
		} else {
			System.out.println("proxy8080");
			PROXY = "proxy:8080"; 
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
			
			driver = new ChromeDriver(cap);
		} else if (PerformanceRunner.getProperty("supaBrowser").equals("iexplore")) {
			System.setProperty("webdriver.ie.driver","C:\\IEDriverServer_x64_2.42.0\\IEDriverServer.exe");
			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			proxy.setHttpProxy(PROXY).setSslProxy(PROXY);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.PROXY, proxy);
			cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);

			driver = new InternetExplorerDriver(cap);
			driver.manage().window().maximize();
		} 
		//--------------Appium Intialisation------------------
		else if(PerformanceRunner.getProperty("supaBrowser").equals("appium")){
			System.out.println("in appium setup");
			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			proxy.setHttpProxy(PROXY).setSslProxy(PROXY);
			  DesiredCapabilities capabilities = new DesiredCapabilities();
			    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Safari");
			    capabilities.setCapability("platformName", "iOS");
			    capabilities.setCapability("deviceName", "iPad Simulator");
			   // capabilities.setCapability("nativeWebTap", true);
		      //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		     // capabilities.setCapability("platformName", "Android");
		     // capabilities.setCapability("deviceName", "NexusOne");
		      capabilities.setCapability("newCommandTimeout", 2400);
		      capabilities.setCapability(CapabilityType.PROXY, proxy);
		      System.out.println("driver intialisation");
		      System.out.println(capabilities);
		      driver=new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				//driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
				System.out.println(driver);
				System.out.println("driver created");
			    /*  JavascriptExecutor js=(JavascriptExecutor) driver;
			      HashMap<String,Double>wait1 =new HashMap<String, Double>();
			      wait1.put("timeout", (double) 250);
			      js.executeScript("mobile: setCommandTimeout", wait1);*/
				//driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			
		}
		//----------------------------------------------------
		else {
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
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
	
		
		navigationBar = new NavigationBar(driver);
		toolArea      = new ShellToolPaletteArea(driver);
		accessHelper  = new AccessHelper(driver);
		
	}
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}		
}
