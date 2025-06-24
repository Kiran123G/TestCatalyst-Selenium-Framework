package com.framework.tests.functional;

import com.framework.driver.BaseTest;
import com.framework.constants.FrameworkConstants;
import com.framework.pageobjects.LoginPage;
import com.framework.reporting.ExtentReportManager;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.framework.driver.TestEventListener.class)
public class LoginTest extends BaseTest {
	
    @Test
    public void testValidLogin() {
    	 ExtentReportManager.startTest("testValidLogin", "Testing valid login");
    	    ExtentReportManager.getTest().info("Starting login test");		
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateLogin(FrameworkConstants.USER_NAME, FrameworkConstants.PASSWORD);
    }
}
			