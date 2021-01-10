package com.mapsynq.automation.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.mapsynq.automation.listeners.ListenerTest;
import org.uncommons.reportng.*;

	@Listeners({ListenerTest.class,HTMLReporter.class,JUnitXMLReporter.class})
	public class TestBase
	{
	    private static Logger log = Logger.getLogger(TestBase.class);
		public WebDriver driver;
		private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

	  @Parameters({"browserName", "url"})
	  @BeforeTest
	  public void createDriver(String browserName, String url) {
		  System.setProperty(ESCAPE_PROPERTY, "false");
		  BrowserManager browser = new BrowserManager();
		  driver=browser.getWebDriver(browserName);
		  log.info("Opening the Url - "+ url);

		  driver.get(url);
	  }

	 public WebDriver getDriver() {
		  return driver;
	 }

	 @AfterTest(alwaysRun=true)
	 public void closeDriver(ITestContext testcontext) {
		if(driver!=null)
		{
			try {
				driver.quit();
			}catch(WebDriverException e)
			{
				log.info("**********CAUGHT EXCEPTION IN DRIVER TEAR DOWN**********");
				log.info(e);
			  }
		  }
	}
}
