package Test;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class gsmarena {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		AppiumDriver driver1;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135");
		@SuppressWarnings("static-access")
		DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("platform", "Android");
		capabilities.setCapability("version", "4.1");
		capabilities.setCapability("newCommandTimeout", 180);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		driver1 = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver1.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver1.get("http://www.gsmarena.com/samsung-phones-9.php");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.navigate().refresh();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver1.manage().window().maximize();
		
		List <WebElement> web1 = (List<WebElement>) driver1.findElements(By.xpath("//input[@type='Checkbox']"));
		System.out.println("No of Checkbox present on the webpage is: " +web1.size());

	for (WebElement eachoption:web1) {
			eachoption.click();
		}
		
		List <WebElement> web2 = (List<WebElement>) driver1.findElements(By.xpath("//a"));
		System.out.println("No of Link present on Page is: " +web2.size());
		
		
		List <WebElement> web3 = (List<WebElement>) driver1.findElements(By.xpath("//div[@class='makers']/ul/li/a/strong"));
		
		System.out.println("All the samsung mobile present on page are : ");
	System.out.println("======================================================");
		for (WebElement eachoption1:web3) {
			System.out.println(eachoption1.getText());
		}
		
		System.out.println("Now navigating through each page");
		
		List <WebElement> web4 = (List<WebElement>) driver1.findElements(By.xpath("//div[@class='nav-pages']/a"));

	for (WebElement eachoption2:web4) {
							
				
				System.out.println(eachoption2.getAttribute("href"));
			
		}
		
		//Page Navigation
		web4.get(2).click();
		driver1.navigate().back();
		driver1.navigate().forward();
		driver1.close();
	}

}

