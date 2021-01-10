package com.mapsynq.automation.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.mapsynq.automation.helper.TestBase;

public class ListenerTest implements ISuiteListener, ITestListener, IInvokedMethodListener {
	
    private static Logger log = Logger.getLogger(ListenerTest.class);

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// Do nothing
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// Do nothing
	}

	@Override
	public void onFinish(ISuite arg0) {
		log.info(arg0.getName() + "---Test Suite Completed---\n");		
	}

	@Override
	public void onStart(ISuite arg0) {
		log.info(arg0.getName() + "---Test Suite starting---\n");		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// Do nothing
	}

	@Override
	public void onStart(ITestContext arg0) {
		// Do nothing
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {	
		// Do nothing
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		log.info(tr.getName() + "---Test method failed---\n");
    	try {
			takeScreenShot(tr);
		} catch (Exception e) {
			log.info(e.toString());
		}	      
	}

	public void takeScreenShot(ITestResult result) {
		Object currentclass=result.getMethod().getInstance();
    	WebDriver driver=((TestBase) currentclass).getDriver();
		String status="failed";
		if(result.isSuccess())
		{
			status="passed";
		}
		String methodName = result.getName().trim();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
			String workingDir = System.getProperty("user.dir");
			String defaultAssetPath = "/target/surefire-reports/Screenshots/" + status + "/" + methodName + "-"
				+ timeStamp + ".png";

			String path = workingDir + defaultAssetPath;
			log.info("ScreenShot path " + path);
			
			FileUtils.copyFile(scrFile, new File(path));

			String html = "<div style=\"height:450px;width:1250px;overflow:scroll\"><a target='_blank' href='"
				+ path + "'> <img src=\"" + path + "\"></a></div>";
			
			Reporter.log("screenshot for " + path + " url=" + driver.getCurrentUrl() + html, true);
			
			log.info(new File(path));
		
		} catch (IOException e) {
			log.info(e.toString());
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// Do nothing
	}

	@Override
	public void onTestStart(ITestResult tr) {
		log.info(tr.getName() + "---Test method starting---\n");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		log.info(tr.getName() + "---Test method passed---\n");
    	try {
			takeScreenShot(tr);
		} catch (Exception e) {
			log.info(e.toString());
		}
	}
}