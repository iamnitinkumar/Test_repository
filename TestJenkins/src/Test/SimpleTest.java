package Test;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;



public class SimpleTest {

	public static void main(String[] args) {
		String profileDirectory1="D:\\SAP\\New folder";
		File profileDirectory = new File(profileDirectory1);
		FirefoxProfile profile = new FirefoxProfile(profileDirectory);
		WebDriver driver = new FirefoxDriver(profile);

		driver.get("http://www.google.co.in");
	       System.out.println(driver.getTitle());
	}

}
