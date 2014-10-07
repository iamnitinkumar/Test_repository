package testCaseWeb;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import setUpConfig.getURL;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	MethodListener.class })
public class LeaveApply {
	{
		System.setProperty("atu.reporter.config", "./atu_demo.properties");
	}

	private static String baseUrl;
	static getURL setUp = new getURL();

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			getURL.driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches",
					Arrays.asList("--start-maximized"));
			getURL.driver = new ChromeDriver(capabilities);
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			getURL.driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		getURL.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeMethod() {
		baseUrl = setUp.urlLaunch();
		getURL.driver.get(baseUrl);
		getURL.driver.manage().window().maximize();
	}

	@Test
	public void applyLeave() {
		getURL.driver.findElement(By.xpath(".//*[@id='txtUserName']")).sendKeys("jyothi_p");
		getURL.driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
		getURL.driver.findElement(By.xpath(".//*[@id='all-apps']/div/div[1]/ul/li[4]/ul[1]/li[1]/a/div/div/img")).click();
		getURL.driver.findElement(By.xpath(".//*[@id='Menu1232']/table/tbody/tr[2]/td[2]/a")).click();
		new Select(getURL.driver.findElement(By.xpath(".//*[@id='ucRptSearchHeader_ddlSubLevel']"))).selectByVisibleText("Direct Subordinates");
		new Select(getURL.driver.findElement(By.xpath(".//*[@id='ucRptSearchHeader_ddlSubList']"))).selectByVisibleText("Shweta Raiker");
		getURL.driver.findElement(By.xpath(".//*[@id='btnShowAll']")).click();
		getURL.driver.findElement(By.xpath(".//*[@id='dgSpecialLeaves_ctl02_chkSelect']")).click();
		getURL.driver.findElement(By.xpath(".//*[@id='btnApprove']")).click();

	}


	@AfterTest
	public void afterTest() {
		getURL.driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		getURL.driver.quit();
	}


	@AfterMethod
	public void afterMethod() {
	}

}
