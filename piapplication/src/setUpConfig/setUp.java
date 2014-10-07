package setUpConfig;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import atu.testng.reports.ATUReports;

public class setUp {
	public static AppiumDriver driver;
	public static void SetupDriver() throws ClassNotFoundException, IOException
	{
		utils.GetData.getInstance().readEntirePropertyFile("./data/app.properties");
		File appDir = new File(utils.GetData.getInstance().readInternalHash("apkfoldername"));
		File app = new File(appDir, utils.GetData.getInstance().readInternalHash("apkname"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device",utils.GetData.getInstance().readInternalHash("device"));
		capabilities.setCapability(CapabilityType.BROWSER_NAME, utils.GetData.getInstance().readInternalHash("browser"));
		capabilities.setCapability(CapabilityType.VERSION, utils.GetData.getInstance().readInternalHash("version"));
		capabilities.setCapability(CapabilityType.PLATFORM,utils.GetData.getInstance().readInternalHash("platform"));
		//capabilities.setCapability("newCommandTimeout", "2400");
		capabilities.setCapability("deviceOrientation","landscape");
		capabilities.setCapability("rotatable", true);
		
		capabilities.setCapability("app-package",utils.GetData.getInstance().readInternalHash("packagename"));
		capabilities.setCapability("app-activity",utils.GetData.getInstance().readInternalHash("activity"));
		capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("newCommandTimeout", 280);
		driver = new AppiumDriver(new URL(utils.GetData.getInstance().readInternalHash("url")), capabilities);
		driver.manage().timeouts().implicitlyWait(1000000, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
	}
	public static void tearDown()
	{
		driver.quit();
	}
	
}
