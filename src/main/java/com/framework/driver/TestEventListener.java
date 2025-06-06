package com.framework.driver;

import com.aventstack.extentreports.Status;
import com.framework.reporting.ExtentReportManager;
import com.framework.utilities.LoggerUtility;
import com.framework.utilities.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestEventListener implements ITestListener {

    // No constructor needed; get driver dynamically
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.startTest(result.getMethod().getMethodName(), "Test started: " + result.getMethod().getMethodName());
        LoggerUtility.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
        LoggerUtility.info("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        driver = WebDriverManager.getDriver();  // get the current thread’s driver

        ScreenshotUtility screenshotUtility = new ScreenshotUtility(driver);
        String screenshotPath = screenshotUtility.captureScreenshot(result.getMethod().getMethodName());

        ExtentReportManager.getTest().log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
        ExtentReportManager.getTest().log(Status.FAIL, result.getThrowable());
        try {
            ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoggerUtility.error("Test failed: " + result.getMethod().getMethodName(), result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
        LoggerUtility.warn("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.endTest();  // this flushes and saves the report
        LoggerUtility.info("Test execution completed.");
    }
	
    
    
}
