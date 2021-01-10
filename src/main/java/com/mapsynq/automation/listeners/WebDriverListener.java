package com.mapsynq.automation.listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverListener implements WebDriverEventListener {

	private static Logger log=Logger.getLogger(WebDriverListener.class);
	 WebDriver driver;
	
	public WebDriverListener(WebDriver driver)
	{
		this.driver=driver;
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		log.info("After clicking url "+ driver.getCurrentUrl());		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("After navigating to "+url+ " the title is "+ driver.getTitle());		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("Before navigating to "+url);
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		log.debug("There is an Exception in the script, please find the below error description",throwable);		
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// Do nothing
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// Do nothing
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// Do nothing
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {	
		// Do nothing
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// Do nothing
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {		
		// Do nothing
	}

	@Override
	public void afterScript(String script, WebDriver driver) {		
		// Do nothing
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {	
		// Do nothing
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {		
		// Do nothing
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {		
		// Do nothing
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {		
		// Do nothing
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {		
		// Do nothing
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// Do nothing
	}
}