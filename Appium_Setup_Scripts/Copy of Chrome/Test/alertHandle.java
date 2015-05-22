package Test;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class alertHandle {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		AppiumDriver driver1;
		DesiredCapabilities capabilities = new DesiredCapabilities();


		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("platform", "Android");
		capabilities.setCapability("version", "4.1");
		capabilities.setCapability("newCommandTimeout", 180);

		driver1 = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver1.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver1.get("https://portal1.bsnl.in/aspxfiles/instaMobpay.aspx");
	//	driver1.manage().window().maximize();
		driver1.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		Alert alert = driver1.switchTo().alert();
		Thread.sleep(10000);
		System.out.println(driver1.switchTo().alert().getText());
		Thread.sleep(10000);
		alert.accept();
		driver1.quit();


	}

}
