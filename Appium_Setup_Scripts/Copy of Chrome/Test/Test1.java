package Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Test1 {
	 AppiumDriver driver;
	//RemoteWebDriver driver;
  @Test
  public void f() {
	  System.out.println("--Test Passed--");
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	 // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	  //WebDriver firefoxdriver=new FirefoxDriver();
	 // firefoxdriver.get("https://www.google.co.in");
	  DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("deviceName", "NexusOne");
      capabilities.setCapability("version", "4.1");
      capabilities.setCapability("newCommandTimeout", 240);
     
	try {
		//driver = new AppiumDriver(new URL("http://127.0.0.1:9515/wd/hub"), capabilities);
		driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get("http://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.findElement(By.cssSelector("input#onefield")).sendKeys("hi");
		wait.until(ExpectedConditions.elementToBeClickable((By.linkText("Log In"))));
		driver.findElement(By.linkText("Log In")).click();

		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("input#user_login"))));
		driver.findElement(By.cssSelector("input#user_login")).sendKeys("abdc");
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("input#user_pass"))));
		driver.findElement(By.cssSelector("input#user_pass")).sendKeys("login");
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("input#rememberme"))));
		driver.findElement(By.cssSelector("input#rememberme")).click();
		driver.get("https://www.google.co.in");
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("input#lst-ib"))));
		driver.findElement(By.cssSelector("input#lst-ib")).sendKeys("bye");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
  	//driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
  }

}
