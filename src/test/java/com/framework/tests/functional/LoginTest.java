package com.framework.tests.functional;

import com.framework.driver.BaseTest;
import com.framework.pageobjects.LoginPage;
import com.framework.reporting.ExtentReportManager;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
    
        ExtentReportManager.startTest(this.getClass().getSimpleName(), "Test Execution Started");

      
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("testuser");
        ExtentReportManager.getTest().info("Entered username.");

        loginPage.enterPassword("password");
        ExtentReportManager.getTest().info("Entered password.");

        loginPage.clickLoginButton();
        ExtentReportManager.getTest().info("Clicked login button.");

        ExtentReportManager.getTest().pass("Test case passed: testValidLogin");

        // End the test and flush the report
        ExtentReportManager.endTest();
    }
}
