package logintest;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.GetData;



public class LoginTest {
		private AppiumDriver driver = null;
	 
		@BeforeTest
		public void setup() throws InterruptedException {
			File appDir = new File("./apk");
			File app = new File(appDir, "PI.apk");
	 
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS"); 
			capabilities.setCapability("deviceName","HTC");
			  // capabilities.setCapability("platformVersion", "4.2");
			   capabilities.setCapability("platformName","Android");
			capabilities.setCapability("appPackage", "com.persistent.pi.activity");
			capabilities.setCapability("appActivity", "SplashScreenActivity");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("newCommandTimeout", "2400");
			//capabilities.setCapability("automationName", "Selendroid");
			capabilities.setCapability("autoWebview", true);
			//capabilities.setCapability("appActivity", "com.persistent.pi.activity.SplashScreenActivity");
			try {
				driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(10000);
		}
	 
		@Test
		public void loginTest() throws Exception {
System.out.println(driver.getContextHandles());
	        List<WebElement> weList = null;
	        weList = driver.findElements(By.className("android.widget.EditText"));
	        //driver.findElement(By.xpath("//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[4]/android.widget.EditText[1]")).sendKeys("mayuresh_shirodkar");
	        weList.get(0).sendKeys("mayuresh_shirodkar");
	        weList.get(1).sendKeys("ipl20!51");
	        driver.findElement(By.className("android.widget.Button")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.ListView[1]/android.view.View[3]/android.view.View[3]")).click();	
			
			Thread.sleep(10000);			

			//driver.findElement(By.xpath("//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[4]/android.widget.EditText[1]")).sendKeys("mayuresh_shirodkar");
		//	driver.findElement(By.xpath("//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[6]/android.widget.EditText[1]")).sendKeys("abcd");
			//driver.findElement(By.xpath("//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.Button[1]")).click();
			//Login Done
			//driver.findElement(By.xpath("//android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.ListView[1]/android.view.View[3]/android.view.View[3]")).click();//Leave Apply Click
			driver.findElement(By.xpath("//android.view.View[1]/android.view.View[4]/android.view.View[2]/android.widget.ListView[1]/android.view.View[3]/android.widget.ListView[1]/android.view.View[5]/android.view.View[3]")).click();//Calendar Click
			List<WebElement> numberPickers1 = driver.findElements(By.className("android.widget.NumberPicker"));
			Thread.sleep(10000);
			numberPickers1.get(0).sendKeys("05");
			Thread.sleep(10000);
			numberPickers1.get(1).sendKeys("Oct");
			Thread.sleep(10000);
			numberPickers1.get(2).sendKeys("2014");
			
			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.view.View[1]/android.view.View[4]/android.view.View[2]/android.widget.ListView[1]/android.view.View[3]/android.widget.ListView[1]/android.view.View[6]/android.view.View[3]")).click();//Click Comment
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys("12");//Add comment
			driver.findElement(By.xpath("//android.widget.Button[1]")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.view.View[1]/android.view.View[4]/android.view.View[2]/android.widget.ListView[2]/android.view.View[2]/android.view.View[1]")).click();//Done
			driver.findElement(By.xpath("//android.view.View[1]/android.view.View[4]/android.view.View[2]/android.widget.ListView[2]/android.view.View[2]/android.view.View[1]")).click();

		}
	 
		@AfterTest
		public void tearDown() {
			//driver.quit();
		}



		
}
