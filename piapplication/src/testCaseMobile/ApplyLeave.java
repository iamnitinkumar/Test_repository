package testCaseMobile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import setUpConfig.setUp;

public class ApplyLeave {
  @Test
 public void ApplyLeave() throws InterruptedException {
	  
	  //new try
	  System.out.println("switchin....");
	  System.out.println(setUpConfig.setUp.driver.getContext());
	  //setUpConfig.setUp.driver.switchTo().window("WEBVIEW_com.persistent.pi.activity");
	  setUpConfig.setUp.driver.context("WEBVIEW_com.persistent.pi.activity");
	  System.out.println("switched");
	  
	  /*
	  System.out.println("Tryin to get handles");
	  Set<String> handles = setUpConfig.setUp.driver.getContextHandles();
	  System.out.println("got Handles");
	  System.out.println(handles.toString());
	  
	  for(String s: handles) {
		  System.out.println("Handle: "+s);
	  }
	  System.out.println("Done.....");*/
	  
	  
	  /*System.out.println("rrrr");
	  final Set<String> contextNames = setUpConfig.setUp.driver.getContextHandles();
	  System.out.println("dsfjosdkj");
	  System.out.println(contextNames.toString());
	  for (final String contextName : contextNames) {
	      if (contextName.contains("WEBVIEW")) {
	        setUpConfig.setUp.driver.context(contextName);
	      }
	    }
	    Thread.sleep(15000);
	    final WebElement bookFlightButton = setUpConfig.setUp.driver.findElement(By.id("register"));
	    bookFlightButton.click();
	    Thread.sleep(5000);
	    
	 /* WebDriverWait wait = new WebDriverWait(setUpConfig.setUp.driver, 800);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.view.View")));
	  /*List<WebElement> wobjectlist = setUpConfig.setUp.driver.findElements(By.className("android.view.View"));
	  wobjectlist.get(wobjectlist.size()-1).click();*/
	    
	    //setUpConfig.setUp.driver.findElement(By.tagName("Leave Apply Link"));  
  }
  @BeforeTest
  public void beforeTest() throws ClassNotFoundException, IOException {
	  
	  setUpConfig.setUp.SetupDriver();
  }

  @AfterTest
  public void afterTest() {
		setUpConfig.setUp.tearDown();
	}

}
