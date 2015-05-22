package Test;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mobile {
	WebDriver driver;
	public void dropdown() throws MalformedURLException, InterruptedException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "NexusOne");
		capabilities.setCapability("version", "4.1");
		capabilities.setCapability("newCommandTimeout", 240);
		driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get("https://vf4-cust233.dev.sapbydesign.com/");
		//WebDriverWait wait=new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("__screen0-langdd-input")));
	//	driver.findElement(By.id("__screen0-langdd-input")).click();
/*		WebElement select;
		select=driver.findElement(By.id("__screen0-langdd-input"));
		List<WebElement> options;
		options=select.findElements(By.tagName("option"));
		for(WebElement option : options){
			System.out.println(option);
		//	if("Germany".equalsIgnoreCase(option.getText()))
				//option.click();
		}*/


 driver.findElement(By.id("__screen0-langdd-select")).click();
 Thread.sleep(5000);
 driver.findElement(By.xpath("//*[contains(text(),'Spanish')]")).click();
 System.out.println("clicked spanish");
 Thread.sleep(2000);
 driver.findElement(By.xpath("//*[contains(text(),'English')]")).click();
 System.out.println("clicked english");
 driver.findElement(By.cssSelector("#__screen0-logonBtn")).click();
System.out.println("done");

	}
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		
		mobile m=new mobile();
		m.dropdown();
	}


}
