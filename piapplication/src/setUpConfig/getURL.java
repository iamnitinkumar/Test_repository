package setUpConfig;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import atu.testng.reports.ATUReports;

public class getURL {

	private String baseURL;
	public static WebDriver driver;
	Properties prop = new Properties();

	public getURL(){
		try
		{
			FileInputStream fileInput = new FileInputStream("./data/piurl.properties");
			prop.load(fileInput);
			System.out.println("file read");
		}
		catch(IOException e){
			e.printStackTrace();
		}  

	}

	public String urlLaunch() { 
		baseURL = prop.getProperty("baseUrl");
		System.out.println(baseURL);
		ATUReports.setWebDriver(driver); 
		return baseURL;			  
	}
}
