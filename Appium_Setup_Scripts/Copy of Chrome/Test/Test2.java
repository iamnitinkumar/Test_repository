package Test;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
		public static void main(String[] args) throws MalformedURLException {
			AppiumDriver driver1;
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			capabilities.setCapability("platformName", "Android");
		    capabilities.setCapability("deviceName", "Nexus One");   
			//capabilities.setCapability("version", "4.1");
			capabilities.setCapability("newCommandTimeout", 180);

			driver1 = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver1.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			driver1.get("https://pay.airtel.com/online-payments/prepaidResponse.do");
			//driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver1.manage().window().maximize();
			WebElement element1 = driver1.findElement(By.xpath("//select[@name='payAmount']"));
				//	("//select[@id='amountsList']"));
	        Select sel1 = new Select(element1);

	        List <WebElement> alloptions = sel1.getOptions();
	      ///   System.out.println(alloptions);
	        for (WebElement kk:alloptions) {
	        	
	        	System.out.println(kk.getText());
	        	  }
	        
	        
	       // driver1.quit();
		}

	}

