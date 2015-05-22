package Test;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewClass throws MalformedURLException {

    
    String strBankConfigurationFileName = "config\\" + strBankName + "_configuration.properties";
    String strBrowserName = ReadPropertiesFile.getValue(strBankConfigurationFileName, "webclient.browser");
    String strPlatformName = ReadPropertiesFile.getValue(strBankConfigurationFileName, "webclient.platform");
    String strDeviceName = ReadPropertiesFile.getValue(strBankConfigurationFileName, "webclient.device");
    String strPlatformVersion = ReadPropertiesFile.getValue(strBankConfigurationFileName, "webclient.version");
    String strWebClientURL = ReadPropertiesFile.getValue(strBankConfigurationFileName, "webclient.webClientURL");
    
    DesiredCapabilities capabilities = new DesiredCapabilities();        
    capabilities.setCapability(CapabilityType.BROWSER_NAME, strBrowserName);        
    capabilities.setCapability("platformName", strPlatformName);        
    capabilities.setCapability("deviceName", strDeviceName);        
    capabilities.setCapability("platformVersion", strPlatformVersion);        
    
    System.out.println("Creating Driver...");
    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    System.out.println("Driver is created");
//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    
    driver.get(strWebClientURL);
}
