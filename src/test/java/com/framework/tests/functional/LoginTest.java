package com.framework.tests.functional;

import com.framework.driver.BaseTest;
import com.framework.pageobjects.LoginPage;
import com.framework.reporting.ExtentReportManager;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
    
        ExtentReportManager.startTest(this.getClass().getSimpleName(), "Test Execution Started");	
        ExtentReportManager.getTest().info("Validate Login Functionality");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateLogin("Admin", "admin123");
      	
    }
}
